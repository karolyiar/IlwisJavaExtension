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
		
		IObject result = Engine._do("gridding_1", "gridding", cs.toString(), new Coordinate(225358.6605, 3849480.5700).toString(),
				Double.toString(1000.0), Double.toString(1000.0), Integer.toString(12), Integer.toString(12));

		FeatureCoverage polygongrid = FeatureCoverage.toFeatureCoverage( result );
	    assertTrue(polygongrid.isValid());
	    assertEquals("wrong IlwisObject type", polygongrid.type(), "FeatureCoverage");
	    assertTrue( polygongrid.name().matches("gridding_[0-9]*") );
	    assertEquals("wrong number of polygons in gridding result!", polygongrid.featureCount(), 144);
	    
	    polygongrid.store(workingDir + "temp/aa_gridding", "vectormap", "ilwis3");
	    polygongrid.store(workingDir + "temp/aa_gridding.shp", "ESRI Shapefile", "gdal");
	}
	
	@Test
	public void resample() { //                                    8, raster;   131072, Georef;  68719476736, String                              
		IObject resampled = Engine._do("resample_1", "resample", "subkenya.mpr", "alm011nd.grf", "bicubic");
	    RasterCoverage resampledR = RasterCoverage.toRasterCoverage( resampled );
		assertTrue(resampledR.isValid());
		resampledR.store(workingDir + "raster/aa_resample_subkenya", "GTiff", "gdal");
		resampledR.store(workingDir + "raster/aa_resample_subkenya", "map", "ilwis3");
	}
	
	@Test
	public void resample_tif() {
		RasterCoverage rc = new RasterCoverage("n000302.tif");
		GeoReference grf = new GeoReference("alm011nd.grf");
		assertTrue(rc.isValid());
		assertTrue(grf.isValid());
		assertEquals("n000302.tif", rc.name());
		assertEquals("alm011nd.grf", grf.name());
		assertTrue(rc.isValid());
		
		IObject result = Engine._do("resample_1", "resample", rc.name(), grf.name(), "bicubic");
	    RasterCoverage resultR = RasterCoverage.toRasterCoverage( result );
		assertTrue(resultR.isValid());
		resultR.store(workingDir + "raster/aa_n000302", "GTiff", "gdal");
		resultR.store(workingDir + "raster/aa_n000302", "map", "ilwis3");
	}
	
	@Test // Almost fully black output
	public void linearstretch() {
		RasterCoverage rc = new RasterCoverage("n000302.tif");
		IObject result = Engine._do("lin_1", "linearstretch", rc.name(), "100", "100");
		RasterCoverage resultR = RasterCoverage.toRasterCoverage( result );
		resultR.store(workingDir + "raster/aa_linearstretch", "GTiff", "gdal");
	}
	
	@Test // Working
		  // !! mirrhor, mirrdiag, transpose, rotate90, rotate180, rotate270 not working
	public void mirrorrotateraster() {
		IObject result = Engine._do("mirror_1", "mirrorrotateraster","n000302.tif", "mirrvert");
		RasterCoverage resultR = RasterCoverage.toRasterCoverage( result );
		resultR.store("aa_mirrorrotateraster", "GTiff", "gdal");
	}
	
	@Ignore // No usable output
	@Test
	public void areanumbering() {
		IObject result = Engine._do("area_1", "areanumbering","n000302.tif", "8");
		RasterCoverage resultR = RasterCoverage.toRasterCoverage( result );
		assertTrue(resultR.isValid());
		resultR.store("aa_areanumbering", "GTiff", "gdal");
		resultR.store("aa_areanumbering", "map", "ilwis3");
	}
	
	@Test // Working
	public void abs() {
		IObject result = Engine._do("abs_1", "abs","n000302.tif");
		RasterCoverage resultR = RasterCoverage.toRasterCoverage( result );
		assertTrue(resultR.isValid());
		resultR.store("aa_abs", "GTiff", "gdal");
	}
	
	@Ignore // No usable output
	@Test
	public void binarylogicalraster() {
		IObject result = Engine._do("binarylogicalraster_1", "binarylogicalraster","n000302.tif", "8", "and");
		RasterCoverage resultR = RasterCoverage.toRasterCoverage( result );
		assertTrue(resultR.isValid());
		resultR.store("aa_binarylogicalraster", "GTiff", "gdal");
	}
	
	@Ignore // EXCEPTION_ACCESS_VIOLATION in ilwiscore.dll
	@Test
	public void binarymathfeatures() {
		ilwisobjects.disconnectIssueLogger();
        Engine.setWorkingCatalog(workingDir+"feature/");
        ilwisobjects.connectIssueLogger();
        
		FeatureCoverage fc = new FeatureCoverage("rainfall.shp");
		assertTrue(fc.isValid());
		//fc.store(workingDir + "temp/rainfall_fromshp", "vectormap", "ilwis3");
		
		FeatureCoverage fc2 = new FeatureCoverage("Natuurkalender_ETRS1989.shp");
		assertTrue(fc2.isValid());
		//fc2.store(workingDir + "temp/Natuurkalender_ETRS1989_fromshp", "vectormap", "ilwis3");
		
		IObject result = Engine._do("bin_1", "binarymathfeatures", "rainfall.shp", "Natuurkalender_ETRS1989.shp", "add");
//		
//		FeatureCoverage resultF = FeatureCoverage.toFeatureCoverage(result);
//		assertTrue(resultF.isValid());
//		resultF.store(workingDir + "temp/aa_binarymathfeatures", "vectormap", "ilwis3");
	}
	
	@Test // Working
	public void binarymathraster() {
		IObject result = Engine._do("binarymathraster_1", "binarymathraster", "n000302.tif", "200", "divide");
		RasterCoverage resultR = RasterCoverage.toRasterCoverage(result);
		assertTrue(resultR.isValid());
		resultR.store("aa_binarymathraster", "GTiff", "gdal");
		
	}
	
	@Test // Working
	public void cos() {
		IObject result = Engine._do("cos_1", "cos","n000302.tif");
		RasterCoverage resultR = RasterCoverage.toRasterCoverage( result );
		assertTrue(resultR.isValid());
		resultR.store("aa_cos", "GTiff", "gdal");
	}
	
	@Test // Working
	public void ln() {
		IObject result = Engine._do("ln_1", "ln","n000302.tif");
		RasterCoverage resultR = RasterCoverage.toRasterCoverage( result );
		assertTrue(resultR.isValid());
		resultR.store("aa_ln", "GTiff", "gdal");
	}
	
	@Ignore // couldn't handle return type (IlwisType=49152) of do(cross_1=cross(n000302.tif,n000302.tif,dontcare))
	@Test
	public void cross() {
		Engine._do("cross_1", "cross", "n000302.tif", "n000302.tif", "dontcare");
	}
	
	@Test // Working
	public void adaptivebilateralfilter() {
		IObject result = Engine._do("adaptivebilateralfilter_1", "adaptivebilateralfilter", "n000302.tif", "21", "21", "3", "200");
		RasterCoverage resultR = RasterCoverage.toRasterCoverage( result );
		assertTrue(resultR.isValid());
		resultR.store("aa_adaptivebilateralfilter", "GTiff", "gdal");
	}
	
}
