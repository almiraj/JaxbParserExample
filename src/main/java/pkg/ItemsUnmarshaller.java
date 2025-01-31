package pkg;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class ItemsUnmarshaller {

	public static Items unmarshall(File xmlFile) throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance(Items.class);

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File(ItemsUnmarshaller.class.getResource("main.xsd").getFile()));

		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setSchema(schema);

		Items items = (Items) unmarshaller.unmarshal(xmlFile);

		return items;

	}

}
