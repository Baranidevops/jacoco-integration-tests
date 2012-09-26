package com.everis.bookstore.view;

import com.everis.bookstore.Book;

public class DataTableResponse {
   
   private String sEcho;
   
   private int iTotalRecords;
   
   private int iTotalDisplayRecords;
   
   private Book[] aaData;
   
   public DataTableResponse(String sEcho, int totalRecords, int totalDisplayRecords, Book[] data){
      this.sEcho = sEcho;
      this.iTotalRecords = totalRecords;
      this.iTotalDisplayRecords = totalDisplayRecords;
      this.aaData = data;
   }
   
   public String getsEcho() {
      return sEcho;
   }

   public void setsEcho(String sEcho) {
      this.sEcho = sEcho;
   }

   public int getiTotalRecords() {
      return iTotalRecords;
   }

   public void setiTotalRecords(int iTotalRecords) {
      this.iTotalRecords = iTotalRecords;
   }

   public int getiTotalDisplayRecords() {
      return iTotalDisplayRecords;
   }

   public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
      this.iTotalDisplayRecords = iTotalDisplayRecords;
   }

   public Book[] getAaData() {
      return aaData;
   }

   public void setAaData(Book[] aaData) {
      this.aaData = aaData;
   }
}
