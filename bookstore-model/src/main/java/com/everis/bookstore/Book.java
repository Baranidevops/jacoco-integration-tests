package com.everis.bookstore;

/**
 * This class models a book in our domain.
 * 
 * @author jagudopr
 * @version 1.0.0
 * 
 * @since 1.0.0
 */
public class Book {
   
   private Long id;
   
   private String isbn;
   
   private String title;
   
   public Book(){
      this(null, null, null);
   }
   
   public Book(Long id, String isbn, String title){
      this.id = id;
      this.isbn = isbn;
      this.title = title;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getIsbn() {
      return isbn;
   }

   public void setIsbn(String isbn) {
      this.isbn = isbn;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }
   
   @Override
   public String toString(){
      StringBuffer sb = new StringBuffer("Book (ID: ");
      sb.append(this.id);
      sb.append(") [ISBN: ");
      sb.append(this.isbn);
      sb.append(" . Title: ");
      sb.append(this.title);
      sb.append("]");
      return sb.toString();
   }
}
