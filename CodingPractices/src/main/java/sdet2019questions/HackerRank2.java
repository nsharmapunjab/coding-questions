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
public class HackerRank2 {

	public static void main(String[] args) {

		List<Integer> leaves = new ArrayList<Integer>();
		leaves.add(10);
		leaves.add(20);
		leaves.add(30);
		leaves.add(20);
		leaves.add(10);
		int percentage = 30;
		List<Integer> day = new ArrayList<Integer>();
		day.add(1);
		day.add(1);
		day.add(2);
		List<Integer> starting = new ArrayList<Integer>();
		starting.add(2);
		starting.add(1);
		starting.add(1);
		List<Integer> ending = new ArrayList<Integer>();
		ending.add(4);
		ending.add(3);
		ending.add(4);

		System.out.println("Result : " + autumnLeaves(leaves, percentage, day, starting, ending));

		System.out.println(200 % 100);
	}

	public static List<Long> autumnLeaves(List<Integer> leaves, int percentage, List<Integer> day,
			List<Integer> starting, List<Integer> ending) {
		// Write your code here

		if (starting.size() != ending.size()) {
			return null;
		}

		List<Long> finalOutput = new ArrayList<Long>();
		List<Integer> temp = new ArrayList<Integer>();
		Integer finalValue = 0;
		Integer dayValue = 0;
		for (int i = 0; i < starting.size(); i++) {
			finalValue = 0;
			dayValue = 0;
			temp = new ArrayList<Integer>();
			dayValue = day.get(i);
			for (int j = 0; j < leaves.size(); j++) {
				temp.add(j, leaves.get(j) - getValue(leaves.get(j), percentage, dayValue));
			}
			for (int k = starting.get(i) - 1; k < ending.get(i); k++) {
				finalValue += leaves.get(k) - temp.get(k);
			}
			finalOutput.add(finalValue.longValue());
		}

		System.out.println("Output : " + finalOutput);
		return finalOutput;
	}

	public static Integer getValue(Integer leaveValue, int percentage, Integer dayValue) {
		if (dayValue == 0) {
			return leaveValue;
		}
		Integer value = 0;
		while (dayValue > 0) {
			if ((leaveValue * percentage % 100) > 0) {
				value = (leaveValue * percentage / 100) + 1;
			}
			else {
				value = leaveValue * percentage / 100;
			}
			dayValue--;
			leaveValue = leaveValue - value;
		}

		return value;
	}

}
