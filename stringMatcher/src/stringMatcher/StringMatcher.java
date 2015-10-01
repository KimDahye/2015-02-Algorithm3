package stringMatcher;

import java.util.HashMap;
import java.util.Map;

public class StringMatcher {

	/* Naive */
	static int naiveMatcher(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		int count = 0;
		if (m < 1)
			throw new IllegalArgumentException("pattern length should be greater than or equal to 1.");
		
		System.out.println("naive text: " + text);
		System.out.println("naive pattern: " + pattern);

		for (int textPos = 0; textPos < n - m + 1; textPos++) {
			if (text.substring(textPos, textPos + m).equals(pattern)) {
				System.out.println("match! pos: " + textPos);
				System.out.println("substring: "
						+ text.substring(textPos, textPos + m));
				count++;
			}
		}
		return count;
	}

	/* Finite Automata */
	static int finiteAutomataMatcher(String text, String pattern){
		int n = text.length();
		int m = pattern.length();
		if (m < 1)
			throw new IllegalArgumentException( "pattern length should be greater than or equal to 1.");
		
		System.out.println("FA text: " + text);
		System.out.println("FA pattern: " + pattern);
		
		//TODO. text에서 alphabet 중복 없애서 집합으로 만들기
		Map<Pair, Integer> transitionFunction = computeTransitionFunction(pattern, text); 
		int q = 0;
		int count = 0;
		
		for(int textPos = 0; textPos < n; textPos++) {
			Pair p = new Pair(q, text.charAt(textPos));
			q = transitionFunction.get(p);
			if(q == m) {
				System.out.println("match! pos: " + (textPos - m + 1));
				System.out.println("substring: " + text.substring(textPos - m + 1, textPos + 1));
				count++;
			}
		}
		return count;	
	}
	
	static Map<Pair, Integer> computeTransitionFunction(String pattern, String alphabetSet) {
		int m = pattern.length();
		int alphabetSize = alphabetSet.length();
		Map<Pair, Integer> transitionFunction = new HashMap<Pair, Integer>();
		
		for (int q = 0; q < m + 1; q++) {
			for(int i = 0; i < alphabetSize; i++) {
				Character c = alphabetSet.charAt(i);
				int k = Math.min(m + 1, q + 2);
				do{
					k--;
				}while(!isSuffix(pattern.substring(0, k), pattern.substring(0, q) + c));
				transitionFunction.put(new Pair(q, c), k);
			}
		}
		
		//transition function 확인 용도
		for(Pair p : transitionFunction.keySet()){
			System.out.println(p + "=>" +transitionFunction.get(p));
		}
		
		return transitionFunction;
	}
		
	static boolean isSuffix(String suff, String text){
		int suffLen = suff.length();
		int texLen = text.length();
		return text.substring(texLen - suffLen, texLen).equals(suff);
	}

	/* KMP */
	static int KMPmatcher(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		int count = 0;

		if (m < 1)
			throw new IllegalArgumentException("pattern length should be greater than or equal to 1.");
		
		System.out.println("KMP text: " + text);
		System.out.println("KMP pattern: " + pattern);

		int[] prefixFunction = computePrefixFunction(pattern);
		/*
		 * q의 의미. 이전 위치까지 봤을 때, prefix 일치하는 것 중 가장 큰 개수. 하지만 index로 쓸 때는 -1 해줘야
		 * 한다. (*) 참고.
		 */
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
				System.out.println("substring: "
						+ text.substring(textPos - m + 1, textPos + 1));
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
		 * q의 의미. 이전 위치까지 봤을 때, prefix 일치하는 것 중 가장 큰 개수. 하지만 index로 쓸 때는 -1 해줘야
		 * 한다. (*) 참고.
		 */
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
