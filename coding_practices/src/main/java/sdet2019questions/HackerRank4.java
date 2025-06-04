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
public class HackerRank4 {
	
	public static void main(String[] args) {
		
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(10);
		arr.add(-5);
		arr.add(6);
		
		System.out.println("Output : " + splitIntoTwo(arr));
	}
	
	public static int splitIntoTwo(List<Integer> arr) {
	    // Write your code here

	    int leftSum=0;
	    int rightSum=0;
	    int finalOutput=0;
	    for(int i=0;i<arr.size()-1;i++) {
	        leftSum +=arr.get(i);
	        rightSum=0;
	        for(int j=i+1;j<arr.size();j++) {
	            rightSum += arr.get(j);
	        }
	        if (leftSum>rightSum) {
	            finalOutput +=1;
	        }
	    }
	    return finalOutput;
	    }

}
