package ¾ËÆÄºª;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][] arr;
	static int[] alpha = new int[37];
	static int[][] visit ;
	static LinkedList<Pair> list = new LinkedList<>();
	static int cnt,max =0;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static class Pair{
		int x; int y; int count;
		Pair(int x, int y,int count){
			this.x=x;
			this.y=y;
			this.count = count;
		}
	}
	
	public static void solve(int x, int y,int cnt){
		for(int d=0;d<4;d++){
			int nx = x+ dir[d][0];
			int ny = y + dir[d][1];
			if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
			
			if(alpha[arr[nx][ny]] ==0 && visit[nx][ny]==0){
				visit[nx][ny] = 1;
				alpha[arr[nx][ny]] =1;
				
				solve(nx,ny,cnt+1);
				visit[nx][ny] = 0;
				alpha[arr[nx][ny]] =0;
			}
			
		}
		
		max = Math.max(cnt, max);
		return;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new int[N][M];
		for(int i=0;i<N;i++){
			String str = br.readLine();
			for(int j=0;j<M;j++){
				arr[i][j] = str.charAt(j) -65;
				
			}
		}
		
		/*
		int max =0;
		visit[arr[0][0]] = 1;
		cnt++;
		
		list.add(new Pair(0,0,1));
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		while(!list.isEmpty()){
			
			Pair temp = list.remove();
			int tx = temp.x;
			int ty = temp.y;
			int tc = temp.count;
			
			max = Math.max(tc, max);
			for(int d=0;d<4;d++){
				int x = tx+dir[d][0];
				int y = ty +dir[d][1];
				
				if(x<0 || y<0 || x>=N || y>=M) continue;
				
				if(visit[arr[x][y]] ==0){
					
					visit[arr[x][y]] = 1;
					list.add(new Pair(x,y,tc+1));
				}
			}
		}
		
		System.out.println(max);
		*/
		visit[0][0]=1;
		alpha[arr[0][0]] = 1;
		solve(0,0,1);
		System.out.println(max);
	}
}

