package ilwisobject_test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRaster {
	private final static String workingDir = TestUtil.workingDir;

	@BeforeClass
	public static void onceExecutedBeforeAll() {
		TestUtil.onceExecutedBeforeAll();
	}

	@Before
	public void setUp() throws Exception {
		ilwisobjects.disconnectIssueLogger();
        Engine.setWorkingCatalog(workingDir+"raster/");
        ilwisobjects.connectIssueLogger();
	}

	@AfterClass
	public static void onceExecutedAfterAll() {
		TestUtil.onceExecutedAfterAll();
	}
	
	@Test
	public void rasterCalculation() {
		/*RasterCoverage rc = new RasterCoverage(workingDir+"raster/n000302.mpr"); //errors
	    RasterCoverage rctif = new RasterCoverage(workingDir+"raster/n0.mpr");
	    assertTrue("couldn't load RasterCoverages", rc.isValid() &&  rctif.isValid());*/
	}
	
	
	
	@Test
	public void reprojectRaster() {
		/*RasterCoverage rc = new RasterCoverage("n000302.mpr"); //errors
		CoordinateSystem targetCsy = new CoordinateSystem("code=epsg:2050");

	    GeoReference sourceGeoref = rc.geoReference();
	    CoordinateSystem sourceCsy = rc.coordinateSystem();
	    Envelope sourceEnv = rc.envelope();

	    Envelope targetEnv = sourceCsy.convertEnvelope(targetCsy, sourceEnv);

	    Box bo = sourceGeoref.envelope2Box(targetEnv);
	    Size sz = bo.size();

	    String newGeoRefStr = "code=georef:type=corners,csy=epsg:2050,envelope=" +
	                        targetEnv + ",gridsize=" + sz.xsize() + " " + sz.ysize() + ",name=grf1";

	    GeoReference targetGeoRef = new GeoReference(newGeoRefStr);
	    IObject rcReproj = Engine._do("resample", rc.name(), targetGeoRef.name(), "bilinear");
	    assertTrue(rcReproj.isValid());

	    RasterCoverage rcReproj2 = rc.reprojectRaster("newraster", 2050, "bilinear");
	    assertTrue(rcReproj2.isValid());*/
	}
	
	//TODO more tests

}
