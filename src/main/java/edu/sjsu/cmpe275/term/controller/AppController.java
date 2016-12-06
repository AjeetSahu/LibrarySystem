package edu.sjsu.cmpe275.term.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import edu.sjsu.cmpe275.term.model.Book;
import edu.sjsu.cmpe275.term.model.BookStatus;
import edu.sjsu.cmpe275.term.model.Librarian;
import edu.sjsu.cmpe275.term.model.Patron;
import edu.sjsu.cmpe275.term.model.Picture;
import edu.sjsu.cmpe275.term.model.Publisher;
import edu.sjsu.cmpe275.term.service.BookService;
import edu.sjsu.cmpe275.term.service.BookStatusService;
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
	
	@Autowired
	private BookStatusService bookStatusService;
	
	@Autowired
	private static MailSender activationMailSender;
	
	/**
	 * 
	 * @param activationMailSender
	 */
	public static void setActivationMailSender(MailSender activationMailSender) {
		AppController.activationMailSender = activationMailSender;
	}

	/**
	 * 
	 * @param bookService
	 */
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	/**
	 * 
	 * @param librarianService
	 */
	public void setLibrarianService(LibrarianService librarianService) {
		this.librarianService = librarianService;
	}
	
	/**
	 * 
	 * @param patronService
	 */
	public void setPatronService(PatronService patronService) {
		this.patronService = patronService;
	}
	
	/**
     * This method will send compose and send the message 
     * @author Pratik 
	 * @param to
	 * @param activationCode
	 */
    public static void sendMail(String to, int activationCode) 
    {
    	System.out.println("to: "+to+" activationCode: "+activationCode);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Library Management System Activation Code");
        message.setText("Thank you for creating an account at Library Management System. "
        		+ "\n Please activate your account using your activation code = "+activationCode
        		+"\n Please don't reply on this email.");
        System.out.println("1");
        System.out.println(activationMailSender);
        activationMailSender.send(message);
    }
    
    /**
	 * ATTACH CURRENT DATE AND TIME TO ALL PAGES
	 * @author Pratik 
     * @param currentdate
     * @param model
     */
    @ModelAttribute
	public void attachCurrentDateAndTime(Date currentdate, Model model){
    	model.addAttribute("currentDate", currentdate);
	}   
	
	/**
	 * GET GO TO WELCOME PAGE
	 * @author Pratik
	 *
	 */

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView goToWelcomePage(ModelMap model) {
		ModelAndView welcome = new ModelAndView("welcome");
		return welcome;
	}
	
	/**
	 * GET GO TO Activate User Page
	 * @author Amitesh
	 *
	 */

	@RequestMapping(value = "/activationPage", method = RequestMethod.GET)
	public ModelAndView activateUser(ModelMap model) {
		ModelAndView activation = new ModelAndView("ActivationPage");
		return activation;
	}
	
	@RequestMapping(value="/activate", method = RequestMethod.POST)
    public String activateUser(@RequestParam Map<String, String> reqParams, Model model){
    	boolean bool = false;
    	if(reqParams.get("email").contains("@sjsu.edu")){
			Librarian librarian = librarianService.findLibrarianByEmailId(reqParams.get("email"));
			try{
				bool = (Integer.parseInt(reqParams.get("activate")) == librarian.getActivationCode()) ? true : false;
			}
			catch(NumberFormatException e ){
				System.out.println(e);
			}
			if(librarian != null && bool){
				librarian.setStatus(true);
				librarianService.updateLibrarian(librarian);
				model.addAttribute("message", "Account created Successfully");
				return "Login";
			}else{
				return "Error";
			}
		}else{
			System.out.println("email: "+reqParams.get("email"));
			Patron patron = patronService.findPatronByEmailId(reqParams.get("email"));
			try{
				bool = (Integer.parseInt(reqParams.get("activate")) == patron.getActivationCode()) ? true : false;
			}
			catch(NumberFormatException e ){
				System.out.println(e);
			}
			if(patron != null && bool){
				patron.setStatus(true);
				patronService.updatePatron(patron);
				model.addAttribute("message", "Account created Successfully");
				return "Login";
			}else{
				return "Error";
			}		
		}
    }
	
	/**
	 * POST AUTHENTICATE USER LOGIN PAGE
	 * @author Pratik
	 *
	 */
    @RequestMapping(value="/home", method = RequestMethod.POST)
    public ModelAndView authenticateUser(@RequestParam Map<String, String> reqParams,
    		Model model, HttpServletRequest request){
    	ModelAndView modelAndView = null;
    	if(reqParams.get("email").contains("@sjsu.edu")){
    		modelAndView = new ModelAndView("LibraryHome");
			Librarian librarian = librarianService.findLibrarianByEmailId(reqParams.get("email"));
			if(librarian != null && librarian.getPassword().equals(reqParams.get("password"))){
				librarian.setStatus(false);
				librarianService.updateLibrarian(librarian);
				request.getSession().setAttribute("loggedIn", librarian);
			}else{
				modelAndView = new ModelAndView("Login");
				model.addAttribute("message", "Authentication failed, incorrect email or password!");
			}
		}else{
			System.out.println("email: "+reqParams.get("email"));
			Patron patron = patronService.findPatronByEmailId(reqParams.get("email"));
			if(patron != null && patron.getPassword().equals(reqParams.get("password"))){
				patron.setStatus(false);
				patronService.updatePatron(patron);
				request.getSession().setAttribute("loggedIn", patron);
			}else{
				model.addAttribute("message", "Authentication failed, incorrect email or password!");
				modelAndView = new ModelAndView("Login");
			}		
		}
    	return modelAndView;
    }
    
    /**
     * LOGOUT A LOGGED IN USER
     * @param request
     * @return
     */
    @RequestMapping(value="/logout", method=RequestMethod.POST)
    public String signout(HttpServletRequest request){
        request.getSession().setAttribute("loggedIn", null);
      	return "login";
    }
	
	/**
	 * Goto ADDNEWBOOK PAGE and search book by ISBN
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/newBook", method = RequestMethod.GET)
	public ModelAndView goToAddNewBookPage(ModelMap model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("login");
			return login;
		}
		ModelAndView welcome = new ModelAndView("AddNewBook");
		return welcome;
	}
	
	/**
	 * Goto ADDNEWBOOK PAGE and add book manually
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/newBookManually", method = RequestMethod.GET)
	public ModelAndView goToAddNewBookManualPage(ModelMap model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("login");
			return login;
		}
		ModelAndView register = new ModelAndView("AddNewBookManually");
		return register;
	}
	
	/**
	 * Goto Registration PAGE to add new Patron/Librarian 
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(ModelMap model) {
		ModelAndView register = new ModelAndView("Registration");
		return register;
	}
	
	/**
	 * Goto Login PAGE to to access Patron/Librarian account 
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelMap model) {
		ModelAndView login = new ModelAndView("Login");
		model.addAttribute("message", "");
		return login;
	}
	
	
	/**
	 * CREATE NEW BOOK ON CLICKING ADD BOOK IN ADDNEWBOOK PAGE
	 * @author Pratik
	 * @param book
	 * @param ucBuilder
	 * @param model
	 * @return
	 */
	public ModelAndView createNewBook(@RequestParam Map<String, String> reqParams, HttpServletRequest request) {
			Book book = new Book();
			book.setIsbn(reqParams.get("isbn"));
			System.out.println("isbn: "+reqParams.get("isbn"));
			book.setAuthor(reqParams.get("author"));
			book.setTitle(reqParams.get("title"));
			Publisher publisher = new Publisher();
			publisher.setPublisher(reqParams.get("publisher"));
			DateFormat format = new SimpleDateFormat("yyyy");
			Date date = null;
			try {
				System.out.println("date: "+reqParams.get("yearOfPublication"));
				date = format.parse(reqParams.get("yearOfPublication").toString());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			publisher.setYearOfPublication(date);
			Picture picture = new Picture();
			//MultipartFile multipartFile = (MultipartFile)reqParams.get("file");
			//book.setCoverImage(
			//picture.setImage(reqParams.get("coverImage"));
			//book.setCoverImage();
			try{
				publisher.setPhoneNumber(Integer.parseInt(reqParams.get("phoneNumber")));
				book.setNumberOfCopies(Integer.parseInt(reqParams.get("numberOfCopies")));
			}
			catch(Exception e){
				System.out.println(e);
			}
			book.setCoverImage(picture);
			book.setPublisher(publisher);
			book.setLocation(reqParams.get("location"));
			if(reqParams.get("keywords").length()>0)
				book.setKeywords(reqParams.get("keywords").toString().trim().split(","));
			book = bookService.saveNewBook(book);
			ModelAndView model = new ModelAndView("LibraryHome");
			model.addObject("httpStatus", HttpStatus.CREATED);
			model.addObject("book",book);
			model.addObject("message", "Book Added Successfully");
			return model;
	}
	
	/**
	 * GET BOOK BY ISBN
	 * @author Pratik 
	 * @param isbn
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/book/{bookISBN}", method = RequestMethod.GET)
	public ModelAndView getBookByISBN(@PathVariable("bookISBN") String isbn, Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("login");
			return login;
		}
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
	
	/**
	 * DELETE AN EXISTING BOOK
	 * @author Pratik
	 * @param isbn
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/book/{bookISBN}", method = RequestMethod.DELETE)
	public String deleteBook(@PathVariable("bookISBN") String isbn, Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			return "login";
		}
		if(bookService.findBookByISBN(isbn)==null){
	        System.out.println("A book with ISBN "+isbn+" doesnot exist");
	        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND);
			return "BookNotFound";
	    }
		bookService.deleteBookByISBN(isbn);;
		model.addAttribute("httpStatus", HttpStatus.OK);
		return "BookDeletedSuccessfully";
	}
	
	/**
	 * UPDATE Book ON CLICKING UPDATE IN UPDATEBOOK PAGE
	 * @author Pratik
	 * @param book
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/book/{bookISBN}", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("book") Book book,
			Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			return "login";
		}
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
	
	/**
	 * CREATE NEW PATRON ON CLICKING CREATE PATRON IN SIGNUP PAGE
	 * @author Pratik
	 * @param patron
	 * @param ucBuilder
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/newPatron", method = RequestMethod.POST)
	public String createNewPatron(@ModelAttribute("patron") Patron patron,
			UriComponentsBuilder ucBuilder, Model model) {
		patron = patronService.saveNewPatron(patron);
		if(patron != null){
			model.addAttribute("httpStatus", HttpStatus.CREATED);
			return "PatronCreationSuccess";
		}else{
			model.addAttribute("httpStatus", HttpStatus.CONFLICT);
			return "Conflict";
		}
	}
	
	/**
	 * Goto Patron Home page 
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/patronHome", method = RequestMethod.GET)
	public ModelAndView patronHome(ModelMap model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("login");
			return login;
		}
		ModelAndView patron = new ModelAndView("PatronHome");
		return patron;
	}
	
	/**
	 * Goto Librarian Home PAGE to access features 
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/libraryHome", method = RequestMethod.GET)
	public ModelAndView libraryHome(ModelMap model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("login");
			return login;
		}
		ModelAndView librarian = new ModelAndView("LibraryHome");
		return librarian;
	}
	
	/**
	 * Goto Librarian AddBook Manually Page 
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/addNewBookManually", method = RequestMethod.GET)
	public ModelAndView addNewBookManually(ModelMap model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("login");
			return login;
		}
		ModelAndView librarian = new ModelAndView("AddNewBookManually");
		return librarian;
	}
	
	/**
	 * Goto Patron profile page to update Patron info 
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/patronProfile", method = RequestMethod.GET)
	public ModelAndView patronProfile(ModelMap model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("login");
			return login;
		}
		ModelAndView patronProfile = new ModelAndView("PatronProfile");
		return patronProfile;
	}
	
	/**
	 * Goto Patron profile page to update Patron info 
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/libraryProfile", method = RequestMethod.GET)
	public ModelAndView libraryProfile(ModelMap model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("login");
			return login;
		}

		ModelAndView libraryProfile = new ModelAndView("LibrarianProfile");
		return libraryProfile;
	}
	
	/**
	 * Goto Error page, if resource not found 
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView error(ModelMap model) {
		ModelAndView error = new ModelAndView("Error");
		return error;
	}
	
	/**
	 * GET PATRON BY ID
	 * @author Pratik
	 * @param patronID
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/patron/{patronUniversityID}", method = RequestMethod.GET)
	public ModelAndView getPatronByID(@PathVariable("patronUniversityID") String patronUniversityID,
			Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("login");
			return login;
		}
		ModelAndView patronFound= new ModelAndView("PatronFound");
		ModelAndView patronNotFound= new ModelAndView("PatronNotFound");
		Patron patron = patronService.findPatronByUniversityId(patronUniversityID);
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
	
	/**
	 * CREATE NEW LIBRARIAN ON CLICKING CREATE LIBRARIAN IN SIGNUP PAGE
	 * @author Pratik 
	 * @param librarian
	 * @param ucBuilder
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/newLibrarian", method = RequestMethod.POST)
	public String createNewLibrarian(@ModelAttribute("librarian") Librarian librarian,
			UriComponentsBuilder ucBuilder, Model model) {
		int randomCode = (int)(Math.random() * 100000);
		librarian.setActivationCode(randomCode);
		librarian = librarianService.saveNewLibrarian(librarian);
		if(librarian != null){
			model.addAttribute("httpStatus", HttpStatus.CREATED);
			return "LibrarianCreationSuccess";
		}else{
			model.addAttribute("httpStatus", HttpStatus.CONFLICT);
			return "Conflict";
		}
	}

	/**
	 * GET LIBRARIAN BY ID
	 * @author Pratik
	 * @param librarianID
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/librarian/{librarianUniversityID}", method = RequestMethod.GET)
	public ModelAndView getLibrarianByID(@PathVariable("librarianUniversityID") String librarianUniversityID,
			Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("login");
			return login;
		}
		ModelAndView librarianFound= new ModelAndView("LibrarianFound");
		ModelAndView librarianNotFound= new ModelAndView("LibrarianNotFound");
		Librarian librarian = librarianService.findLibrarianByUniversityId(librarianUniversityID);
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

	/**
	 * Goto Patron Home page 
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/deleteSearch", method = RequestMethod.GET)
	public ModelAndView deleteSearch(ModelMap model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView delete = new ModelAndView("login");
			return delete;
		}
		ModelAndView delete = new ModelAndView("DeleteSearch");
		return delete;
	}
	
	
	/**
	 * 
	 * @param reqParams
	 * @return
	 */
	@RequestMapping(value="/newUser", method = RequestMethod.POST)
	public ModelAndView createNewUser(@RequestParam Map<String, String> reqParams) {
		System.out.println("inside createNewUser");
		ModelAndView userActivation= new ModelAndView("ActivationPage");
		ModelAndView errorPage= new ModelAndView("Error");
		int randomCode = (int)(Math.random() * 100000);
		if(reqParams.get("email").contains("@sjsu.edu")){
			if(librarianService.findLibrarianByUniversityId(reqParams.get("universityId")) == null){
				Librarian librarian = new Librarian();
				librarian.setEmail(reqParams.get("email"));
				librarian.setPassword(reqParams.get("password"));
				librarian.setUniversityId(reqParams.get("universityId"));
				librarian.setFirstName(reqParams.get("firstName"));
				librarian.setLastName(reqParams.get("lastName")); 
				librarian.setActivationCode(randomCode);
				System.out.println("after randomCode");
				librarian = librarianService.saveNewLibrarian(librarian);
			}
			else{
				return errorPage;
			}
		}
		else{
			if(patronService.findPatronByUniversityId(reqParams.get("universityId")) == null){
				Patron patron = new Patron();
				patron.setEmail(reqParams.get("email"));
				patron.setPassword(reqParams.get("password"));
				patron.setUniversityId(reqParams.get("universityId"));
				patron.setFirstName(reqParams.get("firstName"));
				patron.setLastName(reqParams.get("lastName")); 
				patron.setActivationCode(randomCode);
				patron = patronService.saveNewPatron(patron);
			}
			else{
				return errorPage;
			}
		}
		System.out.println("Email: "+reqParams.get("email") +"randomCode: "+randomCode);
		sendMail(reqParams.get("email"), randomCode);
		userActivation.addObject("universityId", reqParams.get("universityId"));
		userActivation.addObject("email", reqParams.get("email"));
		return userActivation;
		}
	
	/**
	 * 
	 * @param reqParams
	 * @param ucBuilder
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/completeRegistration", method = RequestMethod.POST)
	public String completeUserRegistration(@RequestParam Map<String, String> reqParams,
			UriComponentsBuilder ucBuilder, Model model) {
		String email = reqParams.get("email");
		String universityId = reqParams.get("universityId");
		if(email.contains("@sjsu.edu")){
			Librarian librarian = librarianService.findLibrarianByUniversityId(universityId);
			if(librarian.getActivationCode() == Integer.parseInt(reqParams.get("activationCode"))){
				librarian.setStatus(true);
				librarianService.updateLibrarian(librarian);
				model.addAttribute("httpStatus", HttpStatus.OK);
				return "userCreationSuccess";
			}
			else{
				return "wrongActivationCode";
			}
		}
		else{
			Patron patron = patronService.findPatronByUniversityId(universityId);
				if(patron.getActivationCode() == Integer.parseInt(reqParams.get("activationCode"))){
					patron.setStatus(true);
					patronService.updatePatron(patron);
					model.addAttribute("httpStatus", HttpStatus.CREATED);
					return "userCreationSuccess";
				}
				else{
					return "wrongActivationCode";
				}
		}	
	}	
	
	
	
	/**
	 * Search Books 
	 * Ruchit code strts here
	 * @param librarianID
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/checkout", method = RequestMethod.POST)
	public void checkout( Model model) {
		System.out.println("challa ");
		String books[]=new String[2];
		books[0]="1234";
		books[1]="12345";
		//bookStatusService.issueBooks(books);
		BookStatus bookStatus;
		Calendar c=new GregorianCalendar();
		Date issueDate=c.getTime();
		c.add(Calendar.DATE, 30);
		Date dueDate=c.getTime();
	
		
	Patron patron=patronService.findPatronByEmailId("kadakiaruchit@gmail.com");
	System.out.println("challa 1"+patron);
	
		if(patron.getDayIssuedCount()>5||patron.getTotalIssuedCount()>10)
		return ;
		
		
		for(int i=0;i<books.length;i++) {
			bookStatus=new BookStatus();
		
			Book book = bookService.findBookByISBN(books[i]);
			System.out.println("book bhai wala is "+book);
			
			bookStatus.setCurrentDate(issueDate);
			bookStatus.setDueDate(dueDate);
			bookStatus.setIssueDate(issueDate);
		
			bookStatus.setRequestDate(issueDate);
			bookStatus.setRequestStatus("done");
			bookStatus.setBook(book);
			bookStatusService.issueBooks(bookStatus);
		
		}
		
		System.out.println("Hi You have just checked out following items");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("kadakiaruchit@gmail.com");
        message.setSubject("SJSU Library Checkout on "+c.getTime());
        message.setText("Hi You have just checked out following items "
        		+ "\n = "+c.getTime()
        		+"\n Please don't reply on this email.");
        System.out.println("1");
        System.out.println(activationMailSender);
        activationMailSender.send(message);
		
		}

	public BookStatusService getBookStatusService() {
		return bookStatusService;
	}

	public void setBookStatusService(BookStatusService bookStatusService) {
		this.bookStatusService = bookStatusService;
	}
	
	
	
	
	
}
