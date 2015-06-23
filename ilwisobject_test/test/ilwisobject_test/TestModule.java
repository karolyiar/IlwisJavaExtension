package ilwisobject_test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestModule {
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

	@AfterClass
	public static void onceExecutedAfterAll() {
		ilwisobjects._exitIlwisObjects();
	}

	@Test
	public void exceptions() {
		boolean except = false;
		try {
			;//not implemented yet
		} catch(Exception e) {
			except = true;
		}
		//assertTrue(except);
	}
	
	/*@Test //not implemented yet
	public void issueLogger() {
		ilwisobjects.disconnectIssueLogger();
		boolean except = false;
		try {
			FeatureCoverage fc = new FeatureCoverage(workingDir + "/noneexistentDir/nonexistent.file");
		} catch(Exception e) {
			assertEquals("Cann't find suitable factory for nonexistent.file", e.getMessage());
			except = true;
		}
		assertTrue(except);
		ilwisobjects.connectIssueLogger();
	}*/
	
	@Test
	public void ilwisTypes() {
		assertEquals(7, it.ilwisType.FEATURE.swigValue());
		assertTrue( (it.ilwisType.FEATURE.swigValue() & 4) != 0 );
		assertFalse( (it.ilwisType.CATALOG.swigValue()&it.ilwisType.FEATURE.swigValue()) != 0 );
		assertEquals(4, (it.ilwisType.FEATURE.swigValue() & 4));
		assertEquals(524288, it.ilwisType.CATALOG.swigValue());
		//it.ilwisType.CATALOG.setValue(0); //not implemented
		//assertEquals(0, it.ilwisType.CATALOG.swigValue());
		assertEquals(0, it.ilwisType.CONTINUOUSCOLOR.swigValue());
		
	}

}
