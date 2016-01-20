package test.java.com.lesbonne.comment.end2end;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author yucheng
 * @since 1
 * */
public class CommentServiceTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public CommentServiceTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(CommentServiceTest.class);
	}

	public void testUpsertAProvidePost() {
	}
	
	public void testGetProvidePostById() {
	}
	
	public void testGetProvidePostsByUsers() {
	}

	public void testRemoveAProvidePost() {
	}
}
