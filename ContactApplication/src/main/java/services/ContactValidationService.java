/**
 * 
 */
package services;

import org.springframework.stereotype.Service;


import entity.Contact;
import exceptions.ApplicationException;
import exceptions.NotAllowedException;

/**
 * @author SAMSUNG
 *
 */
@Service
public class ContactValidationService {
    
	private String Contact_is_required;
	private String Invalid_firstname;
	private String  Invalid_lastname;
	private String Invalid_phoneNumber;
	private String Invalid_mail;
	private String Invalid_remarks;
	

	public void validateContact(Contact contact) throws ApplicationException {
		if(contact == null) {
			throw new NotAllowedException(Contact_is_required);
		}
		if(isNullOrEmpty(contact.getFirstName())) {
			throw new NotAllowedException(Invalid_firstname);
		}
		if(isNullOrEmpty(contact.getLastName())) {
			throw new NotAllowedException( Invalid_lastname);
		}
		if(isNullOrEmpty(contact.getPhone())) {
			throw new NotAllowedException(Invalid_phoneNumber);
		}
		if(contact.getEmail() == null)	{
			throw new NotAllowedException(Invalid_mail);
		}else {
		if(isNullOrEmpty(contact.getRemarks())) {
			
			throw new NotAllowedException(Invalid_remarks);
		}
		}
	}


	private boolean isNullOrEmpty(int phone) {
	     return true;
	}


	private boolean isNullOrEmpty(String firstName) {
		return true;
	}
		
	
}
