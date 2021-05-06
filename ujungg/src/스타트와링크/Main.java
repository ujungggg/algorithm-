package 스타트와링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int[] visit;
	static int min = 1000000000;
	
	public static void dfs(int start, int cnt){
		if(cnt == N/2){
			int starts =0;
			int link =0;
			for(int i=0;i<N;i++){
				if(visit[i]==1){
					int startX = i;
					for(int j=0;j<N;j++){
						if(j != startX && visit[j]==1){
							starts += arr[startX][j];
						}
					}
				}
			}
			
			for(int i=0;i<N;i++){
				if(visit[i]==0){
					int startX = i;
					for(int j=0;j<N;j++){
						if(j != startX && visit[j]==0){
							link += arr[startX][j];
						}
					}
				}
			}
			
			min = Math.min(Math.abs(starts-link), min);
			
		}else{
			for(int i= start;i<N;i++){
				if(visit[i]==0){
					visit[i]=1;
					dfs(i+1,cnt+1);
					visit[i]=0;
				}
			}
		}
	}
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	arr = new int[N][N];
	visit = new int[N];
	for(int i=0;i<N;i++){
		st = new StringTokenizer(br.readLine());
		for(int j=0;j<N;j++){
			arr[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	dfs(0,0);
	System.out.println(min);
}
}