package workshop.data_structure.string_array.problem;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCompressor {

	public String compress(String compressible) {

		Map<Character, Long> frequency = compressible.chars()
				                                     .mapToObj(c -> (char) c)
				                                     .collect(Collectors.groupingBy(Function.identity()
				                                    		                      , Collectors.counting()
				                                    		                        )
				                                    		 );
		StringBuffer sb = new StringBuffer();
        for (Entry<Character, Long> element : frequency.entrySet()) {
			sb.append(element.getKey()+""+element.getValue());
		}
        return sb.toString();
	}

	public static void main(String[] args) {

		StringCompressor compressor = new StringCompressor();
		System.out.println(compressor.compress("aaabbbb"));
	}
}
