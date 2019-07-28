package interfaces;

import java.util.List;

import javax.swing.JMenuItem;

/**
 *
 * @author ricardeck
 */
public interface IUIController {
	public boolean initialize();
	
	public JMenuItem addMenuItem(String menuName, String menuItemName);
}
