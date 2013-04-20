
package GUI;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


/**
 * Class used to toggle auto indent
 * @author Roseline Okpara
 *
 */
@SuppressWarnings("serial")
public class AutoIndentAction  extends AbstractAction {
   
    private boolean toggle;
    
    public AutoIndentAction(boolean toggle){
        this.toggle = toggle;
    }
    @Override
    public void actionPerformed(ActionEvent e) { 
        JTextArea textArea = (JTextArea)e.getSource(); 
        Document curDocument = textArea.getDocument(); 
        if(toggle == true){
            try { 
                int curLine = textArea.getLineOfOffset(textArea.getCaretPosition()); 
                int start = textArea.getLineStartOffset(curLine); 
                int end = textArea.getLineEndOffset(curLine); 
                String str = curDocument.getText(start, end - start - 1);
                String amtWhtSpace = getLeadingWhtSpace(str); 
                curDocument.insertString(textArea.getCaretPosition(), '\n' + amtWhtSpace, null); 
            } catch(BadLocationException ex) { 
                //When would this happen? O.o
            } 
        }
        else{
            try {
                curDocument.insertString(textArea.getCaretPosition(), "\n", null);
            } catch (BadLocationException e1) {
                //ignore
            } 
        }
    } 
 
    /**
     * Find the amount of whitespace needed
     */
    private String getLeadingWhtSpace(String str) { 
        int amtWhtSpace = 0; 
        while(amtWhtSpace < str.length()) { 
            char space = str.charAt(amtWhtSpace); 
            if(space ==' ' || space =='\t') 
                amtWhtSpace++; 
            else 
                break; 
        } 
        return str.substring(0, amtWhtSpace); 
    }
 
}

