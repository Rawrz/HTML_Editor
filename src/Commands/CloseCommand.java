package Commands;

import javax.swing.text.html.HTML.Tag;

import Entities.HTML_Editor;
import Entities.Menu_Option;

/**
 * executes the indent command
 * @author Ben Kantor
 *
 */
public class CloseCommand implements Menu_Option{
	private HTML_Editor htmlEditor;
	
	/**
	 * creates a close command for the editor
	 * @param editor
	 */
	public CloseCommand(HTML_Editor editor){
		htmlEditor = editor;
	}
	@Override
	public void execute() {}
	
    @Override
    /**
     * closes the doc whose index matches the param
     */
    public void execute(Object obj) {
        htmlEditor.closeDocument((Integer)obj);
    }

}
