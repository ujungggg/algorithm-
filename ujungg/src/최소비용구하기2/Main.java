package 최소비용구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static LinkedList<Pair>[] list;
	static LinkedList<Integer>[] visit;
	static int[] dist;
	static class Pair implements Comparable<Pair>{
		int y; int value;
		Pair(int y, int value){
			this.y= y;
			this.value= value;
		}
		
		@Override
		public int compareTo(Pair o) {
			return this.value - o.value;
			
		}
	}
	
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   N = Integer.parseInt(st.nextToken());
	   st = new StringTokenizer(br.readLine());
	   int M = Integer.parseInt(st.nextToken());
	   
	   list = new LinkedList[N+1];
	   visit = new LinkedList[N+1];
	   dist = new int[N+1];
	   for(int i=1;i<=N;i++){
			 list[i] = new LinkedList<>();
			 visit[i] = new LinkedList<>();
		}
	   
	   for(int i=0;i<M;i++){
		   st = new StringTokenizer(br.readLine());
		   int a = Integer.parseInt(st.nextToken());
		   int b = Integer.parseInt(st.nextToken());
		   int value = Integer.parseInt(st.nextToken());
		   list[a].add(new Pair(b, value));
	   }
	   
	   st = new StringTokenizer(br.readLine());
	   int start = Integer.parseInt(st.nextToken());
	   int end = Integer.parseInt(st.nextToken());
	   
	   Arrays.fill(dist, 100000000);
	   
	   PriorityQueue<Pair> pq = new PriorityQueue<>();
	   pq.add(new Pair(start,0)); //시작점을 큐에 넣음
	   dist[start] =0;  //처음 시작점은 0으로
	   visit[start].add(start);
	   while(!pq.isEmpty()){
		   Pair temp = pq.remove();
		   
		   int x = temp.y;
		   int value = temp.value;
		   
//		   if(x==end) break;
		   for(int i=0;i<list[x].size();i++){
			   Pair listTemp = list[x].get(i);
			   int arriveX = listTemp.y;
			   int arriveValue = listTemp.value;
			   
			   if(dist[x] + arriveValue < dist[arriveX]){
				   dist[arriveX] = dist[x] + arriveValue;
				   pq.add(new Pair(arriveX,dist[arriveX]));
				   visit[arriveX].clear();  //
				   visit[arriveX].addAll(visit[x]); //전 단계에 있던 경로들은 현재 지점에 다 넣어줌
				   visit[arriveX].add(arriveX); //현재 지점도 넣어줌
			   }
		   }
	   }
	   
//	   for(int i=1;i<=N;i++){
//		   System.out.print(visit[i]+" ");
//	   }
	   System.out.println(dist[end]);
	   System.out.println(visit[end].size());
	   for(int s=0;s<visit[end].size();s++){
		   System.out.print(visit[end].get(s)+" ");
	   }
	   
}
}