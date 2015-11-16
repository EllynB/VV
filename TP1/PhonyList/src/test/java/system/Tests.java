/**
 * 
 */
package system;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Ellyn BLEAS
 * @author Cédric DUBOIS
 *
 */
public class Tests {

	/*
	 * Helper method to create lists.
	 */
	private PhonyList<Integer> list(Integer... content) {
		PhonyList<Integer> list = new PhonyList<>();
		for (Integer i : content)
			list.add(i);
		return list;
	}
	
	
	protected PhonyList liste;
	
	@Before
	public void setUp(){
		liste= new PhonyList();
	}
	
	/**
	 * Tests the "add" method with an empty list.
	 * 
	 * @see PhonyList#add(Object)
	 * @type Functional
	 * @input []
	 * @oracle The obtained list must be not empty.
	 * @passed Yes
	 */
	@Test
	public void add_emptyList(){
		Object o = new Object();
		liste.add(o);
		assertEquals("Testing add method",liste.size(),1);
		assertEquals("Testing add method",liste.get(0),o);
	}
	
	/**
	 * Tests the "add" method with a not empty list.
	 * 
	 * @see PhonyList#add(Object)
	 * @type Functional
	 * @input [75]
	 * @oracle The obtained list must be not empty.
	 * @passed Yes
	 */
	@Test
	public void add_smallList(){
		PhonyList<Integer> list = list(75);
		list.add(4);
		assertEquals("Testing add method",list.size(),2);
		int var = list.get(0);
		assertEquals("Testing add method",75,var);
		var = list.get(1);
		assertEquals("Testing add method",var,4);
	}
	
	/**
	 * Tests "add" and "get" method with a not empty list.
	 * 
	 * @see PhonyList#get(Index)
	 * @see PhonyList#add(Object)
	 * @type Functional
	 * @input [10,30,31,60,70,2]
	 * @passed Yes
	 */
	@Test
	public void get_add_list(){
		PhonyList<Integer> list = list(10,30,31,60,70,2);
		assertEquals("Testing add method",list.size(),6);
		int var = list.get(3);
		assertEquals("Testing get method",60,var);
		var = list.get(5);
		assertEquals("Testing get method",var,2);
	}
	
	/**
	 * Tests the "get" method with a empty list.
	 * 
	 * @see PhonyList#get(Index)
	 * @type Functional
	 * @input []
	 * @passed Yes
	 */
	@Test (expected = IndexOutOfBoundsException.class) 
	public void get_vide(){
		PhonyList<Integer> list = list();
		int var = list.get(3);
	}
	
	/**
	 * Tests the "get" method with a not empty list.
	 * 
	 * @see PhonyList#get(Index)
	 * @type Functional
	 * @input [10,30,31,60,70,2]
	 * @passed Yes
	 */
	@Test (expected = IndexOutOfBoundsException.class) 
	public void get_toFar(){
		PhonyList<Integer> list = list(10,30,31,60,70,2);
		int var = list.get(10);
	}
	
	/**
	 * Tests the "size" method with a empty list.
	 * 
	 * @see PhonyList#size()
	 * @type Functional
	 * @input []
	 * @passed Yes
	 */
	@Test
	public void size_empty(){
		PhonyList<Integer> list = list();
		assertEquals(list.size(),0);
	}
	
	/**
	 * Tests the "size" method with a not empty list.
	 * 
	 * @see PhonyList#size()
	 * @type Functional
	 * @input [20,52,10]
	 * @passed Yes
	 */
	@Test
	public void size_notEmpty(){
		PhonyList<Integer> list = list(20,52,10);
		assertEquals(list.size(),3);
	}
	
	/**
	 * Tests the "isEmpty" method with a empty list.
	 * 
	 * @see PhonyList#isEmpty()
	 * @type Functional
	 * @input []
	 * @passed Yes
	 */
	@Test
	public void empty_true(){
		PhonyList<Integer> list = list();
		assertTrue(list.isEmpty());
	}
	
	/**
	 * Tests the "isEmpty" method with a not empty list.
	 * 
	 * @see PhonyList#isEmpty()
	 * @type Functional
	 * @input [20]
	 * @passed Yes
	 */
	@Test
	public void empty_false(){
		PhonyList<Integer> list = list(20);
		assertFalse(list.isEmpty());
		list.add(3);
		assertFalse(list.isEmpty());
	}
	
	/**
	 * Tests the "set" method with a not empty list.
	 * 
	 * @see PhonyList#set(Index, Object)
	 * @type Functional
	 * @input [20,40,15,68]
	 * @passed Yes
	 */
	@Test
	public void set_list(){
		PhonyList<Integer> list = list(20,40,15,68);
		list.set(2, 4);
		int var = list.get(2);
		assertEquals(var, 4);
		var = list.get(1);
		assertEquals(var, 40);
	}
	
