
package Entities;

/**
 * Menu of document commands
 * @author Ben Kantor
 *
 */
public class DocumentMenu {

	private Menu_Option cutCommand,pasteCommand,insertCommand,indentCommand,saveCommand,saveNewCommand,toggleWrapCommand,toggleIndentCommand;
	
	/**
	 * creates commands based on the parameters
	 * @param cut
	 * @param paste
	 * @param insert
	 * @param indent
	 * @param save
	 * @param saveNew
	 * @param toggleWrap
	 * @param toggleIndent
	 */
	public DocumentMenu(Menu_Option cut, Menu_Option paste, Menu_Option insert, Menu_Option indent, Menu_Option save, Menu_Option saveNew, Menu_Option toggleWrap, Menu_Option toggleIndent){
		cutCommand = cut;
		pasteCommand = paste;
		insertCommand = insert;
		indentCommand = indent;
		saveCommand = save;
		saveNewCommand = saveNew;
		toggleWrapCommand = toggleWrap;
		toggleIndentCommand = toggleIndent;
	}
	
	/**
	 * executes the cut command
	 */
	public void cut(){
		cutCommand.execute();
	}
	
	/**
	 * executes the paste command
	 */
	public void paste(){
		pasteCommand.execute();
	}
	
	/**
	 * executes the insert command
	 */
	public void insert(){
		insertCommand.execute();		
	}
	
	/**
	 * executes the indent command
	 */
	public void indent(){
		indentCommand.execute();
	}
	
	/**
	 * executes the save command
	 */
	public void save(){
		saveCommand.execute();
	}
	
	/**
	 * executes the saveNew command
	 */
	public void saveNew(){
		saveNewCommand.execute();
	}
	
	/**
	 * executes the toggleWrap command
	 */
	public void toggleWrap(){
		toggleWrapCommand.execute();
	}
	
	/**
	 * executes the toggleIndent command
	 */
	public void toggleIndent(){
		toggleIndentCommand.execute();
	}
	
}

