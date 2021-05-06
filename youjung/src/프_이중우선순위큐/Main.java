package 프_이중우선순위큐;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		String[] operations = {"I 7","I 5","I -5","D -1"};
//		String[] operations = {"I 16","D 1"};
		solution(operations);
	}
    public static int[] solution(String[] operations) {
    	
    	PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());
    	PriorityQueue<Integer> minQue = new PriorityQueue<>();
    	
    	for(int i=0;i<operations.length;i++){
    		String temp = operations[i];
    		String[] tempArr = temp.split(" ");
    		
    		String str = tempArr[0];
    		int intNum = Integer.parseInt(tempArr[1]);
    		
    		if(str.equals("I")){
    			maxQue.add(intNum);
    			minQue.add(intNum);
    		}else{
    			if(intNum == 1){
    				if(maxQue.size()>0){
    					int max = maxQue.peek();
    					maxQue.remove(max);
    					minQue.remove(max);
    				}
    				
    			}else {
    				if(minQue.size()>0){
    					int min = minQue.peek();
    					maxQue.remove(min);
    					minQue.remove(min);
    				}
    			}
    		}
    	}
    	int size = maxQue.size();
    	int max =0; int min = 1000000;
    	
    	if(size==0){max =0; min = 0;}
    	
    	for(int s=0;s<size;s++){
    		int num = maxQue.remove();
    		max = Math.max(max, num);
    		min = Math.min(min, num);
    	}	
    	
    	int[] answer = {max, min};
    	
    	
//    	System.out.println(max +" "+min);
       
        return answer;
    }
}