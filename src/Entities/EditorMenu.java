package Entities;

import java.io.File;

/**
 * Menu of editor commands
 * @author Ben Kantor
 *
 */
public class EditorMenu {

	private Menu_Option newCommand,openCommand,closeCommand,terminateCommand;
	
	/**
	 * creates commands based on parameters
	 * @param newFile
	 * @param open
	 * @param close
	 * @param terminate
	 */
	public EditorMenu(Menu_Option newFile, Menu_Option open, Menu_Option close,Menu_Option terminate){
		newCommand = newFile;
		openCommand = open;
		closeCommand = close;
		terminateCommand = terminate;
	}
	
	/**
	 * executes the newFile command
	 * @param htmlFilePath
	 */
	public void newFile(String htmlFilePath){
		newCommand.execute(htmlFilePath);
	}
	
	/**
	 * executes the open command
	 * @param htmlFilePath
	 */
	public void open(String htmlFilePath){
		openCommand.execute(htmlFilePath);
	}
	
	/**
	 * executes the close command
	 * @param closeIndex
	 */
	public void close(Integer closeIndex){
		closeCommand.execute(closeIndex);
	}
	
	/**
	 * executes the terminate command
	 */
	public void terminate(){
		terminateCommand.execute();
	}
}
