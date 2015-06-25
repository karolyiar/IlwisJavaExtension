package ilwisobject_test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUtil {

	public final static String workingDir = "file:///F:/documents/ilwis/ilwisObjects/pytest/";
	public final static String ilwisLocation = "F:/documents/ilwis/ilwisObjects/output/win32debug/bin/";
	public final static double precision = 1e-10;

	@BeforeClass
	public static void onceExecutedBeforeAll() {
		try {
			System.load(ilwisLocation
					+ "extensions/_ilwisobjects/_ilwisobjects.dll");
			ilwisobjects._initIlwisObjects(ilwisLocation);
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

	@AfterClass
	public static void onceExecutedAfterAll() {
		ilwisobjects._exitIlwisObjects();
	}

	@Before
	public void setUp() throws Exception {
		// ilwisobjects.disconnectIssueLogger();
		// ilwisobjects.connectIssueLogger();
	}

	@Test
	public void pixelCoordinate() {
		Pixel p = new Pixel(4, 5);
		assertTrue(p.isValid());
		assertEquals("pixel(4,5)", p.toString());
		p.multiply(3);
		assertTrue(p.equal(new Pixel(12, 15)));
		p.divide(4);
		assertEquals("pixel(3,3)", p.toString());
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

		Coordinate c = new Coordinate(-1871900.47, 1874237.55);
		assertEquals(true, c.isValid());
		assertEquals(false, c.is3D());
		assertEquals("coordinate(-1871900.470000,1874237.550000)", c.toString());
		c.multiply(6);
		assertEquals(true,
				c.equal(new Coordinate(-11231402.820000, 11245425.300000)));
		assertEquals("coordinate(-11231402.820000,11245425.300000)",
				c.toString());
		c.divide(6);
		assertEquals("coordinate(-1871900.470000,1874237.550000)", c.toString());
		assertEquals(false, c.is3D());
		c = new Coordinate(-1871900.47, 1874237.55, 2);
		assertEquals(true, c.is3D());
		assertEquals("coordinate(-1871900.470000,1874237.550000,2.000000)",
				c.toString());
		assertEquals(-1871900.47, c.x(), TestUtil.precision);
		c.setX(4.323);
		assertEquals(4.323, c.x(), TestUtil.precision);
	}

	@Test
	public void sizeSizeD() {
		Size sz = new Size(2, 4, 5);
	    assertTrue(sz.isValid());
	    assertEquals(sz.toString(), "Size(2, 4, 5)");
	    assertEquals(sz.linearSize(), new BigInteger("40"));
	    sz.multiply(2);
	    assertEquals(sz.toString(), "Size(4, 8, 10)");
	    sz.increase( new Size(4, 4, 0) );
	    assertTrue(sz.equal( new Size(8, 12, 10) ));
	    sz.decrease( new Size(1, 1, 0) );
	    assertTrue(sz.equal( new Size(7, 11, 10) ));
	    sz.setXsize(3);
	    assertEquals(sz.xsize(), 3);
	    assertTrue( sz.contains(new Pixel(1, 1, 1)) );
	    assertFalse( sz.contains(new Pixel(5, 5, 5)) );
	    
	    SizeD szd = new SizeD(sz);
	    assertEquals(szd.toString(), "Size(3, 11, 10)");
	    assertTrue(szd.equal(new SizeD(3., 11., 10.)));
	    assertTrue(szd.contains(new Pixel(2, 10, 9)));
	    assertTrue(szd.contains(new PixelD(2., 10., 9.)));
	    assertTrue(szd.contains(new Coordinate(2., 10., 9.)));
	    assertEquals(szd.toString(), "Size(3, 11, 10)");
	    szd.decrease(new SizeD(100., 100.));  // == SizeD(100., 100., 1.)
	    assertEquals(szd.toString(), "Size(0, 0, 9)");
	    assertFalse(szd.isValid());
	    assertFalse(new SizeD(10, 10, 0).isValid());
	    szd.decrease(new SizeD(10, 10, 0));  // calculation with invalid szd == Size(0, 0, 9) results in Size(0, 0, 0);
	    assertEquals(szd.toString(), "Size(0, 0, 0)");
	    szd = new SizeD(2.5, 4.4, 5.1);
	    assertTrue(szd.equal(new SizeD(2.5, 4.4, 5.1)));
	    assertEquals(szd.toString(), "Size(2.5, 4.4, 5.1)");
	    assertEquals(szd.linearSize(), new BigInteger("40")); // == int(2.5) * int(4.4) * int(5.1)
	    szd.multiply(2);
	    assertEquals(szd.toString(), "Size(5, 8.8, 10.2)");
	    
	    sz = new Size(32, 43);
	    assertEquals(sz.toString(), "Size(32, 43, 1)");
	}
	
	@Test
	public void BoxEnvelope() {
		Box b = new Box(new Pixel(3, 4, 5), new Pixel(4, 5, 6));
		assertTrue(b.isValid());
        assertTrue(b.is3D());
        assertEquals(b.toString(), "3 4 5 4 5 6");
        assertTrue(b.equal(new Box("POLYGON(3 4 5,4 5 6)")));
        assertEquals(b.minCorner().toString(), "pixel(3,4,5)");
        b.minCorner().setX(39);
        assertEquals(b.minCorner().toString(), "pixel(3,4,5)");
        assertTrue(b.minCorner().equal( new Pixel(3, 4, 5) ));
        assertEquals(b.maxCorner().toString(), "pixel(4,5,6)");
        assertEquals(b.size().toString(), "Size(2, 2, 2)");
        assertTrue(b.size().equal(new Size(2, 2, 2)));
        assertEquals(b.size().linearSize(), new BigInteger("8") );
        b = new Box(new Pixel(2, 3), new Pixel(4, 5));
        assertEquals(b.toString(), "2 3 4 5");
        assertFalse(b.is3D());
        assertTrue(b.isValid());

        Envelope env = new Envelope(new Coordinate(3.6111119, 4.7, 5.9), new Coordinate(4.7, 5.8, 6.9));
        assertEquals(env.toString(), "3.61111 4.7 5.9 4.7 5.8 6.9");
        assertEquals(env.size().toString(), "Size(2.08889, 2.1, 2)");
        env = new Envelope("POLYGON(3.6111119 4.7 5.9,4.7 5.8 6.9)");
        assertEquals(env.toString(), "3.61111 4.7 5.9 4.7 5.8 6.9");
        assertEquals(env.size().toString(), "Size(2.08889, 2.1, 2)");
        assertFalse(env.size().equal(new SizeD(2.08889, 2.1, 2)));  
        env = new Envelope(env.size());
        assertEquals("0 0 0 1.08889 1.1 1", env.toString());
        env = new Envelope(new Coordinate(3, 4, 5), new Coordinate(4, 5, 6));
        assertEquals(env.toString(), "3 4 5 4 5 6");
        env = new Envelope(env.size());
        assertEquals(env.toString(), "0 0 0 1 1 1");
        assertTrue(env.contains(new Coordinate(.5, .5, .5)));
        assertTrue(env.contains(env));
	}

	
	
	@Test
	public void color() {
		Color c = new Color("RGBA", ilwisobjects.array(new double[] { 10, 20,
				30, 40 }), "blueish");
		assertEquals("RGBA(10,20,30,40)", c.toString());
		assertEquals("blueish", c.getName());
		assertEquals(20, c.getItem("green"), TestUtil.precision);
	}

	@Test
	public void numericRange() {
		NumericRange nr = new NumericRange(1, 10, 0.2);
		assertFalse(nr.contains(1.1));
		assertFalse(nr.contains(0.8));
		assertFalse(nr.contains(10.2));
		assertTrue(nr.contains(1.2));

		double d = 1.0;
		
		for (double j : nr) {
			assertEquals(d, j, TestUtil.precision);
			d += 0.2;
		}
	}

	@Test
	public void thematicRange() {
		ThematicRange themRan = new ThematicRange();
		themRan.add("Sea", "SE", "Area covered by the sea");
		themRan.add("Sand", "SA", "Area covered by sand");

		assertTrue(themRan.isValid());
		assertEquals("Area covered by sand", themRan.listAll().get(1).get(2));
	}

	@Test
	public void testBaby() {
		try {
			ilwisobjects.disconnectIssueLogger();
			Engine.setWorkingCatalog(workingDir + "feature");
			ilwisobjects.connectIssueLogger();
		} catch (Exception e) {
			fail("could not set working directory!");
		}
		FeatureCoverage fc = new FeatureCoverage("rainfall.shp");
		Table t = new Table("rainfall.shp");
		assertEquals("rainfall.shp", t.name());
		String[] expected = new String[] { "RAINFALL", "JANUARY", "FEBRUARY",
				"MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER",
				"OCTOBER", "NOVEMBER", "DECEMBER", "NEWCOL", "IDENT" };
		for (int i = 0; i < expected.length; ++i)
			assertEquals(expected[i], t.columns().get(i));

		// assertEquals( ilwisobjects.getIUNDEF(),
		// t.columnIndex("unknownColumn") ); // not working

		assertEquals(10, t.columnIndex("OCTOBER"));

		/*
		 * double[] expected1 = new double[] {48, 46, 86, 89, 44, 40, 44, 85,
		 * 89, 0, 0, 0, 0}; for(int i=0; i<expected1.length; ++i)
		 * assertEquals(expected[i], t.column("OCTOBER")
		 */
	}

}
