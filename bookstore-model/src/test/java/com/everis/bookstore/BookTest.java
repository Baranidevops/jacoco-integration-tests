package com.everis.bookstore;

import junit.framework.TestCase;

/**
 * Unit test for Book.
 */
public class BookTest extends TestCase {

   /**
    * Rigourous Test :-)
    */
   public void testToString() {
      String isbn = "0987654321";
      String title = "Test book title";
      Book book = new Book(1L, isbn, title);
      String stringInfo = book.toString();
      assertTrue(stringInfo.contains(isbn) && stringInfo.contains(title));
   }
}
