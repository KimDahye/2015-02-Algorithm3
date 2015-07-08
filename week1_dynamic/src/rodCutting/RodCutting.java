package rodCutting;


public class RodCutting {
	public static int rodCutting (int n, int[] prices) {
		if(n < 0) new IllegalArgumentException("n shold be nonnegative");
		if(n < 2) return prices[n]; //더이상 잘라질 수 없는 것 recursion의 base step
		
		int maxIdx = 0;
		int[] maxArray = new int[n+1];
		maxArray[0] = prices[n];
		for(int i = 1; i<=n; i++) {
			maxArray[i] = prices[i] + rodCutting(n-i, prices);
			if(maxArray[maxIdx] < maxArray[i]) maxIdx = i;
		}
		
		return maxArray[maxIdx];
	}
	
	public static int rodCuttingTopDown(int n, int[] prices) {
		int[] rod = new int[n+1];
		for(int i = 0; i < rod.length; i++) {
			 rod[i] = -1;
		}
		return rodCuttingTopDownAux(n, prices, rod);
	}
	
	private static int rodCuttingTopDownAux (int n, int[] prices, int[] rod) {
		if(n < 0) new IllegalArgumentException("n shold be nonnegative");
		
		if(rod[n] >= 0) return rod[n]; //memoization

		if(n < 2) {
			rod[n] = prices[n]; //memo
		}
		
		int maxIdx = 0;
		int[] maxArray = new int[n+1];
		maxArray[0] = prices[n];
		for(int i = 1; i<=n; i++) {
			maxArray[i] = prices[i] + rodCuttingTopDownAux(n-i, prices, rod);
			if(maxArray[maxIdx] < maxArray[i]) maxIdx = i;
		}
		
		rod[n] = maxArray[maxIdx]; //memo
		return rod[n];
	}
	
	public static int rodCuttingBottomUp(int n, int[] prices) {
		if(n < 0) new IllegalArgumentException("n shold be nonnegative");
		int [] rod = new int[n+1];
		rod[0] = prices[0];
		rod[1] = prices[1];
		
		for(int i = 2; i <= n; i++) {
			rod[i] = prices[i];
			for(int j = 1; j <= i/2; j++) {
				if(rod[i] < prices[j] + rod[i-j]) {
					rod[i] = prices[j] + rod[i-j]; // rod[j] + rod[i-j]로 대체할 수 있
				}
			}
		}
		return rod[n];
	}
}
