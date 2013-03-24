package Commands;

import Entities.HTML_Editor;
import Entities.Menu_Option;

public class OpenCommand implements Menu_Option{
	
	private HTML_Editor htmlEditor;
	public OpenCommand(HTML_Editor editor){
		htmlEditor = editor;
	}
	
	@Override
	public void execute() {
		htmlEditor.openDocument();
	}

}
