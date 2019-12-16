package workshop.data_structure.string_array.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PermutationFinder {

	/*
	 * given two strings find if one is permutation of the other
	 */
	public boolean find(String one, String another) {

		if (one == null)
			return false;
		if (one.isEmpty())
			return false;
		if (another == null)
			return false;
		if (another.isEmpty())
			return false;
		if (one.length() != another.length())
			return false;

		char[] oneCharacterArray = one.toCharArray();
		char[] anotherCharacterArray = another.toCharArray();

		class CombinedCount {
			private int oneCount;
			private int anotherCount;

			public CombinedCount(int oneCount, int anotherCount) {
				super();
				this.oneCount = oneCount;
				this.anotherCount = anotherCount;
			}

			public int getOneCount() {
				return oneCount;
			}

			public void setOneCount(int oneCount) {
				this.oneCount = oneCount;
			}

			public int getAnotherCount() {
				return anotherCount;
			}

			public void setAnotherCount(int anotherCount) {
				this.anotherCount = anotherCount;
			}

		}

		Map<Character, CombinedCount> result = new HashMap<>();

		for (int i = 0; i < oneCharacterArray.length; i++) {
			Character char_ = oneCharacterArray[i];
			if (result.get(char_) != null) {
				int existingCount = result.get(char_).getOneCount();
				result.get(char_).setOneCount(++existingCount);
			} else {
				result.put(char_, new CombinedCount(1, 0));
			}
		}

		for (int i = 0; i < anotherCharacterArray.length; i++) {
			Character char_ = anotherCharacterArray[i];
			if (result.get(char_) != null) {
				int existingCount = result.get(char_).getAnotherCount();
				result.get(char_).setAnotherCount(++existingCount);
			} else {
				result.put(char_, new CombinedCount(0, 1));
			}
		}

		for (Entry<Character, CombinedCount> entry : result.entrySet()) {
			if (entry.getValue().getAnotherCount() != entry.getValue().getOneCount()) {
				return false;
			}
		}

		return true;

	}

	public static void main(String[] args) {
		PermutationFinder p = new PermutationFinder();
		p.find("AABC", "ABCB");
	}

}
