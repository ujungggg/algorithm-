package N_Queen_백트래킹;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static int[][] visit;
	public static int N;
	public static int tot =0;
	//public static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
	public static int[][] dir = {{1,0},{0,1},{1,1},{-1,-1},};
	public static void solve(int x, int cnt){
		if(cnt == N){
			tot++;
			return;
		}else{
			for(int y=0 ; y<N ; y++){
				if(visit[x][y]==0){
					visit[x][y] += 1;
					makevisit(x,y,1);
					solve(x+1, cnt+1);
					makevisit(x,y,-1);
					visit[x][y] += -1;
				}
				
			}
		}
	}
	/*
	public static boolean check(int startX,int startY){
		for(int d=0;d<8;d++){
			
			int x = startX; int y = startY;
			while(true){
				x += dir[d][0];
				y += dir[d][1];
				
				if(x<0 || y<0 || x>=N || y>=N) break;
				if(visit[x][y] > 0 ) return false;
			}
		}
		return true;
	}
	*/
	public static void makevisit(int startX, int startY,int num){
		for(int d=0;d<4;d++){
			
			int x = startX; int y = startY;
			while(true){
				x += dir[d][0];
				y += dir[d][1];
				
				if(x<0 || y<0 || x>=N || y>=N) break;
				visit[x][y] += num;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		visit = new int[N][N];
		solve(0,0); //startX, cnt
		
		System.out.println(tot);
	}
}

