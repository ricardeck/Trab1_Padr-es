package pdffactoryplugin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import application.Core;
import interfaces.ICore;
import interfaces.IDocumentEditor;
import interfaces.IDocumentFactory;
import interfaces.IDocumentSerializer;
import interfaces.IDocumentValidator;
import interfaces.IPlugin;
import interfaces.IUIController;

public class PDFFactoryPlugin implements IPlugin, IDocumentFactory {
	private String fileExtension;
	private String fileName = null;
	private static PDFFactoryPlugin instance = null;
	private PDFFactoryPlugin() {
	}
	
	public static PDFFactoryPlugin getInstance() {
		if (instance == null)
			instance = new PDFFactoryPlugin();
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
////					for (Object object : compatiblePlugins) {
////						IDocumentFactory documentFactory = (IDocumentFactory) object;
////						documentFactory.isExtensionSupported(fileExtension);
////					}
//					fileName = chooser.getSelectedFile().getAbsolutePath();
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

		return true;
	}

	@Override
	public String getSupportedExtensions() {
		return "pdf|xls|odf";
	}

	@Override
	public boolean isExtensionSupported(String fileExtension) {
		String fileName = fileExtension;
		fileExtension = fileExtension.split("\\.")[1];
		for (String str : this.getSupportedExtensions().split("\\|")) {
			if (str.equals(fileExtension)) {
//				createEditor().open();
				
				File file = new File(fileName);
		        try {
		            PDFParser parser = new PDFParser(new RandomAccessBufferedFileInputStream(file));
		            parser.parse();
		            COSDocument cosDoc = parser.getDocument();
		            PDFTextStripper pdfStripper = new PDFTextStripper();
		            PDDocument pdDoc = new PDDocument(cosDoc);
//		            for (int i = 1; i <= pdDoc.getNumberOfPages(); i++) {
		                pdfStripper.setStartPage(1);
		                pdfStripper.setEndPage(2);
		                String parsedText = pdfStripper.getText(pdDoc);
		                System.out.println("Página " + "1" + ": " + parsedText);
//		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
				
				
//				createSerializer().load();
//				createSerializer().save();
//				createValidator().validate();
				return true;
			}
		}

		return false;
	}

	@Override
	public IDocumentSerializer createSerializer() {
//		return new TextSerializer();
		return null;
	}

	@Override
	public IDocumentEditor createEditor() {
		return new PDFEditor();
	}

	@Override
	public IDocumentValidator createValidator() {
//		return new TextValidator();
		return null;
	}

	@Override
	public String getType() {
		return "DocumentFactory";
	}

}
