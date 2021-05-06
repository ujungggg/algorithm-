package 최솟값_세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int[] seg;
	public static int[] arr;
	
	public static int init(int node, int start, int end){
		if(start == end){
			 return seg[node] = arr[start];
		}
		
		int mid = (start+end)/2;
		return seg[node] = Math.min(init(node*2,start,mid), init(node*2+1,mid+1,end));
	}
	
	public static int minFind(int start, int end, int node, int left, int right){
		//범위를 벗어난 경우
		if(right < start || end < left){
			return Integer.MAX_VALUE;
		}
	   // 범위 안에 있는경우
		if(left <= start && end <= right){
			return seg[node];
		}
		int mid = (start+end)/2;
		
		return Math.min(minFind(start, mid,node*2 , left,right),
				minFind(mid+1, end ,node*2 +1 , left,right));
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   int N = Integer.parseInt(st.nextToken());
	   int M = Integer.parseInt(st.nextToken());
	 
	   arr = new int[N];
	   
	   seg = new int[N*4];
	   for(int i=0;i<N;i++){
		   st = new StringTokenizer(br.readLine());
		   arr[i] = Integer.parseInt(st.nextToken());
	   }
	  
	   init(1,0,N-1);
	   
	   for(int i=0;i<M;i++){
		   st = new StringTokenizer(br.readLine());
		   int a= Integer.parseInt(st.nextToken());
		   int b= Integer.parseInt(st.nextToken());
		   
		   int num = minFind(1,N,1,a,b);
		   System.out.println(num);
	   }
}
}