package ilwisobject_test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEngine {
	private final static String workingDir = TestUtil.workingDir;
	@BeforeClass
	public static void onceExecutedBeforeAll() {
		TestUtil.onceExecutedBeforeAll();
	}
	@AfterClass
	public static void onceExecutedAfterAll() {
		TestUtil.onceExecutedAfterAll();
	}
	
	@Before
	public void setUp() throws Exception {
		ilwisobjects.disconnectIssueLogger();
        Engine.setWorkingCatalog(workingDir+"raster/");
        ilwisobjects.connectIssueLogger();
	}

	@Test
	public void operations() {
		Engine e = new Engine();
		vectors ops = e.operations();
		String[] oper = new String[] {"abs", "acos", "aggregateraster", "aggregaterasterstatistics", "areanumbering", "asin",
				"assignment", "atan", "binarylogicalraster", "binarymathfeatures", "binarymathraster", "binarymathtable",
				"boxclassification", "ceil", "clusterraster", "contains", "coord2pixel", "coordinate", "correlation", "cos",
				"cosh", "covariance", "coveredby", "covers", "cross", "crosses", "disjoint", "equals", "floor", "gridding",
				"httpserver", "iff", "iff", "ilwisremotecatalog", "intersects", "linearrasterfilter", "linearstretch", "ln",
				"log10", "mastergeoreference", "mirrorrotateraster", "overlaps", "pixel2coord", "pixel", "pointrastercrossing",
				"postgresqlcatalog", "quantile", "rankorderrasterfilter", "rastersize", "rastervalue",
				"relativeaggregaterasterStatistics", "remoteoperation", "resample", "script", "selection", "selection",
				"selection", "setvaluerange", "setworkingcatalog", "sgn", "sin", "sinh", "sliceraster", "sqrt", "stringfind",
				"stringreplace", "stringsub", "tan", "text2output", "timesat", "touches", "wfscatalog", "within"
		};
		for(int i=0;i<ops.capacity();++i)
			assertEquals(oper[i], ops.get(i));
		assertEquals("gridsize(rastercoverage,xsize|ysize|zsize)", e.operationMetaData("rastersize"));
		assertEquals(
                "gridding(coordinatesyste,top-coordinate,x-cell-size, y-cell-size, horizontal-cells, vertical-cells)",
                e.operationMetaData("gridding"));
		assertEquals(("iffraster(featurecoverage,outputchoicetrue, outputchoicefalse)\n"
                 + "iffraster(rastercoverage,outputchoicetrue, outputchoicefalse)"),
               e.operationMetaData("iff"));
	}
	
	@Test //not working
	public void gridding() {
		Engine e = new Engine();
		CoordinateSystem cs = new CoordinateSystem(
                "code=proj4:+proj=utm +zone=35 +ellps=intl +towgs84=-87,-98,-121,0,0,0,0 +units=m +no_defs");
		assertTrue(cs.isValid());
		/*
		 *  metadata of _ilwisobject_4646 not properly initialized
		 *  couldn't do(gridding=_ILWISOBJECT_4646(coordinate(225358.660500,3849480.570000),1000.0,1000.0,12,12))
		 */
		/*IObject polygongrid = Engine._do("gridding", cs.toString(), new Coordinate(225358.6605, 3849480.5700).toString(),
				Double.toString(1000.0), Double.toString(1000.0), Integer.toString(12), Integer.toString(12));
	    assertTrue(polygongrid.isValid());*/
	    /*assertEqual(polygongrid.type(), "FeatureCoverage", msg="wrong IlwisObject type")
	    assertRegex(polygongrid.name(), r"gridding_[0-9]*" );
	    assertEqual(polygongrid.featureCount(), 144, msg="wrong number of polygons in gridding result!")*/
	}
	
	/*@Test //no testdata
	public void resample() {
		IObject resampled = Engine._do("resample", "subkenya.mpr", "alm011nd.grf", "bicubic");
	    assertTrue(resampled.isValid());
	}*/
}
