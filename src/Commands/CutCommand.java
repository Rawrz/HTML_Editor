package Commands;

import javax.swing.text.html.HTML.Tag;

import Entities.Document;
import Entities.Menu_Option;

public class CutCommand implements Menu_Option{
	
	private Document doc;
	
	public CutCommand(Document document){
		doc = document;
	}
	@Override
	public void execute() {
		doc.cut();
	}
    @Override
    public void execute(Object obj) {
        // TODO Auto-generated method stub
        
    }

}
