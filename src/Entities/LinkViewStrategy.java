package Entities;

import java.util.ArrayList;

/**
 * Interface for the link view strategies
 * @author Chris Timmons
 *
 */
public interface LinkViewStrategy {
	
	/**
	 * The strategy method that is different in each subclass
	 * @param input, the document string to look through
	 * @return list of urls
	 */
	public ArrayList<String> getURLs(String input);
}
