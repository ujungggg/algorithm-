package 탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N; 
	static int M;
	static char[][] arr;
	static int cnt=0;
	static int[][] visit;
	static LinkedList<Pair> water;
	static LinkedList<Pair> go;
	static boolean check = false;
	static class Pair{
		int x; int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void bfs(){
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		//물 먼저 퍼트린 후에 고슴도치가 이동함
		while(!go.isEmpty()){
			
			//1. 물 이동
			int size = water.size();
			for(int s=0;s<size;s++){
				Pair temp = water.remove();
				int x = temp.x;
				int y = temp.y;
				
				for(int d=0;d<4;d++){
					int dx = x+dir[d][0];
					int dy = y+dir[d][1];
					if(dx<0 || dy<0 || dx>=N || dy>=M) continue;
					if(visit[dx][dy]==0 && arr[dx][dy] !='D' &&arr[dx][dy] !='X'){
						visit[dx][dy]=1;
						water.add(new Pair(dx,dy));
					}
				}
			}
			
			int size2 = go.size();
			for(int s=0;s<size2;s++){
				Pair temp = go.remove();
				int x = temp.x;
				int y = temp.y;
				
				for(int d=0;d<4;d++){
					int dx = x+ dir[d][0];
					int dy = y+ dir[d][1];
					
					if(dx<0 || dy<0 || dx>=N || dy>=M) continue;
					if(arr[dx][dy] =='D'){
						cnt++;
						check = true;
						return;
					}
					if(visit[dx][dy]==0  &&arr[dx][dy] !='X'){
						visit[dx][dy]=1;
						go.add(new Pair(dx,dy));
					}
				}
			}
			cnt++;
		}
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   N = Integer.parseInt(st.nextToken());
	   M = Integer.parseInt(st.nextToken());
	   
	   arr = new char[N][M];
	   visit = new int[N][M];
	   
	   water = new LinkedList<Pair>();
	   go = new LinkedList<Pair>();
	   for(int i=0;i<N;i++){
		   String str = br.readLine();
		   for(int j=0;j<M;j++){
			   arr[i][j] = str.charAt(j);
			   if(arr[i][j]=='*'){
				   visit[i][j]=1;
				   water.add(new Pair(i,j));
			   }else if(arr[i][j]=='S'){
				   visit[i][j]=1;
				   go.add(new Pair(i,j));
			   }
		   }
	   }
	   
	   
	   bfs();
	   if(check){
		   System.out.println(cnt);
	   }else{
		   System.out.println("KAKTUS");
	   }
	   
	 

}
}