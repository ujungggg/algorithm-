package 기출2048;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] arr;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; // 상 하 좌 우i
	static int max = 0;
//	static int[][] temp ;
	static boolean[][] visit;
	public static void solve(int cnt){
		if( cnt == 5 ){
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					max = Math.max(arr[i][j], max);
				}
			}
//			System.out.println("----------------------------");
			return;
		}else{
			for(int d=0;d<4;d++){
				
				int[][] temp = new int[N][N];
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						temp[i][j] = arr[i][j];
					}
				}
				move(d);
				visit = new boolean[N][N];
//				for(int i=0;i<N;i++){
//					for(int j=0;j<N;j++){
//						System.out.print(arr[i][j]+" ");
//					}System.out.println();
//				}System.out.println();
//				System.out.println(cnt+ "회 종료");
				solve(cnt+1);
//				System.out.println("temp ");
//				for(int i=0;i<N;i++){
//					for(int j=0;j<N;j++){
//						System.out.print(temp[i][j]);
//					}System.out.println();
//				}System.out.println();
//				System.out.println("arr");
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						arr[i][j] = temp[i][j];
					}
				}
			}
		}
	}
	public static void makeMove(int x, int y,int d){
		int now = arr[x][y];
		arr[x][y] = 0;
		boolean flag = visit[x][y];
		visit[x][y] = false;
		
		while(true){
			x += dir[d][0];
			y += dir[d][1];
			
			// 맵 빡을 나가거나
			if(x<0 || y<0 || x>=N || y>=N){
				x -= dir[d][0];
				y -= dir[d][1];
				arr[x][y] = now;
				visit[x][y] = flag;
				break;
			}
			// 숫자가 있는 경우
	    	//   ->숫자가 지금 숫자랑 같은 경우
			else if(arr[x][y] == now && !visit[x][y]){
				arr[x][y] += now;
				visit[x][y] = true;
				break;
			}
		    //   ->숫자가 지금 숫자랑 다른 경우
			else if((arr[x][y]!= 0 && arr[x][y]!=now) || visit[x][y] ){
				x -= dir[d][0];
				y -= dir[d][1];
				arr[x][y] = now;
				visit[x][y] = flag;
				break;
			}
			
		}
	}
	public static void move(int d){
		if(d==0){ //상
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
//			for(int j=0;j<N;j++){
//				for(int i=0;i<N;i++){
					if(arr[i][j]!=0){
						int x = i; int y = j;
						
						makeMove(x,y,d);
					}
				}
			}
		}else if(d==1){ //하
			//아래에서 부터 시작
			for(int i=N-1;i>=0;i--){
				for(int j=0;j<N;j++){
//			for(int j=0;j<N;j++){
//				for(int i=N-1;i>=0;i--){		
					if(arr[i][j]!=0){
						int x = i; int y = j;
						
						makeMove(x,y,d);
					}
				}
			}
		}else if(d==2){ //좌
			for(int j=0;j<N;j++){
				for(int i=0;i<N;i++){
//			for(int i=0;i<N;i++){
//				for(int j=0;j<N;j++){
					if(arr[i][j]!=0){
						int x = i; int y = j;
						
						makeMove(x,y,d);
					}
				}
			}
		}else{ //우
			//오른쪽에서 부터 시작
			for(int j=N-1;j>=0;j--){
				for(int i=0;i<N;i++){
//			for(int j=N-1;j>=0;j--){
//				for(int i=0;i<N;i++){
					if(arr[i][j]!=0){
						int x = i; int y = j;
					
						makeMove(x,y,d);
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
//		temp = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0);
		System.out.println(max);
	}
}

