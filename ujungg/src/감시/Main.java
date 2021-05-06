package °¨½Ã;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[][] visit;
	static int min = 1000000000;
	static int N; static int M;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static ArrayList<Pair> que = new ArrayList<>();
	
	static class Pair{
		int a; int b;
		Pair(int a, int b){
			this.a =a;
			this.b=b;
		}
	}
	
	static void solve(int start,int cnt){
		if(cnt == que.size()){
			 int check = 0;

			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(visit[i][j]==0 && arr[i][j]==0){
						check++;
					}
				}
			}
			if(check<min){
				min = check;
//				System.out.println(check);
//				 for(int i=0;i<N;i++){
//					for(int j=0;j<M;j++){
//						System.out.print(visit[i][j]+" ");
//					}System.out.println();
//				 }System.out.println();
			}
			return;
		}
			for(int i=start;i<que.size();i++){
				Pair temp = que.get(i);
				int x = temp.a;
				int y = temp.b;
				
				for(int d=0;d<4;d++){
					if(arr[x][y]==1){
						move(x,y,d,1);
						solve(i+1,cnt+1);
						move(x,y,d,-1);
					}else if(arr[x][y]==2){
						move(x,y,d,1);
						move(x,y,(d+2)%4,1);
						solve(i+1,cnt+1);
						move(x,y,d,-1);
						move(x,y,(d+2)%4,-1);
					}else if(arr[x][y]==3){
						move(x,y,d,1);
						move(x,y,(d+1)%4,1);
						solve(i+1,cnt+1);
						move(x,y,d,-1);
						move(x,y,(d+1)%4,-1);
					}else if(arr[x][y]==4){
						move(x,y,d,1);
						move(x,y,(d+1)%4,1);
						move(x,y,(d+2)%4,1);
						solve(i+1,cnt+1);
						move(x,y,d,-1);
						move(x,y,(d+1)%4,-1);
						move(x,y,(d+2)%4,-1);
					}
				
				}
				
			}
			
		}
	
	public static void move(int startX, int startY, int d ,int plus ){
		int x = startX + dir[d][0];
		int y = startY + dir[d][1];
		if(x<0 || y<0 || x>=N || y>=M) return;
		while(arr[x][y] !=6){
			if(arr[x][y]==0){
				visit[x][y] +=plus;
	
			}
			
			x += dir[d][0];
			y += dir[d][1];
			if(x<0 || y<0 || x>=N || y>=M) return;
		}
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
			   if(arr[i][j]!=0 && arr[i][j]!=6 && arr[i][j]!=5){
				   visit[i][j]++;
				   que.add(new Pair(i,j));
			   }
		   }
	   }
	  
	   for(int x=0;x<N;x++){
			for(int y=0;y<M;y++){
				if(arr[x][y]==5){
					visit[x][y] ++;
					   move(x,y,0,1);
					   move(x,y,1,1);
					   move(x,y,2,1);
					   move(x,y,3,1);
				}
			}
		 }
		 
		 
	   solve(0,0);
	   System.out.println(min);

}
}