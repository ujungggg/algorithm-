package 구간합구하기2_세그먼트트리_업데이트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static long[] seg, arr,lazy;
	
	public static long setInit(int node, int start, int end){
		if(start == end){
			return seg[node] = arr[start];
		}
		int mid = (start+end)/2;
		
		return seg[node] = setInit(node*2, start,mid) + setInit(node*2+1, mid+1, end);
	}
	public static void lazyUpdate(int node, int start, int end){
		if(lazy[node]!=0){
			seg[node] += (end-start+1)* lazy[node];
			
			//leaf- node가 아니라면 lazy를 아래로 넘겨줌
			if(start!=end){
				lazy[node*2] += lazy[node];
				lazy[node*2+1] +=lazy[node];
			}
			
			//현재의 노드의 lazy는 지워줌
			lazy[node] = 0;
		}
	}
	public static void update(int node, int start, int end, int left, int right, long d){
		lazyUpdate(node,start,end);
		
		//범위 밖에 있는 경우
		if(end < left || start > right){
			return;
		}
		
		//범위가 포함될때
		if(left<=start && right>=end){
			seg[node] += (end-start+1)*d;
			//리프노드가 아니면 lazy 넘겨주기
			if(start!=end){
				lazy[node*2] += d;
				lazy[node*2+1] +=d;
				
			}
			return;
		}
		
		int mid = (start+end)/2;
		
		update(node*2, start, mid, left,right,d);
		update(node*2+1, mid+1, end, left,right,d);
		seg[node] = seg[node*2]+seg[node*2+1];


	}
	
	//fist-last: 구하려고 하는 범위
	//start, end: 현재 구간의 시작-끝
	public static long getSum(int start, int end, int node, int left, int right){
		lazyUpdate(node,start,end);
		
		//범위 밖에 있는 경우
		if(left > end || right <start ) return 0;
		
		if(left<= start && end <= right) return seg[node];
		
		int mid = (start + end)/2;
		return getSum(start,mid,node*2,left,right) + getSum(mid+1, end ,node*2+1 ,left,right);
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   int N = Integer.parseInt(st.nextToken());
	   int M = Integer.parseInt(st.nextToken());
	   int K = Integer.parseInt(st.nextToken());
	   
	   arr = new long[N+1];
	   seg = new long[N*4];
	   lazy = new long[N*4];
	   for(int i=1;i<=N;i++){
		   arr[i] = Long.parseLong(br.readLine());
	   }
	   
	   setInit(1,1,N);
	   
	   
	   for(int i=0;i<M+K;i++){
		   st = new StringTokenizer(br.readLine());
		   int a = Integer.parseInt(st.nextToken());
		   if(a==1){
			   int b = Integer.parseInt(st.nextToken());
			   int c = Integer.parseInt(st.nextToken());
			   long d = Long.parseLong(st.nextToken());
			   
			   //b부터 c까지 d값만큼 더해라
			   update(1,1,N,b,c,d);
		   }else if(a==2){
			   int b = Integer.parseInt(st.nextToken());
			   int c = Integer.parseInt(st.nextToken());
			   
			   long sum = getSum(1,N,1,b,c);
			   System.out.println(sum);
		   }
	   }
	  
	  
}
}