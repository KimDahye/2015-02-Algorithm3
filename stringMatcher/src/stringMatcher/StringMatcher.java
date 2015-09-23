package stringMatcher;

public class StringMatcher {
	public static void main(String[] args) {
		String text1 = "ababc";
		String text2 = "ababbacababcabc";

		String pattern1 = "ababc";
		String pattern2 = "";
		String pattern3 = "a";
		
		KMPmatcher(text1, pattern1);
		System.out.println("h");
		KMPmatcher(text2, pattern1);
		KMPmatcher(text2, pattern2);
		KMPmatcher(text2, pattern3);
	}
	
	static void KMPmatcher(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		if(m <= 0) 
			return;
		
		int[] prefixFunction = computePrefixFunction(pattern);
		int q = 0; // // maxPrefixFunctionValueUntilPreviousPos
		for (int textPos = 0; textPos < n; textPos++) {
			while (q > 0 && text.charAt(textPos) != pattern.charAt(q)) {
				q = prefixFunction[q - 1];
			}
			if (text.charAt(textPos) == pattern.charAt(q)) {
				q++;
			}
			if (q == m) {
				System.out.println("match! pos: " + (textPos - m + 1));
				System.out.println("substring: " + text.substring(textPos - m + 1, textPos + 1));
				q = prefixFunction[q-1];
			}
		}
	}

	static int[] computePrefixFunction(String pattern) {
		int m = pattern.length();
		int[] result = new int[m];
		result[0] = 0; // trivial
		int q = 0; // maxPrefixFunctionValueUntilPreviousPos
		for (int pos = 1; pos < m; pos++) {
			while (q > 0 && pattern.charAt(pos) != pattern.charAt(q)) {
				q = result[q - 1];
			}
			if (pattern.charAt(pos) == pattern.charAt(q)) {
				q++;
			}
			result[pos] = q;
			System.out.println(q);
		}
		System.out.println("compute completed");
		return result;
	}
}
