package application;

import interfaces.IDocumentFactory;
import interfaces.IUIController;

import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author ricardeck
 */
public class UIController implements IUIController {

	private MainWindow mainWindow;

	@Override
	public boolean initialize() {
		mainWindow = new MainWindow();
		mainWindow.setVisible(true);

		return true;
	}

	@Override
	public JMenuItem addMenuItem(String menuName, String menuItemName) {
		JMenu myMenu = null;
		JMenuBar myMenuBar = mainWindow.getJMenuBar();
		for (int i = 0; i < myMenuBar.getMenuCount(); ++i) {
			if (myMenuBar.getMenu(i).getText().equals(menuName))
				myMenu = myMenuBar.getMenu(i);
		}

		if (myMenu == null) {
			myMenu = new JMenu(menuName);
			myMenuBar.add(myMenu);
		} else {
			for (int i = 0; i < myMenu.getItemCount(); ++i)
				if (myMenu.getItem(i).getText().equals(menuItemName))
					return null;
		}

		JMenuItem myMenuItem = new JMenuItem(menuItemName);
		myMenu.add(myMenuItem);
		mainWindow.pack();
		return myMenuItem;
	}
}
