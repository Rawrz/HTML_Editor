package Entities;

public class Document {
	
	private boolean isWrapped = false;
	private boolean isIndented = false;
	
	public Document() {
	}

	
	public void cut() {
		
		
	}

	
	public void paste() {
		// TODO Auto-generated method stub
		
	}

	
	public void save() {
		

	}

	
	public void saveAs() {
		save();

	}

	
	public void close() {
		// TODO Auto-generated method stub

	}
	
	
	public void indent() {
		
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

}
