/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
