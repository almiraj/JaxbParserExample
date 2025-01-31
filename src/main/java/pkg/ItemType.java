package pkg;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class ItemType {

	@XmlAttribute
	public String attr;

	@XmlValue
	public String value;

	@Override
	public String toString() {
		return "ItemType [attr=" + this.attr + ", value=" + this.value + "]";
	}

}
