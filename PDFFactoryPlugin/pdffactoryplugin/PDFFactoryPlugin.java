package pdffactoryplugin;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.rendering.PDFRenderer;
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
		return true;
	}

	@Override
	public String getSupportedExtensions() {
		return "pdf";
	}

	@Override
	public boolean isExtensionSupported(String fileName) throws InvalidPasswordException, IOException {
		fileExtension = fileName.split("\\.")[1];
		for (String str : this.getSupportedExtensions().split("\\|")) {
			if (str.equals(fileExtension)) {
//				createEditor().open();

//				File file = new File(fileName);
//		        try {
//		            PDFParser parser = new PDFParser(new RandomAccessBufferedFileInputStream(file));
//		            parser.parse();
//		            COSDocument cosDoc = parser.getDocument();
//		            PDFTextStripper pdfStripper = new PDFTextStripper();
//		            PDDocument pdDoc = new PDDocument(cosDoc);
//		                pdfStripper.setStartPage(1);
//		                pdfStripper.setEndPage(2);
//		                String parsedText = pdfStripper.getText(pdDoc);
//		                System.out.println("Página " + "1" + ": " + parsedText);
//		                cosDoc.close();
//		        } catch (IOException e) {
//		            e.printStackTrace();
//		        }

				File file = new File(fileName);
				PDDocument pdDocument = PDDocument.load(file);
				PDFRenderer pdfRenderer = new PDFRenderer(pdDocument);
				BufferedImage bufferedImage = pdfRenderer.renderImage(0);
				ImageIO.write(bufferedImage, "JPEG", new File(fileExtension + ".jpg"));
				File imgDir = new File(fileExtension + ".jpg");

				Image image = ImageIO.read(imgDir);

				ImageIcon imageIcon = new ImageIcon(image);

				JFrame jFrame = new JFrame("Image Demo");
				jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

				JLabel jLabel = new JLabel();
				jLabel.setIcon(imageIcon);
				jFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

				jFrame.pack();
				jFrame.setLocationRelativeTo(null);
				jFrame.setSize(600, 700);
				jFrame.setVisible(true);
				pdDocument.close();
				imgDir.delete();

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
		return null;
	}

	@Override
	public IDocumentEditor createEditor() {
		return new PDFEditor();
	}

	@Override
	public IDocumentValidator createValidator() {
		return null;
	}

	@Override
	public String getType() {
		return "DocumentFactory";
	}

}
