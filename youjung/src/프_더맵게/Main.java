package ÇÁ_´õ¸Ê°Ô;
import java.util.*;

class Solution {
	
	
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12}	;
		int K = 7;
		solution(scoville,K);
	}
	
	  public static  int solution(int[] scoville, int K) {
		  
		  int cnt =0;
		  PriorityQueue<Integer> list = new PriorityQueue<>();
		  for(int i=0;i<scoville.length;i++){
			  list.add(scoville[i]);
		  }
		  boolean flag = false;
		  while(list.peek()<K){
			  if(list.size() <2) break;
			  if(list.peek() > K) {
				  flag = true;
				  break;
			  }
			  
			  int first = list.poll();
			  int second = list.poll();
			  
			  list.add(first + (second*2));
			  
			  cnt++;
		  }
		  int answer =0;
		  if(flag){
			   answer = cnt;
		        System.out.println(answer);
		  }else{
			  answer = -1;
		  }
	     
	        return answer;
	    }
}

