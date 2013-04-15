package Entities;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Strategy that sorts the URLs by position in the document
 * @author Chris Timmons
 *
 */
public class LinkViewPosition implements LinkViewStrategy {
	
	/**
	 * Finds URLs and sorts them by position
	 * @param input, the document string to look through
	 * @return the sorted list of URLs
	 */
	@Override
	public ArrayList<String> getURLs(String input) {
		ArrayList<String> result = new ArrayList<String>();

		Pattern pattern = Pattern.compile(
		"\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|www.)" + 
		"(\\w+:\\w+@)?(([-\\w]+\\.)+(com|org|net|edu|gov" + 
		"|mil|biz|info|mobi|name|aero|jobs|museum" + 
		"|travel|[a-z]{2}))(:[\\d]{1,5})?" + 
		"(((\\/([-\\w~!$+|.,=]|%[a-f\\d]{2})+)+|\\/)+|\\?|#)?" + 
		"((\\?([-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" + 
		"([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)" + 
		"(&(?:[-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" + 
		"([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)*)*" + 
		"(#([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)?\\b");
			
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			result.add(matcher.group());
		}

		return result;
	}
}
