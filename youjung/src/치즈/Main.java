package ДЎБо;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][] arr;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visit;
	static int total =0;
	public static class Pair{
		int x; int y;
		Pair(int x, int y){
			this.x=x; this.y=y;
		}
	}
	public static void checkOut(){
		
		LinkedList<Pair> list = new LinkedList<>();
		visit = new boolean[N][M];
		list.add(new Pair(0,0));
		visit[0][0] = true;
		
		while(!list.isEmpty()){
			Pair temp = list.remove();
			int x = temp.x;
			int y = temp.y;
			
			for(int d=0;d<4;d++){
				int nx = x +dir[d][0];
				int ny = y+ dir[d][1];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				if(!visit[nx][ny] && arr[nx][ny]==0){
					list.add(new Pair(nx,ny));
					visit[nx][ny] = true;
				}
			}
		}
	}
	public static void remove(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(arr[i][j]==1){
					for(int d=0;d<4;d++){
						int nx = i +dir[d][0];
						int ny = j+ dir[d][1];
						
						if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
						if(visit[nx][ny]){
							arr[i][j] =0;
							total--;
							break;
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] ==1) total++;
			}
		}
		int before = 0;
		int time =0;
		while(total!=0){
			before = total;
			checkOut();
			remove();
			time++;
		}
		System.out.println(time);
		System.out.println(before);
	}
}



