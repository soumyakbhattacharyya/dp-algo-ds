package workshop.data_structure.string_array.problem;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PermutationFinderTest {

	@Test
	void test() {
		PermutationFinder finder = new PermutationFinder();
		assertTrue(finder.find("AABCD", "BAACD"));
		assertFalse(finder.find("AABCE", "BAACD"));
	}

}
