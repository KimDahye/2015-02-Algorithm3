package stringMatcher;

public class StringMatcher {
	public static void main(String[] args) {
		String text1 = "ababc";
		String text2 = "ababbacababcabc";

		String pattern1 = "ababc";
		String pattern2 = "";
		String pattern3 = "a";

		KMPmatcher(text1, pattern1);
		KMPmatcher(text2, pattern1);
		KMPmatcher(text2, pattern2);
		KMPmatcher(text2, pattern3);
		
		naiveMatcher(text1, pattern1);
		naiveMatcher(text2, pattern1);
		naiveMatcher(text2, pattern2);
		naiveMatcher(text2, pattern3);
	}

	static void naiveMatcher(String text, String pattern) {
		System.out.println("naive text: " + text);
		System.out.println("naive pattern: " + pattern);
		
		int n = text.length();
		int m = pattern.length();
		
		if (m <= 0)
			return;

		for (int textPos = 0; textPos < n - m + 1; textPos++) {
			if(text.substring(textPos, textPos + m).equals(pattern)){
				System.out.println("match! pos: " + textPos);
				System.out.println("substring: " + text.substring(textPos, textPos + m));
			}
		}
	}

	static void KMPmatcher(String text, String pattern) {
		System.out.println("KMP text: " + text);
		System.out.println("KMP pattern: " + pattern);

		int n = text.length();
		int m = pattern.length();
		if (m <= 0)
			return;

		int[] prefixFunction = computePrefixFunction(pattern);
		/*
		 * q의 의미.
		 * 이전 위치까지 봤을 때, prefix 일치하는 것 중 가장 큰 개수. 
		 * 하지만 index로 쓸 때는 -1 해줘야 한다. (*) 참고.
		 * */
		int q = 0; 
		for (int textPos = 0; textPos < n; textPos++) {
			while (q > 0 && text.charAt(textPos) != pattern.charAt(q)) {
				q = prefixFunction[q - 1]; // (*)이렇게.
			}
			if (text.charAt(textPos) == pattern.charAt(q)) {
				q++;
			}
			if (q == m) {
				q = prefixFunction[q - 1];
				System.out.println("match! pos: " + (textPos - m + 1));
				System.out.println("substring: " + text.substring(textPos - m + 1, textPos + 1));
			}
		}
	}

	static int[] computePrefixFunction(String pattern) {
		int m = pattern.length();
		int[] result = new int[m];
		result[0] = 0; // trivial
		/*
		 * q의 의미.
		 * 이전 위치까지 봤을 때, prefix 일치하는 것 중 가장 큰 개수. 
		 * 하지만 index로 쓸 때는 -1 해줘야 한다. (*) 참고.
		 * */
		int q = 0; 
		for (int pos = 1; pos < m; pos++) {
			while (q > 0 && pattern.charAt(pos) != pattern.charAt(q)) {
				q = result[q - 1];
			}
			if (pattern.charAt(pos) == pattern.charAt(q)) {
				q++;
			}
			result[pos] = q;
		}
		return result;
	}
}
