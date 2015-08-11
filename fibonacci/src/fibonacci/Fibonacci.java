package fibonacci;

public class Fibonacci {
	public static int fibonacciByRecursion (int n) {
		if(n < 0) throw new IllegalArgumentException("n shold be nonnegative");
		if(n < 2) return n;
		return fibonacciByRecursion(n-1) + fibonacciByRecursion(n-2);
	}
	
	public static int fibonacciTopDown (int n, int[] res) {
		if(n < 0) throw new IllegalArgumentException("n shold be nonnegative");
		if(res[n] != -1) return res[n];
		if(n < 2) return n;
		res[n] = fibonacciTopDown(n-1, res) + fibonacciTopDown(n-2, res);
		return res[n];
	}
	
	public static int fibonacciBottomUp (int n) {
		if(n < 0) throw new IllegalArgumentException("n shold be nonnegative");
		if(n < 2) return n;

		int[] fibonacci = new int[n+1];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		for(int i = 2; i < n+1; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
		}
		
		return fibonacci[n];
	}
	
	//topological sort로 구하는 것도 구현해보자.
}
