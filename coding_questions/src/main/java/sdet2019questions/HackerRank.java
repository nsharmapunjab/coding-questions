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
public class HackerRank {

	public static void main(String[] args) {
		String s = "bcbab";
		List<Integer> startIndex = new ArrayList<Integer>();
		startIndex.add(1);
		startIndex.add(1);
		startIndex.add(2);
		List<Integer> endIndex = new ArrayList<Integer>();
		endIndex.add(4);
		endIndex.add(3);
		endIndex.add(3);
		List<Integer> subs = new ArrayList<Integer>();
		subs.add(3);
		subs.add(3);
		subs.add(0);
		
		System.out.println("Result : " + palindromeChecker(s, startIndex, endIndex, subs));
		
	}

	public static String palindromeChecker(String s, List<Integer> startIndex, List<Integer> endIndex,
			List<Integer> subs) {
		// Write your code here
		System.out.println("s : " + s);
		System.out.println("startIndex : " + startIndex);
		System.out.println("endIndex : " + endIndex);
		System.out.println("subs : " + subs);
		if (startIndex.size() != endIndex.size()) {
			System.out.println("Input is incorrect");
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < startIndex.size(); i++) {
			String subStr = s.substring(startIndex.get(i), endIndex.get(i)+1);
			int pCombinations = subs.get(i);
			if (subStr.length() == 1) {
				sb.append("1");
			} else if (isPalindrome(subStr)) {
				sb.append("1");
			} else if (pCombinations > 0 && (subStr.length() == 2 || subStr.length() == 3)) {
				sb.append("1");
			} else if (pCombinations > 1 && subStr.length() > 3) {
				if (replaceAndCheckPalindrome(pCombinations, subStr)) {
					sb.append("1");
				} else {
					sb.append("0");
				}
			} else {
				sb.append("0");
			}
		}
		System.out.println("sb : " + sb.toString());
		return sb.toString();
	}

	public static boolean replaceAndCheckPalindrome(int patterns, String sToReplace) {

		int mid = sToReplace.length() / 2;
		int left = mid;
		int right = mid;
		while (left >= 0 && right < sToReplace.length() && patterns > 0) {
			patterns--;
			left--;
			right++;
			if (left == 0 && right == sToReplace.length() && patterns >= 0) {
				return true;
			}
		}
		return false;
	}

	public static boolean isPalindrome(String str) {
		int n = str.length();
		for (int i = 0; i < n / 2; i++) {
			if (str.charAt(i) != str.charAt(n - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
