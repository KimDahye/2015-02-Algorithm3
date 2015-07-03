package rodCutting;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class RodCunttingTest {
	ArrayList<Price> prices = new ArrayList<Price>();

	@Before
	public void setup() {
		Price p0 = new Price(0);
		Price p1 = new Price(1);
		Price p2 = new Price(5);		
		Price p3 = new Price(8);
		Price p4 = new Price(9);
		Price p5 = new Price(10);
		Price p6 = new Price(17);
		Price p7 = new Price(17);
		Price p8 = new Price(20);
		Price p9 = new Price(24);
		Price p10 = new Price(30);
		
		prices.add(0, p0);
		prices.add(1, p1);
		prices.add(2, p2);
		prices.add(3, p3);
		prices.add(4, p4);
		prices.add(5, p5);
		prices.add(6, p6);
		prices.add(7, p7);
		prices.add(8, p8);
		prices.add(9, p9);
		prices.add(10, p10);
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

}
