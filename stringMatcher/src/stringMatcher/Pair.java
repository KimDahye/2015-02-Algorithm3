package stringMatcher;

public class Pair {
	int state;
	char alphabet;
	
	Pair(int state, char alphabet){
		this.state = state;
		this.alphabet = alphabet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alphabet;
		result = prime * result + state;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (alphabet != other.alphabet)
			return false;
		if (state != other.state)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pair [state=" + state + ", alphabet=" + alphabet + "]";
	}
}
