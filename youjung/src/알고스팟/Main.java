package ¾Ë°í½ºÆÌ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static int[][] dist;
	public static int[][] visit;
	public static int N;
	public static int M;
	public static PriorityQueue<Pair> list = new PriorityQueue<Pair>();;
	
	public static class Pair implements Comparable<Pair>{
		int x; int y; int dists;
		Pair(int x, int y, int dists){
			this.x=x;
			this.y=y;
			this.dists = dists;
		}
		@Override
		public int compareTo(Pair p) {
			return dists - p.dists;
		}
		
	}
	
	public static void solve(){
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		
		while(!list.isEmpty()){
			Pair temp = list.poll();
			
			int x = temp.x; 
			int y = temp.y;
			
			if(x==N-1 && y == M-1) return;
			for(int d=0;d<4;d++){
				int newX = x+ dir[d][0];
				int newY = y+ dir[d][1];
				
				if(newX<0 || newY<0 || newX>=N || newY>=M) continue;
				if(dist[newX][newY] > arr[newX][newY] + dist[x][y]){
					dist[newX][newY] = arr[newX][newY] + dist[x][y];
					list.add(new Pair(newX, newY,dist[newX][newY]));
				}
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		dist = new int[N][M];
		visit = new int[N][M];
		for(int i=0;i<N;i++){
			String str = br.readLine();
			for(int j=0;j<M;j++){
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		for(int i=0;i<N;i++){
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		dist[0][0] = 0;
		visit[0][0] = 1;
		list.add(new Pair(0,0,0));
		
		solve();
		System.out.println(dist[N-1][M-1]);
		
	}
}

