package com.everis.bookstore;

public interface BookRepository {
   
   Book store(Book book);
   
   Book find(Long bookId);
}
