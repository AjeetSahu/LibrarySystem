package edu.sjsu.cmpe275.term.controller;

import java.util.Map;

import javax.mail.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import edu.sjsu.cmpe275.term.model.Book;
import edu.sjsu.cmpe275.term.model.BookStatus;
import edu.sjsu.cmpe275.term.model.BookingCart;
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
	
	@PersistenceContext(unitName = "CMPE275TERM")
	private EntityManager entityManager;
	
	@Autowired
    ServletContext context;
	
	/**
	 * 
	 * @param context
	 */
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	/**
	 * 
	 * @param bookStatusService
	 */
	public void setBookStatusService(BookStatusService bookStatusService) {
		this.bookStatusService = bookStatusService;
	}

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
	 * GET GO TO WELCOME PAGE
	 * @author Pratik
	 *
	 */

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView goToWelcomePage(Model model) {
		ModelAndView welcome = new ModelAndView("welcome");
		return welcome;
	}
	
	/**
	 * GET ADD TO CART PAGE
	 * @author Pratik
	 *
	 */
	@RequestMapping(value = "/addToCart/{bookISBN}", method = RequestMethod.GET)
	@Transactional
	public String addToCart(@PathVariable("bookISBN") String isbn, Model model){
		//Session session = entityManager.unwrap(Session.class);
		BookingCart bookingCart = new BookingCart();
		Book book = bookService.findBookByISBN(isbn);
		book.setAvailableCopies(book.getAvailableCopies()-1);
		entityManager.merge(book);
        if (book != null) {
        	bookingCart.addCartItem(book);
        }
        return "redirect:/patronHome";
	}
	
	/**
	 * Remove all items from Cart
	 * @author Pratik
	 *
	 */
	@RequestMapping(value = "/clearCart", method = RequestMethod.GET)
    public void clearCart(Model model) {
		BookingCart bookingCart = new BookingCart();
		bookingCart.clearCart();
    }

	/**
	 * Remove a particular item from Cart
	 * @author Pratik
	 *
	 */
	@RequestMapping(value = "/removeFromCart/{bookISBN}", method = RequestMethod.GET)
    public void removeFromCart(@PathVariable("bookISBN") String isbn, Model model) {
		BookingCart bookingCart = new BookingCart();
		bookingCart.removeCartItemByISBN(isbn);
    }
	
	
	/**
	 * GET GO TO Activate User Page
	 * @author Amitesh
	 *
	 */

	@RequestMapping(value = "/activationPage", method = RequestMethod.GET)
	public ModelAndView activateUser(Model model) {
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
			if(librarian != null && librarian.getPassword().equals(reqParams.get("password")) && librarian.isStatus()==true){
//				librarian.setStatus(false);
				librarianService.updateLibrarian(librarian);
				request.getSession().setAttribute("loggedIn", librarian);
				request.getSession().setAttribute("email", librarian.getEmail());
				request.getSession().setAttribute("userName", librarian.getFirstName());
				System.out.println(request.getSession().getAttribute("loggedIn"));
			}else{
				modelAndView = new ModelAndView("Login");
				model.addAttribute("message", "Authentication failed, incorrect email or password!");
			}
		}else{
			System.out.println("email: "+reqParams.get("email"));
			Patron patron = patronService.findPatronByEmailId(reqParams.get("email"));

			if(patron != null && patron.getPassword().equals(reqParams.get("password")) && patron.isStatus()==true){
				modelAndView = new ModelAndView("PatronHome");
//				patron.setStatus(false);
				patronService.updatePatron(patron);
				request.getSession().setAttribute("loggedIn", patron);
				request.getSession().setAttribute("email", patron.getEmail());
				request.getSession().setAttribute("userName", patron.getFirstName());
				request.getSession().setAttribute("pattern", "");
				request.getSession().setAttribute("loggedIn", patron);
				request.getSession().setAttribute("userName", patron.getFirstName());
				
			}else{
				model.addAttribute("message", "Authentication failed, incorrect email or password!");
				modelAndView = new ModelAndView("Login");
			}		
		}
    	modelAndView.addObject("userEmail",request.getSession().getAttribute("userEmail"));
    	model.addAttribute("pattern","");
    	return modelAndView;
    }
    
    /**
     * LOGOUT A LOGGED IN USER
     * @param request
     * @return
     */
    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String signout(HttpServletRequest request){
        request.getSession().setAttribute("loggedIn", null);
        System.out.println("After logout " + request.getSession().getAttribute("loggedIn"));
      	return "Login";
    }
	
	/**
	 * Goto ADDNEWBOOK PAGE and search book by ISBN
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/newBook", method = RequestMethod.GET)
	public ModelAndView goToAddNewBookPage(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("Login");
			return login;
		}
		ModelAndView welcome = new ModelAndView("AddNewBook");
		return welcome;
	}
	
	/**
	 * Goto Patron Search Book from Database PAGE and search book by ISBN
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/patronSearchBook", method = RequestMethod.GET)
	public ModelAndView patronSearchBook(HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("Login");
			return login;
		}
		ModelAndView patronSearch = new ModelAndView("PatronSearchBook");
		return patronSearch;
	}
	
	/**
	 * Goto Patron Search Book from Database PAGE and search book by ISBN
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/patronReturnSearch", method = RequestMethod.GET)
	public ModelAndView patronReturnSearch(HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("Login");
			return login;
		}
		ModelAndView patronSearch = new ModelAndView("PatronReturnSearch");
		return patronSearch;
	}
	
	/**
	 * Goto ADDNEWBOOK PAGE and add book manually
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/newBookManually", method = RequestMethod.GET)
	public ModelAndView goToAddNewBookManualPage(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("Login");
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
	public ModelAndView registration(Model model) {
		ModelAndView register = new ModelAndView("Registration");
		return register;
	}
	
	/**
	 * Goto Login PAGE to to access Patron/Librarian account 
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model) {
		ModelAndView login = new ModelAndView("Login");
		model.addAttribute("message", "");
		return login;
	}
	/**
	 * CREATE NEW BOOK ON CLICKING ADD BOOK IN ADDNEWBOOK PAGE
	 * @author Pratik
	 * @param reqParams
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/newBook", method = RequestMethod.POST)
	public ModelAndView createNewBook(@RequestParam Map<String, String> reqParams, @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {
			Book book = new Book();
			if((reqParams.get("isbn"))!=null && (reqParams.get("isbn")).isEmpty()==false)
				book.setIsbn(reqParams.get("isbn"));
			if((reqParams.get("author"))!=null && (reqParams.get("author")).isEmpty()==false)
				book.setAuthor(reqParams.get("author"));
			if((reqParams.get("title"))!=null && (reqParams.get("title")).isEmpty()==false)
				book.setTitle(reqParams.get("title"));
			
			Publisher publisher = new Publisher();
			if(reqParams.get("publisher")!=null && (reqParams.get("publisher")).isEmpty()==false)
				publisher.setPublisher(reqParams.get("publisher"));
			DateFormat format = new SimpleDateFormat("y");
			Date date = null;
			try {
				if(reqParams.get("yearOfPublication")!=null && (reqParams.get("yearOfPublication")).isEmpty()==false){
					date = format.parse(reqParams.get("yearOfPublication").toString());
					publisher.setYearOfPublication(date);
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			Picture picture = new Picture();
			System.out.println("file: "+file);
			if(file!=null)
				picture.setImage(file);
			if(!picture.getImage().isEmpty()){					
				try {
					String webAppPath = context.getRealPath("/");
					File file1 = new File(webAppPath+"/resources/uploaded_images/" + String.valueOf(book.getIsbn()) + ".jpg");
					FileUtils.writeByteArrayToFile(file1, picture.getImage().getBytes());
					picture.setLocation(file1.getAbsolutePath());
				} catch(IOException e) { 
					System.out.println("Unable to save image "+e); 
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				picture.setLocation("/resources/images/book.png");
			}
			System.out.println(" 1   no of copies value is "+reqParams.get("numberOfCopies"));
			
			try{
				if(reqParams.get("phoneNumber")!=null && (reqParams.get("phoneNumber")).isEmpty()==false)
					publisher.setPhoneNumber(Integer.parseInt(reqParams.get("phoneNumber")));
				if(reqParams.get("numberOfCopies")!=null && (reqParams.get("numberOfCopies")).isEmpty()==false)
				{
					System.out.println("2  no of copies value is "+reqParams.get("numberOfCopies"));
					book.setNumberOfCopies(Integer.parseInt(reqParams.get("numberOfCopies")));
					book.setAvailableCopies(Integer.parseInt(reqParams.get("numberOfCopies")));
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
			book.setCoverImage(picture);
			book.setPublisher(publisher);
			if(reqParams.get("location")!=null && (reqParams.get("location")).isEmpty()==false)
				book.setLocation(reqParams.get("location"));
			if(reqParams.get("keywords").length()>0 && reqParams.get("keywords")!=null && (reqParams.get("keywords")).isEmpty()==false)
				book.setKeywords(Arrays.asList(reqParams.get("keywords").split("\\s*,\\s*")));
			book = bookService.saveNewBook(book);
			ModelAndView model = new ModelAndView("LibraryHome");
			model.addObject("httpStatus", HttpStatus.CREATED);
			model.addObject("book",book);
			model.addObject("message", "Book Added Successfully");
			return model;
	}
	
	
	/**
	 * CREATE NEW BOOK ON CLICKING ADD BOOK IN ADDNEWBOOK PAGE
	 * @author Pratik
	 * @param book
	 * @param ucBuilder
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/newBookAPI", method = RequestMethod.POST)
	public ModelAndView createNewBookAPI(@RequestParam Map<String, String> reqParams, HttpServletRequest request) {
			Book book = new Book();
			/*System.out.println("Inside createNewBookAPI");
			Iterator it = reqParams.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		    }*/
			if((reqParams.get("isbn"))!=null && (reqParams.get("isbn")).isEmpty()==false)
				book.setIsbn(reqParams.get("isbn"));
			if((reqParams.get("author"))!=null && (reqParams.get("author")).isEmpty()==false)
				book.setAuthor(reqParams.get("author"));
			if((reqParams.get("title"))!=null && (reqParams.get("title")).isEmpty()==false)
				book.setTitle(reqParams.get("title"));
			Publisher publisher = new Publisher();
			if(reqParams.get("publisher")!=null && (reqParams.get("publisher")).isEmpty()==false)
				publisher.setPublisher(reqParams.get("publisher"));
			book.setAvailableCopies(Integer.parseInt(reqParams.get("numberOfCopies")));
			DateFormat format = new SimpleDateFormat("y");
			Date date = null;
			try {
				if(reqParams.get("yearOfPublication")!=null && (reqParams.get("yearOfPublication")).isEmpty()==false){
					date = format.parse(reqParams.get("yearOfPublication").toString());
					publisher.setYearOfPublication(date);
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			Picture picture = new Picture();
			if(reqParams.get("image_location")!=null && (reqParams.get("image_location")).isEmpty()==false)
				picture.setLocation(reqParams.get("image_location"));
			try{
				if(reqParams.get("phoneNumber")!=null && (reqParams.get("phoneNumber")).isEmpty()==false)
					publisher.setPhoneNumber(Integer.parseInt(reqParams.get("phoneNumber")));
				if(reqParams.get("numberOfCopies")!=null && (reqParams.get("numberOfCopies")).isEmpty()==false)
					book.setNumberOfCopies(Integer.parseInt(reqParams.get("numberOfCopies")));
			}
			catch(Exception e){
				System.out.println(e);
			}
			book.setCoverImage(picture);
			book.setPublisher(publisher);
			if(reqParams.get("location")!=null && (reqParams.get("location")).isEmpty()==false)
				book.setLocation(reqParams.get("location"));
			if(reqParams.get("keywords").length()>0 && reqParams.get("keywords")!=null && (reqParams.get("keywords")).isEmpty()==false)
				book.setKeywords(Arrays.asList(reqParams.get("keywords").split("\\s*,\\s*")));
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
//	@RequestMapping(value="/book/{bookISBN}", method = RequestMethod.GET)
//	public ModelAndView getBookByISBN(@PathVariable("bookISBN") String isbn, Model model, HttpServletRequest request) {
//		System.out.println("getBookByISBN");
//		if(request.getSession().getAttribute("loggedIn") == null){
//			ModelAndView login = new ModelAndView("Login");
//			return login;
//		}
//		ModelAndView bookFound= new ModelAndView("BookFound");
//		ModelAndView bookNotFound= new ModelAndView("Error");
//		Book book = bookService.findBookByISBN(isbn);
//		System.out.println("working getBookByISBN"+book);
//		System.out.println("book "+book);
//		if(book == null){
//	        System.out.println("Unable to find book as book with ISBN "+isbn+" doesnot exist");
//	        bookNotFound.addObject("message","Unable to find book as book with ISBN "+isbn+" doesnot exist");
//	        bookNotFound.addObject("httpStatus", HttpStatus.NOT_FOUND);
//			return bookNotFound;
//	    }
//		bookFound.addObject("book", book);
//		bookFound.addObject("test", "test");
//		bookFound.addObject("httpStatus", HttpStatus.OK);
//		return bookFound;	
//	}
	
	@RequestMapping(value="/book/{bookISBN}", method = RequestMethod.GET)
	public String getBookByISBN(@PathVariable("bookISBN") String isbn, Model model, HttpServletRequest request) {
		System.out.println("getBookByISBN");
		if(request.getSession().getAttribute("loggedIn") == null){
			return "Login";
		}
		
		Book book = bookService.findBookByISBN("9788881555581");
		System.out.println("working getBookByISBN"+book);
		System.out.println("book "+book);
		if(book == null){
	        System.out.println("Unable to find book as book with ISBN "+isbn+" doesnot exist");
	        model.addAttribute("message","Unable to find book as book with ISBN "+isbn+" doesnot exist");
	        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND);
			return "Error";
	    }
		model.addAttribute("book", book);
		model.addAttribute("author", book.getAuthor());
		model.addAttribute("test", "test");
		model.addAttribute("httpStatus", HttpStatus.OK);
		return "PatronHome";	
	}
	
	@RequestMapping(value="/searchBookByTitle/{pattern}", method = RequestMethod.GET)
	public String searchBookByTitle(@PathVariable("pattern") String pattern, Model model, HttpServletRequest request){
		System.out.println("Hi Search book by Title: "+pattern);
		//String pattern = reqParams.get("isbn");
		if(pattern.equals(""))
			return "PatronHome";
		request.getSession().setAttribute("pattern", pattern);
		Query q = entityManager.createNativeQuery("SELECT * FROM book where title LIKE '%" + pattern + "%'", Book.class);
		List<Book> books = q.getResultList();
		int i = 0;
		while(books.size() > i){
			System.out.println(books.get(i).getAuthor());
			i++;
		}
		model.addAttribute("books", books);
		return "PatronHome";
	}
	
	
	@RequestMapping(value="/book/return/{bookISBN}", method = RequestMethod.GET)
	public ModelAndView getBookReturnByISBN(@PathVariable("bookISBN") String isbn, Model model, HttpServletRequest request) {
		System.out.println("getBookByISBN");
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("Login");
			return login;
		}
		ModelAndView bookFound= new ModelAndView("BookReturnFound");
		ModelAndView bookNotFound= new ModelAndView("Error");
		Book book = bookService.findBookByISBN(isbn);
		System.out.println("working getBookByISBN"+book);
		System.out.println("book "+book);
		if(book == null){
	        System.out.println("Unable to find book as book with ISBN "+isbn+" doesnot exist");
	        bookNotFound.addObject("message","Unable to find book as book with ISBN "+isbn+" doesnot exist");
	        bookNotFound.addObject("httpStatus", HttpStatus.NOT_FOUND);
			return bookNotFound;
	    }
		bookFound.addObject("book", book);
		bookFound.addObject("test", "test");
		bookFound.addObject("httpStatus", HttpStatus.OK);
		return bookFound;	
	}
	
	
	/**
	 * GET BOOK BY ISBN
	 * @author Pratik 
	 * @param isbn
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/book/update/{bookISBN}", method = RequestMethod.GET)
	public ModelAndView getBookByISBNForUpdate(@PathVariable("bookISBN") String isbn, Model model, HttpServletRequest request) {
		System.out.println("inside getBookByISBN"+isbn);
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("Login");
			return login;
		}
		ModelAndView bookFound= new ModelAndView("LibrarianUpdateBookDetail");
		ModelAndView bookNotFound= new ModelAndView("Error");
		Book book = bookService.findBookByISBN(isbn);
		System.out.println("working getBookByISBN"+book);
		System.out.println("book "+book);
		if(book == null){
	        System.out.println("Unable to find book as book with ISBN "+isbn+" doesnot exist");
	        bookNotFound.addObject("message","Unable to find book as book with ISBN "+isbn+" doesnot exist");
	        bookNotFound.addObject("httpStatus", HttpStatus.NOT_FOUND);
			return bookNotFound;
	    }
		bookFound.addObject("book", book);
		bookFound.addObject("test", "test");
		bookFound.addObject("httpStatus", HttpStatus.OK);
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
	public ModelAndView deleteBook(@PathVariable("bookISBN") String isbn, Model model, HttpServletRequest request) {
		ModelAndView login= new ModelAndView("Login");
		if(request.getSession().getAttribute("loggedIn") == null){
			return login;
		}
		ModelAndView deletedBook= new ModelAndView("BookDeletedSuccessfully");
		ModelAndView notDeletedBook= new ModelAndView("Error");
		System.out.println("inside deleteBook");
		Book book = bookService.findBookByISBN(isbn);
		if(book==null){
	        notDeletedBook.addObject("message", "A book with ISBN "+isbn+" doesnot exist");
	        notDeletedBook.addObject("httpStatus", HttpStatus.NOT_FOUND);
			return notDeletedBook;
	    }
		if(book.getNumberOfCopies()==book.getAvailableCopies()){
			bookService.deleteBookByISBN(isbn);
			notDeletedBook.addObject("httpStatus", HttpStatus.OK);
			return deletedBook;
		}else{
			notDeletedBook.addObject("message", "Cannot be deleted as checkout by patron");
			notDeletedBook.addObject("httpStatus", HttpStatus.FORBIDDEN);
			return notDeletedBook;
		}		
		
	}
	
	/**
	 * UPDATE Book ON CLICKING UPDATE IN UPDATEBOOK PAGE
	 * @author Pratik
	 * @param book
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value="/book/{bookISBN}", method = RequestMethod.POST)
	public String updateBook(@PathVariable("bookISBN") String isbn,
			@RequestParam Map<String, String> reqMap,
			Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			return "Login";
		}
		System.out.println("IN UPDATE METHOD"+reqMap.get("author"));
		Book book1 = bookService.findBookByISBN(isbn);
//		if(book1 == null){
//	        System.out.println("Unable to update as book with id "+book.getIsbn()+" doesnot exist");
//	        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND);
//			return "BookNotFound";
//	    }
		book1.setAuthor(reqMap.get("author"));
		book1.setTitle(reqMap.get("title"));
		book1.setLocation(reqMap.get("location"));
		book1.setNumberOfCopies(Integer.parseInt(reqMap.get("numberOfCopies")));
		book1.getPublisher().setPublisher(reqMap.get("publisher"));
		bookService.updateBook(book1);
		model.addAttribute("httpStatus", HttpStatus.OK);
		return "redirect:/libraryHome";
	}
	
//	@RequestMapping(value="/book/{bookISBN}", method = RequestMethod.POST)
//	public String updateBook(@ModelAttribute("book") Book book,
//			Model model, HttpServletRequest request) {
//		if(request.getSession().getAttribute("loggedIn") == null){
//			return "Login";
//		}
//		System.out.println("IN UPDATE METHOD");
//		Book book1 = bookService.findBookByISBN(book.getIsbn());
//		if(book1 == null){
//	        System.out.println("Unable to update as book with id "+book.getIsbn()+" doesnot exist");
//	        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND);
//			return "BookNotFound";
//	    }
//		bookService.updateBook(book);
//		model.addAttribute("httpStatus", HttpStatus.OK);
//		return "BookUpdatedSuccessfully";
//	}
	
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
	public String patronHome(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			//ModelAndView login = new ModelAndView("Login");
			return "Login";
		}
		//ModelAndView patron = new ModelAndView("PatronHome");
		Book book = bookService.findBookByISBN("9788881555581");
		model.addAttribute("author",book.getAuthor());
		System.out.println("book: "+book);
		model.addAttribute("pattern",request.getSession().getAttribute("patron"));
		return "PatronHome";
	}
	
	/**
	 * Goto Librarian Home PAGE to access features 
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/libraryHome", method = RequestMethod.GET)
	public ModelAndView libraryHome(Model model, HttpServletRequest request) {
		System.out.println("current value in sesson is " + request.getSession().getAttribute("loggedIn"));
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("Login");
			return login;
		}
		ModelAndView librarian = new ModelAndView("LibraryHome");
		return librarian;
	}
	
	
	/**
	 * Goto Librarian Home PAGE to access features 
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/updateBook", method = RequestMethod.GET)
	public ModelAndView libraryUpdateBook(HttpServletRequest request) {
		System.out.println("current value in sesson is " + request.getSession().getAttribute("loggedIn"));
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("Login");
			return login;
		}
		ModelAndView librarian = new ModelAndView("LibrarianUpdateBook");
		return librarian;
	}
	
	/**
	 * Goto Librarian AddBook Manually Page 
	 * @author Amitesh
	 *
	 */
	@RequestMapping(value = "/addNewBookManually", method = RequestMethod.GET)
	public ModelAndView addNewBookManually(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("Login");
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
	public ModelAndView patronProfile(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("Login");
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
	public ModelAndView libraryProfile(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView login = new ModelAndView("Login");
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
	public ModelAndView error(Model model) {
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
			ModelAndView login = new ModelAndView("Login");
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
	
/*	*//**
	 * CREATE NEW LIBRARIAN ON CLICKING CREATE LIBRARIAN IN SIGNUP PAGE
	 * @author Pratik 
	 * @param librarian
	 * @param ucBuilder
	 * @param model
	 * @return
	 *//*
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
	}*/

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
			ModelAndView login = new ModelAndView("Login");
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
	public ModelAndView deleteSearch(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("loggedIn") == null){
			ModelAndView delete = new ModelAndView("Login");
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
		ModelAndView userActivation = null;
		try{
		userActivation= new ModelAndView("ActivationPage");
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
				errorPage.addObject("httpStatus", "ErrorLogin");
				errorPage.addObject("message", "Id already Exist");
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
				errorPage.addObject("httpStatus", "ErrorLogin");
				errorPage.addObject("message", "Id already Exist");
				return errorPage;
			}
		}
		System.out.println("Email: "+reqParams.get("email") +"randomCode: "+randomCode);
		sendMail(reqParams.get("email"), randomCode);
		userActivation.addObject("universityId", reqParams.get("universityId"));
		userActivation.addObject("email", reqParams.get("email"));
		}
		catch(DataIntegrityViolationException e1){
			System.out.println("Exception: "+e1);
			userActivation= new ModelAndView("Error");
		}
		catch(Exception e){
			System.out.println("Exception: "+e);
			userActivation= new ModelAndView("Error");
		}
		return userActivation;
		}
	
/*	*//**
	 * 
	 * @param reqParams
	 * @param ucBuilder
	 * @param model
	 * @return
	 *//*
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
	}*/	
	
	/**
	 * Search Books 
	 * Ruchit code strts here
	 * @param librarianID
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/checkout", method = RequestMethod.POST)
	@Transactional
	public ModelAndView checkout(@RequestParam(value = "isbn[]") String[] isbnArray,Model model, HttpServletRequest request) {
		ModelAndView success = new ModelAndView("PatronHome");
		ModelAndView error = new ModelAndView("Error");
		System.out.println("inside checkout ");
		System.out.println(isbnArray[0]);
		String email="kadakiaruchit@gmail.com";
		//String email = ((Patron)request.getSession().getAttribute("loggedIn")).getEmail();
		System.out.println(email);
		Calendar c = new GregorianCalendar();
		Date issueDate = c.getTime();
		c.add(Calendar.DATE, 30);
		Date dueDate = c.getTime();	
		Patron patron=patronService.findPatronByEmailId(email);
		String checkoutData="";
		
		if(isbnArray.length>5){

		//	model.addAttribute("message2","You cant checkout more than 5 books at a time");
	error.addObject("message", "You cant checkout more than 5 books at a tiime");
			return error;
		}
		
		
		if(patron.getDayIssuedCount()+isbnArray.length>5){
			error.addObject("message1", "You cant checkout more than 5 books in one day");
					return error;
				}
		
		

		if(patron.getTotalIssuedCount()+isbnArray.length>10){
			error.addObject("message1", "You cant checkout more than total 10 books ");
					return error;
				}
		
		System.out.println("before for in checkout ");
	
		
		List<BookStatus> patronsBookStatus=patron.getBookStatus();
		
		System.out.println("before for in checkout 1 "+patronsBookStatus.size());
		
		for(int i=0;i<isbnArray.length;i++){
			
			for(int j=0;j<patronsBookStatus.size();j++){
				
				BookStatus bookStatus = new BookStatus();
				
				if(isbnArray[i].equals(patronsBookStatus.get(j).getBook().getIsbn())){
					System.out.println("fuck u");
					return error;
				}
			}
		}
		
		for(int i=0;i<isbnArray.length;i++){
			
	
			
			BookStatus bookStatus = new BookStatus();
			
		
			

		    Book book = bookService.findBookByISBN(isbnArray[i]);
		    System.out.println("challa 1"+patron+book.getIsbn());
			if(book.getAvailableCopies()<=0){
				error.addObject("message","Sorry, Requested book is not available");
				
				return error;
			}		
				
			patron.setDayIssuedCount(patron.getDayIssuedCount()+1);
			patron.setTotalIssuedCount(patron.getTotalIssuedCount()+1);
			
			System.out.println(book.getIsbn()+" book bhai wala is "+book);
			//bookStatus.setCurrentDate(issueDate);
			bookStatus.setDueDate(dueDate);
			bookStatus.setIssueDate(issueDate);
			//bookStatus.setRequestDate(issueDate);
			//bookStatus.setRequestStatus("done");
			bookStatus.setBook(book);
			bookStatus.getPatrons().add(patron);
			book.setAvailableCopies(book.getAvailableCopies()-1);			
			entityManager.persist(book);
			entityManager.persist(patron);
			//bookStatus.getPatrons().add(patron);
			entityManager.persist(bookStatus);

			checkoutData+="\n  ISBN: "+book.getIsbn()+" TITLE:"+book.getTitle()+"	";
		}
		System.out.println("Hi You have just checked out following items");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("SJSU Library Checkout on "+c.getTime());
        message.setText("Hi You have just checked out following items "+checkoutData
        	+ "\n = issueDate : "+issueDate+"   DueDate : "+dueDate+"   "
        		+"\n Please don't reply on this email.");
        System.out.println("1");
        System.out.println(activationMailSender);
        activationMailSender.send(message);
        return success;
		}
		
	
	 /* Search Books 
	 * Ruchit code strts here
	 * @param librarianID
	 * @param model
	 * @return
	 * 
	 */ 
	

	@RequestMapping(value="/checkout/return", method = RequestMethod.POST)
	public ModelAndView Return(@RequestParam(value = "isbn[]") String[] isbnArray, Model model, HttpServletRequest request) {
		ModelAndView success = new ModelAndView("PatronHome");
		ModelAndView error = new ModelAndView("Error");
		
		System.out.println("inside checkout ");
		String email="kadakiaruchit@gmail.com";
		
		
		//System.out.println(reqParams.get("isbn"));
		//String email = ((Patron)request.getSession().getAttribute("loggedIn")).getEmail();
		System.out.println(email);
		Calendar c=new GregorianCalendar();
		Date returnDate=c.getTime();
	//	int days = Days.daysBetween(returnDate, returnDate).getDays();
		//c.add(Calendar.DATE, 30);
//		Date dueDate=c.getTime();	
//		System.out.println();
		
	
		String checkoutReturnData="";
		
	
		
		Patron patron=patronService.findPatronByEmailId(email);
		
		if(isbnArray.length>10){

		//	model.addAttribute("message2","You cant checkout more than 5 books at a time");
	error.addObject("message", "You cant return more than 10 books at a tiime");
		
	return error;
			
		}
	
		
		List<BookStatus> patronsBookStatus=patron.getBookStatus();
		for(int i=0;i<patronsBookStatus.size();i++){
		System.out.println("bhaijaan"+patronsBookStatus.get(i).getBookStatusId()+"  "+patronsBookStatus.get(i).getBook().getIsbn());
		for(int j=0;j<isbnArray.length;j++){
			
			if(isbnArray[j].equals(patronsBookStatus.get(i).getBook().getIsbn())){
				System.out.println("deleting book isbn of "+isbnArray[j]);
				checkoutReturnData+="\n"+patronsBookStatus.get(i).getBook().getIsbn()+"  "+patronsBookStatus.get(i).getBook().getTitle()+"  "+patronsBookStatus.get(i).getIssueDate();
				System.out.println("deleting book isbn of "+isbnArray[j]);
				int penalty=(int)(returnDate.getTime()-patronsBookStatus.get(i).getDueDate().getTime()/(1000 * 60 * 60 * 24));
				System.out.println(penalty);
				if(penalty>0){
			
				patron.setPenalty(patron.getPenalty()+penalty);
			
				}
				
				bookStatusService.returnBooks(patronsBookStatus.get(i).getBookStatusId());
				break;
			}
		}
		
		}
		
		
		
		
		
			
		System.out.println("Hi You have just Returned out following item");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("SJSU Library Return on "+c.getTime());
        message.setText("Hi You have just return out following items "
        		+checkoutReturnData +"     Rerturn date is "	+returnDate+ "\n = "+c.getTime()
        		+"\n Please don't reply on this email.");
        System.out.println("bhaijaan mail bje dia");
        System.out.println(activationMailSender);
        activationMailSender.send(message);
        return success;

		} 
	
	
	/**
	 * Will set date and time of application as input by user in variable "appTIme"
	 * @param reqParams
	 * @param request
	 */
	@RequestMapping(value="/setDateTime", method = RequestMethod.POST)
	@Transactional
	public void setDateTime(@RequestParam Map<String, String> reqParams, HttpServletRequest request){
		//"EEEE, MMM dd, yyyy HH:mm:ss a"
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = null;
		try {
			date = formatter.parse(reqParams.get("appTime"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("appTime", date);
  
 /*
            System.out.println(date);
            BookStatus bookstatus = new BookStatus();
            Book book = bookService.findBookByISBN("471417439");
            bookstatus.setCurrentDate(date);
            bookstatus.setBook(book);
            bookstatus.setReturnDate(date);
            entityManager.persist(bookstatus);*/
         
	}
	
	
	
	@RequestMapping(value="/requestBook/{bookISBN}", method = RequestMethod.POST)
	@Transactional
	public ModelAndView set( @PathVariable("bookISBN") String isbn, HttpServletRequest request){
		ModelAndView requestSuccess = new ModelAndView("BookRequestSuccess");
		Book book = bookService.findBookByISBN(isbn);
		if(book.getAvailableCopies() == 0){
			String email = (String)request.getSession().getAttribute("email");
			System.out.println("email address is " + email);
			Patron patron = patronService.findPatronByEmailId(email);
			BookStatus bookstatus = new BookStatus();
			System.out.println("date to be set is " + (Date)request.getSession().getAttribute("appTime"));
			bookstatus.setAssignedDate((Date)request.getSession().getAttribute("appTime"));
			bookstatus.setRequestDate((Date)request.getSession().getAttribute("appTime"));
	        bookstatus.setRequestStatus("requested");
	        bookstatus.getPatrons().add(patron);
	        bookstatus.setBook(book);
	        //patron.getBookStatus().add(bookstatus);
	        //patronService.updatePatron(patron);
			//entityManager.persist(book);
			entityManager.persist(patron);
			entityManager.persist(bookstatus);
	        requestSuccess.addObject("message", "book have been requested");
	        return requestSuccess; 
		}
		else{
			ModelAndView error = new ModelAndView("BookRequestError");
			error.addObject("message", "Book is available");
			return error;
		}
	}

	@RequestMapping("/tester")
	public void tester(HttpServletRequest request){
		String email = (String)request.getSession().getAttribute("email");
		System.out.println(email);
	}
	@Scheduled(fixedRate = 10000)
	public void removeRequestAfterThreeDays(){
		Query q = entityManager.createNativeQuery("SELECT * FROM cmpe275termdb.book_status where requeststatus = 'emailed';", BookStatus.class);
		List<BookStatus> bookstatuslist = q.getResultList();
		int i = 0;
		while(bookstatuslist.size() > i){
			
			i++;
		}
		System.out.println("cron job running");
			
	}
	
}


//patron cant keep a more than 1 boook for same isbn
