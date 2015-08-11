package rodCutting;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RodCunttingTest {
	int[] prices = new int[11];

	@Before
	public void setup() {
		int p0 = 0;
		int p1 = 1;
		int p2 = 5;		
		int p3 = 8;
		int p4 = 9;
		int p5 = 10;
		int p6 = 17;
		int p7 = 17;
		int p8 = 20;
		int p9 = 24;
		int p10 = 30;
		
		prices[0] = p0;
		prices[1] = p1;
		prices[2] = p2;
		prices[3] = p3;
		prices[4] = p4;
		prices[5] = p5;
		prices[6] = p6;
		prices[7] = p7;
		prices[8] = p8;
		prices[9] = p9;
		prices[10] = p10;
	}
	
	@Test
	public void testRecursion() {		
		assertEquals(RodCutting.rodCutting(4, prices), 10);
		assertEquals(RodCutting.rodCutting(5, prices), 13);
	}
	
	@Test
	public void testTopDown() {
		assertEquals(RodCutting.rodCuttingTopDown(4, prices), 10);
		assertEquals(RodCutting.rodCuttingTopDown(5, prices), 13);
	}
	
	@Test
	public void testBottomUp() {
		assertEquals(RodCutting.rodCuttingBottomUp(4, prices), 10);
		assertEquals(RodCutting.rodCuttingBottomUp(5, prices), 13);
	}
	
	@Test
	public void testBottomUpWithFullSolution() {
		System.out.print("rod length 4: ");
		assertEquals(RodCutting.rodCuttingSolution(4, prices), 10);
		System.out.print("\nrod length 5: ");
		assertEquals(RodCutting.rodCuttingSolution(5, prices), 13);
	}
}
