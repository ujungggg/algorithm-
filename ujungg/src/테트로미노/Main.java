package ��Ʈ�ι̳�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N; static int M;
	static int[][] arr;
	static int[][] visit;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int max =0;
	public static void dfs(int startX, int startY, int cnt,int total){
		if(cnt == 4){
			
			max = Math.max(total, max);
			return;
		}
		for(int d=0;d<4;d++){
			int x = startX +dir[d][0];
			int y = startY + dir[d][1];
			if(x<0 || y<0 || x>=N || y>= M) continue;
			if(visit[x][y]==0){
				visit[x][y] =1 ;
				dfs(x,y,cnt+1,total+arr[x][y] );
				visit[x][y]=0;
			}
		}
	}
	
	public static void solve(int startX,int startY,int total){
		int count =0; // ���� ���� �Ѿ�°� ���� üũ
		int min =10000; //�� ������ ���� �� üũ
//		int total = 0; // ���Ѱ�
		for(int d=0;d<4;d++){
			int x = startX + dir[d][0];
			int y = startY + dir[d][1];
			
			if(x<0 || y<0 || x>=N || y>=M){
				count ++;
			}else{
				total += arr[x][y];
				min = Math.min(arr[x][y], min);
			}
		}
//		for(int i=0;i<N;i++){
//			for(int j=0;j<M;j++){
//				System.out.print(visit[i][j]+" ");
//			}System.out.println();
//		}System.out.println();
		if(count ==2){
			//��� �� �ʿ����
		}else if (count == 1){
			max = Math.max(total, max);
		}else { // ���� �Ѿ�°� ������
			total -= min;
			max = Math.max(total, max);
		}
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
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				dfs(i,j,0,0);
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				visit[i][j]=1;
				solve(i,j,arr[i][j]);
			}
		}
		
		System.out.println(max);
	}
}