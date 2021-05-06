package 아기상어2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] visit;
	static int[][] arr;
	static LinkedList<Pair> list;
	
	static class Pair{
		int x;int y;
		Pair(int x,int y){
			this.x=x;
			this.y=y;
			
		}
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   N = Integer.parseInt(st.nextToken());
	   M = Integer.parseInt(st.nextToken());
	  visit = new int[N][M]; // 거리를 나타내기 위한 배열
	  int[][] check; // 현재 지나갔는지 안지나갔는지 체크하기 위해
	  arr = new int[N][M];
	  list = new LinkedList<>();
	  
	  for(int i=0;i<N;i++){
		  st = new StringTokenizer(br.readLine());
		  for(int j=0;j<M;j++){
			  int num = Integer.parseInt(st.nextToken());
			  arr[i][j] = num;
			  if(num == 1){
				  list.add(new Pair(i,j));
			  }
		  }
	  }
	 
	  LinkedList<Pair> fish = new LinkedList<>();
	  
	  
	  int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
	  for(int s=0;s<list.size();s++){
		  Pair temp = list.get(s);
		  
		  int x = temp.x;
		  int y = temp.y;
		  
		  fish.add(new Pair(x,y));
		  check = new int[N][M];
		  while(!fish.isEmpty()){
			  
			  Pair fishTemp = fish.remove();
			  int tempX = fishTemp.x;
			  int tempY = fishTemp.y;
			  
			  check[tempX][tempY]=1;
			  for(int d=0;d<8;d++){
				  int x1 = tempX+dir[d][0];
				  int y1 = tempY+dir[d][1];
				  
				  if(x1<0 || y1<0 || x1>=N || y1>=M) continue;
				  if(arr[x1][y1]==0 && check[x1][y1]==0){
					  if(visit[x1][y1]==0){
						  visit[x1][y1] = visit[tempX][tempY]+1;
					  }else{
						  visit[x1][y1] = Math.min(visit[x1][y1], visit[tempX][tempY]+1);
					  }
					  check[x1][y1]=1;
					  fish.add(new Pair(x1,y1));
				  }
			  }
		  }
		 
	  }
	  
	  int max =0;
	  for(int i=0;i<N;i++){
		  for(int j=0;j<M;j++){
			 max = Math.max(visit[i][j], max);
		  }
	  }
	  System.out.println(max);
}
}