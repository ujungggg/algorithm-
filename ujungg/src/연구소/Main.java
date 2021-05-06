package 연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int[][] visit;
	static int N; static int M;
	static int max =0;
	static Queue<Pair> que = new LinkedList<>();
	
	static class Pair{
		int x; int y;
		Pair(int x, int y){
			this.x =x ;
			this.y =y;
		}
	}
	public static void solve(int startX, int startY, int cnt){
		if(cnt ==3){
			int num = check();
			max = Math.max(num, max);
			return;
		}else{
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(arr[i][j]==0 && visit[i][j]==0){
						arr[i][j]=3;
						visit[i][j]=1;
						solve(i,j,cnt+1);
						arr[i][j]=0;
						visit[i][j]=0;
					}
				}
			}
		}
	}
	
	public static int check(){ // 바이러스 퍼트린후 검사
		int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(arr[i][j]==2){
					que.add(new Pair(i,j));
				}
			}
		}
		while(!que.isEmpty()){
			Pair temp =que.remove();
			
			int x = temp.x;
			int y = temp.y;
			
			for(int d=0;d<4;d++){
				int newX = x +dir[d][0];
				int newY = y+dir[d][1];
				if(newX<0|| newY<0 || newX>=N || newY>=M) continue;
				if(arr[newX][newY] ==0 && visit[newX][newY]==0){
					visit[newX][newY] =1;
					que.add(new Pair(newX,newY));
				}
			}
			
		}
		int cnt=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(arr[i][j]==0 && visit[i][j]==0){
					cnt++; //바이러스 침투 안당한곳
				}
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				visit[i][j]=0;
			}
		}
		return cnt;
	}
   public static void main(String[] args) throws NumberFormatException, IOException {

	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	   StringTokenizer st;
	   st = new StringTokenizer(br.readLine());
	   N = Integer.parseInt(st.nextToken());
	   M = Integer.parseInt(st.nextToken());
	   
	   arr = new int[N][M];
	   visit = new int[N][M];
	   for(int i=0;i<N;i++){
		   st = new StringTokenizer(br.readLine());
		   for(int j=0;j<M;j++){
			   arr[i][j] = Integer.parseInt(st.nextToken());			  
		   }
	   }
	   
	   
	   for(int i=0;i<N;i++){
		   for(int j=0;j<M;j++){
			   if(arr[i][j]==0 && visit[i][j]==0){
				   arr[i][j]=3;
				   solve(i,j,1);
				   arr[i][j]=0;
			   }
		   }
	   }
	   System.out.println(max);
}
}