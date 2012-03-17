package cz.fi.muni.jhuska.bc.api;

import java.util.List;

/**
 * Validation component represents all kind of validation messages mostly.
 * 
 * @author jhuska
 *
 */
public interface ValidationComponent extends Component {

	/**
	 * Returns the list containing all the messages currently on the page. 
	 * 
	 * @return
	 */
	List<Message> getAllMessages();
	
	/**
	 * Returns the list containing all the error messages currently on the page.
	 * 
	 * @return
	 */
	List<ErrorMessage> getAllErrorMessages();
	
	/**
	 * Returns the list containing all the info messages currently on the page.
	 * 
	 * @return
	 */
	List<ErrorMessage> getAllInfoMessages();
	
	/**
	 * Determines whether the given message is rendered on the page.
	 * 
	 * @param msg
	 * @return
	 */
	boolean isMessageRendered(Message msg);
	
	/**
	 * Represents the general messages which can appear on the page during validation.
	 * 
	 * @author jhuska
	 *
	 */
	public interface Message {
		
		/**
		 * Returns the string representation of this message.
		 * @return
		 */
		String getValue();
	}
	
	/**
	 * Represents error message which can appear on the page during validation.
	 * 
	 * @author jhuska
	 *
	 */
	public interface ErrorMessage extends Message {
		
	}
	
	/**
	 * Represents info message which can appear on the page during validation.
	 * 
	 * @author jhuska
	 *
	 */
	public interface InfoMessage extends Message {
		
	}
}
