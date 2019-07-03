package textfactoryplugin;

import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import interfaces.ICore;
import interfaces.IDocumentFactory;
import interfaces.IPlugin;
import interfaces.IPluginController;
import interfaces.IUIController;

public class TextFactoryPlugin implements IPlugin, IDocumentFactory{
	String fileExtension;
	@Override
	public boolean initialize(ICore core) {
        IUIController uiController = core.getUIController();
        
        JMenuItem fileNewItem = uiController.addMenuItem("File", "New");
        fileNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("choosertitle");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                	fileExtension = chooser.getName().split(".")[1];
                	
                } else {
                  System.out.println("Erro ao selecionar");
                }
                if(!isExtensionSupported(fileExtension)) {
                	
                	uiController.getPluginsByType();
                	System.out.println("Não foi encontrado um leitor para esse arquivo");
                }
            }
        }); 
		
        return true;
	}

	@Override
	public String getSupportedExtensions() {
		return "txt|doc|odt";
	}

	@Override
	public boolean isExtensionSupported(String fileExtension) {
		
//		String[] supportedExtensions = this.getSupportedExtensions().split("|");
		
		for (String str : this.getSupportedExtensions().split("|")) {
    		if(str.equals(fileExtension)) {
    			TextEditor editor = new TextEditor();
    			TextSerializer serializer = new TextSerializer();
    			TextValidator validator = new TextValidator();
    			editor.open();
    			serializer.load();
    			serializer.save();
    			return true;
    		}
		}
		return false;
	}

}
