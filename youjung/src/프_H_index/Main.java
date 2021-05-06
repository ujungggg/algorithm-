package га_H_index;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		int[] arr = {0 , 1, 1};
//		int[] arr = {3,0,6,1,5};
		solution(arr);
	}
	 public static int solution(int[] citations) {
	    	
	    	Arrays.sort(citations);
	    	
	        int max =0;
	    	int arrMax = citations[citations.length -1];
	    	
	    	int answer = 0;
	    	int cnt =0;
	    	for(int j=1;j<=arrMax;j++){
	    		cnt =0;
	    		for(int i=0;i<citations.length;i++){
//	    			if(length-j >= citations[i] && j<=citations[i]){
//		    			max = Math.max(max, citations[i]);                                                                                                                                       
//		    		}
	    			if(citations[i]>=j ){
	    				
	    				cnt++;
	    				
	    			}
	    		}
	    		if(citations.length-cnt<=j && cnt>=j ){
//	    			max = cnt;
	    			answer = j;
	    		}
	    	}
	        
	         System.out.println(answer);
	        return answer;
	    }
}