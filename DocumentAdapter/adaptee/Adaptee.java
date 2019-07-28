package adaptee;

import java.awt.image.BufferedImage;
import java.io.File;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import interfaces.IDocumentAdaptee;

public class Adaptee implements IDocumentAdaptee{

	@Override
	public void open(String fileName) throws IOException {
		File file = new File(fileName);
		String fileExtension = fileName.split("\\.")[1];
		PDDocument pdDocument = PDDocument.load(file);
		PDFRenderer pdfRenderer = new PDFRenderer(pdDocument);
		BufferedImage bufferedImage = pdfRenderer.renderImage(0);
		ImageIO.write(bufferedImage, "JPEG", new File(fileExtension + ".jpg"));
		File imgDir = new File(fileExtension + ".jpg");

		Image image = ImageIO.read(imgDir);

		ImageIcon imageIcon = new ImageIcon(image);

		JFrame jFrame = new JFrame(fileName);
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
	}

}
