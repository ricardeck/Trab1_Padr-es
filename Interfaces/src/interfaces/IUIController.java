package interfaces;

import java.util.List;

import javax.swing.JMenuItem;

/**
 *
 * @author aluno
 */
public interface IUIController {
	public boolean initialize();

	public List<IDocumentFactory> getPluginsByType(IDocumentFactory iDocumentFactory);

	public JMenuItem addMenuItem(String menuName, String menuItemName);
}
