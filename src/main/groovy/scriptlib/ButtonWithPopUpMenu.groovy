package scriptlib
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.MenuListener
import javax.swing.event.MenuEvent


class ButtonWithPopUpMenu extends JButton{ //TEST temp JButton
	  
	  JPopupMenu popup = new JPopupMenu()
	  def invoker //to optionally set
	
	  public ButtonWithPopUpMenu(String title){
	  super(title)	  
	  
	  addMouseListener(new MouseAdapter() {
		  public void mouseEntered(MouseEvent e) {
			   popup.show(e.getComponent(), e.getX(), e.getY())
		  }
		  public void mouseClicked(MouseEvent e) {
			  if (popup.isVisible()) popup.setVisible(false) else popup.setVisible(true)
		  }
	  });
	 
	  }
	void setItem(def parent,String title, def menuObject){
		MenuItem menuItem
		parent.add(menuItem=new MenuItem(title, menuObject))
		menuItem.invoker=invoker
	}
	
	JMenuItem setItem(String title, def menuObject){
		MenuItem menuItem
		popup.add(menuItem=new MenuItem(title, menuObject))
		menuItem.invoker=invoker
		return menuItem
	}
	JMenu setMenu(def parent, String title){
		JMenu menu
		parent.add(menu=new JMenu(title))
		menu.setVisible(true)
		return menu
	}
	JMenu setMenu(String title){
		JMenu menu
		popup.add(menu=new JMenu(title))
		menu.setVisible(true)
		return menu
	}
}