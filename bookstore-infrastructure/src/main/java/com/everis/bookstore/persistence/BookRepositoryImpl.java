package com.everis.bookstore.persistence;

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

}
