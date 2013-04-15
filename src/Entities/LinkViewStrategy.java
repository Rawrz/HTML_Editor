package Entities;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Abstract Class for the link view strategies
 * @author Chris Timmons
 *
 */
public abstract class LinkViewStrategy {
	
	/**
	 * Takes in the document and return s them as a sorted list
	 * @param input, the document string to look through
	 * @return list of URLs
	 */
	public ArrayList<String> getSortedURLs(String input) {
		Matcher matcher = getURLs(input);
		return sortURLs(matcher);
	}
	
	/**
	 * Creates the URL regular expression and returns the matcher for it
	 * @param input, the document
	 * @return the matcher of the document
	 */
	protected Matcher getURLs(String input) {
		
		//Regular expression found from stackoverflow.com
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
		
		return pattern.matcher(input);
	}
	
	/**
	 * Sorts the URLs, described in subclasses
	 * @param matcher, the matcher for the URL regular expression
	 * @return the list of sorted links
	 */
	abstract protected ArrayList<String> sortURLs(Matcher matcher);
}
