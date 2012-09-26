package com.everis.bookstore.initialization;

import com.everis.bookstore.Book;

public class BookDataReader {
   
   public Book read(String line){
      String[] bookData = separateIsbnTitle(line);
      return new Book(null, bookData[0], bookData[1]);
   }
   
   String[] separateIsbnTitle(String bookDataLine){
      int i = bookDataLine.indexOf(",");
      String[] result = new String[2];
      result[0] = bookDataLine.substring(0, i);
      i++;
      result[1] = bookDataLine.substring(i);
      return result;
   }
}
