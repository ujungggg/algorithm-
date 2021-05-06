package 최소비용구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[] dist;
	static int[] visit;
	static int N;
	public static void solve(int start){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(start);
		int before = 0;
		dist[start] = 0;
		while(!pq.isEmpty()){
			
			before = pq.poll();
			for(int i=1;i<=N;i++){
				System.out.print(dist[i]+" ");
			}System.out.println();
			for(int i=1;i<=N;i++){
				System.out.println(arr[before][i] + dist[before]);
				System.out.println(dist[i]);
				System.out.println();
				if((arr[before][i] + dist[before] < dist[i] )){
					dist[i] = arr[before][i] + dist[before];
					pq.add(i);
				}
			}
		}
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   
	   N = Integer.parseInt(st.nextToken());
	   st = new StringTokenizer(br.readLine());
	   int M = Integer.parseInt(st.nextToken());
	   arr = new int[N+1][N+1];
	   dist = new int[N+1];
	   visit = new int[N+1];
	   
	   for(int i=1;i<=N;i++){
		   Arrays.fill(arr[i], 1000000001);
	   }
	   
	   Arrays.fill(dist, 1000000001);
	   
	   for(int i=0;i<M;i++){
		   st = new StringTokenizer(br.readLine());
		   int start = Integer.parseInt(st.nextToken());
		   int end = Integer.parseInt(st.nextToken());
		   int value = Integer.parseInt(st.nextToken());
		   if(arr[start][end] > value){
			   arr[start][end] = value;
		   }
		   
		   
	   }
	   
//	   for(int i=1;i<=N;i++){
//		   for(int j=1;j<=N;j++){
//			   System.out.print(arr[i][j]+" ");
//		   }System.out.println();
//	   }System.out.println();
	   st = new StringTokenizer(br.readLine());
	   int first = Integer.parseInt(st.nextToken());
	   int last = Integer.parseInt(st.nextToken());
	   
	   visit[first] = 1;
	   solve(first);
//	   for(int i=1;i<=N;i++){
//		   System.out.println(dist[i]);
//	   }
	   System.out.println(dist[last]);
}
}