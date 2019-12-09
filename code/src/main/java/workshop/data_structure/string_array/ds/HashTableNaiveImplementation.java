package workshop.data_structure.string_array.ds;

import java.util.LinkedList;

public class HashTableNaiveImplementation {

	Object[] container = new Object[100];

	public Value get(Key key) {
		int keyHashCode = key.hashCode();
		int arrayIndex = keyHashCode % container.length;
		LinkedList<Tuple> l = (LinkedList<Tuple>) container[arrayIndex];
		int keyIndex = l.lastIndexOf(key);
		return l.get(keyIndex).getValue();
	}

	public void put(Key key, Value value) {
		int keyHashCode = key.hashCode();
		int position = keyHashCode % container.length;

		if (container[position] == null) {
			LinkedList<Tuple> l = new LinkedList<>();
			l.add(new Tuple(key, value));
		} else {
			LinkedList<Tuple> l = (LinkedList<Tuple>) container[position];
			l.add(new Tuple(key, value));
		}
	}

	public static void main(String[] args) {
		
		HashTableNaiveImplementation h = new HashTableNaiveImplementation();
		h.put(new Key("first"), new Value("Hello"));
		h.get(new Key("first"));

	}

}
