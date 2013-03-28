package Commands;

import Entities.HTML_Editor;
import Entities.Menu_Option;

/**
 * executes the new command
 * @author Ben Kantor
 *
 */
public class NewCommand implements Menu_Option{	
	private HTML_Editor htmlEditor;
	
	/**
	 * creates a new command for the editor
	 * @param editor
	 */
	public NewCommand (HTML_Editor editor){
		htmlEditor = editor;
	}
	@Override
	public void execute() {}
		
    @Override
    /**
     * creates a doc for the given string
     */
    public void execute(Object obj) {
    	String filePath = (String)obj;
    	htmlEditor.newDocument(filePath);
    }

}
