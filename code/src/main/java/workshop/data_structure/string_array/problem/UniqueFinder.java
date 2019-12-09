package workshop.data_structure.string_array.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class UniqueFinder {

	public boolean hasUnique(String input) {

		boolean result = true;

		char[] parts = input.toCharArray();
		Map<String, Integer> holder = new HashMap<>();

		// O(N)
		for (char c : parts) {
			String key = String.valueOf(c);
			if (holder.containsKey(key)) {
				int count = holder.get(key);
				count++;
				holder.put(key, count);
			} else {
				holder.put(key, 1);
			}
		}

		Optional<Integer> occuranceGreaterThanOne = holder.values().stream().filter(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t > 1;
			}
		}).findFirst();

		result = result && occuranceGreaterThanOne.isPresent();
		return result;
	}

	private boolean alternativeImplementation(String input) {
		// a string can not contain more than 128 charactres and still claim to be
		// unique
		// seeking to understand first if the string is ASCII or Unicode is better
		// ASCII will require initializing with 128 characters
		// Unicode will require initializing with 256 characters
		if (input.length() > 128)
			return false;

		// the following scheme is exploiting the fact, that character can be stored as
		// integer (respective integer value from ASCII format
		boolean[] char_arry = new boolean[128];
		for (int i = 0; i < input.length(); i++) {
			if (char_arry[input.charAt(i)] == true) {
				return false;
			} else {
				char_arry[input.charAt(i)] = true;
			}
		}

		return true;

	}

}
