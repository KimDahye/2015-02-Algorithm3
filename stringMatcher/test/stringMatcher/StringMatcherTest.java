package stringMatcher;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringMatcherTest {
	String text1 = "ababc";
	String text2 = "ababbacababcabc";

	String pattern1 = "ababc";
	String pattern2 = "";
	String pattern3 = "a";
	
	@Test
	public void testNaive() {		
		assertEquals(StringMatcher.naiveMatcher(text1, pattern1), 1);
		assertEquals(StringMatcher.naiveMatcher(text2, pattern1), 1);
		//StringMatcher.naiveMatcher(text2, pattern2); //exception test
		assertEquals(StringMatcher.naiveMatcher(text2, pattern3), 6);	
	}
	
	@Test
	public void testKMP() {
		assertEquals(StringMatcher.KMPmatcher(text1, pattern1), 1);
		assertEquals(StringMatcher.KMPmatcher(text2, pattern1), 1);
		//StringMatcher.KMPmatcher(text2, pattern2); //exception test
		assertEquals(StringMatcher.KMPmatcher(text2, pattern3), 6);
	}
}
