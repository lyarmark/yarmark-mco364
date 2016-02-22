package yarmark.mavenProject;

//main difference btw. junit 3 and 4 is use of annotations
//if you want to use annotations, you can comment out AppTest methods
//framework is the old way, org is the new way

//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
import static org.junit.Assert.assertEquals; //import this instead of doing Assert.assert___
import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class AppTest/* extends TestCase */{
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	/*
	 * public AppTest(String testName) { super(testName); }
	 */
	/**
	 * @return the suite of tests being tested
	 */
	/*
	 * public static Test suite() { return new TestSuite(AppTest.class); }
	 */
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void testApp() {
		String test = "Hello Earth";
		assertEquals(test, "Hello Earth");
	}
}
