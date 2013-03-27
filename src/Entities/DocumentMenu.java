
package Entities;

public class DocumentMenu {
	private Menu_Option cutCommand,pasteCommand,insertCommand,indentCommand,saveCommand,saveNewCommand,toggleWrapCommand,toggleIndentCommand;
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
	public void save(){
		saveCommand.execute();
	}
	public void saveNew(){
		saveNewCommand.execute();
	}
	public void toggleWrap(){
		toggleWrapCommand.execute();
	}
	public void toggleIndent(){
		toggleIndentCommand.execute();
	}
	
}

