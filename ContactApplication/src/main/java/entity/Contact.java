/**
 * 
 */
package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author SAMSUNG
 *
 */
@Entity
@Table(name="contact")
public class Contact {

	@Id
	private int contactId;
	private int userId;
	private String FirstName;
	private String LastName;
	private String Email;
	private static int Phone;
	private String Remarks;
	/**
	 * @param contactId
	 * @param userId
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phone
	 * @param remarks
	 */
	public Contact(int contactId, int userId, String firstName, String lastName, String email, int phone,
			String remarks) {
		super();
		this.contactId = contactId;
		this.userId = userId;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Phone = phone;
		Remarks = remarks;
	}
	/**
	 * @return the contactId
	 */
	public int getContactId() {
		return contactId;
	}
	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return FirstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return LastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}
	/**
	 * @return the phone
	 */
	public int getPhone() {
		return Phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
		Phone = phone;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return Remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public static int randomPhone() {
		
		return Phone;
		
		
	}
	
}
