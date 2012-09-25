package com.everis.bookstore.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOKS")
public class JPABook {

   @Id
   @GeneratedValue
   private Long id;

   private String isbn;

   private String title;
   
   public JPABook(){
      this(null, null, null);
   }

   public JPABook(Long id, String isbn, String title) {
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
}
