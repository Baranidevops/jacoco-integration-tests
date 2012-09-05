package com.everis.bookstore;

public interface BookRepository {
   
   public void store(Book book);
   
   public Book find(Long bookId);
}
