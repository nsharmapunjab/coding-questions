package arraylist;

import java.util.HashMap;

public class WordFrequencyInBook {

	public static void main(String[] args) {

	}

	public static int getFrequencyOfWord(HashMap<String, Integer> map,
			String word) {

		if (map == null || word == null) {
			return -1;
		}
		word = word.toLowerCase();
		if (map.containsKey(word)) {
			return map.get(word);
		}

		return 0;
	}

	public static HashMap<String, Integer> setUpDictionary(String[] book) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word : book) {
			word = word.toLowerCase();
			if (word.trim() != "") {
				if (map.containsKey(word)) {
					map.put(word, 0);
				} else {
					map.put(word, map.get(word) + 1);
				}
			}
		}

		return map;
	}

}
