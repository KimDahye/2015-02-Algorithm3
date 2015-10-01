package core;

public class Item {
	public String value;
	public int freq;
	
	public Item(String value, int freq) {
		this.value = value;
		this.freq = freq;
	}

	@Override
	public String toString() {
		return "[value=" + value + ", freq=" + freq + "]";
	}
}
