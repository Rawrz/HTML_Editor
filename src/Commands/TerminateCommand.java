package Commands;

import Entities.HTML_Editor;
import Entities.Menu_Option;

/**
 * executes the terminate command
 * @author Ben Kantor
 *
 */
public class TerminateCommand implements Menu_Option{
	
	private HTML_Editor htmlEditor;
	
	/**
	 * creates a terminate command for the editor
	 * @param editor
	 */
	public TerminateCommand(HTML_Editor editor){
		htmlEditor = editor;
	}

	@Override
	/**
	 * terminates the editor
	 */
	public void execute(){
		htmlEditor.terminate();
	}
    @Override
    public void execute(Object obj) {
        // TODO Auto-generated method stub     
    }
}
