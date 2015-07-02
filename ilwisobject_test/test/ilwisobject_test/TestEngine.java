package ilwisobject_test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEngine {
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
	
	@Test
	public void gridding() {
		Engine e = new Engine();
		CoordinateSystem cs = new CoordinateSystem(
                "code=proj4:+proj=utm +zone=35 +ellps=intl +towgs84=-87,-98,-121,0,0,0,0 +units=m +no_defs");
		assertTrue(cs.isValid());

		FeatureCoverage polygongrid = FeatureCoverage.toFeatureCoverage( Engine._do("gridding_1", "gridding", cs.toString(), new Coordinate(225358.6605, 3849480.5700).toString(),
				Double.toString(1000.0), Double.toString(1000.0), Integer.toString(12), Integer.toString(12)) );
	    assertTrue(polygongrid.isValid());
	    assertEquals("wrong IlwisObject type", polygongrid.type(), "FeatureCoverage");
	    assertTrue( polygongrid.name().matches("gridding_[0-9]*") );
	    assertEquals("wrong number of polygons in gridding result!", polygongrid.featureCount(), 144);
	}
	
	@Test
	public void resample() {
		//IObject resampled = Engine._do("resample_1", "resample", "subkenya.mpr", "alm011nd.grf", "bicubic");
		IObject resampled = Engine._do("resample_1", "resample", "small.mpr", "alm011nd.grf", "bicubic");
	    RasterCoverage resampledF = RasterCoverage.toRasterCoverage( resampled );
		assertTrue(resampledF.isValid());
	}
}
