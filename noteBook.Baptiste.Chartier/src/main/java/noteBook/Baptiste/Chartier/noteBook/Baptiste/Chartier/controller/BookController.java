package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

	@GetMapping(value="/book")
	@ResponseBody
	public Book getBook(@RequestParam String titre) throws Exception {
		return bookService.getBook(titre);
	}
	
	@GetMapping(value="/allBooks")
	@ResponseBody
	public List<Book> getAllBooks() throws Exception {
		return bookService.getAllBook();
	}
	
	@GetMapping(value="/allAutheur")
	@ResponseBody
	public List<Auteur> getAllAutheur() throws Exception {
		return bookService.getAllAuteur();
	}
	
	@GetMapping(value="/booksFromAuteur")
	@ResponseBody
	public List<Book> getBooks(@Valid @RequestParam Auteur auteur) throws Exception {
		return bookService.getBookFromAuteur(auteur);
	}
	
	@GetMapping(value="/booksFromSerie")
	@ResponseBody
	public List<Book> getBooks(@Valid @RequestParam Serie serie) throws Exception {
		return bookService.getBookFromSerie(serie);
	}
	
	@GetMapping(value="/allSerie")
	@ResponseBody
	public List<Serie> getAllSerieFromAutheur(@Valid @RequestParam Auteur auteur) throws Exception {
		return bookService.getSerieFromAuteur(auteur);
	}
	
	@PutMapping(value="/book")
	@ResponseBody
	public Book putBook(@Valid @RequestParam Book book, @Valid @RequestParam Auteur auteur, @Valid @RequestParam(required = false) Optional<Serie> serie) throws Exception {
		return bookService.addBook(book, auteur, serie);
	}
	
	@DeleteMapping(value="/deleteBook")
	@ResponseBody
	public void deleteBook(@Valid @RequestParam Book book) throws Exception {
		bookService.deleteBook(book);
	}
	
}
