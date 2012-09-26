package com.everis.bookstore.initialization;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.bookstore.Book;
import com.everis.bookstore.BookRepository;

@Service
public class BookLoaderService {
   
   private Logger LOGGER = LoggerFactory.getLogger(BookLoaderService.class);
   
   public static final String DEFAULT_BOOK_DATA_FILE = "books.data";
   
   private BookDataReader reader;
   
   private String bookDataFile;
   
   @Autowired
   private BookRepository repository;

   public BookLoaderService(){
      super();
      this.reader = new BookDataReader();
      this.bookDataFile = DEFAULT_BOOK_DATA_FILE;
   }
   
   public void load(){
      if(LOGGER.isDebugEnabled()){
         LOGGER.debug("Loading books in repository...");
      }
      if(existBooksInRepository()){
         if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Repository contains books already. Loading process exit.");
         }
         return;
      }
      InputStream in = this.getClass().getClassLoader()
            .getResourceAsStream(bookDataFile);
      Scanner scanner = new Scanner(in);
      int count = 0;
      while(scanner.hasNextLine()){
         Book newBook = reader.read(scanner.nextLine());
         repository.store(newBook);
         count++;
      }
      if(LOGGER.isDebugEnabled()){
         LOGGER.debug(count + " books loaded in repository.");
      }
   }
   
   private boolean existBooksInRepository(){
      List<Book> allBooks = repository.findAll();
      return (allBooks!=null) && (allBooks.size()>0);
   }
   
   public String getBookDataFile() {
      return bookDataFile;
   }

   public void setBookDataFile(String bookDataFile) {
      this.bookDataFile = bookDataFile;
   }
   
   public BookRepository getRepository() {
      return repository;
   }

   public void setRepository(BookRepository repository) {
      this.repository = repository;
   }
}
