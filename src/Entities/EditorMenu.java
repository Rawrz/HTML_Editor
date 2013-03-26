package Entities;

import java.io.File;

public class EditorMenu {
	private Menu_Option newCommand,openCommand,closeCommand,terminateCommand;
	public EditorMenu(Menu_Option newFile, Menu_Option open, Menu_Option close,Menu_Option terminate){
		newCommand = newFile;
		openCommand = open;
		closeCommand = close;
		terminateCommand = terminate;
	}
	
	public void newFile(File htmlFile){
		newCommand.execute(htmlFile);
	}
	
	public void open(File htmlFile){
		openCommand.execute(htmlFile);
	}
	
	public void close(Integer closeIndex){
		closeCommand.execute(closeIndex);
	}
	
	public void terminate(){
		terminateCommand.execute();
	}
}
