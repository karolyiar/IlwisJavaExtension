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

	/*
	 * @Test public void colorPalette() { Color col1 = new
	 * Color(ColorModel.Value.cmRGBA, ilwisobjects.array(new double[]{220.0,
	 * 20.0, 30.0, 200.0})); Color col2 = new Color(ColorModel.Value.cmRGBA,
	 * ilwisobjects.array(new double[]{255.0, 80.0, 60.0, 240.0})); Color col3 =
	 * new Color(ColorModel.Value.cmRGBA, ilwisobjects.array(new double[]{255.0,
	 * 80.0, 69.0, 240.0})); ColorPalette colPal = new ColorPalette();
	 * 
	 * colPal.add(col1); assertEquals(1, colPal.count()); colPal.add(col2);
	 * assertEquals(2, colPal.count());
	 * assertEquals("RGBA(0.86,0.08,0.12,0.78)", colPal.item(0).toString());//!
	 * String name1 = colPal.itemByOrder(1).getName();//! assertFalse(
	 * colPal.containsColor(col3) ); colPal.add(col3); assertTrue(
	 * colPal.containsColor(col3) ); assertEquals(3, colPal.count());
	 * colPal.remove(name1); assertEquals(2, colPal.count());
	 * assertEquals("RGBA(1,0.31,0.27,0.94)", colPal.color(1).toString());//!
	 * 
	 * colPal.clear(); assertEquals(colPal.valueAt(1, colPal).toString(),
	 * colPal.color(1).toString()); }
	 */
	
	@Test
	public void color() {
		Color c = new Color("RGBA", ilwisobjects.array(new double[] { 10, 20,
				30, 40 }), "blueish");
		assertEquals("RGBA(10,20,30,40)", c.toString());
		assertEquals("blueish", c.getName());
		assertEquals(20, c.getItem("green"), TestUtil.precision);
	}

	@Test
	public void colorRange() {
		Color color1 = new Color(ColorModel.Value.cmRGBA,
				ilwisobjects.array(new double[] { 220.0, 20.0, 30.0, 200.0 }));
		Color color2 = new Color(ColorModel.Value.cmRGBA,
				ilwisobjects.array(new double[] { 255.0, 80.0, 60.0, 240.0 }));
		Color color3 = new Color(ColorModel.Value.cmRGBA,
				ilwisobjects.array(new double[] { 230.0, 60.0, 50.0, 240.0 }));

		ContinuousColorRange col = new ContinuousColorRange(color1, color2);
		assertTrue(col.isValid());

		ContinuousColorRange col2 = col.clone();
		assertTrue(col2.isValid());

		col.defaultColorModel(ColorModel.Value.cmRGBA);
		assertEquals(col.defaultColorModel(), ColorModel.Value.cmRGBA);

		// ColorDomain colDom = new ColorDomain("testdomain");
		// colDom.setRange(col);
		// assertEquals(colDom.containsColor(color3), "c);
	}

	@Test
	public void numericRange() {
		NumericRange nr = new NumericRange(1, 10, 0.2);
		assertFalse(nr.contains(1.1));
		assertFalse(nr.contains(0.8));
		assertFalse(nr.contains(10.2));
		assertTrue(nr.contains(1.2));

		double d = 1.0;
		
		for (NumericRangeIterator i = nr.begin(); i.compareTo(nr.end())!=0; i._next()) {
			assertEquals(d, i.current(), TestUtil.precision);
			d += 0.2;
		}
	}

	@Test
	public void numericItemRange_containment() {
		NumericItemRange interrange = new NumericItemRange();
		interrange.add("sealevel", 40, 100);
		interrange.add("dijks", 101, 151);

		assertEquals("sealevel", interrange.listAll().get(0).get(0));
		assertEquals("numericrange:40.0|100.0", interrange.listAll().get(0)
				.get(1));
		assertEquals("dijks", interrange.listAll().get(1).get(0));
		assertEquals("numericrange:101.0|151.0", interrange.listAll().get(1)
				.get(1));

		ItemDomain childdom = new ItemDomain(interrange);

		interrange.add("by the sea", 152.0, 181.0, 5.0);
		ItemDomain parentdom = new ItemDomain(interrange);

		childdom.setParent(parentdom);

		assertEquals("cSELF", childdom.contains(40));
		assertEquals("cNONE", childdom.contains(39.9));
		assertEquals("cNONE", childdom.contains(161.1));

		childdom.setStrict(false);
		assertEquals("cPARENT", childdom.contains(161.1));
	}

	@Test
	public void numericItemRange_parents() {
		NumericItemRange nir = new NumericItemRange();
		nir.add("sealevel", 40, 100);
		ItemDomain childdom = new ItemDomain(nir);

		nir.add("by the sea", 151, 181, 5);
		ItemDomain parentdom = new ItemDomain(nir);

		boolean exception = false;
		try {
			childdom.parent(); // raises exception
		} catch (Exception e) {
			assertEquals("ILWIS ErrorObject: No parent domain found",
					e.getMessage());
			exception = true;
		}
		assertTrue(exception);

		childdom.setParent(parentdom);
		assertTrue(childdom.parent().isValid());
	}

	@Test
	public void numericItemRange_removeAndCount() {
		NumericItemRange nir = new NumericItemRange();
		nir.add("sealevel", 40.0, 100.0, 5.0);
		nir.add("by the sea", 151.0, 181.0, 5.0);
		ItemDomain childdom = new ItemDomain(nir);

		assertEquals(2, childdom.count());
		childdom.removeItem("sealevel");
		assertEquals(1, childdom.count());
		// childdom.add("sealevel", 185.0, 250.0, 5.0);
		// assertEquals(2, childdom.count());
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
	public void helloWorld() {
		try {
			ilwisobjects.disconnectIssueLogger();
			Engine.setWorkingCatalog(workingDir + "world");
			ilwisobjects.connectIssueLogger();
		} catch (Exception e) {
			fail("could not set working directory!");
		}
		FeatureCoverage world = new FeatureCoverage("countries.mpa");
		assertTrue(world.isValid());
		assertFalse(world.isInternal());
		assertEquals(286, world.featureCount());

		HashMap<String, Integer> population_ranking = new HashMap<String, Integer>();

		// TODO remake
		for (FeatureIterator country = world.iterator();; country._next()) {
			try {
				String name = country.current().attribute("iso_a2", "");
				if (!population_ranking.containsKey(name))
					population_ranking.put(name,
							(int) (country.current().attribute("pop_est", 0)));
			} catch (Exception e) {
				break;
			}
		}

		assertEquals(3971020, (int) population_ranking.get("PR"));
		assertEquals(3418085, (int) population_ranking.get("OM"));
		assertEquals(14268711, (int) population_ranking.get("MW"));
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
