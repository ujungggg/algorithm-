package 뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int[][] visit;
	static int direction;
	static Deque<Pair> que = new LinkedList<>();
	static LinkedList<Pair> time = new LinkedList<>();
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int totalTime =0;
	static class Pair{
		int a; int b;
		Pair(int a, int b){
			this.a=a;
			this.b=b;
			
		}
	}
	
	static void solve(){
//		int totalTime =0;
		int i = 1; int j =1;
		
		while(true){
			int size = time.size();
			if(size>0){
				Pair temp = time.getFirst();
				int t = temp.a;
				int change = temp.b;
				
				if(t == totalTime){
					time.remove();
					//방향 바꿈
					if(change == 1){
						direction = (direction+1)%4;
					}else{
						if(direction == 0){
							direction = 3;
						}else{
							direction= direction-1;
						}
					}
					
				}
			}
			
			i += dir[direction][0];
			j += dir[direction][1];
			
			if(i<1 || j<1 || i>N || j>N) {
				totalTime++;
				return;
			}
			
			if(visit[i][j]==1) {
				totalTime++;
				return;
			}
			if(arr[i][j] == 1 && visit[i][j]==0){ //사과가 있으면 사과 없어지고 꼬리가 그대로
				arr[i][j]=0;
				que.addFirst(new Pair(i,j)); //시작점
				visit[i][j]=1;
			}else if(arr[i][j]==0 && visit[i][j]==0){ //사과 없으면 꼬리도 없어짐
				Pair t = que.pollLast();
				visit[t.a][t.b]=0;
				que.addFirst(new Pair(i,j)); //시작점
				visit[i][j]=1;
			}
//			for(int r=1;r<=N;r++){
//				for(int t=1;t<=N;t++){
//					System.out.print(visit[r][t]+" ");
//				}System.out.println();
//			}System.out.println();
			totalTime++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		visit = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
	
		for(int i=0;i<K;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<L;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			String cr = st.nextToken();
			int b =0;
			if(cr.equals("D")){
				b = 1;
			}else{
				b= -1;
			}
			time.add(new Pair(a,b));
		}
		que.add(new Pair(1,1));
		solve();
		System.out.println(totalTime);
	}

}