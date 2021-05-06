package 청소년상어.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.print.StreamPrintService;

public class Main {
	
	static int[][] firstArr = new int[4][4];
	static int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	static int max =0;
	static Pair[] firstFish = new Pair[17];
	static LinkedList<Pair> sharks = new LinkedList<>();
	static class Pair{
		int x; int y; int d;
		Pair(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	static void dfs(int[][] firstArr, Pair[] firstFish, int eat){
		int[][] arr = new int[4][4];
		for(int k=0;k<4;k++){
			 System.arraycopy(firstArr[k], 0, arr[k], 0, 4);
		}
		
		Pair[] fish = new Pair[17];
		for(int i=1;i<=16;i++){
			fish[i] = new Pair(firstFish[i].x, firstFish[i].y, firstFish[i].d);
		}
		boolean check = false;
		for(int i=1;i<=16;i++){ //물고기의 순서대로 움직인다.
			for(int a=0;a<4;a++){
				for(int j=0;j<4;j++){
					System.out.print(arr[a][j]+" ");
				}System.out.println();
			}
			System.out.println();
			int startX = fish[i].x;
			int startY = fish[i].y;
			int startD =  fish[i].d;
			System.out.println("이번 차례!!!!!!!!"+i);
			if(startD != -1){ //이미 먹은 물고기가 아닐때
				check = true;
				int d =startD;
				int x = startX + dir[d][0];
				int y = startY +dir[d][1];
				
				boolean flag = true;
			     //이동할수있는곳이 나올때까지 반시계 45각도로 움직인다
				
				
				 while(x < 0 || y < 0 || x >=4 || y>=4 || arr[x][y] == -1){ // -1은 상어일경우
			    	 x -= dir[d%8][0];
			    	 y-= dir[d%8][1];
			    	 if(d > startD+7) { 
				    		flag = false; 
				    		break; //이미 7방향을 모두 탐색했을때 반복문 끝나고 물고기도 이동할 곳 없음
				    	}
			    	 d++;
			    	 x += dir[d%8][0];
			    	 y += dir[d%8][1];
			    	 
			     }
				 
				 if(flag){ //물고기가 이동할 방향이 있는 경우만
					 if( arr[x][y]==0){ //옮길 방향이 빈칸이면 그냥 거기로 들어감
						 fish[arr[startX][startY]] = new Pair(x,y,d%8); //새로운 좌표값
						
						 arr[x][y]= arr[startX][startY]; //옮기는 자리에 값 넣어주고
						 arr[startX][startY]=0; // 빈값 (상어가 먹은 자리)
						 
					 }else if(arr[x][y]>0){ //옮길 방향에 물고기가 있으면
						 fish[arr[startX][startY]] = new Pair(x,y,d%8); //좌표와 방향 바꿔줌
					     fish[arr[x][y]] = new Pair(startX,startY,fish[arr[x][y]].d);
					     
					     int temps = arr[startX][startY];
					     arr[startX][startY] = arr[x][y];
					     arr[x][y] = temps; //좌표 바꾸고 
					 }
				    
			     }
			}
			
		}
			
		Pair temp = sharks.remove();
		int startX = temp.x; 
		int startY = temp.y;
		int sharksDir = temp.d;
		
		boolean eatCheck = false;
		for(int i=1;i<=4;i++){ //4칸이 최대니까 
			int sx = startX + (dir[sharksDir][0] * i);
			int sy = startY + (dir[sharksDir][1] * i);	
			
			if(sx >=0 && sy>=0 && sx < 4 && sy <4){
				if(arr[sx][sy] >0 ){
					//여기 있는 물고기 먹음
					eatCheck = true;
					int changeDir = fish[arr[sx][sy]].d; //원래 그 자리에 있던 물고기의 방향
					sharks.add(new Pair(sx,sy,changeDir)); //상어의 방향도 바꿔줘야함
					int nowEat = arr[sx][sy];
					fish[arr[sx][sy]] = new Pair(0,0,-1); // 상어가 먹은애는 -1로 처리
					arr[sx][sy] = -1; //상어의 현재 위치는 -1로 구분
					arr[startX][startY]=0; //상어가 원래 있던 자리는 빈자리로 바뀜
					
//					System.out.println("먹은 물고기"+ (eat + nowEat));
					dfs(arr,fish, eat+nowEat );
					for(int a=0;a<4;a++){
					for(int j=0;j<4;j++){
						System.out.print(arr[a][j]+" ");
					}System.out.println();
				}
					
					arr[startX][startY] =-1;
					arr[sx][sy] = nowEat;
					fish[arr[sx][sy]] = new Pair(sx,sy,changeDir); //원상복귀
				}
			}
		}

		if(!eatCheck){
//			System.out.println("eat!!!!!!!!!!"+eat);
			max = Math.max(max, eat);
		}
		
			
	
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st;
	  int[][] direc = new int[4][4];
	  for(int i=0;i<4;i++){
		  st = new StringTokenizer(br.readLine());
		  for(int j=0;j<4;j++){
			  int fishSize = Integer.parseInt(st.nextToken());
			  int fishDir = Integer.parseInt(st.nextToken())-1;
			  
			  firstFish[fishSize] = new Pair(i,j,fishDir); //fish배열에 좌표 넣어줌 (순서 크기대로 들어가게됨)
			  firstArr[i][j] = fishSize;
			  direc[i][j] = fishDir;
		  }
	  }

	  int eat = firstArr[0][0];
	  int sharksDir = firstFish[firstArr[0][0]].d;
	  sharks.add(new Pair(0,0,sharksDir));
	  firstFish[firstArr[0][0]]  = new Pair(0,0,-1); //0,0에 있던 fish는 먹음 처리 당함 (-1로 먹은거 표시함)
	  firstArr[0][0] = -1; // 상어가 먹음
//	  for(int i=0;i<4;i++){
//		  for(int j=0;j<4;j++){
//			  System.out.print(direc[i][j]+ " ");
//		  }System.out.println();
//	  }
	  dfs(firstArr, firstFish, eat);
	  System.out.println(max);
	
}
}