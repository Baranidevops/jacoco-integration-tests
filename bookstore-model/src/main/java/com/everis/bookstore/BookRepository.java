package com.everis.bookstore;

import java.util.List;

public interface BookRepository {
   
   Book store(Book book);
   
   Book find(Long bookId);
   
   List<Book> findAll();
}
