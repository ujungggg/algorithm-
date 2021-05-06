package 직사각형탈출;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
   static int N; static int M;
   static int H; static int W;
   static int[][] arr;
   static int[][] visit;
   static int [][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
   static int endX; static int endY;
   static LinkedList<Pair> list;
   static int min =1000000000;
   static class Pair{
	   int x; int y; int cnt;
	   Pair(int x, int y,int cnt){
		   this.x=x;
		   this.y=y;
		   this.cnt = cnt;
	   }
   }
   
   public static void solve(){
	 
	   while(!list.isEmpty()){
		   Pair temp = list.poll();
		   int x = temp.x;
		   int y = temp.y;
		   int cnt = temp.cnt;
		   
		   if( x== endX && y== endY){
			   min = Math.min(min, cnt);
			   break;
		   }
		   
		 /*
		   for(int d=0;d<4;d++){
			   boolean flag = false;; //H,W 범위내에 1이 없는지 카운트
			   for(int a=0;a<H;a++){
				   for(int b=0;b<W;b++){
					   int tempX = x + a+ dir[d][0];
					   int tempY = y + b+ dir[d][1];
					   
					   if(tempX<=0 || tempY<=0 || tempX >N || tempY >M) {
						   flag = true;
						   break;
					   }
					   if(arr[tempX][tempY]==1) {
						   flag = true;
						   break;
					   }
					   
					   
				   }
			   }
			   
			   if(!flag) {
				   if(x + dir[d][0] == endX && y+ dir[d][1] == endY ) {
					   min = Math.min(min, cnt+1);
					   break;
				   }
				   if( visit[x+dir[d][0]][y+dir[d][1]] ==0){
					   visit[x+dir[d][0]][y+dir[d][1]] = 1;
					   list.add(new Pair(x + dir[d][0], y+ dir[d][1], cnt+1));
				   }
				  
				   
			   }
		   }
		   */
		   
		   for(int d=0;d<4;d++){
			   int tempX = x + dir[d][0];
			   int tempY = y + dir[d][1];
			   
			   if(tempX<=0 || tempY<=0 || tempX >N || tempY >M) continue;
			   if(arr[tempX][tempY]==1) continue;
			   
			   if(visit[tempX][tempY]==0 && check(x,y,d)){
				   
				   visit[tempX][tempY] = 1;
				   list.add(new Pair(tempX,tempY,cnt+1));
			   }
		   }
		  
	   }
   }
   
   public static boolean check(int x, int y, int d){
	   for(int a=0;a<H;a++){
		   for(int b=0;b<W;b++){
			   int tempX = x + a+ dir[d][0];
			   int tempY = y + b+ dir[d][1];
			   
			   if(tempX<=0 || tempY<=0 || tempX >N || tempY >M) return false;
			   if(arr[tempX][tempY]==1) return false;
			   
			 
		   }
	   }
	   return true;
   }
   public static void dfs(int startX, int startY, int cnt){
	   if(startX == endX && startY == endY){
		   System.out.println(cnt);
		   min = Math.min(min, cnt);
		   return;
	   }else{
		   for(int d=0;d<4;d++){
			   boolean flag = false;; //H,W 범위내에 1이 없는지 카운트
			   for(int a=0;a<H;a++){
				   for(int b=0;b<W;b++){
					   int tempX = startX + a + dir[d][0];
					   int tempY = startY + b + dir[d][1];
					   
					   if(tempX<=0 || tempY<=0 || tempX >N || tempY >M) continue;
					   if(arr[tempX][tempY]==1) return;
					   if(visit[tempX][tempY] == 1) return;
				   }
			   }
			   visit[startX+dir[d][0]][startY+dir[d][1]] = 1;
			   dfs(startX+dir[d][0],startY+dir[d][1],cnt+1);
			   visit[startX+dir[d][0]][startY+dir[d][1]] = 0;
		   }
	   }
   }
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   
	   N = Integer.parseInt(st.nextToken());
	   M = Integer.parseInt(st.nextToken());
	   
	   arr = new int[N+1][M+1];
	   visit = new int[N+1][M+1];
	   for(int i=1;i<=N;i++){
		   st = new StringTokenizer(br.readLine());
		   for(int j=1;j<=M;j++){
			   arr[i][j] = Integer.parseInt(st.nextToken());
		   }
	   }
	   
	   st = new StringTokenizer(br.readLine());
	   
	   H = Integer.parseInt(st.nextToken());
	   W = Integer.parseInt(st.nextToken());
	   
	   int startX = Integer.parseInt(st.nextToken());
	   int startY = Integer.parseInt(st.nextToken());
	   
	   endX = Integer.parseInt(st.nextToken());
	   endY = Integer.parseInt(st.nextToken());
	   
	   list = new LinkedList<>();
	   list.add(new Pair(startX,startY,0));
	   
	   visit[startX][startY] = 1;
	   solve();
	   if(min == 1000000000){
		   System.out.println("-1");
	   }else{
		   System.out.println(min);
	   }
//	   visit[startX][startY]=1;
//	   dfs(startX, startY,0);
	  
   }
}