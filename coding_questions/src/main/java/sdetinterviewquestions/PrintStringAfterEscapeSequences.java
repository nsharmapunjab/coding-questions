package sdetinterviewquestions;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintStringAfterEscapeSequences {

	public static void main(String[] args) {

		String[] str = { "This is sample tests\b \nThis is \bnew line", "This is also a new line" };
		System.out.println("Original Array : " + Arrays.toString(str));
		StringBuilder sb = new StringBuilder();
		ArrayList<String> output = new ArrayList<String>();
		
		for (int j = 0; j < str.length; j++) {
			
			sb.delete(0, sb.length());
			String s = str[j];
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '\b') {
					sb.deleteCharAt(sb.length() - 1);
				} else {
					sb.append(s.charAt(i));
				}
				if (s.charAt(i) == '\n') {
					sb.deleteCharAt(sb.length() - 1);
					output.add(sb.toString());
					sb.delete(0, sb.length());
				}
			}
			output.add(sb.toString());
		}
		
		System.out.println("Output Array : " + output);
	}

}
