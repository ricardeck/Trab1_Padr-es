package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import interfaces.ICore;
import interfaces.IDocumentEditor;
import interfaces.IDocumentFactory;
import interfaces.IDocumentSerializer;
import interfaces.IDocumentValidator;
import interfaces.IPlugin;
import interfaces.IPluginController;
import interfaces.IUIController;
import pdffactoryplugin.PDFFactoryPlugin;

public class DocumentController implements IPluginController {

	private String fileName = null;;
	private List<IPlugin> loadedPlugins = new ArrayList<IPlugin>();

	@Override
	public boolean initialize(ICore core) {
		IUIController uiController = core.getUIController();

		JMenuItem fileNewItem = uiController.addMenuItem("File", "New Document");
		fileNewItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				JFileChooser chooser = new JFileChooser();
				int retorno = chooser.showOpenDialog(null);
				if (retorno == JFileChooser.APPROVE_OPTION) {
					List compatiblePlugins = core.getPluginController().getPluginsByType(IDocumentFactory.class, core);
					fileName = chooser.getSelectedFile().getAbsolutePath();
					boolean find = false;
					for (Object object : compatiblePlugins) {
						if (object instanceof IDocumentFactory) {
							IDocumentFactory documentFactory = (IDocumentFactory) object;
								if (documentFactory.createValidator().validate(fileName)) {
									try {
										System.out.println(documentFactory.createEditor().namePlugin());
										documentFactory.createEditor().open(fileName);
									} catch (IOException e) {
										e.printStackTrace();
									}
									find = true;
								}
						}
					}
					if (!find)
						System.out.println(
								"Não foi encontrado um leitor para esse arquivo - " + fileName.split("\\.")[1]);
				}

				else {
					System.out.println("Erro ao selecionar");
				}

			}
		});

		return true;
	}

	@Override
	public List<IPlugin> getLoadedPlugins() {
		return loadedPlugins;
	}

	@Override
	public <T> List<T> getPluginsByType(T t, ICore core) {
		List<T> loadedPluginsByType = new ArrayList<>();

		for (IPlugin plugin : core.getPluginController().getLoadedPlugins()) {

			if (t.toString().contains(plugin.getType())) {
				loadedPluginsByType.add((T) plugin);
			}
		}
		return loadedPluginsByType;
	}
}
