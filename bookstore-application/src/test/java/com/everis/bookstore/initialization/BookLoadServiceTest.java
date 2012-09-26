package com.everis.bookstore.initialization;

import com.everis.bookstore.Book;
import com.everis.bookstore.BookRepository;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class BookLoadServiceTest extends TestCase {
   
   public void testLoad(){
      BookLoaderService loadService = new BookLoaderService();
      loadService.setBookDataFile("test-books.data");
      BookRepository mockBookRepository = mock(BookRepository.class);
      loadService.setRepository(mockBookRepository);
      loadService.load();
      verify(mockBookRepository, times(10)).store(any(Book.class));
   }
}
