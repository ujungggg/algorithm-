package 청소년상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr = new int[4][4];
	static int[][] direc = new int[4][4];
	static int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	static int eat = 0;
	static LinkedList<Pair> sharks = new LinkedList<>();
	static LinkedList<Pair> fish = new LinkedList<>();
	
	static class Pair{
		int x; int y; //int d;
	    Pair(int x, int y){
	    	this.x = x;
	    	this.y=y ;
	    	//this.d=d;
	    }
	}
	
	static void solve(){
		
		while(true){
			  for(int i=0;i<4;i++){
				  for(int j=0;j<4;j++){
					  System.out.print(direc[i][j]+" ");
				  }System.out.println();
			  }System.out.println();
			  
			int fish1 = 17; 
			//먹을 fish 찾기 
			  int startFishX =0; int startFishY =0;
			  for(int i=0;i<4;i++){
				  for(int j=0;j<4;j++){
					  if(arr[i][j]<fish1 && arr[i][j]!=0){
						  fish1 = arr[i][j];
						  startFishX = i;
						  startFishY = j;
					  }
				  }
			  }
//			  fish.add(new Pair(startFishX,startFishY));
//			while(!fish.isEmpty()){ //물고기 이동
				 for(int i=0;i<4;i++){
					  for(int j=0;j<4;j++){
						  System.out.print(arr[i][j]+" ");
					  }System.out.println();
				  }System.out.println();
				  
//			     Pair temp = fish.remove();
//			     int startX = temp.x; int startY = temp.y;
//			     int startD = direc[startX][startY];
			   
			     int startD = direc[startFishX][startFishY];
			     int d = startD;
			     int x = startFishX + dir[d][0];
			     int y = startFishY + dir[d][1];
			     
			     boolean flag = true;
			     //이동할수있는곳이 나올때까지 반시계 45각도로 움직인다
			     while(x < 0 || y < 0 || x >=4 || y>=4 || arr[x][y]==0){
			    	 x -= dir[d%7][0];
			    	 y-= dir[d%7][1];
			    	 if(d > startD+7) { 
				    		flag = false; 
				    		break; //이미 7방향을 모두 탐색했을때 반복문 끝나고 물고기도 이동할 곳 없음
				    	}
			    	 d++;
			    	 x += dir[d%7][0];
			    	 y += dir[d%7][1];
			    	 
			     }
			  
			     if(flag){ //물고기가 이동할 방향이 있는 경우만
			    	  fish.add(new Pair(x,y));
					     int temps = arr[startFishX][startFishY];
					     arr[startFishX][startFishY] = arr[x][y];
					     arr[x][y] = temps;
					     
					     direc[startFishX][startFishY] = direc[x][y];
					     direc[x][y] = (d%7) ;//바뀐 방향 넣기
			     }else{
			    	 //없으면 끝남
			    	 return;
			     }
//			}
		}
		
	}
	
	public static void sharksEat(int startX, int startY){
		
		
//		Pair temp = sharks.remove();
//		int startX = temp.x; 
//		int startY = temp.y;
//		int maxFishSize =0;
//		
//		int xx = startX; int yy = startY;
//		int pointX =0; int pointY =0;
//		boolean flags = false;
//		xx += dir[direc[startX][startY]][0];
//		yy += dir[direc[startX][startY]][1];
//		while(xx>=0 && yy >=0 && xx < 4 && yy <4 && arr[xx][yy]!=0){ //범위안에 있고 먹을수 있을때까지
//			flags = true;
//			if(maxFishSize < arr[xx][yy]){
//				maxFishSize = arr[xx][yy];
//				pointX = xx; pointY = yy; //먹을게 최대값인 지점
//			}
//			xx += dir[direc[startX][startY]][0];
//			yy += dir[direc[startX][startY]][1];
//			
//		}
//		
//		if(flags){ //상어가 먹을거가 있을 경우
//			eat += arr[pointX][pointY];
//			arr[pointX][pointY] =0; //먹어서 없앰
////			direc[pointX][pointY] = direc[startX][startY]; //상어의 방향을 원래 있던 칸의 방향과 같게
//			sharks.add(new Pair(pointX,pointY));
//		}else{
//			return;
//		}
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st;
	  
	  for(int i=0;i<4;i++){
		  st = new StringTokenizer(br.readLine());
		  for(int j=0;j<4;j++){
			  arr[i][j] = Integer.parseInt(st.nextToken());
			  direc[i][j] = Integer.parseInt(st.nextToken())-1;
		  }
	  }

	  sharks.add(new Pair(0,0));
	  arr[0][0]=0; //상어가 먹음
	  
//	  int fish1 = 17; 
//	  int startX =0; int startY =0;
//	  for(int i=0;i<4;i++){
//		  for(int j=0;j<4;j++){
//			  if(arr[i][j]<fish1){
//				  fish1 = arr[i][j];
//				  startX = i;
//				  startY = j;
//			  }
//		  }
//	  }
//	  fish.add(new Pair(startX,startY));
	 
	  solve();
	  sharksEat(0,0);
	  System.out.println("eat"+ eat);
}
}