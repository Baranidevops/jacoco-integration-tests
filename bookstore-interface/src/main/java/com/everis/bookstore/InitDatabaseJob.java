package com.everis.bookstore;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class InitDatabaseJob extends QuartzJobBean {
   
   private DatabaseInitializer initDatabase;

   @Override
   protected void executeInternal(JobExecutionContext arg0)
         throws JobExecutionException {
      initDatabase.loadBooksInDB();
   }
   
   public DatabaseInitializer getInitDatabase() {
      return initDatabase;
   }

   public void setInitDatabase(DatabaseInitializer initDatabase) {
      this.initDatabase = initDatabase;
   }

}
