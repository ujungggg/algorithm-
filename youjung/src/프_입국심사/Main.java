package 프_입국심사;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		int n = 6;
		int[] times = {7,10};
		
		solution(n,times);
	}
    public static long solution(int n, int[] times) {
        long answer = 0;
        
        long left =1;
        long right = n* (long)times[times.length-1];
        
     
        while(left <= right){
        	
        	long person = 0;
        	long mid = (left + right)/2;
        	
        	for(int i=0;i<times.length;i++){
        		person += (mid/times[i]);
        	}
        	
//        	if(person == n ){
//        		answer = mid;
//        		break;
//        	}else 
        	if(person>=n){
        		right = mid-1;
        		answer = mid;
        	}else{
        		left = mid+1;
        	}
        }
        System.out.println(answer);
        return answer;
    }
}