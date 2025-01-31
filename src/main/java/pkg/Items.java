package pkg;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Items {

	public String title;

	@XmlElement(name="item")
	public List<Item> itemList;

	@Override
	public String toString() {
		return "Items [title=" + this.title + ", itemList=" + this.itemList + "]";
	}

}
