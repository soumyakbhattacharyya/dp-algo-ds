package archive;

import java.util.HashMap;
import java.util.Map;

public class Class1 {

	/**
	 * problem
	 * 
	 * 1.1 given a string find if it has all unique character
	 */

	private static boolean isUnique(String subject) {
		if (null == subject)
			return false;
		char[] holder = subject.toCharArray();
		Map<Character, Integer> store = new HashMap<>();
		for (char c : holder) {
			store.put(c, store.getOrDefault(c, 0) + 1);
			if (store.get(c) > 1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
		System.out.println(isUnique("svfqyao"));

	}

}
