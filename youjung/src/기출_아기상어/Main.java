package 기출_아기상어;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] visit;
	static int[][] arr;
	static LinkedList<Pair> list;
	static int fish = 2;
	static int totalTime =0;
	static int times =0;
	static boolean check = false;
	static class Pair{
		int x; int y; 
		Pair(int x, int y){
			this.x=x; this.y=y; 
		}
//		@Override
//		public int compareTo(Pair p) {
//			
//		}
		
		
		
	}
	
	public static boolean checkValue(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(arr[i][j]!=0 && arr[i][j]<fish){
					return true;
				}
			}
		}
		return false;
	}
	public static void solve(){
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		int eat  = 0;
		
		while(!list.isEmpty()){
			int fishX = 1000000000; int fishY = 1000000000; 
			
			
			if(!checkValue()) break;
			int size = list.size();
			
			for(int s=0;s<size;s++){
				Pair temp = list.remove();
				int x = temp.x;
				int y = temp.y;
			
				
				for(int d=0;d<4;d++){
					int nx = x+ dir[d][0];
					int ny = y + dir[d][1];
					
					if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
					if((arr[nx][ny]==0 || arr[nx][ny] == fish) && visit[nx][ny]==0){
						//0이거나 물고기와 크기가 같으면 지나갈수는 있음
						visit[nx][ny] = 1;
						list.add(new Pair(nx,ny));
					}else if(arr[nx][ny]< fish && visit[nx][ny]==0){
						visit[nx][ny] = 1;
						if(nx<= fishX){
							if(nx==fishX){ //x값 같은 경우에는 y를 비교
								if(ny<fishY){
									fishY = ny;
								}
							}else{
								fishX = nx;
								fishY = ny;
							}
						}
					}
				}
			}
		
			totalTime++;
			if(fishX!= 1000000000){
				check = true;
				visit = new int[N][N];
				list = new LinkedList<>();
				list.add(new Pair(fishX,fishY));
				arr[fishX][fishY] = 0;
				eat++;
				times = totalTime;
				if(eat == fish){
					fish++;
					eat =0;
				}
			}
			
			
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new int[N][N];
		list = new LinkedList<Pair>();
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==9){
					arr[i][j]= 0;
					list.add(new Pair(i,j));
				}
			}
		}
		
		solve();
		if(!check){
			System.out.println("0");
		}else{
			System.out.println(times);
		}
		
	}
}

