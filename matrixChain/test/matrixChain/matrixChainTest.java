package matrixChain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class matrixChainTest {
	ArrayList<Matrix> matrixArr = new ArrayList<Matrix>();
	
	@Before
	public void setup() {
		Matrix matrix0 = new Matrix(3, 4);
		Matrix matrix1 = new Matrix(4, 5);
		Matrix matrix2 = new Matrix(5, 2);
		
		matrixArr.add(0, matrix0);
		matrixArr.add(1, matrix1);
		matrixArr.add(2, matrix2);
	}
	
	@Test
	public void testRecursive() {
		 int minCost = MatrixChain.matrixChainRecursive(matrixArr, 0, matrixArr.size() -1);
		 assertEquals(minCost, 64);
	}
	
	@Test
	public void testMemoization() {
		 int minCost = MatrixChain.matrixChainMemoization(matrixArr);
		 assertEquals(minCost, 64);
	}
	
	@Test
	public void testBottomUp() {
		 int minCost = MatrixChain.matrixChainBottomUp(matrixArr);
		 assertEquals(minCost, 64);
	}
}
