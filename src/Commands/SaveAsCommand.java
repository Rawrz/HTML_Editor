package Commands;

import javax.swing.text.html.HTML.Tag;

import Entities.TheDocument;
import Entities.Menu_Option;

public class SaveAsCommand implements Menu_Option{
	private TheDocument doc;
	public SaveAsCommand(TheDocument theDocument){
		doc = theDocument;
	}

	@Override
	public void execute() {
		//doc.saveAs();
	}

    @Override
    public void execute(Object obj) {
        // TODO Auto-generated method stub
        
    }

}
