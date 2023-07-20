/**
 * 
 */
package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Contact;

/**
 * @author SAMSUNG
 *
 */
public interface ContactRepository extends JpaRepository<Integer,Contact>{
      
	List<Contact> findByFirstName(String FirstName);
	
	List<Contact> findByLastName(String LastName);
	
	List<Contact> findByPhone(int Phone);

	Contact save(Contact contact);

	List<Contact> findById(int contactId);

	List<Contact> UpdateContactByContactId(int contactId);

	int existsById(int contactId);

	int existsByPhone(int phone);

	List<Contact> FindContactByContactId(int contactId);
	

}
