package sortingandsearching;

public class FindStringIndexInSortedArray {

	public static void main(String[] args) {

		String[] strings = { "at", "", "", "", "ball", "", "", "car", "", "",
				"dad", "", "" };

		System.out.println("Index of string : "
				+ search(strings, "ball", 0, strings.length - 1));

	}

	public static int search(String[] strings, String str, int first, int last) {
		
		while (first <=last) {
			while (first<=last && strings[last]=="") {
				last--;
			}
			if (last<first) {
				return -1;
			}
			int mid = (first + last)/2;
			while (strings[mid]=="") {
				mid++;
			}
			int r = strings[mid].compareTo(str);
			if (r==0) {
				return mid;
			}
			if (r<0) {
				first = mid+1;
			}
			else {
				last = mid-1;
			}
		}
		
		return -1;
	}
}
