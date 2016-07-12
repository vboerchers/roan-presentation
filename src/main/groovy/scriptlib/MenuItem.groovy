package scriptlib

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

class MenuItem extends JMenuItem{
	def menuObject
	def invoker //top optionally set

	MenuItem(String title, def menuExecute){
		super(title)
		this.menuObject=menuExecute
		addActionListener(handler)
		setVisible(true)
	}

	void execute(){menuObject.executeMenuItem(invoker)}


	private ActionListener createHandler() {
		new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MenuItem m=e.getSource()
						m.execute()
					}
				};

	}
}
