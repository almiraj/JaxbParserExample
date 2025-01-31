package pkg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import javax.xml.bind.UnmarshalException;

import org.junit.Test;

public class MainTest {

	@Test
	public void test1() throws Exception {
		Items items = ItemsUnmarshaller.unmarshall(new File(MainTest.class.getResource("test.xml").getFile()));
		System.out.println("test1:");
		System.out.println(items.itemList);

		assertEquals("TITLE", items.title);

		assertEquals(2, items.itemList.size());

		assertEquals("TITLE1", items.itemList.get(0).title);
		assertEquals("ATTR1", items.itemList.get(0).type.attr);
		assertEquals("TYPE1", items.itemList.get(0).type.value);

		assertEquals("TITLE2", items.itemList.get(1).title);
		assertNull(items.itemList.get(1).type.attr);
		assertEquals("TYPE2", items.itemList.get(1).type.value);
	}

	@Test
	public void test_illegal_element() throws Exception {
		try {
			ItemsUnmarshaller.unmarshall(new File(MainTest.class.getResource("test_illegal_element.xml").getFile()));
			fail();
		} catch (UnmarshalException e) {
			System.out.println("test_illegal_element:");
			System.out.println(e.getCause().getMessage());
			assertTrue(e.getCause().getMessage().contains("'illegal-element'"));
		}
	}

	@Test
	public void test_illegal_attr() throws Exception {
		try {
			ItemsUnmarshaller.unmarshall(new File(MainTest.class.getResource("test_illegal_attr.xml").getFile()));
			fail();
		} catch (UnmarshalException e) {
			System.out.println("test_illegal_attr:");
			System.out.println(e.getCause().getMessage());
			assertTrue(e.getCause().getMessage().contains("'illegal-attr'"));
		}
	}

	@Test
	public void test_illegal_order() throws Exception {
		try {
			ItemsUnmarshaller.unmarshall(new File(MainTest.class.getResource("test_illegal_order.xml").getFile()));
			fail();
		} catch (UnmarshalException e) {
			System.out.println("test_illegal_order:");
			System.out.println(e.getCause().getMessage());
			assertTrue(e.getCause().getMessage().contains("'{title}'"));
		}
	}

}
