package datastructure;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coding.basic.array.LinkedList;

public class LinkedListTest {

	LinkedList link;
	
	@Before
	public void setUp() throws Exception {
		link = new LinkedList();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddObject() {
		link.add("11");
		link.add("12");
		link.add("13");
		assertEquals(3, link.size());
	}

	@Test
	public void testAddIntObject() {
		link.add("13");
		link.add("12");
		link.add("13");
		link.add(2, "456");
		assertTrue("13".equals(link.get(3).toString()));
//		for (int i = 0; i < link.size(); i++) {
//			System.out.println(link.get(i));
//		}
	}
	@Test
	public void testGet() {
		link.add("asd");
		link.add("tytt");
		assertTrue(link.get(1).equals("tytt"));
	}

	@Test
	public void testRemoveInt() {
		link.add("asd");
		link.add("tytt");
		link.add("tyustt");
		assertTrue(link.remove(1).equals("tytt"));
		assertEquals(2, link.size());
		assertTrue("tyustt".equals(link.get(1)));
	}

	@Test
	public void testSize() {
		link.add("123");
		assertEquals(1, link.size());
	}

	@Test
	public void testAddFirst() {
		link.add("asd");
		link.add("bc");
		link.addFirst("asdttyy");
		assertTrue("asdttyy".equals(link.get(0)));
	}

	@Test
	public void testAddLast() {
		link.add("asd");
		link.add("bc");
		link.addLast("yyy");
		assertTrue("yyy".equals(link.get(2)));
	}

	@Test
	public void testRemoveFirst() {
		link.add("asd");
		link.add("bc");
		link.add("34455");
		link.removeFirst();
		assertTrue("bc".equals(link.get(0)));
	}

	@Test
	public void testRemoveLast() {
		link.add("asd");
		link.add("bc");
		link.add("34455");
		link.removeLast();
		assertTrue("bc".equals(link.get(1)));
	}
//
//	@Test
//	public void testIterator() {
//		fail("Not yet implemented");
//	}

}
