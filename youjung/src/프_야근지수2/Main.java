package ��_�߱�����2;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		int[] works = {1,1};
		int n= 3;
		solution(n , works);
	}
    public static long solution(int n, int[] works) {
    	
    	// �迭�� ������������ ������ �ʹٸ� priorityQueue ����
    	PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());
    	for(int i=0;i<works.length;i++){
    		list.add(works[i]);
    	}
    	
    	// �� ���� ������������� �ּҰ���. 
    	
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