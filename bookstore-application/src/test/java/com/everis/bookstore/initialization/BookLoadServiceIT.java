package com.everis.bookstore.initialization;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.everis.bookstore.Book;
import com.everis.bookstore.BookRepository;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:test-applicationContext-db.xml",
    "classpath:applicationContext-persistence.xml",
    "classpath:applicationContext-services.xml"
})
public class BookLoadServiceIT extends TestCase {
   
   @Autowired
   private BookLoaderService loadService;
   
   @Autowired
   private BookRepository repository;
   
   @Test
   public void testLoad(){
      loadService.setBookDataFile("test-books.data");
      loadService.load();
      List<Book> allBooks = repository.findAll();
      assertEquals(10, allBooks.size());
   }
}