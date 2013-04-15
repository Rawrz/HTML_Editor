package Entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * Strategy that sorts the URLs alphabetically
 * @author Chris Timmons
 *
 */
public class LinkViewAlphabet extends LinkViewStrategy {
	
	/**
	 * Finds the URLs and sorts them alphabetically
	 * @param matcher, the matcher for the URL regular expression
	 * @return the list of alphabetically sorted links
	 */
	@Override public ArrayList<String> sortURLs(Matcher matcher) {
		Hashtable<String, Integer> linkHash = createLinkHash(matcher);
		ArrayList<String> result = getUnsortedLinks(linkHash);
		return compareAndSortURLs(result);
	}
	
	/**
	 * Creates a Hashtable for the links and increments their values every time they show up
	 * @param matcher, the matcher for the URL regular expression
	 * @return the created Hashtable
	 */
	private Hashtable<String, Integer> createLinkHash(Matcher matcher) {
		Hashtable<String, Integer> linkHash = new Hashtable<String, Integer>();
		while (matcher.find()) {
			if (!linkHash.containsKey(matcher.group())) {
				linkHash.put(matcher.group(), 1);
			}
			else {
				Integer value = linkHash.get(matcher.group()) + 1;
				linkHash.put(matcher.group(), value);
			}
		}
		return linkHash;
	}
	
	/**
	 * Creates an unsorted list of the links with their number counts
	 * @param linkHash, the Hashtable of the links
	 * @return the unsorted link list
	 */
	private ArrayList<String> getUnsortedLinks(Hashtable<String, Integer> linkHash) {
		ArrayList<String> result = new ArrayList<String>();
		Iterator<Map.Entry<String, Integer>> iter = linkHash.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			result.add("(" + entry.getValue() + ") " + entry.getKey());
		}
		return result;
	}
	
	/**
	 * Sorts the link list using an anonymous comparator
	 * @param links, the unsorted list of links
	 * @return the sorted list of links
	 */
	private ArrayList<String> compareAndSortURLs(ArrayList<String> links) {
		Collections.sort(links, new Comparator<String>() {
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
		return links;
	}
}
