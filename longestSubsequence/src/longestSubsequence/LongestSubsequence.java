package longestSubsequence;

public class LongestSubsequence {
	/* recursion */
	static int recursion(String str1, int str1SubLength, String str2, int str2SubLength) {
		if(str1SubLength == 0 || str2SubLength == 0) return 0;
		if(str1.charAt(str1SubLength-1) == str2.charAt(str2SubLength - 1)) 
			return recursion(str1, str1SubLength-1, str2, str2SubLength-1) + 1;
		return Math.max(recursion(str1, str1SubLength-1, str2, str2SubLength), recursion(str1, str1SubLength, str2, str2SubLength-1));
	}
	
	/* memoization */
	static int memoization(String str1, String str2) {
		int size1 = str1.length();
		int size2 = str2.length();
		int[][] result = new int[size1+1][size2+1];
		
		for(int i = 0; i <= size1; i++ ) {
			for(int j =0; j<= size2; j++) {
				result[i][j] = -1;
			}
		}
		
		return memoizationAug(str1, size1, str2, size2, result);
	}
	
	static int memoizationAug(String str1, int str1SubLength, String str2, int str2SubLength, int[][] memo){
		if(memo[str1SubLength][str2SubLength] != -1) return memo[str1SubLength][str2SubLength];
		if(str1SubLength == 0 || str2SubLength == 0) {
			 memo[str1SubLength][str2SubLength] = 0;
			return 0;
		}
		
		int lcsLength = 0;
		if(str1.charAt(str1SubLength-1) == str2.charAt(str2SubLength - 1)) 
			lcsLength = recursion(str1, str1SubLength-1, str2, str2SubLength-1) + 1;
		else
			lcsLength = Math.max(recursion(str1, str1SubLength-1, str2, str2SubLength), recursion(str1, str1SubLength, str2, str2SubLength-1));
		
		memo[str1SubLength][str2SubLength] = lcsLength;
		return lcsLength;		
	}
	
	
	/* bottom up */
	static int bottomUp(String str1, String str2) {
		int size1 = str1.length();
		int size2 = str2.length();
		int[][] result = new int[size1+1][size2+1];
		
		//result 초기화
		for(int i = 0; i <= size1; i++){
			result[i][0] = 0; //str2가 공집합일 때
		}
		for(int j = 0; j <= size2; j++) {
			result[0][j] = 0; //str1이 공집합일 때
		}
		
		for(int i = 1; i <= size1; i++ ) {
			for(int j =1; j<= size2; j++) {
				char cur1 = str1.charAt(i-1);
				char cur2 = str2.charAt(j-1);
				if(cur1 == cur2) {
					result[i][j] = result[i-1][j-1] + 1;
				}
				else {
					result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
				}
			}
		}
		
		return result[size1][size2];
	}
}
