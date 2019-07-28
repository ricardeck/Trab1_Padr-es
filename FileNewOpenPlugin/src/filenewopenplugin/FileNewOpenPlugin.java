package filenewopenplugin;

import interfaces.ICore;
import interfaces.IPlugin;
import interfaces.IUIController;
import javax.swing.JMenuItem;

import biometryfactoryplugin.BiometryFactoryPlugin;

/**
 *
 * @author ricardeck
 */
public class FileNewOpenPlugin implements IPlugin {
	
	@Override
	public boolean initialize(ICore core) {
		IUIController uiController = core.getUIController();

		JMenuItem fileNewItem = uiController.addMenuItem("File", "New");
		fileNewItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("Voce clicou no File->New");
			}
		});

		JMenuItem fileOpenItem = uiController.addMenuItem("File", "Open");
		fileOpenItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("Voce clicou no File->Open");
			}
		});
		return true;
	}

	@Override
	public String getType() {
		return "File";
	}
}
