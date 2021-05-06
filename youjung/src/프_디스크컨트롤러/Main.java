package 프_디스크컨트롤러;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		
		int[][] puddles = {{0, 3}, {1, 9}, {2, 6}};
//		int[][] puddles ={{0, 3}, {1, 9}, {5, 6}};
		solution(puddles);
	}
	public static class Pair implements Comparable<Pair>{
		int start ; 
		int time;
		
		Pair(int start, int time){
			this.start = start;
			this.time = time;
			
		}

		@Override
		public int compareTo(Pair p) {
			return this.time - p.time;
		}
	}
	public static int solution(int[][] jobs) {
    	
    	LinkedList<Pair> priorityQue = new LinkedList<>();
    	LinkedList<Pair> waiting = new LinkedList<>();
    	for(int i=0;i<jobs.length;i++){
    		int start = jobs[i][0];
    		int time = jobs[i][1];
    		
//    		priorityQue.add(new Pair(start, time));
    		waiting.add(new Pair(start,time));
    	}
    	
    	
    	Collections.sort(waiting, new Comparator<Pair>(){

			@Override
			public int compare(Pair p1, Pair p2) {
				
				return p1.start - p2.start;
			}
    		
    	});
    	
    	int now =0;
    	int totalTime =0;
    	int cnt =0;
    	
    	int size = waiting.size();
    	while(cnt<size){ 
    	
    		while(!waiting.isEmpty() && waiting.peek().start <= now){
    			
    			priorityQue.add(waiting.poll());
    			
    		} 
    		
    		Collections.sort(priorityQue);
    		
    		if(!priorityQue.isEmpty()){
    			Pair temp = priorityQue.remove();
    			int start = temp.start;
    			int time = temp.time;
    			
    			totalTime += (now-start+time);
    			now += time;
    			cnt++;
    		}else{
    			now++;
    		}
    		
    		
    		
    	}
//    	System.out.println(totalTime);
//    	System.out.println(totalTime/jobs.length);
    	int answer = totalTime/jobs.length;
        return answer;
    }
}