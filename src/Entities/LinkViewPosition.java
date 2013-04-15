package Entities;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Strategy that sorts the URLs by position in the document
 * @author Chris Timmons
 *
 */
public class LinkViewPosition extends LinkViewStrategy {
	
	/**
	 * Finds URLs and sorts them by position
	 * @param matcher, the matcher for the URL regular expression
	 * @return the list of links sorted by position
	 */
	@Override public ArrayList<String> sortURLs(Matcher matcher) {
		ArrayList<String> result = new ArrayList<String>();
		while (matcher.find()) {
			result.add(matcher.group());
		}

		return result;
	}
}
