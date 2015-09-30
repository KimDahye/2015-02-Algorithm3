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
		assertEquals(1, StringMatcher.naiveMatcher(text1, pattern1));
		assertEquals(1, StringMatcher.naiveMatcher(text2, pattern1));
		assertEquals(6, StringMatcher.naiveMatcher(text2, pattern3));	
	}
	
	@Test
	public void testFiniteAutomata() {
		assertEquals(1, StringMatcher.finiteAutomataMatcher(text1, pattern1));
		assertEquals(1, StringMatcher.finiteAutomataMatcher(text2, pattern1));
		assertEquals(6, StringMatcher.finiteAutomataMatcher(text2, pattern3));
	}
	
	@Test
	public void testKMP() {
		assertEquals(1, StringMatcher.KMPmatcher(text1, pattern1));
		assertEquals(1, StringMatcher.KMPmatcher(text2, pattern1));
		assertEquals(6, StringMatcher.KMPmatcher(text2, pattern3));
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testException() {
		StringMatcher.naiveMatcher(text1, pattern2);
		StringMatcher.finiteAutomataMatcher(text1, pattern2);
		StringMatcher.KMPmatcher(text2, pattern2);
	}
}
