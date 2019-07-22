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
	String nomeClasse;
	IAutenticationBackEnd autenticationBackEnd;

	public AutenticationController() {
		try {
			this.lerXML();
			autenticationBackEnd = (IAutenticationBackEnd) Class.forName(nomeClasse).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
