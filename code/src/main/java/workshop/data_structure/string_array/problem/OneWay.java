package workshop.data_structure.string_array.problem;

import java.util.Arrays;

public class OneWay {

	public static void main(String[] args) {
		OneWay oneWay = new OneWay();
		System.out.println(oneWay.findIfOneEditAway("palb", "palbc"));
	}

	private boolean findIfOneEditAway(String first, String second) {
		

		// if two string's length differs by more than 1, they are not
		int lengthOfFirstArray = first.length();
		int lengthOfSecondArray = second.length();
		if (Math.abs(lengthOfFirstArray - lengthOfSecondArray) > 1) {
			return false;
		}

		// Arrays.sort(first.toCharArray());
		// Arrays.sort(second.toCharArray());

		/* find shorter and longer string */
		String longer = lengthOfFirstArray > lengthOfSecondArray ? first : second;
		String shorter = lengthOfSecondArray < lengthOfFirstArray ? second : first;

		int anomaly = 0;
		int lastIndex = 0;

		for (int i = 0; i < shorter.length(); i++) {
			if (longer.charAt(i) == shorter.charAt(i)) {
				// do nothing;
			} else {
				anomaly++;
			}

			lastIndex = i;

		}

		if ((longer.length() - (lastIndex + 1)) == 1) {
			// at this point we know that there is one insertion
			if (anomaly == 0) {
				return true; // at this point, the solution has identified that there is one change
			} else {
				return false;
			}
		} else if ((longer.length() - (lastIndex + 1)) == 0) {
			if (anomaly == 1) {
				return true; // at this point, the solution has identified that there is one change
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
