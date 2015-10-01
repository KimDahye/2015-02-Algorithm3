package longestSubsequence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestSubsequenceTest {
	String str1 = "abcde";
	String str2 = "bdac";
	String str3 = "ababc";
	
	@Test
	public void testRecursion() {
		assertEquals(LongestSubsequence.recursion(str1, str1.length(), str2, str2.length()), 2);
		assertEquals(LongestSubsequence.recursion(str2, str2.length(), str3, str3.length()), 3);
		assertEquals(LongestSubsequence.recursion(str3, str3.length(), str3, str3.length()), 5);
	}
	
	@Test
	public void testMemoization() {
		assertEquals(LongestSubsequence.memoization(str1, str2), 2);
		assertEquals(LongestSubsequence.memoization(str2, str3), 3);
		assertEquals(LongestSubsequence.memoization(str3, str3), 5);
	}

	@Test
	public void testBottomUp() {
		assertEquals(LongestSubsequence.bottomUp(str1, str2), 2);
		assertEquals(LongestSubsequence.bottomUp(str2, str3), 3);
		assertEquals(LongestSubsequence.bottomUp(str3, str3), 5);
	}
}
