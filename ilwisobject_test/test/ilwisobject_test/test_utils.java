package ilwisobject_test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class test_utils {

	@BeforeClass
	public static void onceExecutedBeforeAll() {
		final String ilwisLocation = "F:/documents/ilwis/ilwisObjects/output/win32debug/bin/";
	    try {    	
	    	System.load(ilwisLocation + "extensions/_ilwisobjects/_ilwisobjects.dll");
	    } catch (UnsatisfiedLinkError e) {
	      System.err.println("Native code library failed to load.\n");
	      e.printStackTrace();
	      System.exit(1);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void color_test() {
		vectord a = new vectord();
		a.add(10); a.add(20); a.add(30); a.add(40);
		Color c = new Color("RGBA", a, "blueish");
		assertEquals("RGBA(10,20,30,40)", c.toString());
		assertEquals("blueish", c.getName());
		assertEquals(20, c.getItem("green"), 0.001);
	}
	
	@Test
	public void pixel_test() {
		Pixel p = new Pixel(2, 3, 1);
		p.multiply(2);

		assertEquals(4, p.x());
		assertEquals(6, p.y());
		assertEquals(2, p.z());
		assertEquals("pixel(4,6,2)", p.toString());
	}

}