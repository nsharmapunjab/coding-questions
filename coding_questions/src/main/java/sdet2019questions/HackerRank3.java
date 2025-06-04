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
public class HackerRank3 {
	
	public static void main(String[] args) {
		
		List<Integer> songs = new ArrayList<Integer>();
		songs.add(4);
		songs.add(10);
		songs.add(50);
		songs.add(90);
		songs.add(30);
		
		System.out.println(playlist(songs));
	}
	
	public static long playlist(List<Integer> songs) {
	    // Write your code here
	    if (songs==null || songs.size()==0) {
	        return -1;
	    }

	    int finalValue=0;
	    for(int i=0;i<songs.size();i++) {
	        for(int j=i+1;j<songs.size();j++) {
	            if ((songs.get(i) + songs.get(j))%60==0) {
	                finalValue +=1;
	            }
	        }
	    }
	    return finalValue;
	    }

}
