package com.everis.bookstore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.everis.bookstore.Book;
import com.everis.bookstore.services.BookService;
import com.everis.bookstore.view.DataTableResponse;

@Controller
@RequestMapping(value="/books")
public class BookController {

   private static Logger LOGGER = LoggerFactory.getLogger(BookController.class);
   
   @Autowired
   private BookService service;

   @RequestMapping(value = "/all", method=RequestMethod.GET)
   public ModelAndView handleRequest(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      if(LOGGER.isDebugEnabled()){
         LOGGER.debug("/books/all (GET) : Rendering /books/list.jsp");
      }
      return new ModelAndView("/books/list.jsp");
   }
   
   @RequestMapping(value = "/search", method=RequestMethod.GET)
   public @ResponseBody DataTableResponse search(){
      if(LOGGER.isDebugEnabled()){
         LOGGER.debug("/books/search (GET)");
      }
      List<Book> books = service.retrieveAllBooks();
      Book[] data = new Book[books.size()];
      int i=0;
      for(Book b : books){
         data[i] = b;
         i++;
      }
      if(LOGGER.isDebugEnabled()){
         LOGGER.debug("JSON response generated");
      }
      DataTableResponse response = new DataTableResponse("1", books.size(), 10, data);
      return response;
   }
}
