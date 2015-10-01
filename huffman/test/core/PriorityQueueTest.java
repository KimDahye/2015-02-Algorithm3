package core;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

import core.Item;
import core.Node;
import core.NodeFrequencyComparator;

public class PriorityQueueTest {

	@Test
	public void test() {
		// priorityQueueTest
		Comparator<Node> comparator = new NodeFrequencyComparator();
		PriorityQueue<Node> queue = new PriorityQueue<Node>(10, comparator);
		queue.add(new Node(new Item("a", 45)));
		queue.add(new Node(new Item("b", 13)));
		queue.add(new Node(new Item("c", 12)));
		queue.add(new Node(new Item("d", 16)));
		queue.add(new Node(new Item("e", 9)));
		queue.add(new Node(new Item("f", 5)));

		while (queue.size() != 0) {
			System.out.println(queue.remove()); //extractMin 과 같은 역할을 한다.
		}
	}
}
