package workshop.data_structure.string_array.problem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UniqueFinderTest {

	@Test
	void test() {
		UniqueFinder u = new UniqueFinder();
		assertTrue(u.hasUnique("unique"));
		assertFalse(u.hasUnique("uniqe"));
	}

}
