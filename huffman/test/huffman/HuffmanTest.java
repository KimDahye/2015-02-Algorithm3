package huffman;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Before;
import org.junit.Test;

import core.Item;
import core.Node;
import core.NodeFrequencyComparator;

public class HuffmanTest {
	PriorityQueue<Node> queue;
	
	@Before
	public void setUp() {
		// priorityQueueTest
		Comparator<Node> comparator = new NodeFrequencyComparator();
		queue = new PriorityQueue<Node>(10, comparator);
		queue.add(new Node(new Item("a", 45)));
		queue.add(new Node(new Item("b", 13)));
		queue.add(new Node(new Item("c", 12)));
		queue.add(new Node(new Item("d", 16)));
		queue.add(new Node(new Item("e", 9)));
		queue.add(new Node(new Item("f", 5)));
	}
	
	@Test
	public void huffmanTest() {
		Node root = Huffman.huffmanTree(queue);
		root.print(0);
	}
}
