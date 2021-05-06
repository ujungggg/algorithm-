package ∂Û¿Œ;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
	public static void main(String[] args) {
		int[] ball = {1, 2, 3, 4, 5, 6};
		int[] order = {6, 2, 5, 1, 4, 3};
		
		solution(ball,order);
	}
    public static int[] solution(int[] ball, int[] order) {
    	
    	Deque<Integer> ballQue = new LinkedList<>();
    	LinkedList<Integer> orderQue = new LinkedList<>();
    	LinkedList<Integer> resultQue = new LinkedList<>();
    	for(int i=0;i<ball.length;i++){
    		ballQue.add(ball[i]);
    	}
    	for(int i=0;i<order.length;i++){
    		orderQue.add(order[i]);
    	}
    	
    	int i = 0;
    	while(!orderQue.isEmpty()){
    		int point = orderQue.get(i);
    		if(ballQue.getFirst() == point){
    			resultQue.add(ballQue.pollFirst());
    			int a = orderQue.remove(i);
    			i=0;
    		}else if(ballQue.getLast() == point){
    			resultQue.add(ballQue.pollLast());
    			int b =orderQue.remove(i);
    			i=0;
    		}else{
    			i++;
    		}
    	}
    	System.out.println(resultQue);
        int[] answer = new int[resultQue.size()];
        for(int s=0;s<resultQue.size();s++){
        	answer[s] = resultQue.get(s);
        }
        return answer;
    }
}