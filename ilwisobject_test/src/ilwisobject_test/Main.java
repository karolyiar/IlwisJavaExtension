package ilwisobject_test;

import java.lang.reflect.Field;

public class Main {
	/*
	 *  Folder, contains Ilwis
	 *  TODO: load from ilwislocation.config file
	 */
	final static String ilwisLocation = "F:/documents/ilwis/ilwisObjects/output/win32debug/bin/";
	
	static {
	    try {
	    	String prevProperty = System.getProperty( "java.library.path" );
	    	System.setProperty( "java.library.path",
	    			  ilwisLocation + "../../../libraries/win32debug;"
	    			+ ilwisLocation + "../../../output/win32debug/bin/extensions/_ilwisobjects;"
	    			+ ilwisLocation + ";"
	    			//+ ilwisLocation + "../../../external/geos;"
	    			//+ ilwisLocation + "../../../IlwisCore/core;"
	    			//+ "ilwisLocation + "../../../output/win32debug/bin;"
	    			//+ "ilwisLocation + "../../../libraries/win32debug/extensions/_ilwisobjects;"
	    			+ prevProperty );
	    	 
	    	/*
	    	 * Fixes java.library.path caching
	    	 * http://blog.cedarsoft.com/2010/11/setting-java-library-path-programmatically/
	    	 */
	    	Field fieldSysPath = ClassLoader.class.getDeclaredField( "sys_paths" );
	    	fieldSysPath.setAccessible( true );
	    	fieldSysPath.set( null, null );
	    	
	    	System.out.println( "Path: " + System.getProperty("java.library.path"));
	    	
	    	System.loadLibrary("_ilwisobjects");
	    } catch (UnsatisfiedLinkError e) {
	      System.err.println("Native code library failed to load.\n");
	      e.printStackTrace();
	      System.exit(1);
	    } catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	  }


	public static void main(String[] args) {
		IlwisObject o = new IlwisObject(0, false);
		System.out.println( o.__str__() );
	}

}
