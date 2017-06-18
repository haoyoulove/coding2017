package datastructure;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coding.basic.Iterator;
import com.coding.basic.array.ArrayList;

public class BasicTest {
	ArrayList arr = null;

	@Before
	public void setUp() throws Exception {
		arr  = new ArrayList();
	}

	@After
	public void tearDown() throws Exception {
		
	}

//	@Test
//	public void testAddObject() {
//		arr.add("str1");
//		arr.add("str2");
//		arr.add("str3");
//		arr.add("str4");
//		arr.add("str5");
//		arr.add("str6");
//		arr.add("str7");
//		assertEquals(7, arr.size());
//	}

//	@Test
//	public void testAddIntObject() {
//		arr.add("str3");
//		arr.add("str4");
//		arr.add("str5");
//		arr.add("str6");
//		arr.add("str7");
//		arr.add("str8");
//		arr.add("str9");
//		arr.add(2, "str");
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i));
//		}
//		assertEquals(7, arr.size());
//	}

//	@Test
//	public void testGet() {
//		arr.add("str3");
//		arr.add("str4");
//		arr.add("str5");
//		assertEquals("str5", arr.get(2));
//	}

//	@Test
//	public void testRemove() {
//		arr.add("123");
//		arr.add("345");
//		arr.add("3451");
//		arr.add("3452");
//		arr.add("3453");
//		arr.add("3454");
//		arr.remove(5);
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i));
//		}
//	}

	@Test
	public void testIterator() {
		arr.add("123");
		arr.add("345");
		arr.add("3451");
		arr.add("3452");
		Iterator it = arr.iterator();
		while(it.hasNext()){
			Object o = it.next();
			System.out.println(o.toString());
		}
		
	}


}
