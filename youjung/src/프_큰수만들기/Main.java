package 프_큰수만들기;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
		
		solution(number,k);
	}
	 public static String solution(String number, int k) {
	    	StringBuilder sb = new StringBuilder();
	    	int total = number.length()-k;
	    	
	    	String answer = "";
	    	int start = 0;
	    	int end = k;
	    	
	    while(true){
	    	 
//	    	  System.out.println(answer);
	    	  int max =0; int point=0;
	    	  for(int i= start ;i<=end ;i++){
	    		 if(max < number.charAt(i)-'0'){
	    			 max = number.charAt(i)-'0';
	    			 point = i;
	    		 }
	    	  }
	    		
	    	  sb.append(max);
	    	  start = point + 1;
	    	  end ++;
	          if(sb.toString().length() == total) break;
	    	}
	    	

	    	/*
	    	int start =0; int point =0;
	    	for(int i=0;i<number.length()-k;i++){
	    		int max =0;
	    		for(int j=start ; j<= i + k; j++){
	    			 if(max < number.charAt(j)-'0'){
		    			 max = number.charAt(j)-'0';
		    			 point = j;
		    		 }
	    		}
	    		sb.append(max); //append 사용!!
//	    		answer += max; //시간초과!!!
	    		start = point+1;
//	    		System.out.println(answer);
	    	}
	    	
	    	*/
//	       System.out.println(answer);
	        return sb.toString();
	    }
}

