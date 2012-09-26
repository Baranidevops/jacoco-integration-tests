package com.everis.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.bookstore.initialization.BookLoaderService;

@Component
public class DatabaseInitializer {
   
   private static Logger LOGGER = LoggerFactory.getLogger(DatabaseInitializer.class);

   @Autowired
   private BookLoaderService loader;

   public void loadBooksInDB() {
      if(LOGGER.isDebugEnabled()){
         LOGGER.debug("Starting database initialization...");
      }
      loader.load();
      if(LOGGER.isDebugEnabled()){
         LOGGER.debug("Initialization finished.");
      }
   }

   public BookLoaderService getLoader() {
      return loader;
   }

   public void setLoader(BookLoaderService loader) {
      this.loader = loader;
   }
}