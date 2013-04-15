package Entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Strategy that sorts the URLs alphabetically
 * @author Chris Timmons
 *
 */
public class LinkViewAlphabet implements LinkViewStrategy {
	
	/**
	 * Finds the URLs and sorts them alphabetically, keeping track of how many times a URL shows up
	 * @param input, the document string to look through
	 * @return the sorted list of URLs
	 */
	@Override
	public ArrayList<String> getURLs(String input) {
		
		ArrayList<String> result = new ArrayList<String>();
		Hashtable<String, Integer> linkHash = new Hashtable<String, Integer>();
		
		Pattern pattern = Pattern.compile(
		"\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|www.)" + 
		"(\\w+:\\w+@)?(([-\\w]+\\.)+(com|org|edu|net|gov" + 
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
			if (!linkHash.containsKey(matcher.group())) {
				linkHash.put(matcher.group(), 1);
			}
			else {
				Integer value = linkHash.get(matcher.group()) + 1;
				linkHash.put(matcher.group(), value);
			}
		}
		
		Iterator<Map.Entry<String, Integer>> iter = linkHash.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			result.add("(" + entry.getValue() + ") " + entry.getKey());
		}
		
		Collections.sort(result, new Comparator<String>() {
			/**
			 * Sorts the URLs by index 3 and beyond, skipping the number count
			 * @param a, the first URL
			 * @param b, the second URL
			 * @return the sort value of the URLs
			 */
		    public int compare(String a, String b) {
		    	int smallString;
		    	if (a.length() < b.length()) {
		    		smallString = a.length();
		    	}
		    	else {
		    		smallString = b.length();
		    	}
		    	for (int i=3; i<smallString; i++) {
		    		if (b.charAt(i) != a.charAt(i)) {
		    			return Integer.signum(a.charAt(i) - b.charAt(i));
		    		}
		    	}
		    	return 0;
		    }
		});
		
		return result;
	}

}
