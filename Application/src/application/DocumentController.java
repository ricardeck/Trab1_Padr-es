package application;

import java.io.IOException;
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

	private String fileExtension;
	private String fileName = null;;
//	private static DocumentController instance = null;
	JFileChooser chooser2 = null;

//	private DocumentController() {
//	}
//
//	public static DocumentController getInstance() {
//		if (instance == null)
//			instance = new DocumentController();
//		return instance;
//	}

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
					fileExtension = chooser.getSelectedFile().getAbsolutePath().split("\\.")[1];
					boolean find = false;
					for (Object object : compatiblePlugins) {
						if (object instanceof IDocumentFactory) {
							IDocumentFactory documentFactory = (IDocumentFactory) object;
							try {
								if (documentFactory.isExtensionSupported(fileName) && fileName != null)
									find = true;
							} catch (IOException e) {
								e.printStackTrace();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> getPluginsByType(T t, ICore core) {
		// TODO Auto-generated method stub
		return null;
	}
}
