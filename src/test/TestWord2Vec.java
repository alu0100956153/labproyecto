/*
 * package LaB.proyectoF;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


import org.junit.Test;

public class TestWord2Vec {

	@BeforeClass
	public void setUp() {
		System.out.println("xd");
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
*/
package LaB.proyectoF;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TestWord2Vec 
    extends TestCase
{
	
	
	
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestWord2Vec( String testName )
    {
    	
    	getInputFile()
    	getOutPutFile()
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestWord2Vec.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}