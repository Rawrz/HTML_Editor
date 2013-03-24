package Commands;

import Entities.HTML_Editor;
import Entities.Menu_Option;

public class NewCommand implements Menu_Option{	
	private HTML_Editor htmlEditor;
	
	public NewCommand (HTML_Editor editor){
		htmlEditor = editor;
	}
	@Override
	public void execute() {
		htmlEditor.newDocument();
	}

}
