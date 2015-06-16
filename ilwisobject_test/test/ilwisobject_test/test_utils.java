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
	
	@Test
	public void coordinate_test() {
		Coordinate c = new Coordinate(-1871900.47, 1874237.55);
		assertEquals(true, c.isValid());
		assertEquals(false, c.is3D());
		assertEquals("coordinate(-1871900.470000,1874237.550000)", c.toString());
		c.multiply(6);
		assertEquals(true, c.equal(new Coordinate(-11231402.820000, 11245425.300000)));
		assertEquals("coordinate(-11231402.820000,11245425.300000)", c.toString());
		c.divide(6);
		assertEquals("coordinate(-1871900.470000,1874237.550000)", c.toString());
		assertEquals(false, c.is3D());
		c = new Coordinate(-1871900.47, 1874237.55, 2);
		assertEquals(true, c.is3D());
		assertEquals("coordinate(-1871900.470000,1874237.550000,2.000000)", c.toString());
		assertEquals(-1871900.47, c.x(), 0.0001);
		c.setX(4.323);
		assertEquals(4.323, c.x(), 0.0001);
	}
	
	@Test
	public void colorPalette_test() {
		Color col1 = new Color(ColorModel.Value.cmRGBA, ilwisobjects.array(new double[]{220.0, 20.0, 30.0, 200.0}));
		Color col2 = new Color(ColorModel.Value.cmRGBA, ilwisobjects.array(new double[]{255.0, 80.0, 60.0, 240.0}));
		Color col3 = new Color(ColorModel.Value.cmRGBA, ilwisobjects.array(new double[]{255.0, 80.0, 69.0, 240.0}));
		
		//for(int i=0;i<10000;++i) {
			ColorPalette colPal = new ColorPalette();
			colPal.add(col1);
			assertEquals(1, colPal.count());
			colPal.add(col2);
			assertEquals(2, colPal.count());
			assertEquals("RGBA(0.86,0.08,0.12,0.78)", colPal.item(0).toString());//!
			String name1 = colPal.itemByOrder(1).getName();//!
			assertFalse( colPal.containsColor(col3) );
			colPal.add(col3);
			assertTrue( colPal.containsColor(col3) );
			assertEquals(3, colPal.count());
			colPal.remove(name1);
			assertEquals(2, colPal.count());
			assertEquals("RGBA(1,0.31,0.27,0.94)", colPal.color(1).toString());//!
			
			colPal.clear();
			assertEquals(colPal.valueAt(1, colPal).toString(), colPal.color(1).toString());
		//}
	}
	

}
