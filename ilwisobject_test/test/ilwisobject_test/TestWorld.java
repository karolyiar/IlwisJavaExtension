package ilwisobject_test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestWorld {
	private final static String workingDir = TestUtil.workingDir;

	@BeforeClass
	public static void onceExecutedBeforeAll() {
		final String ilwisLocation = TestUtil.ilwisLocation;
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

	@Before
	public void setUp() throws Exception {
		ilwisobjects.disconnectIssueLogger();
        Engine.setWorkingCatalog(workingDir+"world/");
        ilwisobjects.connectIssueLogger();
	}

	@AfterClass
	public static void onceExecutedAfterAll() {
		ilwisobjects._exitIlwisObjects();
	}
	
	@Test
	public void halloWorld() {
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
		assertEquals(-99, (int) population_ranking.get("EH"));
		assertEquals(9905596, (int) population_ranking.get("HU"));
		assertEquals(9035536, (int) population_ranking.get("HT"));
	}
	
	@Test
	public void ilwisObject() {
		FeatureCoverage fc = new FeatureCoverage("newFC");
	    assertEquals("newFC", fc.name());
	    fc.name("newName");
	    assertEquals("newName", fc.name());
	    assertTrue(fc.isInternal());
	    fc.open(workingDir + "world/countries.mpa", "vectormap", "ilwis3");
	    fc = new FeatureCoverage("countries.mpa");
	    assertFalse(fc.isInternal());
	    assertEquals("countries.mpa", fc.name());
	    //fc.setOutputConnection(workingDir + "world/countries.shp", "ESRI Shapefile", "gdal");
	    //fc.store();
	}
	
	@Test
	public void attributeTable() {
		Table table = new Table(workingDir + "world/countries.tbt");
	    assertTrue(table.isValid());
	    assertFalse(table.isInternal());
	    String value = table.cell("iso_a2", 4);
	    assertEquals("AR", value);
	    table.setCell("iso_a2", 4, value.toUpperCase());
	    long recCount = table.recordCount();
	    assertEquals(177, recCount);
	    long colCount = table.columnCount();
	    assertEquals(63, colCount);
	    vectors columns = table.columns();  // ('column1','column2',...)
	    assertEquals(63, columns.size());
	    assertEquals(42, table.columnIndex("iso_a2"));
	    assertEquals(ilwisobjects.getIUNDEF(), table.columnIndex("ihfg"));
	    /*column = table.column(42);
	    assertEquals(177, column.size());
	    column1 = table.column("iso_a2");
	    assertEquals(column, column1);
	    record = table.record(4);
	    assertEquals(63, len(record))
	    table.addColumn("newCol", "value")
	    assertEquals(64, table.columnCount())*/
	}

}
