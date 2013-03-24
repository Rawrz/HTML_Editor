package Entities;

public class Document {
	
	private boolean isWrapped;
	private boolean isIndented;
	private boolean isSaved;
	private String name;
	
	public Document(String nameParam) {
		name = nameParam;
		isWrapped = false;
		isIndented = false;
		isSaved = true;
	}


	public void cut() {
		
		
	}

	
	public void paste() {
		// TODO Auto-generated method stub
		
	}

	
	public void save() {
		if (isSaved) {
			return;
		}
		else {
			//To Add
		}
	}

	
	public void saveAs() {
		save();
		
	}

	
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	public void indent() {
		if (isIndented) {
			//To Add
		}
		else {
			return;
		}
	}
	
	public void changeWrap(boolean wrapParam) {
		isWrapped = wrapParam;
	}
	
	public void changeIndent(boolean indentParam) {
		isIndented = indentParam;
	}
	
	public boolean getWrap() {
		return isWrapped;
	}
	
	public boolean getIndent() {
		return isIndented;
	}
	
	public boolean getSaved() {
		return isSaved;
	}

}
