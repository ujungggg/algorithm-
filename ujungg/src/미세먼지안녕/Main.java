package 미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int[][] visit;
	static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}}; //윗부분 순환 방향
	static int[][] dir2 = {{0,1},{1,0},{0,-1},{-1,0}}; //아래부분 순환 방향
	static int R; static int C; static int T;
	static LinkedList<Pair> queA = new LinkedList<>();
	static LinkedList<Pair> queB= new LinkedList<>();
	static LinkedList<Pair> que= new LinkedList<>();
	
	static class Pair{
		int x; int y;
		Pair(int x, int y){
			this.x = x ;
			this.y = y;
		}
	}
	
	static void solve(int start, int cnt){
		int d =0;
	 while(!queA.isEmpty()){
		 Pair temp = queA.remove();
		 int startX = temp.x;
		 int startY = temp.y;
		 
		
		 int x = startX + dir[d][0];
		 int y = startY  + dir[d][1];
		 if(x<0 || y<0 || x>= R || y>=C){
			 d++;
			 
			 x = startX + dir[d][0];
			 y = startY + dir[d][1];
		 }
		 
		 if(arr[x][y] != -1){
			 visit[x][y] = arr[startX][startY];
			 queA.add(new Pair(x,y));
		 }
	 }
	 
	 d=0;
	 while(!queB.isEmpty()){
		 Pair temp = queB.remove();
		 int startX = temp.x;
		 int startY = temp.y;
		 
		 int x = startX + dir2[d][0];
		 int y = startY  + dir2[d][1];
		 if(x<0 || y<0 || x>= R || y>=C){
			 d++;
			 
			 x = startX + dir2[d][0];
			 y = startY + dir2[d][1];
		 }
		 
		 if(arr[x][y] != -1){
			 visit[x][y] = arr[startX][startY];
			 queB.add(new Pair(x,y));
		 }
	 }
	 
	 
	 for(int i=0;i<R;i++){
		 for(int j=0;j<C;j++){
			 arr[i][j] = visit[i][j];
		 }
	 }
	 
//	  for(int i=0;i<R;i++){
//	  for(int j=0;j<C;j++){
//		System.out.print(arr[i][j]+" ");
//	  }System.out.println();
// }
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st;
	  
	  st = new StringTokenizer(br.readLine());
	  R = Integer.parseInt(st.nextToken());
	  C = Integer.parseInt(st.nextToken());
	  T = Integer.parseInt(st.nextToken());
	   
	  arr = new int[R][C];
	  visit = new int[R][C];
	  
	  for(int i=0;i<R;i++){
		  st = new StringTokenizer(br.readLine());
		  for(int j=0;j<C;j++){
			  arr[i][j] = Integer.parseInt(st.nextToken());
		  }
	  }
	  
	  int t =0;
	  int sx =0 ; int sx2 =0;
	  while(t< T){
		  visit = new int[R][C];
		  int a = 0; int b=0;
		  for(int i=0;i<R;i++){
			  for(int j=0;j<C;j++){
				  if(arr[i][j]==-1){
					  if(queA.size() ==0 && queB.size() ==0){
						  queA.add(new Pair(i,j+1)); //시작점을 넣어줌. 나중에 순환할때 사용하기 위해
						  sx = i;
					  }else{
						  queB.add(new Pair(i,j+1));
						  sx2 = i;
					  }
				  }
			  }
		  }
		  
		  for(int i=0;i<R;i++){
			  for(int j=0;j<C;j++){
				  if(arr[i][j]!=0 && arr[i][j]!=-1){
					  int cnt =0;
					  for(int d=0;d<4;d++){					  
						  int x = i+dir[d][0];
						  int y = j+dir[d][1];
						  
						  if(x<0 || y<0 || x>=R || y>=C) continue;
						  else if(arr[x][y] !=-1){
							  visit[x][y] += (arr[i][j]/5);
							  cnt++;
						  }
					  }
					  visit[i][j] += arr[i][j]- ((arr[i][j]/5) * cnt);
				  }else if(arr[i][j] ==-1){
					  visit[i][j] = -1;
				  }
			  }
		  }
		  
		  for(int i=0;i<R;i++){
			  for(int j=0;j<C;j++){
				  arr[i][j] = visit[i][j];
				 
			  }
		  }
		  visit[sx][1] = 0;
		  visit[sx2][1]=0;
		  
//		  for(int i=0;i<R;i++){
//			  for(int j=0;j<C;j++){
//				System.out.print(arr[i][j]+" ");
//			  }System.out.println();
//		  }System.out.println();
		  solve(0,0);
//		  for(int i=0;i<R;i++){
//			  for(int j=0;j<C;j++){
//				System.out.print(arr[i][j]+" ");
//			  }System.out.println();
//		  }System.out.println();
//		  System.out.println("=================");
		  t++;
	  }
	  
	
	  int cnt =0;
	  for(int i=0;i<R;i++){
		  for(int j=0;j<C;j++){
			  if(arr[i][j] !=-1){
				  cnt += arr[i][j];
			  }
			  
		  }
	  }
System.out.println(cnt);
}
}