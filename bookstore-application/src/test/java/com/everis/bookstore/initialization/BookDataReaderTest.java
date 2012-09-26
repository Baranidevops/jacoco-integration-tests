package com.everis.bookstore.initialization;

import com.everis.bookstore.Book;

import junit.framework.TestCase;

public class BookDataReaderTest extends TestCase {
   
   private static final String BOOK_INFO_SEPARATOR = ",";
   
   public void testRead(){
      String isbn = "0028604296";
      String title = "Movie Time: A Chronology Of Hollywood And The Movie Industry From Its Beginnings To The Present";
      BookDataReader reader = new BookDataReader();
      Book book = reader.read(isbn + BOOK_INFO_SEPARATOR + title);
      assertEquals(isbn, book.getIsbn());
      assertEquals(title, book.getTitle());
   }
   
   public void testSeparateIsbnTitle(){
      String isbn = "0028604164";
      String title = "New York Public Library Students Desk Reference";
      BookDataReader reader = new BookDataReader();
      String[] result = reader.separateIsbnTitle(isbn + BOOK_INFO_SEPARATOR + title);
      assertEquals(isbn, result[0]);
      assertEquals(title, result[1]);
   }
}
