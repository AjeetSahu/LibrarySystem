package edu.sjsu.cmpe275.term.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import edu.sjsu.cmpe275.term.model.Book;
import edu.sjsu.cmpe275.term.model.Librarian;
import edu.sjsu.cmpe275.term.model.Patron;
import edu.sjsu.cmpe275.term.service.BookService;
import edu.sjsu.cmpe275.term.service.LibrarianService;
import edu.sjsu.cmpe275.term.service.PatronService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private LibrarianService librarianService;
	
	@Autowired
	private PatronService patronService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	public void setLibrarianService(LibrarianService librarianService) {
		this.librarianService = librarianService;
	}
	
	public void setPatronService(PatronService patronService) {
		this.patronService = patronService;
	}
	
	/*GET GO TO WELCOME PAGE*/
	/**
	 * @author Pratik
	 *
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView goToWelcomePage(ModelMap model) {
		ModelAndView welcome = new ModelAndView("welcome");
		System.out.println("HI There");
		return welcome;
	}
	
	/*CREATE NEW BOOK ON CLICKING ADD BOOK IN ADDNEWBOOK PAGE*/
	/**
	 * @author Pratik
	 *
	 */
	@RequestMapping(value="/newBook", method = RequestMethod.POST)
	public String createNewBook(@ModelAttribute("book") Book book,
			UriComponentsBuilder ucBuilder, Model model) {
		book = bookService.saveNewBook(book);
		HttpHeaders headers = new HttpHeaders();
		if(book != null){
		    headers.setLocation(ucBuilder.path("/book/{id}").buildAndExpand(book.getBookId()).toUri());
			model.addAttribute("headers", headers);
			model.addAttribute("httpStatus", HttpStatus.CREATED);
			return "BookCreationSuccess";
		}else{
			model.addAttribute("httpStatus", HttpStatus.CONFLICT);
			return "Conflict";
		}
	}
	
	/*GET BOOK BY ISBN*/
	/**
	 * @author Pratik
	 *
	 */
	@RequestMapping(value="/book/{bookISBN}", method = RequestMethod.GET)
	public ModelAndView getBookByISBN(@PathVariable("bookISBN") String isbn, Model model) {
		ModelAndView bookFound= new ModelAndView("BookFound");
		ModelAndView bookNotFound= new ModelAndView("BookNotFound");
		Book book = bookService.findBookByISBN(isbn);
		System.out.println("book "+book);
		if(book == null){
	        System.out.println("Unable to find book as book with ISBN "+isbn+" doesnot exist");
	        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND);
			return bookNotFound;
	    }
		model.addAttribute("book", book);
		model.addAttribute("httpStatus", HttpStatus.OK);
		return bookFound;	
	}
	
	/*DELETE AN EXISTING BOOK*/
	/**
	 * @author Pratik
	 *
	 */
	@RequestMapping(value="/book/{bookISBN}", method = RequestMethod.DELETE)
	public String deleteBook(@PathVariable("bookISBN") String isbn, Model model) {
		if(bookService.findBookByISBN(isbn)==null){
	        System.out.println("A book with ISBN "+isbn+" doesnot exist");
	        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND);
			return "BookNotFound";
	    }
		bookService.deleteBookByISBN(isbn);;
		model.addAttribute("httpStatus", HttpStatus.OK);
		return "BookDeletedSuccessfully";
	}
	
	/*UPDATE Book ON CLICKING UPDATE IN UPDATEBook PAGE*/
	/**
	 * @author Pratik
	 *
	 */
	@RequestMapping(value="/book/{bookISBN}", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("book") Book book,
			Model model) {
		System.out.println("IN UPDATE METHOD");
		Book book1 = bookService.findBookByISBN(book.getIsbn());
		if(book1 == null){
	        System.out.println("Unable to update as book with id "+book.getIsbn()+" doesnot exist");
	        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND);
			return "BookNotFound";
	    }
		bookService.updateBook(book);
		model.addAttribute("httpStatus", HttpStatus.OK);
		return "BookUpdatedSuccessfully";
	}
	/*CREATE NEW PATRON ON CLICKING CREATE PATRON IN SIGNUP PAGE*/
	/**
	 * @author Pratik
	 *
	 */
	@RequestMapping(value="/newPatron", method = RequestMethod.POST)
	public String createNewPatron(@ModelAttribute("patron") Patron patron,
			UriComponentsBuilder ucBuilder, Model model) {
		patron = patronService.saveNewPatron(patron);
		HttpHeaders headers = new HttpHeaders();
		if(patron != null){
		    headers.setLocation(ucBuilder.path("/patron/{id}").buildAndExpand(patron.getPatronId()).toUri());
			model.addAttribute("headers", headers);
			model.addAttribute("httpStatus", HttpStatus.CREATED);
			return "PatronCreationSuccess";
		}else{
			model.addAttribute("httpStatus", HttpStatus.CONFLICT);
			return "Conflict";
		}
	}
	
	/*GET PATRON BY ID*/
	/**
	 * @author Pratik
	 *
	 */
	@RequestMapping(value="/patron/{patronID}", method = RequestMethod.GET)
	public ModelAndView getPatronByID(@PathVariable("patronID") String patronID, Model model) {
		ModelAndView patronFound= new ModelAndView("PatronFound");
		ModelAndView patronNotFound= new ModelAndView("PatronNotFound");
		Patron patron = patronService.findPatronById(patronID);
		System.out.println("patron "+patron);
		if(patron == null){
	        System.out.println("Unable to find patron as patron with ID "+patron+" doesnot exist");
	        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND);
			return patronNotFound;
	    }
		model.addAttribute("patron", patron);
		model.addAttribute("httpStatus", HttpStatus.OK);
		return patronFound;	
	}
	
	/*CREATE NEW LIBRARIAN ON CLICKING CREATE LIBRARIAN IN SIGNUP PAGE*/
	/**
	 * @author Pratik
	 *
	 */
	@RequestMapping(value="/newLibrarian", method = RequestMethod.POST)
	public String createNewLibrarian(@ModelAttribute("librarian") Librarian librarian,
			UriComponentsBuilder ucBuilder, Model model) {
		librarian = librarianService.saveNewLibrarian(librarian);
		HttpHeaders headers = new HttpHeaders();
		if(librarian != null){
		    headers.setLocation(ucBuilder.path("/librarian/{id}").buildAndExpand(librarian.getLibrarianId()).toUri());
			model.addAttribute("headers", headers);
			model.addAttribute("httpStatus", HttpStatus.CREATED);
			return "LibrarianCreationSuccess";
		}else{
			model.addAttribute("httpStatus", HttpStatus.CONFLICT);
			return "Conflict";
		}
	}
	
	/*GET LIBRARIAN BY ID*/
	/**
	 * @author Pratik
	 *
	 */
	@RequestMapping(value="/librarian/{librarianID}", method = RequestMethod.GET)
	public ModelAndView getLibrarianByID(@PathVariable("librarianID") String librarianID, Model model) {
		ModelAndView librarianFound= new ModelAndView("LibrarianFound");
		ModelAndView librarianNotFound= new ModelAndView("LibrarianNotFound");
		Librarian librarian = librarianService.findLibrarianById(librarianID);
		System.out.println("librarian "+librarian);
		if(librarian == null){
	        System.out.println("Unable to find patron as patron with ID "+librarian+" doesnot exist");
	        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND);
			return librarianNotFound;
	    }
		model.addAttribute("librarian", librarian);
		model.addAttribute("httpStatus", HttpStatus.OK);
		return librarianFound;	
	}
}
