package edu.sjsu.cmpe275.term.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

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
	public ModelAndView createNewUser(ModelMap model) {
		ModelAndView welcome = new ModelAndView("welcome");
		return welcome;
	}
	
	/*CREATE NEW BOOK ON CLICKING ADD BOOK IN ADDNEWBOOK PAGE*/
	@RequestMapping(value="/newBook", method = RequestMethod.POST)
	public String createNewUser(@RequestParam(value="isbn", required=false) String isbn,
			@RequestParam(value="author", required=false) String author,
			@RequestParam(value="title", required=false) String title, 
			@RequestParam(value="street", required=false) String street,
			@RequestParam(value="city", required=false) String city,
			@RequestParam(value="state", required=false) String state,
			@RequestParam(value="location", required=false) String location,
			@RequestParam(value="numberOfCopies", required=false) String numberOfCopies,
			UriComponentsBuilder ucBuilder, Model model) {
		//bookService.saveUser(book);//It should return book to get id.	
		HttpHeaders headers = new HttpHeaders();
	    //headers.setLocation(ucBuilder.path("/book/{id}").buildAndExpand(book.getBookId()).toUri());
		model.addAttribute("headers", headers);
		model.addAttribute("httpStatus", HttpStatus.CREATED);
		return "userCreationSuccess";
	}
}
