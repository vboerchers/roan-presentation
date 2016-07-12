package roan
//Author Jodi D.Krol 2014-06
import javax.swing.JTextArea
import scriptlib.NodeLib
import javax.swing.text.DefaultHighlighter
import javax.swing.text.Document
import javax.swing.text.Highlighter
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener
import java.awt.Color
import java.awt.Rectangle
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.SwingUtilities
import java.awt.Point
import javax.swing.text.Utilities
import scriptlib.StringLib
import scriptlib.Message

class ActionsField extends JTextArea{
	private JTextArea ta
	private Integer columns
	void clearBackground(){setBackground(Color.WHITE)}
	
	
	ActionsField(def rows, def columns){
		super(rows,columns)
		ta=this
		this.columns=columns
		getDocument().putProperty("owner", this);
		getDocument().addDocumentListener(new MenuFieldListener())
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				ta.setCaretPosition(ta.viewToModel(me.getPoint()))
			  if (SwingUtilities.isRightMouseButton(me)){
				  
				  Highlighter hilit = new DefaultHighlighter();
				  Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.green);
				  ta.setHighlighter(hilit);
				  hilit.addHighlight(ActionsField.lineStart(ta), ActionsField.lineEnd(ta), painter);
				  
				  // select nodeIds in action str
				  String aStr=ta.text.substring(ActionsField.lineStart(ta), ActionsField.lineEnd(ta))
				  aStr=Action.getParmsStr_fromParms_translatedActionStr(aStr)
				  ArrayList nodes=NodeLib.nodesForIds(StringLib.nodeIds(aStr))
				  NodeLib.selectNodes(nodes)
				  
				  if (Message.confirm("Delete")) ActionsField.lineDelete(ta)
			  }
			  else ActionsField.clearHighLite(ta)
			}
		  });
	}
	
	static void clearHighLite(ActionsField ta){
		Highlighter hilit = new DefaultHighlighter();
		Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.white);
		ta.setHighlighter(hilit);
		hilit.addHighlight(0, ta.text.size(), painter);
	}
	// TO scriptlib
	Integer getRow(){
		int offset = ta.getCaretPosition()
		int rowNum=0
		while (offset>0){
			offset = Utilities.getRowStart(ta, offset) - 1;
			rowNum+=1
		}
		
		return rowNum
	}
	// TO scriptlib
	Integer getCol(){
		int caretPos = ta.getCaretPosition()
		int offset = Utilities.getRowStart(ta, caretPos);
		int colNum = caretPos - offset + 1;
		return colNum
	}
	static Integer lineStart(ActionsField ta){
		int caretPos = ta.getCaretPosition()
		int offset = Utilities.getRowStart(ta, caretPos);
		return offset
	}
	
	static Integer lineEnd(ActionsField ta){
		int caretPos = ta.getCaretPosition()
		int offset=Utilities.getRowEnd(ta, caretPos);
		return offset
	}
	
	static lineDelete(ActionsField ta){
		String s=ta.text
		int lineStart=lineStart(ta); if (lineStart>0) lineStart-=1
		int lineEnd=lineEnd(ta); if (lineEnd<ta.text.size()) lineEnd+=1 
		
		if (s!="") if (lineStart==0) ta.text=s.substring(lineEnd,s.size()) //+1 skip new line
		           else ta.text=s.substring(0,lineStart)+s.substring(lineEnd,s.size()) //-1 for new line
	}
	
	class MenuFieldListener implements DocumentListener {
		public void changedUpdate(DocumentEvent documentEvent) {	
		 setModified(documentEvent)
		 true
		}
	  
		public void insertUpdate(DocumentEvent documentEvent) {
		  setModified(documentEvent)
		  true
		}
	  
		public void removeUpdate(DocumentEvent documentEvent) {
		   setModified(documentEvent)
		   true
		}
	  
		
		void setModified(DocumentEvent documentEvent){
			JTextArea ta=documentEvent.getDocument().getProperty("owner");
			ta.setBackground(Color.YELLOW)
		}
	}

}
