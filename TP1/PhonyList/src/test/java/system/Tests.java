/**
 * 
 */
package system;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Ellyn BLEAS
 * @author C�dric DUBOIS
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
	public void addEmptyList(){
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
	public void addSmallList(){
		PhonyList<Integer> list = list(75);
		list.add(4);
		assertEquals("Testing add method",list.size(),2);
		int var = list.get(0);
		assertEquals("Testing add method",75,var);
		var = list.get(1);
		assertEquals("Testing add method",var,4);
	}
	
	/**
	 * Tests the "get" method with a not empty list.
	 * 
	 * @see PhonyList#get(Index)
	 * @type Functional
	 * @input [10,30,31,60,70,2]
	 * @passed Yes
	 */
	@Test
	public void getaddList(){
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
	public void getVide(){
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
	public void getToFar(){
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
	public void sizeEmpty(){
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
	public void sizeNotEmpty(){
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
	public void emptyTrue(){
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
	public void emptyFalse(){
		PhonyList<Integer> list = list(20);
		assertFalse(list.isEmpty());
		list.add(3);
		assertFalse(list.isEmpty());
	}

	@Test
	public void setList(){
		PhonyList<Integer> list = list(20,40,15,68);
		list.set(2, 4);
		int var = list.get(2);
		assertEquals(var, 4);
		var = list.get(1);
		assertEquals(var, 40);
	}
	
	@Test (expected = IndexOutOfBoundsException.class) 
	public void setToFar(){
		PhonyList<Integer> list = list(10,30,31,60,70,2);
		list.set(10,70);
	}
	
	@Test (expected = IndexOutOfBoundsException.class) 
	public void setVide(){
		PhonyList<Integer> list = list();
		list.set(0,70);
	}
	
	@Test
	public void removeList(){
		PhonyList<Integer> list = list(4,5,9,2,4,5);
		list.remove(4);
		assertEquals(list.size(), 5);
		int var = list.get(0);
		assertEquals(var, 5);
		var = list.get(3);
		assertEquals(var, 4);


	}
}
