package core;

import java.util.Comparator;

public class NodeFrequencyComparator implements Comparator<Node> {
	@Override
	public int compare(Node x, Node y) {
		if (x.item.freq < y.item.freq)
			return -1;
		if (x.item.freq > y.item.freq)
			return 1;
		return 0;
	}
}
