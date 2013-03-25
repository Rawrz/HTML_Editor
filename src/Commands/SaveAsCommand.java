package Commands;

import javax.swing.text.html.HTML.Tag;

import Entities.Document;
import Entities.Menu_Option;

public class SaveAsCommand implements Menu_Option{
	private Document doc;
	public SaveAsCommand(Document document){
		doc = document;
	}

	@Override
	public void execute() {
		doc.saveAs();
	}

    @Override
    public void execute(Object obj) {
        // TODO Auto-generated method stub
        
    }

}
