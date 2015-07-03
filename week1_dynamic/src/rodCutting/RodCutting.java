package rodCutting;

import java.util.ArrayList;

public class RodCutting {
	public static int rodCutting (int n, ArrayList<Price> prices) {
		if(n < 0) new IllegalArgumentException("n shold be nonnegative");
		if(n < 2) return prices.get(n).price; //더이상 잘라질 수 없는 것 recursion의 base step
		
		int maxIdx = 0;
		int[] maxArray = new int[n+1];
		maxArray[0] = prices.get(n).price;
		for(int i = 1; i<=n; i++) {
			maxArray[i] = prices.get(i).price + rodCutting(n-i, prices);
			if(maxArray[maxIdx] < maxArray[i]) maxIdx = i;
		}
		
		prices.get(maxIdx).cutted = true;
		return maxArray[maxIdx];
	}
	
	public static int rodCuttingTopDown(int n, ArrayList<Price> prices) {
		int[] rod = new int[n+1];
		for(int i = 0; i < rod.length; i++) {
			 rod[i] = -1;
		}
		return rodCuttingTopDownAux(n, prices, rod);
	}
	
	private static int rodCuttingTopDownAux (int n, ArrayList<Price> prices, int[] rod) {
		if(n < 0) new IllegalArgumentException("n shold be nonnegative");
		
		if(rod[n] >= 0) return rod[n]; //memoization

		if(n < 2) {
			rod[n] = prices.get(n).price; //memo
		}
		
		int maxIdx = 0;
		int[] maxArray = new int[n+1];
		maxArray[0] = prices.get(n).price;
		for(int i = 1; i<=n; i++) {
			maxArray[i] = prices.get(i).price + rodCuttingTopDownAux(n-i, prices, rod);
			if(maxArray[maxIdx] < maxArray[i]) maxIdx = i;
		}
		
		prices.get(maxIdx).cutted = true;
		rod[n] = maxArray[maxIdx]; //memo
		return rod[n];
	}
}
