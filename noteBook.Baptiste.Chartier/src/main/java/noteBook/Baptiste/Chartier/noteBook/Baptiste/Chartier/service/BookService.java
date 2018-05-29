package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.service;

import org.springframework.stereotype.Service;

import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.repository.BookRepository;

@Service
public interface BookService {

	public BookRepository getBookRepository();
	public void setBookRepository(BookRepository bookRepository); 
}
