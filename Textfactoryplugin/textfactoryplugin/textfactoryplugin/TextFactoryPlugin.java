package textfactoryplugin;

import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import application.Core;
import interfaces.ICore;
import interfaces.IDocumentEditor;
import interfaces.IDocumentFactory;
import interfaces.IDocumentSerializer;
import interfaces.IDocumentValidator;
import interfaces.IPlugin;
import interfaces.IUIController;

public class TextFactoryPlugin implements IPlugin, IDocumentFactory {
	private String fileExtension;
	private static TextFactoryPlugin instance = null;
	
	private TextFactoryPlugin() {
	}
	
	public static TextFactoryPlugin getInstance() {
		if (instance == null)
			instance = new TextFactoryPlugin();
		return instance;
	}
	
	@Override
	public boolean initialize(ICore core) {
//		IUIController uiController = core.getUIController();
//
//		JMenuItem fileNewItem = uiController.addMenuItem("File", "New Document");
//		fileNewItem.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//
//				JFileChooser chooser = new JFileChooser();
//				int retorno = chooser.showOpenDialog(null);
//				if (retorno == JFileChooser.APPROVE_OPTION) {
//					List compatiblePlugins = core.getPluginController().getPluginsByType(IDocumentFactory.class, core);
//					for (Object object : compatiblePlugins) {
//						IDocumentFactory documentFactory = (IDocumentFactory) object;
//						documentFactory.isExtensionSupported(fileExtension);
//					}
//					fileExtension = chooser.getSelectedFile().getAbsolutePath().split("\\.")[1];
//					for (Object object : compatiblePlugins) {
//						IDocumentFactory documentFactory = (IDocumentFactory) object;
//						if (!isExtensionSupported(fileExtension) && fileExtension != null) {
//							System.out.println("Não foi encontrado um leitor para esse arquivo - " + fileExtension);
//						}
//					}
//				}
//
//				else {
//					System.out.println("Erro ao selecionar");
//				}
//
//			}
//		});
//
		return true;
	}

	@Override
	public String getSupportedExtensions() {
		return "txt|doc|odt";
	}

	@Override
	public boolean isExtensionSupported(String fileExtension) {
		fileExtension = fileExtension.split("\\.")[1];
		for (String str : this.getSupportedExtensions().split("\\|")) {
			if (str.equals(fileExtension)) {
				createEditor().open();
				createSerializer().load();
				createSerializer().save();
				createValidator().validate();
				return true;
			}
		}

		return false;
	}

	@Override
	public IDocumentSerializer createSerializer() {
		return new TextSerializer();
	}

	@Override
	public IDocumentEditor createEditor() {
		return new TextEditor();
	}

	@Override
	public IDocumentValidator createValidator() {
		return new TextValidator();
	}

	@Override
	public String getType() {
		return "DocumentFactory";
	}

}
