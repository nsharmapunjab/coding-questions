package sdetinterviewquestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class StringSplitter {

	@SuppressWarnings("rawtypes")
	public HashMap<Enum, String> map = new HashMap<Enum, String>();

	@SuppressWarnings("rawtypes")
	public StringSplitter(Enum separatorChar) {

		map.clear();
		map.put(separatorChar, getSeparator(separatorChar.toString()));
	}

	@SuppressWarnings("rawtypes")
	public StringSplitter(Enum separatorChar, Enum separatorChar2) {

		map.clear();
		map.put(separatorChar, getSeparator(separatorChar.toString()));
		map.put(separatorChar2, getSeparator(separatorChar2.toString()));
	}

	public String getSeparator(String str) {

		if (str.equalsIgnoreCase("FORWARD_SLASH")) {
			return "/";
		} else if (str.equalsIgnoreCase("PERIOD")) {
			return ".";
		}
		return null;
	}

	public static void main(String[] args) {

		// Simple splitter with one parameter
		// This should result in {“tmp”, “file.txt”)
		StringSplitter s1 = new StringSplitter(Separator.FORWARD_SLASH);
		List<String> split1 = s1.split("/tmp/file.txt");
		System.out.println("Output : " + split1);

		// Complex splitter with two parameters
		// This should result in {“tmp”, “file”, “txt”)
		StringSplitter s2 = new StringSplitter(Separator.FORWARD_SLASH,
				Separator.PERIOD);
		List<String> split2 = s2.split("/tmp/file.txt");
		System.out.println("Output : " + split2);
	}

	public enum Separator {
		FORWARD_SLASH, PERIOD;

	}

	@SuppressWarnings("rawtypes")
	public List<String> split(String str) {

		List<String> finalOutput = new ArrayList<String>();
		if (str == null) {
			return null;
		}
		int len = str.length();
		if (len == 0) {
			return null;
		}
		int i = 0;
		List<String> list = new ArrayList<String>();
		for (Entry<Enum, String> entry : map.entrySet()) {
			if (i == 0) {
				extractStringWithSeparator(str, list, entry);
				i++;
			} else {
				for (int j = 0; j < list.size(); j++) {
					str = list.get(j);
					extractStringWithSeparator(str, finalOutput, entry);
				}
				i++;
			}
		}

		if (i == 1) {
			return list;
		}
		return finalOutput;
	}

	@SuppressWarnings("rawtypes")
	private void extractStringWithSeparator(String str,
			List<String> finalOutput, Entry<Enum, String> entry) {
		int temp = 0;
		int fromIndex = 0;
		while (temp >= 0) {
			temp = str.indexOf(entry.getValue(), fromIndex);
			if (temp < 0) {
				finalOutput.add(str.substring(fromIndex, str.length()));
				break;
			} else if (temp == 0) {
				// do nothing
			} else {
				finalOutput.add(str.substring(fromIndex, temp));
			}
			fromIndex = temp + 1;
		}
	}
}
