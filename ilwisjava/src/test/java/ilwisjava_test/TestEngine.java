package ilwisjava_test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.n52.ilwis.java.*;

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
		vectors ops = Engine.operations();
		String[] oper = new String[] {"setvaluerange", "binarymathtable", "selection", "mastergeoreference", "binarymathfeatures",
                "binarymathraster", "selection", "iff", "stringfind", "stringsub", "stringreplace", "rastersize",
                "text2output", "coord2pixel", "coordinate", "pixel", "pixel2coord", "selection", "assignment",
                "sin", "cos", "tan", "asin", "acos", "atan", "log10", "ln", "abs", "sqrt", "ceil", "floor", "sgn",
                "cosh", "sinh", "binarylogicalraster", "iff", "rastervalue", "resample", "gridding", "script",
                "aggregateraster", "areanumbering", "cross", "linearstretch", "linearrasterfilter",
                "rankorderrasterfilter"
		};
		for(String s : oper) {
			boolean contains = false;
			for(int i=0; i<ops.capacity(); ++i) {
				if (s.equals(ops.get(i))) {
					contains = true;
					break;
				}
			}
			assertTrue(contains);
		}
		assertEquals("gridsize(rastercoverage,xsize|ysize|zsize)", Engine.operationMetaData("rastersize"));
		assertEquals(
                "gridding(coordinatesyste,top-coordinate,x-cell-size, y-cell-size, horizontal-cells, vertical-cells)",
                Engine.operationMetaData("gridding"));
		assertEquals(("iffraster(featurecoverage,outputchoicetrue, outputchoicefalse)\n"
                 + "iffraster(rastercoverage,outputchoicetrue, outputchoicefalse)"),
               Engine.operationMetaData("iff"));
	}
	
	@Test
	public void gridding() {
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
	
	@Ignore
	@Test
	public void resample() { //                                    8, raster;   131072, Georef;  68719476736, String                              
		IObject resampled = Engine._do("resample_1", "resample", "subkenya.mpr", "alm011nd.grf", "bicubic");
	    RasterCoverage resampledR = RasterCoverage.toRasterCoverage( resampled );
		assertTrue(resampledR.isValid());
		resampledR.store(workingDir + "raster/aa_resample_subkenya", "GTiff", "gdal");
		resampledR.store(workingDir + "raster/aa_resample_subkenya", "map", "ilwis3");
		
		//resampledR.store(workingDir + "raster/aa_resample_subkenya2", "ESRI Shapefile", "gdal"); // Not working
	}
	
	@Ignore
	@Test
	public void resample_tif() {
		RasterCoverage rc = new RasterCoverage("n000302.tif");
		GeoReference grf = new GeoReference("alm011nd.grf");
		assertTrue(rc.isValid());
		assertTrue(grf.isValid());
		assertEquals("n000302.tif", rc.name());
		assertEquals("alm011nd.grf", grf.name());
		assertTrue(rc.isValid());
		
		IObject resampled = Engine._do("resample_1", "resample", rc.name(), grf.name(), "bicubic");
	    RasterCoverage resampledR = RasterCoverage.toRasterCoverage( resampled );
		assertTrue(resampledR.isValid());
		resampledR.store(workingDir + "raster/aa_n000302", "GTiff", "gdal");
		resampledR.store(workingDir + "raster/aa_n000302", "map", "ilwis3");
	}
	
	@Test
	public void linearstretch() {
		RasterCoverage rc = new RasterCoverage("n000302.tif");
		IObject resampled = Engine._do("lin_1", "linearstretch", rc.name(), "100", "100");
		RasterCoverage resampledR = RasterCoverage.toRasterCoverage( resampled );
		resampledR.store(workingDir + "raster/aa_linearstretch", "GTiff", "gdal");
	}
	
	@Test
	public void mirrorrotateraster() {
		RasterCoverage rc = new RasterCoverage("n000302.tif");
		//IObject resampled = Engine._do("mirror_1", "mirrorrotateraster", rc.name(), "mirrvert");
		IObject resampled = Engine._do("mirror_1", "mirrorrotateraster","n000302.tif", "mirrvert");
		RasterCoverage resampledR = RasterCoverage.toRasterCoverage( resampled );
		resampledR.store("aa_mirrorrotateraster", "GTiff", "gdal");
	}
}
