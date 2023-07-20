/**
 * 
 */
package controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Contact;
import exceptions.ResourceNotFoundException;
import services.ContactService;

/**
 * @author SAMSUNG
 *
 */
@CrossOrigin()
@RestController
@RequestMapping("/contact/v1")
public class ContactsController {
     
	private final ContactService contactsService;
	
	private static final Logger log = LoggerFactory.getLogger(ContactService.class);
	
    @Autowired
	public ContactsController(ContactService contactsService) {
	        this.contactsService = contactsService;
	}
    
    @PostMapping(value = "/contact")
    public ResponseEntity<Object> createContact(@RequestBody Contact contact) {
        try {
            Contact createdContact = contactsService.addOrUpdateContact(contact);
            return ResponseHandler.response(createdContact, HttpStatus.OK);
        } catch (Exception e) {
            log.info("Error while add new contact, msg " + e.getMessage());
            return ResponseHandler.error(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }
    
    @GetMapping(value = "/contacts/{contactId}")
    public ResponseEntity<Object> getContactsById(@PathVariable("contactId") int contactId) {
        try {
            List<Contact> contacts = contactsService.getContactById(contactId);
            return ResponseHandler.response(contacts, HttpStatus.OK);
        } catch (Exception e) {
            log.info("Error while get contacts by contactid, msg " + e.getMessage());
            return ResponseHandler.error(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }
    
    @GetMapping(value = "/contacts/search/{firstName}")
    public ResponseEntity<Object> getContactByFirstName(@PathVariable("firstName") String firstName) {
        try {
            List<Contact> contacts = contactsService.getContactByFirstName(firstName);
            return ResponseHandler.response(contacts, HttpStatus.OK);
        } catch (Exception e) {
            log.info("Error while get contacts by firstname, msg " + e.getMessage());
            return ResponseHandler.error(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }
    
    @GetMapping(value = "/contacts/search/{lastName}")
    public ResponseEntity<Object> getContactByLastName(@PathVariable("lastName") String lastName) {
        try {
            List<Contact> contacts = contactsService.getContactByLastName(lastName);
            return ResponseHandler.response(contacts, HttpStatus.OK);
        } catch (Exception e) {
            log.info("Error while get contacts by lastname, msg " + e.getMessage());
            return ResponseHandler.error(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }
    
    @GetMapping(value = "/contacts/search/{Phone}")
    public ResponseEntity<Object> getContactByPhoneNumber(@PathVariable("Phone") int Phone) {
        try {
            List<Contact> contacts = contactsService.getContactByPhoneNumber(Phone);
            return ResponseHandler.response(contacts, HttpStatus.OK);
        } catch (Exception e) {
            log.info("Error while get contacts by phone number, msg " + e.getMessage());
            return ResponseHandler.error(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }
    
    @PutMapping(value= "/contact/{contactId}")
    public ResponseEntity<Object> updateContactByContactId(@PathVariable("contactId") int contactId) {
    	try {
    		List<Contact> contacts = contactsService.UpdateContactByContactId(contactId);
    		return ResponseHandler.response(contacts,HttpStatus.OK);
    	} catch (Exception e) {
    		log.info("Error while updating contacts by contactid,msg " + e.getMessage());
    		return ResponseHandler.error(e.getMessage(),HttpStatus.MULTI_STATUS);
    	}
    }
    
    @DeleteMapping(value = "/contact/{contactId}")
    public ResponseEntity<Object> deleteContactByContactId(@PathVariable("contactId") int contactId) {
        try {
            contactsService.getContactByContactId(contactId)
                    .orElseThrow(() -> new ResourceNotFoundException(CONTACT_NOT_FOUND));
            return ResponseHandler.response(contactsService.deleteByContactId(contactId), HttpStatus.OK);
        } catch (Exception e) {
            log.info("Error while delete contact by contactid " + contactId + ", msg " + e.getMessage());
            return ResponseHandler.error(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }
    
  
	
}
