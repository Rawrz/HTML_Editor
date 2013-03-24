package Commands;

import javax.swing.text.html.HTML;

import Entities.Document;
import Entities.Menu_Option;

public class InsertCommand implements Menu_Option{
	private Document doc;
	public InsertCommand(Document document){
		doc = document;
	}
	@Override
	public void execute(HTML.Tag tag) {
		
	}

    @Override
    public void execute() {
        
    }

}
