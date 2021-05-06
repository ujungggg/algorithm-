package 프_피보나치수;
import java.util.*;

class Solution {
	
	
	public static void main(String[] args) {
		int n = 10000;
		solution(n);
	}
	
	public static int getFib(int n){
		if(n<=1) return n;
		else{
			return (getFib(n-1)+ getFib(n-2)) %1234567;
		}
	}
	  public static int solution(int n) {
		  
//		  int[] fib = new int[100001];
//		  fib[0] = 0;
//		  fib[1] = 1;
//		
//		  for(int i=2;i<=n;i++){
//			  fib[i] = (fib[i-2] + fib[i-1]) %1234567;
//		  }
				  
	        int answer = getFib(n);
	        System.out.println(answer);
	        return answer;
	    }
}

