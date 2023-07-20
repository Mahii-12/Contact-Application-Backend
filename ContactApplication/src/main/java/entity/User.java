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
@Table(name="user")
public class User {
       
	@Id
	private int userId;
	private String FrstName;
	private String LastName;
	private String Email;
	private int PhoneNumber;
	/**
	 * @param userId
	 * @param frstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 */
	public User(int userId, String frstName, String lastName, String email, int phoneNumber) {
		super();
		this.userId = userId;
		FrstName = frstName;
		LastName = lastName;
		Email = email;
		PhoneNumber = phoneNumber;
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
	 * @return the frstName
	 */
	public String getFrstName() {
		return FrstName;
	}
	/**
	 * @param frstName the frstName to set
	 */
	public void setFrstName(String frstName) {
		FrstName = frstName;
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
	 * @return the phoneNumber
	 */
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	
	
}
