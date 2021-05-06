package ��Ϲ���2;


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
	   for(int i=0;i<M;i++){ //M����ŭ ��Ϲ����� ����
		   int start = move[i][0];
		   int dir = move[i][1]*-1;
		   
		   int before = -1;
		   int now = 0;
		   boolean[] flag = new boolean[N+1];
		   Arrays.fill(flag, false);
		   int newStart = start;
		   while(newStart<=N){ // -> �������� ��Ϲ��� ����
//			   boolean flag = false;
			   if(newStart%2 ==0){ //¦����°�� �ִ°Ÿ� arr[newStart][6]��°�� Ȯ��
				   now = arr[newStart][7];
			   }else{ //arr[newStart][3] Ȯ��
				   now = arr[newStart][3];
			   }
			   
			   if(before == -1 || now!=before){ // ó�������Ҷ��ų�, ���ڰ� �ٸ����� �̵�
				   flag[newStart] = true;
				   before = now;
				   dir*=-1;
			   }else{ //�������� ������ �� �ķε� �������� ����
				  
				   break;
			   }
			   
			   for(int a=1;a<=8;a++){
				   int next = a+(dir);
				   if(next == 0){ next = 8 ; }
				   else if(next == 9){next = 1;}
				   newArr[newStart][next] = arr[newStart][a];
			   }
//			   if(!flag){
//				   for(int b=1;b<=8;b++){
//					   arr[newStart][b]= newArr[newStart][b]; //������ ������ ���� �迭�� ����
//				   }   
//			   }
//			   for(int a=1;a<=N;a++){
//				   for(int b=1;b<=8;b++){
//					   System.out.print(arr[a][b]+" ");
//				   }System.out.println();
//			   }System.out.println();
//			   System.out.println();
			   newStart ++;
		   }
		   
		   newStart = start-1;
		   dir = move[i][1];
		   if(newStart%2 ==0){ //¦����°�� �ִ°Ÿ� arr[start][6]��°�� Ȯ��
			   before = arr[newStart+1][3];
		   }else{ //arr[newStart][3] Ȯ��
			   before = arr[newStart+1][7];
		   }
		   while(newStart>0){ // <- �������� ��Ϲ��� ����
//			   boolean flag = false;
			   if(newStart%2 ==0){ //¦����°�� �ִ°Ÿ� arr[start][6]��°�� Ȯ��
				   now = arr[newStart][7];
			   }else{ //arr[newStart][3] Ȯ��
				   now = arr[newStart][3];
			   }
			   
			   if(now!=before){ // ó�������Ҷ��ų�, ���ڰ� �ٸ����� �̵�
				   flag[newStart] = true;
				   before = now;
			   }else{ //�������� ������ �� �ķε� �������� ����
				  
				   break;
			   }
			   
			   for(int a=1;a<=8;a++){
				   int next = a+(dir*-1);
				   if(next == 0){ next = 8 ; }
				   else if(next == 9){next = 1;}
				   newArr[newStart][next] = arr[newStart][a];
			   }
//			   if(!flag){
//				   for(int b=1;b<=8;b++){
//					   arr[newStart][b]= newArr[newStart][b]; //������ ������ ���� �迭�� ����
//				   }  
//			   }
			   newStart --;
		   }
		   for(int k=1;k<=N;k++){
			   if(flag[k]){
				   for(int b=1;b<=8;b++){
					   arr[k][b]= newArr[k][b]; //������ ������ ���� �迭�� ����
				   }
			   }
		   }
		   for(int a=1;a<=N;a++){
			   for(int b=1;b<=8;b++){
				   System.out.print(arr[a][b]+" ");
			   }System.out.println();
		   }System.out.println();
	   }
	   int cnt =0;
	   for(int a=1;a<=N;a++){
		   if(arr[a][1] == 1){
			   cnt++;   
		   }
	   }
	  System.out.println(cnt);
} 
}