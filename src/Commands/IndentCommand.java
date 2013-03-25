package Commands;

import javax.swing.text.html.HTML.Tag;

import Entities.Document;
import Entities.Menu_Option;

public class IndentCommand implements Menu_Option{
	private Document doc;
	
	public IndentCommand(Document document){
		doc = document;
	}

	@Override
	public void execute() {
		doc.indent();		
	}

    @Override
    public void execute(Object obj) {
        // TODO Auto-generated method stub
        
    }

}
