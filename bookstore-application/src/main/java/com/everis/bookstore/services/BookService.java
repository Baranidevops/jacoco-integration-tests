package com.everis.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.bookstore.Book;
import com.everis.bookstore.BookRepository;

@Service
public class BookService {
   
   @Autowired
   private BookRepository repository;
   
   public List<Book> retrieveAllBooks(){
      return repository.findAll();
   }
}
