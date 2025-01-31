package pkg;

public class Item {

	public String title;

	public ItemType type;

	@Override
	public String toString() {
		return "Item [title=" + this.title + ", type=" + this.type + "]";
	}

}
