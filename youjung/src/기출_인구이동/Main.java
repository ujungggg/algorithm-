package 기출_인구이동;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	
	public static int N,L,R; 
	public static int[][] arr;
	public static int[][] visit;
	public static int cnt ;
	public static int total;
	public static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public static LinkedList<Pair> list = new LinkedList<>();
	public static boolean flag = false;
	public static class Pair{
		int x; int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void check(int visitCheck){
		while(!list.isEmpty()){
			Pair temp = list.remove();
			int x= temp.x;
			int y= temp.y;
			
			for(int d=0;d<4;d++){
				int nx = x+dir[d][0];
				int ny = y+dir[d][1];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if( visit[nx][ny]==0 && Math.abs(arr[x][y]- arr[nx][ny])>= L && Math.abs(arr[x][y]- arr[nx][ny] )<= R){
					flag = true;
					visit[nx][ny] = visitCheck;
					cnt++;
					total+= arr[nx][ny];
					list.add(new Pair(nx,ny));
				}
			}
		}
	}
	
	public static void change(int visitCheck, int num){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(visit[i][j] == visitCheck){
					arr[i][j] = num;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		visit = new int[N][N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int visitCheck =1;
		
		int count=0;
		while(true){
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(visit[i][j] == 0){
						list.add(new Pair(i,j));
						total = arr[i][j];
						visit[i][j] = visitCheck;
						cnt = 1;
						check(visitCheck);
						change(visitCheck, total/cnt);
						visitCheck++;
					}
					
				}
			}
			if(!flag) break;
			flag = false;
			visit = new int[N][N];
			visitCheck = 1;
			count++;
		}
		
		System.out.println(count);
		
	}
}

