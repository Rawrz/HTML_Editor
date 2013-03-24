
package Entities;

import java.util.ArrayList;


public class DocumentMenu {
	private Menu_Option cutCommand,pasteCommand,insertCommand,indentCommand;
	public DocumentMenu(Menu_Option cut, Menu_Option paste, Menu_Option insert, Menu_Option indent){
		cutCommand = cut;
		pasteCommand = paste;
		insertCommand = insert;
		indentCommand = indent;
	}

	public void cut(){
		cutCommand.execute();
	}
	public void paste(){
		pasteCommand.execute();
	}
	public void insert(){
		insertCommand.execute();		
	}
	public void indent(){
		indentCommand.execute();
	}
	
}

