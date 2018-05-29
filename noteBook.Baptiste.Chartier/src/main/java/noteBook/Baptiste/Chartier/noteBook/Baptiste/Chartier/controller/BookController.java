package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Auteur;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Book;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Serie;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	Auteur auteur;
	
	@Autowired
	Serie serie;

	@GetMapping(value="/book")
	@ResponseBody
	public Book getBook(@RequestParam String titre) throws Exception {
		return bookService.getBookRepository().findByTitre(titre);
	}
	
	@GetMapping(value="/books")
	@ResponseBody
	public List<Book> getBooks(@RequestParam Auteur auteur) throws Exception {
		return bookService.getBookRepository().findByAuteur(auteur);
	}
	
	@GetMapping(value="/Allbooks")
	@ResponseBody
	public List<Book> getAllBooks() throws Exception {
		return bookService.getBookRepository().findAll();
	}
	
	@PutMapping(value="/book")
	@ResponseBody
	public Book putBook(@RequestParam Book book, @RequestParam Auteur auteur, @RequestParam(required = false) Serie serie) throws Exception {
		Book bookInBase = bookService.getBookRepository().findByTitre(book.getTitre());
		
		if(bookInBase != null)
		{
			bookInBase.setAuteur(book.getAuteur());
			bookInBase.setCollection(book.getCollection());
			
			return bookService.getBookRepository().save(bookInBase);
		} else {
			return bookService.getBookRepository().save(book);
		}
	}
	
	@DeleteMapping(value="/deleteBook")
	@ResponseBody
	public void deleteBook(@RequestParam Book book) throws Exception {
		bookService.getBookRepository().delete(book);
	}
	
}
