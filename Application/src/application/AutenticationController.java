package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import interfaces.IAutenticationBackEnd;
import interfaces.IAutenticationController;

public class AutenticationController implements IAutenticationController {
	private String nomeClasse;
	private IAutenticationBackEnd autenticationBackEnd;
	private static AutenticationController instance = null;
	
	private AutenticationController() {
		try {
			this.lerXML();
			autenticationBackEnd = (IAutenticationBackEnd) Class.forName(nomeClasse).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static AutenticationController getInstance() {
		if (instance ==  null)
			instance = new AutenticationController();
		return instance;
	}

	@Override
	public boolean initialize() {
		System.out.println(autenticationBackEnd.getAutentication());
		return true;
	}
	
	public void lerXML() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse("classe.xml");
		
		this.nomeClasse = doc.getElementsByTagName("classe").item(0).getTextContent();
		
	}

}
