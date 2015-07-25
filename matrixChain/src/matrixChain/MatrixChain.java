/*
 * HW.C3 Matrix-chain 곱셈 비용 구하는 알고리즘 구현
 * recursive, memoization, bottomup 으로.
 * */

package matrixChain;

import java.util.ArrayList;

public class MatrixChain {
	
	public static int matrixChainRecursive(ArrayList<Matrix> matrixArr, int start, int end) {
		if (matrixArr == null || start > end) throw new IllegalArgumentException();
		if (start == end) return 0;

		int minCost, cost;
		minCost = Integer.MAX_VALUE;

		for (int endIdxOfFirstSeq = start; endIdxOfFirstSeq < end; endIdxOfFirstSeq++) {
			cost = matrixChainRecursive(matrixArr, start, endIdxOfFirstSeq)
					+ matrixChainRecursive(matrixArr, endIdxOfFirstSeq + 1, end)
					+ matrixArr.get(start).row * matrixArr.get(endIdxOfFirstSeq).col * matrixArr.get(end).col;

			if (minCost > cost)
				minCost = cost;
		}
		return minCost;
	}
	
	public static int matrixChainMemoization(ArrayList<Matrix> matrixArr) {
		if (matrixArr == null) throw new IllegalArgumentException();

		int size = matrixArr.size();
		int[][] memo = new int[size][size];
		initializeMemoTable(memo, size);
		return matrixChainMemoizationAug(matrixArr, 0, size-1, memo);
	}
	
	private static int matrixChainMemoizationAug(ArrayList<Matrix> matrixArr,	int start, int end, int[][] memo) {
		if (matrixArr == null || start > end || memo == null) throw new IllegalArgumentException();
		if (memo[start][end] != -1) return memo[start][end];
		if (start == end) {
			memo[start][end] = 0;
			return 0;
		}
		
		int minCost, cost;
		minCost = Integer.MAX_VALUE;

		for (int endIdxOfFirstSeq = start; endIdxOfFirstSeq < end; endIdxOfFirstSeq++) {
			cost = matrixChainRecursive(matrixArr, start, endIdxOfFirstSeq)
					+ matrixChainRecursive(matrixArr, endIdxOfFirstSeq + 1, end)
					+ matrixArr.get(start).row * matrixArr.get(endIdxOfFirstSeq).col * matrixArr.get(end).col;

			if (minCost > cost)
				minCost = cost;
		}
		memo[start][end] = minCost;
		return minCost;
	}
	
	public static int matrixChainBottomUp(ArrayList<Matrix> matrixArr) {
		if (matrixArr == null) throw new IllegalArgumentException();

		int size = matrixArr.size();
		int[][] memo = new int[size][size];
		initializeMemoTable(memo, size);

		// bottomup logic
		for (int d = 0; d < size; d++) {
			for (int i = 0; i < size - d; i++) {
				memo[i][i + d] = matrixChainBottomUpAug(matrixArr, i, i + d, memo);
			}
		}

		return memo[0][size-1];
	}

	private static int matrixChainBottomUpAug(ArrayList<Matrix> matrixArr, int start, int end, int[][] memo) {
		if (matrixArr == null || start > end || memo == null) throw new IllegalArgumentException();

		if(start == end) return 0 ;
		int min = Integer.MAX_VALUE;
		int current;
		for(int i = start; i < end; i++) {
			current = memo[start][i] + memo[i+1][end] + matrixArr.get(start).row * matrixArr.get(i).col * matrixArr.get(end).col;
			if(min > current) min = current;
		}
		return min;
	}
	
	private static void initializeMemoTable(int[][] memo, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				memo[i][j] = -1;
			}
		}
	}
}
