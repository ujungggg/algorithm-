package 프_N개의최소공배수;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		int[] arr = {2,5,10,12};
//		int[] arr ={1,2,3};
		solution(arr);
	}

	public static int GCD(int a, int b){
		if (b==0) return a;
		else return GCD(b, a%b);
	}
	
	public static int LCM(int a, int b){
		
		return a*b/GCD(a,b);
	}
	public static int solution(int[] arr) {
		
		int num = arr[0];
		
		for(int i=1;i<arr.length;i++){
			 num = LCM(num, arr[i]);
		}
        int answer = num;
        System.out.println(answer);
        
        String st = "s";
       
        System.out.println( st.toUpperCase());
        return answer;
    }
}
