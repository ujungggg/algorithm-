package codility9_2;
//you can also use imports, for example:
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	public static void main(String[] args) {
		int[] A = {-6,4,0,-8,3,5};
		solution(A);
	}
 public static int solution(int[] A) {
     int localMax =A[0];
     int globalMax =A[0];
    

     

     for(int i = 1 ; i < A.length; i++) {
    	 localMax = Math.max(A[i], localMax + A[i]);
    	 globalMax = Math.max(globalMax, localMax);
     }
     System.out.println(globalMax);
 return globalMax;

 }
}



