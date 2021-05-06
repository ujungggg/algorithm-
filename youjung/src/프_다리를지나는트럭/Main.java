package 프_다리를지나는트럭;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		int br = 100;
		int we = 100;
		int[] truck = {10};
		
		solution(br,we,truck);
		
	}
	
	public static class Pair{
		int truck;
		int time;
		
		Pair( int truck, int time){
			this.truck = truck;
			this.time = time;
					
		}
			}
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
    	
    	 int answer = 1;
    	
    	 LinkedList<Pair> list = new LinkedList<>();
    	 LinkedList<Pair> tempList = new LinkedList<>();
    	 list.add(new Pair(truck_weights[0],bridge_length));
       
    	 int num = 1;
    	 
    	 int totalWeight = truck_weights[0];
    	 while(!list.isEmpty()){
     		 int size = list.size();
    		boolean flag = false;
    		 for(int s=0;s<size;s++){
    			 Pair temp = list.remove();
//    			 System.out.println(temp.truck+"   "+temp.time);
        		 int truck = temp.truck;
        		 int time = temp.time - 1;
        		 if(time >0){
        			 list.add(new Pair(temp.truck,time )); // 원래 다리 위에 있던 트럭 리스트에 넣음
        			 if(!flag && num<truck_weights.length && totalWeight + truck_weights[num] <= weight ){  //새로운거 하나 태울수 있다면
        				 flag = true;
        				 totalWeight += truck_weights[num];
        				 tempList.add(new Pair(truck_weights[num],bridge_length));
        				 num++;
        			 }
        		 }else{
        			 totalWeight -= truck;
        			 if(num<truck_weights.length){
        				 if(!flag && totalWeight + truck_weights[num] <= weight ){
        					 flag = true;
        					 totalWeight +=truck_weights[num];
        					 tempList.add(new Pair(truck_weights[num],bridge_length));
            				 num++;
        				 }
        				
        			 }
        			 
        		 }
    		 }
//    		 System.out.println("----------------------");
    		 list.addAll(tempList);
    		 tempList = new LinkedList<>();
    		 answer++;
    	 }
    	 System.out.println(answer);
        return answer;
    }
}