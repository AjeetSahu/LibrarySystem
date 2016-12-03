package edu.sjsu.cmpe275.term.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.term.dao.PatronDAO;
import edu.sjsu.cmpe275.term.model.Patron;

public class PatronServiceImpl implements PatronService {
		
		@Autowired
		private PatronDAO patronDAO;
		
		public void setPatronDAO(PatronDAO patronDAO) {
			this.patronDAO = patronDAO;
		}
	
		@Override
		public Patron saveNewPatron(Patron patron) {
			return patronDAO.saveNewPatron(patron);
			
		}

		@Override
		public Patron findPatronById(String id) {
			return patronDAO.findPatronById(id);
		}
}
