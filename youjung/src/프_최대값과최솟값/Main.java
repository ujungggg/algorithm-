package 프_최대값과최솟값;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		String s = "-1 -2 -3 -4";
		solution(s);
	}
    public static String solution(String s) {
        
        String[] arr = s.split(" ");
        int max =-1000000000; int min = 1000000000;
        for(int i=0;i<arr.length;i++){
        	max = Math.max(max, Integer.parseInt(arr[i]));
        	min = Math.min(min, Integer.parseInt(arr[i]));
        }
        String answer = min+" "+max;
        System.out.println(answer);
        return answer;
    }
}
