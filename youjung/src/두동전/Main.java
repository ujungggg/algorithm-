package 두동전;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static char[][] arr;
	public static LinkedList<Pair> list = new LinkedList<>();
	public static int[][][][] visit ;
	public static int tot =0;
	public static class Pair{
		int x1; int y1;
		int x2; int y2; int time;
		Pair(int x1, int y1,int x2, int y2, int time){
			this.x1=x1;
			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
			this.time = time;
		}
	}
	public static class Pair2{
		int x1; int y1;
		int x2; int y2;
		Pair2(int x1, int y1,int x2, int y2){
			this.x1=x1;
			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
			
		}
	}
	public static void solve(){
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		while(!list.isEmpty()){
			Pair temp = list.remove();
			int X1 = temp.x1;
			int Y1 = temp.y1;
			int X2 = temp.x2;
			int Y2 = temp.y2;
			int time = temp.time;
			if(time >= 10) {
				tot = -1;
				return;
			}
			for(int d=0;d<4;d++){
				int x1 = X1 + dir[d][0];
				int y1 = Y1 + dir[d][1];
				int x2 = X2 + dir[d][0];
				int y2 = Y2 + dir[d][1];
				
				if((x1<0 || y1<0 || x1 >=N || y1>=M ) && (x2<0 || y2<0 || x2 >=N || y2>=M )){
					continue;
				} //두개다 범위 넘어가면 ㄴㄴ
				else if (((x1<0 || y1<0 || x1 >=N || y1>=M ) && (x2 >=0 && y2>=0 && x2 <N && y2<M))
						|| ((x2<0 || y2<0 || x2 >=N || y2>=M )  && (x1 >=0 && y1>=0 && x1 <N && y1< M))){
					tot = time+1;
					return;
				} //한개가 범위가 넘어가면 끝남
				
				if(arr[x1][y1] == '#' ){
					x1 = X1; y1 = Y1;
				}
				if(arr[x2][y2] == '#'){
					x2 = X2; y2 = Y2;
				}
				//if(visit[x1][y1][x2][y2] == 0){
				//	visit[x1][y1][x2][y2] = 1;
					list.add(new Pair(x1,y1,x2,y2,time+1));
				//}
				
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		visit = new int[N][M][N][M];
		int x1=-1; int y1=-1;
		int x2=-1; int y2=-1;
		for(int i=0;i<N;i++){
			String str = br.readLine();
			for(int j=0;j<M;j++){
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == 'o' && x1==-1 && y1==-1){
					x1 =i; y1= j;
					arr[x1][y1] = '.';
				}else if(arr[i][j] == 'o' && x1!=-1 && y1!=-1){
					x2 =i; y2= j;
					arr[x2][y2] = '.';
				}
			}
		}
		
		list.add(new Pair(x1,y1,x2,y2,0));
		visit[x1][y1][x2][y2] = 1;
		solve();
		System.out.println(tot);
	}
}



