package ilwisobject_test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestNumericDomain {
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
		ilwisobjects.connectIssueLogger();
	}

	@AfterClass
	public static void onceExecutedAfterAll() {
		ilwisobjects._exitIlwisObjects();
	}

	@Test
	public void containementInt() {
		NumericRange nr = new NumericRange(5, 60, 5);
		NumericDomain childnumdom = new NumericDomain("numbers");
		childnumdom.setRange(nr);
		NumericRange nr2 = new NumericRange(0, 80, 5);
		NumericDomain parentnumdom = new NumericDomain("parentnumbers");
		parentnumdom.setRange(nr2);

		childnumdom.setParent(parentnumdom);
		childnumdom.setStrict(false); // doesn't reset by default

		assertEquals("cSELF", childnumdom.contains(20));
		assertEquals("cPARENT", childnumdom.contains(80));
		assertEquals("cNONE", childnumdom.contains(100));
		assertEquals("cNONE", childnumdom.contains(31));

		assertFalse(childnumdom.isStrict());
		childnumdom.setStrict(true);
		assertTrue(childnumdom.isStrict());

		assertEquals("cNONE", childnumdom.contains(80));
	}

	@Test
	public void containementDouble() {
		NumericRange nr = new NumericRange(5.8, 60.2, 0.2);
		NumericDomain childnumdom = new NumericDomain("numbers");
		childnumdom.setRange(nr);
		NumericRange nr2 = new NumericRange(0, 80.4, 0.2);
		NumericDomain parentnumdom = new NumericDomain("parentnumbers");
		parentnumdom.setRange(nr2);

		childnumdom.setParent(parentnumdom);
		childnumdom.setStrict(false); // doesn't reset by default

		assertEquals("cSELF", childnumdom.contains(12.8));
		assertEquals("cPARENT", childnumdom.contains(72.2));
		assertEquals("cNONE", childnumdom.contains(100));

		assertFalse(childnumdom.isStrict());
		childnumdom.setStrict(true);
		assertTrue(childnumdom.isStrict());

		assertEquals("cNONE", childnumdom.contains(72.5));
	}

	@Test
	public void boundaries() {
		NumericRange nr = new NumericRange(5.8, 60.2, 0.2);
		NumericDomain childnumdom = new NumericDomain("numbers");
		childnumdom.setRange(nr);

		assertEquals("cSELF", childnumdom.contains(6.0));
		assertEquals("cNONE", childnumdom.contains(5.6));
		assertEquals("cSELF", childnumdom.contains(60.2));
		assertEquals("cNONE", childnumdom.contains(60.4));
	}

	@Test
	public void parents() {
		NumericRange nr = new NumericRange(5.8, 60.2, 0.2);
		NumericDomain childnumdom = new NumericDomain("numbers");
		childnumdom.setRange(nr);
		NumericRange nr2 = new NumericRange(0, 80.4, 0.2);
		NumericDomain parentnumdom = new NumericDomain("parentnumbers");
		parentnumdom.setRange(nr2);

		/*boolean except = false; //doesn't drop exception
		try {
			childnumdom.parent();
		} catch (Exception e) {
			System.out.println( e.getMessage() );
			except = true;
		}
		assertTrue(except);*/
		childnumdom.setParent(parentnumdom);
		assertTrue(childnumdom.parent().isValid());
	}
}