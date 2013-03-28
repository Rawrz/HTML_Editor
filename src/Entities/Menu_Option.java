
package Entities;

/**
 * interface for each command
 * @author Ben Kantor
 *
 */
public interface Menu_Option {
	
	/**
	 * executes commands
	 */
	public void execute();
	
	/**
	 * executes commands based on the object passed
	 * @param obj
	 */
	public void execute(Object obj);
	
}