	/**
	 * Tests the "set" method with a not empty list.
	 * 
	 * @see PhonyList#set(Index, Object)
	 * @type Functional
	 * @input [10,30,31,60,70,2]
	 * @passed Yes
	 */
	@Test (expected = IndexOutOfBoundsException.class) 
	public void set_toFar(){
		PhonyList<Integer> list = list(10,30,31,60,70,2);
		list.set(10,70);
	}
	
	/**
	 * Tests the "set" method with a empty list.
	 * 
	 * @see PhonyList#set(Index, Object)
	 * @type Functional
	 * @input []
	 * @passed Yes
	 */
	@Test (expected = IndexOutOfBoundsException.class) 
	public void set_vide(){
		PhonyList<Integer> list = list();
		list.set(0,70);
	}
	
	/**
	 * Tests the "remove" method with a not empty list.
	 * 
	 * @see PhonyList#remove(Object)
	 * @type Functional
	 * @input [4,5,9,2,4,5]
	 * @passed Yes
	 */
	@Test
	public void remove_list(){
		PhonyList<Integer> list = list(4,5,9,2,4,5);
		list.remove(4);
		assertEquals(list.size(), 5);
		int var = list.get(0);
		assertEquals(var, 5);
		var = list.get(3);
		assertEquals(var, 4);
	}
	
	/**
	 * Tests the "remove" method with a empty list.
	 * 
	 * @see PhonyList#remove(Object)
	 * @type Functional
	 * @input []
	 * @passed Yes
	 */
	@Test
	public void remove_vide(){
		PhonyList<Integer> list = list();
		list.remove(5);
		assertEquals(list.size(), 0);
		assertEquals(list, list());
	}
	
	/**
	 * Tests the "remove" method with a not empty list.
	 * 
	 * @see PhonyList#remove(Object)
	 * @type Functional
	 * @input [4,5,9,2,4,5]
	 * @passed Yes
	 */
	@Test
	public void remove_eAbsent(){
		PhonyList<Integer> list = list(4,5,9,2,4,5);
		list.remove(20);
		assertEquals(list.size(), 6);
		assertEquals(list, list(4,5,9,2,4,5));
	}
	
	/**
	 * Tests the "removeAll" method with a not empty list.
	 * 
	 * @see PhonyList#removeAll(Collection<Object>)
	 * @type Functional
	 * @input [4,5,9,2,4,5]
	 * @passed Yes
	 */
	@Test
	public void removeAll_list(){
		PhonyList<Integer> list = list(4,5,9,2,4,5);
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(5); c.add(9); c.add(4);
		list.removeAll(c);
		assertEquals(list.size(), 1);
		int var = list.get(0);
		assertEquals(var, 2);
	}
	
	/**
	 * Tests the "removeAll" method with a empty list.
	 * 
	 * @see PhonyList#removeAll(Collection<Object>)
	 * @type Functional
	 * @input [4,5,9,2,4,5]
	 * @passed Yes
	 */
	@Test
	public void removeAll_vide(){
		PhonyList<Integer> list = list();
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(5); c.add(1);
		list.removeAll(c);
		assertEquals(list.size(), 0);
	}
	
	/**
	 * Tests the "contains" method with a not empty list.
	 * 
	 * @see PhonyList#contains(Object)
	 * @type Functional
	 * @input [4,5,9,2,4,5]
	 * @passed Yes
	 */
	@Test
	public void contains_list(){
		PhonyList<Integer> list = list(4,5,9,2,4,5,22);
		assertTrue(list.contains(5));
		assertTrue(list.contains(22));
		assertTrue(list.contains(4));
		assertFalse(list.contains(222));
	}
	
	/**
	 * Tests the "contains" method with a one element list.
	 * 
	 * @see PhonyList#contains(Object)
	 * @type Functional
	 * @input [8]
	 * @passed Yes
	 */
	@Test
	public void contains_listOne(){
		PhonyList<Integer> list = list(8);
		assertFalse(list.contains(3));
		assertTrue(list.contains(8));
	}
	
	/**
	 * Tests the "contains" method with a empty list.
	 * 
	 * @see PhonyList#contains(Object)
	 * @type Functional
	 * @input []
	 * @passed Yes
	 */
	@Test
	public void contains_vide(){
		PhonyList<Integer> list = list();
		assertFalse(list.contains(3));
		assertFalse(list.contains(86));
	}
	
