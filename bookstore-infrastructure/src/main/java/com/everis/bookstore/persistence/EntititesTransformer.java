package com.everis.bookstore.persistence;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.everis.bookstore.Book;

public class EntititesTransformer {
   
   private static Mapper mapper = new DozerBeanMapper();
   
   private EntititesTransformer(){
      super();
   }
   
   public static JPABook domainToPersistence(Book domainBook){
      return mapper.map(domainBook, JPABook.class);
   }
   
   public static Book persistenceToDomain(JPABook persistedBook){
      return mapper.map(persistedBook, Book.class);
   }
}
