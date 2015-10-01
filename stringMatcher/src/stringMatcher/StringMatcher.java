package stringMatcher;

public class StringMatcher {
	
	static int naiveMatcher(String text, String pattern) {
		System.out.println("naive text: " + text);
		System.out.println("naive pattern: " + pattern);
		
		int n = text.length();
		int m = pattern.length();
		int count = 0;
		if (m < 1)
			throw new IllegalArgumentException("pattern length should be greater than or equal to 1.");

		for (int textPos = 0; textPos < n - m + 1; textPos++) {
			if(text.substring(textPos, textPos + m).equals(pattern)){
				System.out.println("match! pos: " + textPos);
				System.out.println("substring: " + text.substring(textPos, textPos + m));
				count++;
			}
		}
		return count;
	}

	static int KMPmatcher(String text, String pattern) {
		System.out.println("KMP text: " + text);
		System.out.println("KMP pattern: " + pattern);

		int n = text.length();
		int m = pattern.length();
		int count = 0;
		
		if (m < 1)
			throw new IllegalArgumentException("pattern length should be greater than or equal to 1.");

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
				count++;
			}
		}
		return count;
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
