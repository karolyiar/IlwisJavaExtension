package ilwisobject_test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestConst {
	@BeforeClass
	public static void onceExecutedBeforeAll() {
		TestUtil.onceExecutedBeforeAll();
	}

	@AfterClass
	public static void onceExecutedAfterAll() {
		TestUtil.onceExecutedAfterAll();
	}

	@Test
	public void undef() {
		//assertEquals(Const.sUNDEF, "?");
        //assertEquals(Const.shUNDEF, 32767);
        assertEquals(2147483645, ilwisobjects.getIUNDEF());
        //assertEquals(1e38, ilwisobjects.getFlUNDEF(), TestUtil.precision);
        assertEquals(-1e308, ilwisobjects.getRUNDEF(), TestUtil.precision);
        assertEquals(-9223372036854775808L, ilwisobjects.getI64UNDEF());
        
	}

}
