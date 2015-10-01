package activitySelection;

import java.util.ArrayList;

public class ActivitySelection {
	static int greedy(ArrayList<Activity> activities) {
		int num = activities.size();
		int maxNum, lastInsertedActId;
		
		if(num <= 0 ) return 0;
		maxNum = 1;
		lastInsertedActId = 0;
		for(int id = 1; id < num; id++) {
			if(activities.get(id).start >= activities.get(lastInsertedActId).end) {
				lastInsertedActId = id;
				maxNum++;
			}
		}
		return maxNum;
	}
}
