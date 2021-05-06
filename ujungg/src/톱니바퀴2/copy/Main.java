package 톱니바퀴2.copy;


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
	static int N;
	static int M;
	static int[][] arr;
	static int[][] move;
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   N = Integer.parseInt(st.nextToken());
	   
	   arr = new int[N+1][9];
	   for(int i=1;i<=N;i++){
		   String str = br.readLine();
		   for(int j=0;j<8;j++){
			   arr[i][j+1] = str.charAt(j)-48;
		   }
	   }
	   
	   st = new StringTokenizer(br.readLine());
	   M = Integer.parseInt(st.nextToken());
	   
	   move = new int[M][2];
	   for(int i=0;i<M;i++){
		   st = new StringTokenizer(br.readLine());
		   for(int j=0;j<2;j++){
			   move[i][j] = Integer.parseInt(st.nextToken());
		   }
	   }
	   
	   int[][] newArr = new int[N+1][9];
	  
	   for(int i=0;i<M;i++){
		   //1. 톱니바퀴가 -> 방향으로 움직일수 있는지 확인
		   
	   }
} 
}