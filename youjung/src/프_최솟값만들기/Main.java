package 프_최솟값만들기;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		int[] A = {1,2};
		int[] B = {3,4};
		
		solution(A,B);
	}
	 public static int solution(int []A, int []B) {
	    	Arrays.sort(A);
	    	Arrays.sort(B);
	    	
	    	int total =0;
	    	int n = A.length-1;
	    	for(int i=0;i<=n;i++){
	    		int num = A[i] * B[n-i];
	    		total += num;
	    	}
	    	System.out.println(total);
	    	return total;
	    	
	    }
}

