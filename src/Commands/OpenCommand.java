package Commands;

import Entities.HTML_Editor;
import Entities.Menu_Option;

/**
 * executes the open command
 * @author Ben Kantor
 *
 */
public class OpenCommand implements Menu_Option{
	
	private HTML_Editor htmlEditor;
	
	/**
	 * creates the open command for the editor
	 * @param editor
	 */
	public OpenCommand(HTML_Editor editor){
		htmlEditor = editor;
	}
	
	@Override
	public void execute() {
	}

    @Override
    /**
     * opens the doc for the given string
     */
    public void execute(Object obj) {
    	String filePath = (String)obj;
    	htmlEditor.openDocument(filePath);
    }

}
