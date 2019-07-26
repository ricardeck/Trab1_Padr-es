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
		if(createValidator().validate(fileName)) {
			createEditor().open(fileName);
			return true;
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
	public String getType() {
		return "DocumentFactory";
	}

	@Override
	public IDocumentValidator createValidator() {
		return new PDFValidator();
	}

}
