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
import edu.sjsu.cmpe275.term.service.BookService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	private BookService bookService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	/*GET GO TO WELCOME PAGE*/
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView goToWelcomePage(ModelMap model) {
		ModelAndView welcome = new ModelAndView("welcome");
		return welcome;
	}
	
	/*CREATE NEW BOOK ON CLICKING ADD BOOK IN ADDNEWBOOK PAGE*/
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
	@RequestMapping(value="/book/{bookISBN}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable("bookISBN") String isbn, Model model) {
		if(bookService.findBookByISBN(isbn)==null){
	        System.out.println("A book with ISBN "+isbn+" doesnot exist");
	        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND);
			return "BookNotFound";
	    }
		bookService.deleteBookByISBN(isbn);;
		model.addAttribute("httpStatus", HttpStatus.OK);
		return "BookDeletedSuccessfully";
	}
	
	/*UPDATE USER ON CLICKING UPDATE IN UPDATEUSER PAGE*/
	@RequestMapping(value="/book/{bookISBN}", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("book") Book book,
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
}