	/**
	 * Tests the "equals" method with a empty list.
	 * 
	 * @see PhonyList#equals(Object)
	 * @type Functional
	 * @input []
	 * @passed Yes
	 */
	@Test
	public void equals_vide(){
		PhonyList<Integer> list1 = list();
		PhonyList<Integer> list2 = list();
		assertTrue(list1.equals(list2));
	}
	
	/**
	 * Tests the "equals" method with a not phony list.
	 * 
	 * @see PhonyList#equals(Object)
	 * @type Functional
	 * @input []
	 * @passed Yes
	 */
	@Test
	public void equals_notPhonyList(){
		PhonyList<Integer> list1 = list();
		ArrayList<Integer>list2 = new ArrayList(1);
		assertFalse(list1.equals(list2));
	}
	
	
	/**
	 * Tests the "equals" method with an element present.
	 * 
	 * @see PhonyList#equals(Object)
	 * @type Functional
	 * @input [1]
	 * @passed Yes
	 */
	@Test
	public void equals_equals(){
		PhonyList<Integer> list1 = list(1);
		PhonyList<Integer> list2 = list(1);
		assertTrue(list1.equals(list2));
	}
	
	/**
	 * Tests the "equals" method with an element absent.
	 * 
	 * @see PhonyList#equals(Object)
	 * @type Functional
	 * @input [1]
	 * @passed Yes
	 */
	@Test
	public void equals_not_equals(){
		PhonyList<Integer> list1 = list(1);
		PhonyList<Integer> list2 = list(2);
		assertFalse(list1.equals(list2));
	}
	
	/**
	 * Tests the "equals" method with two not equals lists.
	 * 
	 * @see PhonyList#equals(Object)
	 * @type Functional
	 * @input [1,3,5]
	 * @passed Yes
	 */
	@Test
	public void equals_not_equals_lists(){
		PhonyList<Integer> list1 = list(1,3,5);
		PhonyList<Integer> list2 = list(2,4,6);
		assertFalse(list1.equals(list2));	
		}
	
	/**
	 * Tests the "equals" method with two equals lists.
	 * 
	 * @see PhonyList#equals(Object)
	 * @type Functional
	 * @input [1,2,3,4,5]
	 * @passed Yes
	 */
	@Test
	public void equals_equals_lists(){
		PhonyList<Integer> list1 = list(1,2,3,4,5);
		PhonyList<Integer> list2 = list(1,2,3,4,5);
		assertTrue(list1.equals(list2));
	}
	
	/**
	 * Tests the "equals" method with two differents sized lists lists.
	 * 
	 * @see PhonyList#equals(Object)
	 * @type Functional
	 * @input [1,2,3]
	 * @passed Yes
	 */
	@Test
	public void equals_dif_size_lists1(){
		PhonyList<Integer> list1 = list(1,2,3);
		PhonyList<Integer> list2 = list(1,2);
		assertFalse(list1.equals(list2));
	}
	
	/**
	 * Tests the "equals" method with two differents sized lists lists.
	 * 
	 * @see PhonyList#equals(Object)
	
 * @type Functional
	 * @input [1,2]
	 * @passed Yes
	 */
	@Test
	public void equals_dif_size_lists2(){
		PhonyList<Integer> list1 = list(1,2);
		PhonyList<Integer> list2 = list(1,2,3);
		assertFalse(list1.equals(list2));
	}
	
	/**
	 * Tests the "addAll" method with an empty list and an element.
	 * 
	 * @see PhonyList#equals(Object)
	 * @type Functional
	 * @input [4,5]
	 * @passed Yes
	 */
	@Test
	public void addAll_empty_oneElement_Index0(){
		PhonyList<Integer> list1 = list();
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(4);
		c.add(5);
		list1.addAll(0,c);
		PhonyList<Integer> list2 = list(4,5);
		assertTrue(list1.equals(list2));
	}
	
	/**
	 * Tests the "addAll" method with a list and an other list.
	 * 
	 * @see PhonyList#equals(Object)
	 * @type Functional
	 * @input [1,2,3]
	 * @passed Yes
	 */
	@Test
	public void addAll_empty_list_and_list(){
		PhonyList<Integer> list1 = list(1,2,3);
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(4);
		c.add(5);
		list1.addAll(3,c);
		PhonyList<Integer> list2 = list(1,2,3,4,5);
		assertTrue(list1.equals(list2));
	}
	
	
	/**
	 * Tests the "addAll" method with an index out of range.
	 * 
	 * @see PhonyList#equals(Object)
	 * @type Functional
	 * @input [1]
	 * @passed Yes
	 */
	@Test (expected = IndexOutOfBoundsException.class) 
	public void addAll_empty_oneElement_Index1(){
		PhonyList<Integer> list1 = list(1);
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(4);
		c.add(5);
		list1.addAll(12,c);

	}
	
	
}
