package application;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import interfaces.IAutenticationBackEnd;
import interfaces.IAutenticationController;
import interfaces.IPlugin;

public class AutenticationController implements IAutenticationController {
	private String nomeClasse;
	private IAutenticationBackEnd autenticationBackEnd;
	private static AutenticationController instance = null;

	public AutenticationController() {
		try {
			this.lerXML();
			Object o = null;
			Class cls = Class.forName(nomeClasse);
			Constructor constructor = cls.getDeclaredConstructor();
			Method singleton = cls.getMethod("getInstance", new Class[0]);
			o = singleton.invoke(null, null);
			autenticationBackEnd = (IAutenticationBackEnd) o;
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
