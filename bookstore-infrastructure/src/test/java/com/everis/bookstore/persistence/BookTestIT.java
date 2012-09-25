package com.everis.bookstore.persistence;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.everis.bookstore.Book;
import com.everis.bookstore.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:test-applicationContext-db.xml",
    "classpath:applicationContext-persistence.xml"
})
public class BookTestIT extends TestCase {
   
   @Autowired
   private BookRepository repository;
   
   @Test
   public void testSave(){
      String isbn = "978-0-306-40615-7";
      String title = "Example book";
      Book savedBook = repository.store(new Book(null, isbn, title));
      assertNotNull(savedBook.getId());
   }
}
