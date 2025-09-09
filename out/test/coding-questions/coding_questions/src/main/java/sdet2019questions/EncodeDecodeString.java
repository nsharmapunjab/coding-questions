/**
 * 
 */
package sdet2019questions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nitin Sharma
 *
 */
public class EncodeDecodeString {

	// Encode and Decode an Array of strings

	public static String serialize(List<String> strs) {
		StringBuilder ret = new StringBuilder();
		for (String str : strs) {
			int size = str.length();
			ret.append(size);
			ret.append('-');
			ret.append(str);
		}
		return ret.toString();
	}

	public static List<String> deserialize(String str) {

		List<String> strs = new ArrayList<String>();
		int len = str.length(), i = 0;
		while (i < len) {
			int start = i;
			while (str.charAt(i) != '-')
				i++;
			int size = Integer.parseInt(str.substring(start, i));
			i += 1 + size;
			if (size > 0)
				strs.add(str.substring(i - size, i));
			else
				strs.add("");
		}

		return strs;
	}

	public static void main(String[] args) {

		List<String> str = new ArrayList<String>();
		str.add("abc");
		str.add("def");
		str.add("ghi");

		String encodedString = serialize(str);
		System.out.println("Encode Array String : " + encodedString);
		System.out.println("Decoded String Array : " + deserialize(encodedString));
	}
}
