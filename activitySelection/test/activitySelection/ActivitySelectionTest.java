package activitySelection;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ActivitySelectionTest {
	ArrayList<Activity> activities = new ArrayList<Activity>(); 

	@Before
	public void setup() {
		activities.add(new Activity(1, 4));
		activities.add(new Activity(3, 5));
		activities.add(new Activity(0, 6));
		activities.add(new Activity(5, 7));
		activities.add(new Activity(3, 9));
		activities.add(new Activity(5, 9));
		activities.add(new Activity(6, 10));
	}
	
	@Test
	public void test() {
		assertEquals(ActivitySelection.greedy(activities), 2);
	}

}
