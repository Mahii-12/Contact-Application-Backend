/**
 * 
 */
package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author SAMSUNG
 *
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ApplicationException extends Exception {
	
	public ApplicationException(String message) {
        super(message);
    }
	
	public ApplicationException(int contactId) {
        super();
    }

	public ApplicationException() {
		
	}

}
