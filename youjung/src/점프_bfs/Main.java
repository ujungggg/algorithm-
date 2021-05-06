package 점프_bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int N,K;
	static int[][] arr;
	static boolean[][] visit;
	static LinkedList<Pair> list;
	static boolean flag = false;
	static class Pair{
		int x; int y; 
		Pair(int x, int y){
			this.x=x;
			this.y=y;
			
		}
	}
	
	public static void solve(){
		
		int[] dir = {1,-1};
		int time =0;
		while(!list.isEmpty()){
			
			int size = list.size();
			for(int s=0 ; s<size ; s++){
				Pair temp = list.remove();
				int x = temp.x;
				int y = temp.y;
				if( y < time) continue;
				
				for(int d=0;d<2;d++){
					int newY = y + dir[d];
					
					if(newY >= N){
						flag = true;
						return;
					}
					if(newY<0 ) continue;
					
					if(!visit[x][newY] && arr[x][newY]==1){
						visit[x][newY] = true;
						list.add(new Pair(x,newY));
					}
				}
				
				//건너편의 +K 지점으로 이동
				int newX = (x+1)%2;
				int newY = y + K;
				if(newY >= N){
					flag = true;
					return;
				}
				if(!visit[newX][newY] && arr[newX][newY]==1){
					visit[newX][newY] = true;
					list.add(new Pair(newX,newY));
				}
			}
			
			time++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[2][N];
		visit = new boolean[2][N];
		list =new LinkedList<>();
		
		for(int i=0;i<2;i++){
			String str = br.readLine();
			for(int j=0;j<N;j++){
				arr[i][j] = str.charAt(j)-48;
			}
		}
		
		list.add(new Pair(0,0));
		visit[0][0] = true;
		solve();
		if(flag) {
			System.out.println("1");
		}else{
			System.out.println("0");
		}
		
	}
}