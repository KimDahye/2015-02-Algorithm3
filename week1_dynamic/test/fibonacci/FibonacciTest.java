package fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void testRecursion() {
		assertEquals(Fibonacci.fibonacciByRecursion(6), 8);
	}

	@Test
	public void testTopDown() {
		int n = 6;
		int fib_n = 8;
		int[] arr = new int[n + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		assertEquals(Fibonacci.fibonacciTopDown(n, arr), fib_n);
	}

	@Test
	public void testBottomUp() {
		assertEquals(Fibonacci.fibonacciBottomUp(6), 8);
	}

}
