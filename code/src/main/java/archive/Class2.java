package archive;

import java.util.Iterator;

public class Class2 {

	/**
	 * problem
	 * 
	 * 1.2 given two strings find if one is permutation of other
	 */
	private static boolean isPermutation(String first, String second) {

		boolean permutation = true;

		if (first.length() != second.length())
			return !permutation;

		/*
		 * strategy
		 * 
		 * find characters of first string find characters of second string
		 */
		char[] firstCharArray = first.toCharArray();
		char[] secondCharArray = second.toCharArray();

		int[] i1 = new int[256];
		int[] i2 = new int[256];

		for (char c1 : firstCharArray) {
			i1[c1] = c1;
		}

		for (char c2 : secondCharArray) {
			if (i1[c2] == 0) {
				permutation = false;
				return permutation;
			}
		}
		return permutation;

	}

	public static void main(String[] args) {

		System.out.println(isPermutation("asasasAS", "asaCasAS"));

	}
}
