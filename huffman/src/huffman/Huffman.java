package huffman;

import java.util.PriorityQueue;

import core.Item;
import core.Node;

public class Huffman {
	static Node huffmanTree(PriorityQueue<Node> queue) {
		while(queue.size() > 1) {
			Node m1 = queue.remove();
			Node m2 = queue.remove();
			Node newNode = new Node(null, m1, m2, new Item(null,  m1.item.freq + m2.item.freq));
			m1.parent = newNode;
			m2.parent = newNode;
			queue.add(newNode);
		}
		return queue.remove();
	}
}
