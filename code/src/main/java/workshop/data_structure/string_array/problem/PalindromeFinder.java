package workshop.data_structure.string_array.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Predicate;

public class PalindromeFinder {

	/*
	 * finds if a string is palindrome or not
	 */
	public boolean find(String subject) {
		char[] characters = subject.toCharArray();
		boolean hasEvenNumberOfChacacters = characters.length % 2 == 0 ? true : false;
		boolean hasOddNumberOfCharacters = !hasEvenNumberOfChacacters;

		if (hasEvenNumberOfChacacters) {
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (char c : characters) {
				map.merge(c, 1, Integer::sum);
			}

			boolean isPalindrome = !(map.values().stream().anyMatch(new Predicate<Integer>() {

				@Override
				public boolean test(Integer t) {
					return t != 2;
				}
			}));

			return isPalindrome;
		} else {

			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (char c : characters) {
				map.merge(c, 1, Integer::sum);
			}

			Optional<Entry<Character, Integer>> characterAppearingOnceOptional = map.entrySet().stream()
					.filter(new Predicate<Entry<Character, Integer>>() {

						@Override
						public boolean test(Entry<Character, Integer> t) {
							return t.getValue() == 1;
						}
					}).findFirst();

			if (characterAppearingOnceOptional.isPresent()) {
				Character characterAppearingOnce = characterAppearingOnceOptional.get().getKey();
				map.remove(characterAppearingOnce);
			}

			boolean isPalindrome = !(map.values().stream().anyMatch(new Predicate<Integer>() {

				@Override
				public boolean test(Integer t) {
					return t != 2;
				}
			}));

			return isPalindrome;

		}

	}

	public static void main(String[] args) {
		PalindromeFinder finder = new PalindromeFinder();
		System.out.println(finder.find("AAKNNK"));
		System.out.println(finder.find("AAKNNKPQ"));		
	}

}
