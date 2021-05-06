package 파이프옮기기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int cnt=0;
	static int N;
	static int[][] arr;
	static int[][][] visit;
	static LinkedList<Pair> list;
	static int[][] dir= {{0,1},{1,1},{1,0}};
	static class Pair{
//		int x1; int y1; 
		int x2; int y2;
		int d;
		
//		Pair(int x1,int y1,int x2,int y2,int d){
		Pair(int x2,int y2,int d){
//			this.x1=x1;
//			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
			this.d=d;
		}
	}
	
//	public static void pushList(int x1,int y1,int x2,int y2,int newD){
	public static void pushList(int x2,int y2,int newD){
//		int newX1 = x2;
//		int newY1 = y2;
		int newX2 = x2 + dir[newD][0];
		int newY2 = y2+ dir[newD][1];
		
		
		if(newX2<0 || newY2<0 || newX2>=N || newY2>=N ) return;
		
		if(newD == 1){ // 대각선일때는 왼쪽 위쪽 방향 따로 생각해줘야함
			//위쪽 방향
			int tempX = newX2-1;
			if(tempX>=0){ // 범위 안에 있는데
				if(arr[tempX][newY2] !=0){ //그값이 벽이라면 끝냄
					return;
				}
			}
			
			//왼쪽방향 
			int tempY = newY2 -1;
			if(tempY>=0){
				if(arr[newX2][tempY] !=0){
					return;
				}
			}
		}
	
		
//		if(visit[newX2][newY2][newD]==0 && arr[newX1][newY1]==0 &&  arr[newX2][newY2]==0){
		if(arr[newX2][newY2]==0){
//			visit[newX2][newY2][newD] =1;
			list.add(new Pair(newX2,newY2,newD));
		}
	}
	public static boolean isPossible(int x2, int y2,int newD){
		int newX2 = x2 + dir[newD][0];
		int newY2 = y2+ dir[newD][1];
		
		if(newX2<0 || newY2<0 || newX2>=N || newY2>=N ) return false;
		
		if(newD == 1){ // 대각선일때는 왼쪽 위쪽 방향 따로 생각해줘야함
			//위쪽 방향
			int tempX = newX2-1;
			if(tempX>=0){ // 범위 안에 있는데
				if(arr[tempX][newY2] !=0){ //그값이 벽이라면 끝냄
					return false;
				}
			}
			
			//왼쪽방향 
			int tempY = newY2 -1;
			if(tempY>=0){
				if(arr[newX2][tempY] !=0){
					return false;
				}
			}
		}
		
		if(arr[newX2][newY2]!=0){
			return false;
		}
		return true;
	}
	public static void solve(){
		while(!list.isEmpty()){
			Pair temp = list.remove();
//			int x1 = temp.x1;
//			int y1 = temp.y1;
			int x2 = temp.x2;
			int y2 = temp.y2;
			int d = temp.d;
			if(x2 == N-1 && y2 ==N-1 && arr[x2][y2]==0) {
				cnt++;
				continue;
			}

			 //0 -> 0,1 
			 //1-> 0,1,2
			 //2 -> 1,2
			
			for(int di =0;di<3;di++){
				if(d==0 && di==2) continue;
				if(d==2 && di==0) continue;
//				pushList(x1,y1,x2,y2,di);
//				pushList(x2,y2,di);
				if(isPossible(x2,y2,di)){
					list.add(new Pair(x2+dir[di][0],y2+dir[di][1],di));
				}
			}
			/*
			int newD = 0;
			if(d==0){
				newD = 0;
				pushList(x1,y1,x2,y2,newD);
				newD = 1;
				pushList(x1,y1,x2,y2,newD);
				
			}else if(d==1){
				newD = 0;
				pushList(x1,y1,x2,y2,newD);
				newD = 1;
				pushList(x1,y1,x2,y2,newD);
				newD = 2;
				pushList(x1,y1,x2,y2,newD);
			}else if(d==2){
				newD = 1;
				pushList(x1,y1,x2,y2,newD);
				newD = 2;
				pushList(x1,y1,x2,y2,newD);
			}
			*/
		}
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   N = Integer.parseInt(st.nextToken());
	   arr = new int[N][N];
	   visit = new int[N][N][3]; //방향성을 추가
	   for(int i=0;i<N;i++){
		   st = new StringTokenizer(br.readLine());
		   for(int j =0;j<N;j++){
			   arr[i][j] = Integer.parseInt(st.nextToken());
		   }
	   }
	   list = new LinkedList<>();
	   
	   
	   list.add(new Pair(0,1,0));
	  
	  
	   solve();
	   System.out.println(cnt);
}
}