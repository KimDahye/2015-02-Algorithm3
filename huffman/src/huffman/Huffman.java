package huffman;

import core.Item;
import core.Node;

public class Huffman {
	Node huffmanTree(Item[] items) {
		Heap h = buildMinHeap(items);
		while(h.size > 1) {
			Node m1 = h.extractMin();
			Node m2 = h.extractMin();
			Node newNode = new Node(null,m1, m2, new Item(null,  m1.item.freq + m2.item.freq));
			m1.parent = newNode;
			m2.parent = newNode;
			h.insert(newNode);
		}
		return h.extractMin();
	}
}
