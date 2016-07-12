package scriptlib
// Author Jodi Krol 2012-8-01
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection
import java.awt.datatransfer.Transferable
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.Robot;
import java.awt.Toolkit;
import java.util.ArrayList;
 
class AClipboard {
	
	static Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard()
	
	static String getText(){
		clipboard.getData(DataFlavor.stringFlavor)
	}
	 
	static void setText(String text){
		StringSelection data = new StringSelection(text);
		//Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(data, null);
		}
	
	static void setHtml(String html) {// should start with <html>
		Transferable t = new HtmlSelection(html);
		//Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(t, null);
	}

	
	static void enter(){ control_Key(KeyEvent.VK_ENTER)}
	static void tab(){ control_Key(KeyEvent.VK_TAB)}
	static void paste(){
		control_Key(KeyEvent.VK_V);
		}
	static void copy(){
		control_Key(KeyEvent.VK_C);
		}
	
	static void shiftFocus(){
		alt_Key(KeyEvent.VK_TAB)
	}
	
	//robot
	static private Robot robot = new Robot()
	
	static void control_Key(Integer key){
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(key);
		Thread.sleep(10)
		robot.keyRelease(key);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	static void alt_Key(Integer key){
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(key);
		Thread.sleep(10)
		robot.keyRelease(key);
		robot.keyRelease(KeyEvent.VK_ALT);
	}
	
	// Author http://elliotth.blogspot.nl/2005/01/copying-html-to-clipboard-from-java.html
	private static class HtmlSelection implements Transferable {
		private static ArrayList htmlFlavors = new ArrayList();
		static {
			try {
				htmlFlavors.add(new DataFlavor("text/html;class=java.lang.String"));
				htmlFlavors.add(new DataFlavor("text/html;class=java.io.Reader"));
				htmlFlavors.add(new DataFlavor("text/html;charset=unicode;class=java.io.InputStream"));
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		}

		private String html;

		public HtmlSelection(String html) {
			this.html = html;
		}

		public DataFlavor[] getTransferDataFlavors() {
			return (DataFlavor[]) htmlFlavors.toArray(new DataFlavor[htmlFlavors.size()]);
		}

		public boolean isDataFlavorSupported(DataFlavor flavor) {
			return htmlFlavors.contains(flavor);
		}

		public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
			if (String.class.equals(flavor.getRepresentationClass())) {
				return html;
			} else if (Reader.class.equals(flavor.getRepresentationClass())) {
				return new StringReader(html);
			} else if (InputStream.class.equals(flavor.getRepresentationClass())) {
				return new StringBufferInputStream(html);
			}
			throw new UnsupportedFlavorException(flavor);
		}
	}
}
