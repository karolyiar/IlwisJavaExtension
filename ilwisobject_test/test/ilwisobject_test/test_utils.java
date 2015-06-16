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
		Color c = new Color("RGBA", ilwisobjects.array(new double[]{10, 20, 30, 40}), "blueish");
		assertEquals("RGBA(10,20,30,40)", c.toString());
		assertEquals("blueish", c.getName());
		assertEquals(20, c.getItem("green"), 0.001);
	}
	
	@Test
	public void pixel_test() {
		Pixel p = new Pixel(4, 5);
		assertTrue(p.isValid());
		assertEquals("pixel(4,5)", p.toString());
		p.multiply(3);
		assertTrue(p.equal(new Pixel(12, 15)));
		p.divide(4);
		assertEquals("pixel(3,3)", p.toString());
		assertFalse(p.equal(new Pixel(3, 4)));
		assertTrue(p.notequal(new Pixel(3, 4)));
		assertFalse(p.is3D());
		
		Pixel v = new Pixel(4, 5, 6);
		assertEquals("pixel(4,5,6)", v.toString());
		assertTrue(v.is3D());
		assertEquals(4, v.x());
		v.setX(32);
		assertEquals(32, v.x());
		v.setY(32);
		assertEquals(32, v.y());
		v.setZ(32);
		assertEquals(32, v.z());
		assertEquals("pixel(32,32,32)", v.toString());
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
	}
	
	@Test
	public void colorRange_test() {
		Color color1 = new Color(ColorModel.Value.cmRGBA, ilwisobjects.array(new double[]{220.0, 20.0, 30.0, 200.0}));
		Color color2 = new Color(ColorModel.Value.cmRGBA, ilwisobjects.array(new double[]{255.0, 80.0, 60.0, 240.0}));
		Color color3 = new Color(ColorModel.Value.cmRGBA, ilwisobjects.array(new double[]{230.0, 60.0, 50.0, 240.0}));
		
		ContinuousColorRange col = new ContinuousColorRange(color1, color2);
		assertTrue(col.isValid());
		
		ContinuousColorRange col2 = col.clone();
		assertTrue(col2.isValid());
		
		col.defaultColorModel( ColorModel.Value.cmRGBA );
		assertEquals(col.defaultColorModel(), ColorModel.Value.cmRGBA);
		
		//ColorDomain colDom = new ColorDomain("testdomain");
		//colDom.setRange(col);
		//assertEquals(colDom.containsColor(color3), "cSELF");
	}
	
	@Test
	public void numericRange_test() {
		NumericRange nr = new NumericRange(1, 10, 0.2);
		assertFalse(nr.contains(1.1));
		assertFalse(nr.contains(0.8));
		assertFalse(nr.contains(10.2));
		assertTrue(nr.contains(1.2));
		
		double d = 1;
		for(NumericRangeIterator i = nr.begin(); i.compareTo(nr.end()) != 0; ) {
			assertEquals( i.next(), d, 0.0001 );
			d += 0.2;
		}
	}
	
	@Test
	public void numericItemRange_test() {
		NumericItemRange interrange = new NumericItemRange();
		interrange.add("sealevel", 40, 100);
		interrange.add("dijks", 101, 151);
		
		assertEquals("sealevel", interrange.listAll().get(0).get(0) );
		assertEquals("numericrange:40.0|100.0", interrange.listAll().get(0).get(1));
		assertEquals("dijks", interrange.listAll().get(1).get(0) );
		assertEquals("numericrange:101.0|151.0", interrange.listAll().get(1).get(1));
	}
	
	@Test
	public void thematicRange_test() {
		ThematicRange themRan = new ThematicRange();
		themRan.add("Sea", "SE", "Area covered by the sea");
		themRan.add("Sand", "SA", "Area covered by sand");
		
		assertTrue(themRan.isValid());
		assertEquals("Area covered by sand", themRan.listAll().get(1).get(2) );
	}
	


}
