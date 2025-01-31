package pkg;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws JAXBException, SAXException {
		System.out.println(ItemsUnmarshaller.unmarshall(new File("xml/main.xml")));
	}

}
