package 디스크컨트롤러;

import java.util.*;
class Solution {
   public static void main(String[] args){
       int[][] jobs ={{0, 3}, {1, 9}, {2, 6}, {4, 3}};
       solution(jobs);
   }
   public static class Pair implements Comparable<Pair>{
	   int a; int b;
	   Pair(int a, int b){
		   this.a= a;
		   this.b=b;
	   }
	@Override
	public int compareTo(Pair p) {
		
		return b- p.b;
	}
	   
	   
	   
	   
   }
    public static int solution(int[][] jobs) {
        
        Arrays.sort(jobs,(o1,o2)->(o2[0]-o1[0])); //먼저 시작하는 거 우선으로
        //0,1,2로 정렬이됨
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        LinkedList<Pair> waitingList = new LinkedList<>();
        for(int i=0;i<jobs.length;i++){
        	pq.add(new Pair(jobs[i][0],jobs[i][1]));
        	System.out.println("------------------------");
        	System.out.println(jobs[i][0] +" "+jobs[i][1]);
        }
       int size = pq.size();
        for(int s=0;s<size;s++){
        	Pair temp = pq.poll();
        	int x = temp.a; 
        	int y = temp.b;
        	System.out.println(x+" "+y);
        	waitingList.add(new Pair(x,y));
        }
        int totalTime =0;
      
        int time = 0;
        int cnt =0;
        while(!waitingList.isEmpty()){
        	
        	for(int s=0;s<waitingList.size();s++){
        		   Pair temp = waitingList.get(s);
                   int queTime = temp.a; //요청받은시간
                   int requireTime = temp.b; //작업에 걸리는 시간
                   
                   if(time>=queTime){ //현재시간>=요청받은 시간
                       waitingList.remove(s);
                       totalTime +=(time-queTime) + requireTime; //현재시간- 요청받은시간 + 걸리는 시간
                       time+= requireTime;
                   }
//                   else{
//                      time++; //시간만 흘러감
//                   }
        	}
         
        }
        System.out.println("###"+totalTime);
        int answer = totalTime/jobs.length;
         System.out.println(answer);
        return answer;
    }
}