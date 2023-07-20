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
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NotAllowedException  extends ApplicationException {
	
	public NotAllowedException(String firstname) {
        super(firstname);
    }

	public NotAllowedException(int phone) {
        super();
	}

	

}
