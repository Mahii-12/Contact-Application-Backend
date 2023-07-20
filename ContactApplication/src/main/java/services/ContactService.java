/**
 * 
 */
package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Contact;
import exceptions.ApplicationException;
import exceptions.NotAllowedException;
import repository.ContactRepository;

/**
 * @author SAMSUNG
 *
 */
@Service
public class ContactService {
	
	private final ContactRepository contactRepository;
	private final ContactValidationService validationService;
	/**
	 * @param contactRepository
	 * @param validationService
	 */
	@Autowired 
	public ContactService(ContactRepository contactRepository, ContactValidationService validationService) {
		super();
		this.contactRepository = contactRepository;
		this.validationService = validationService;
	}
	
	public Contact addOrUpdateContact(Contact contact) throws ApplicationException {
		validationService.validateContact(contact);
		if(isNullOrEmpty(contact.getPhone())) {
			contact.setPhone(Contact.randomPhone());
		}
        return contactRepository.save(contact);
	}
	
	 public List<Contact> getContactByFirstName(String firstname) throws ApplicationException {
	        if (isNullOrEmpty(firstname)) throw new NotAllowedException(firstname);
	        return contactRepository.findByFirstName(firstname);
	    }
	 
	 private boolean isNullOrEmpty(String firstname) {
		
		return true;
	  }

	public List<Contact> getContactByLastName(String lastname) throws ApplicationException {
	        if (isNullOrEmpty(lastname)) throw new NotAllowedException(lastname);
	        return contactRepository.findByLastName(lastname);
	    }
	 
	 public List<Contact> getContactByPhoneNumber(int phone) throws ApplicationException {
	        if (isNullOrEmpty(phone)) throw new NotAllowedException(phone);
	        return contactRepository.findByPhone(phone);
	    }
	 
	 private boolean isNullOrEmpty(int phone) {
		
		return true;
	}

	 public List<Contact> UpdateContactByContactId(int contactId) throws ApplicationException {
			if(isNullOrEmpty(contactId)) throw new NotAllowedException(contactId);
			return contactRepository.UpdateContactByContactId(contactId);
		}
	 
	 public List<Contact> getContactByContactId(int contactId) throws ApplicationException {
		 if(isNullOrEmpty(contactId)) throw new NotAllowedException(contactId);
			return contactRepository.FindContactByContactId(contactId);
		}
	 
	 
	 
	 
	 public List<Contact> getContactById(int contactId) throws ApplicationException {
	        if (isNullOrEmpty(contactId)) throw new NotAllowedException(contactId);
	        return contactRepository.findById(contactId);
	    }
	 
	 public boolean deleteAll() {
	        contactRepository.deleteAll();
	        return true;
	    }

    public void deleteByContactId(int contactId) throws ApplicationException {
		if(isNullOrEmpty(contactId)) throw new NotAllowedException(contactId);
	     contactRepository.existsById(contactId);
	   
	}

	public void deleteByPhone(int phone) throws ApplicationException {
		if(isNullOrEmpty(phone)) throw new NotAllowedException(phone);
		contactRepository.existsByPhone(phone);
	}

}