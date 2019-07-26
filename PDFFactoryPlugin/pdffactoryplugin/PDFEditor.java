package pdffactoryplugin;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.rendering.PDFRenderer;

import interfaces.IDocumentEditor;

public class PDFEditor implements IDocumentEditor{

	@Override
	public boolean open(String fileName) throws InvalidPasswordException, IOException {
		
//		File file = new File(fileName);
//        try {
//            PDFParser parser = new PDFParser(new RandomAccessBufferedFileInputStream(file));
//            parser.parse();
//            COSDocument cosDoc = parser.getDocument();
//            PDFTextStripper pdfStripper = new PDFTextStripper();
//            PDDocument pdDoc = new PDDocument(cosDoc);
//                pdfStripper.setStartPage(1);
//                pdfStripper.setEndPage(2);
//                String parsedText = pdfStripper.getText(pdDoc);
//                System.out.println("Página " + "1" + ": " + parsedText);
//                cosDoc.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

		File file = new File(fileName);
		String fileExtension = fileName.split("\\.")[1];
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
		
		return true;
	}

	@Override
	public String namePlugin() {
		return "Editor de PDF";
	}

}
