package Entities;

public class EditorMenu {
	private Menu_Option newCommand,openCommand,closeCommand,terminateCommand;
	public EditorMenu(Menu_Option newFile, Menu_Option open, Menu_Option close,Menu_Option terminate){
		newCommand = newFile;
		openCommand = open;
		closeCommand = close;
		terminateCommand = terminate;
	}
	
	public void newFile(){
		newCommand.execute();
	}
	
	public void open(){
		openCommand.execute();
	}
	
	public void close(){
		closeCommand.execute();
	}
	
	public void terminate(){
		terminateCommand.execute();
	}
}
