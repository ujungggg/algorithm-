package ��ũ��Ʈ�ѷ�;

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
        
        Arrays.sort(jobs,(o1,o2)->(o2[0]-o1[0])); //���� �����ϴ� �� �켱����
        //0,1,2�� �����̵�
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
                   int queTime = temp.a; //��û�����ð�
                   int requireTime = temp.b; //�۾��� �ɸ��� �ð�
                   
                   if(time>=queTime){ //����ð�>=��û���� �ð�
                       waitingList.remove(s);
                       totalTime +=(time-queTime) + requireTime; //����ð�- ��û�����ð� + �ɸ��� �ð�
                       time+= requireTime;
                   }
//                   else{
//                      time++; //�ð��� �귯��
//                   }
        	}
         
        }
        System.out.println("###"+totalTime);
        int answer = totalTime/jobs.length;
         System.out.println(answer);
        return answer;
    }
}