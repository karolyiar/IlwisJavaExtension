package ilwisobject_test;

public class Main {
	/*
	 * !! Ilwis location have to be in the PATH variable !!
	 *  F:\documents\ilwis\ilwisObjects\output\win32debug\bin;
	 *  
	 *  Folder, contains Ilwis
	 *  TODO: load from ilwislocation.config file
	 */
	final static String ilwisLocation = "F:/documents/ilwis/ilwisObjects/output/win32debug/bin/";
	
	static {
	    try {    	
	    	System.load(ilwisLocation + "extensions/_ilwisobjects/_ilwisobjects.dll");
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

	public static void main(String[] args) {
		//ilwisobjects._initIlwisObjects("F:/documents/ilwis/python_helloworld/");
		Pixel p = new Pixel(2, 3);
		p.multiply(2);
		System.out.println( p );
		
		Color c = new Color();
		c.setName("blueish");
		
		System.out.println( c + " " + c.getName() + " "+ c.getItem("blue") );
		
		System.out.println( (int)ilwisobjects.getQVariant() );
		
		Object[] list = (Object[])ilwisobjects.getQList1();
	    
		//System.out.println( list.length );
	}
	
	public static int test(Object a) {
		return 0;
	}

}
