package 프_야근지수2;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		int[] works = {1,1};
		int n= 3;
		solution(n , works);
	}
    public static long solution(int n, int[] works) {
    	
    	// 배열을 내림차순으로 뒤집고 싶다면 priorityQueue 쓰자
    	PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());
    	for(int i=0;i<works.length;i++){
    		list.add(works[i]);
    	}
    	
    	// 각 수가 비슷해졌을때가 최소값임. 
    	
    	while(n>0){
    		int num = list.remove();
    		num --;
    		list.add(num);
    		n--;
    		
    	}
    	 long answer = 0;
    	 int size = list.size();
    	for(int i=0;i<size;i++){
    		int num = list.remove();
    		if(num>0){
    			answer += Math.pow(num,2);
    		}
    		
    	}
    	System.out.println(answer);
       
        return answer;
    }
}