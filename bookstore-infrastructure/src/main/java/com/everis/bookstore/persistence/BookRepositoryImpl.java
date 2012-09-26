package com.everis.bookstore.persistence;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.bookstore.Book;
import com.everis.bookstore.BookRepository;

@Component
public class BookRepositoryImpl implements BookRepository {

   @Autowired
   private JPABookRepository jpaRepository;

   @Override
   public Book store(Book book) {
      return EntititesTransformer.persistenceToDomain(this.jpaRepository.save(EntititesTransformer.domainToPersistence(book)));
   }

   @Override
   public Book find(Long bookId) {
      return EntititesTransformer.persistenceToDomain(this.jpaRepository
            .findOne(bookId));
   }

   @SuppressWarnings({ "rawtypes", "unchecked" })
   @Override
   public List<Book> findAll() {
      List allBooks = this.jpaRepository.findAll();
      CollectionUtils.transform(allBooks, new Transformer() {
         @Override
         public Object transform(Object obj) {
            JPABook book = null;
            if(obj instanceof JPABook){
               book = (JPABook) obj;
            }
            if(book==null){
               return null;
            }
            return EntititesTransformer.persistenceToDomain(book);
         }
      });
      return allBooks;
   }

}
