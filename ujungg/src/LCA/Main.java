package LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

//	static int[] arr;
//	static HashMap<Integer,Integer> hash;
	static LinkedList<Integer>[] list;
	static int[] level ;
	static int[] parent;
	static int ans;
	
	/*
	public static int getParent(int x){
		if(arr[x] == x) {
			if(hash.get(x) != null){
				hash.put(x, hash.get(x)+1);
			}else{
				hash.put(x, 1);
			}
			return x;
		}else{
			if(hash.get(arr[x]) != null){
				hash.put(arr[x], hash.get(arr[x])+1);
			}else{
				hash.put(arr[x], 1);
			}
			
			return getParent(arr[x]);
		}
	}
	*/
	
	public static void solve(int a, int b,int level1, int level2){// level2가 level1이 될때까지
		
		while(level1 != level2){ //level이 같아질때까지
			level2--;
			b = parent[b];
		}
		
		while(a!=b){ //a와 b가 같아질때까지
			a = parent[a];
			b = parent[b];
		}
		
		ans = a;
		
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   int N = Integer.parseInt(br.readLine());
	   list = new LinkedList[N+1];
	   for(int i=1;i<=N;i++){
		   list[i] = new LinkedList<>();
	   }
	   
	   parent = new int[N+1];
	   parent[1] = 1;
	   for(int i=1;i<N;i++){
		   st = new StringTokenizer(br.readLine());
		   int a = Integer.parseInt(st.nextToken());
		   int b = Integer.parseInt(st.nextToken());
		   
		   list[a].add(b);
		   list[b].add(a);
		   
		   
		   //이런식으로 parent를 정해두면 답은 나오지만 시간초과 나옴... (?)
//		   if(a<b){
//			   parent[b] =a ;
//		   }else{
//			   parent[a] = b;
//		   }
		   
	   }
	   
	   LinkedList<Integer> que = new LinkedList<>();
	   
	   que.add(1);
	   
	   level = new int[N+1];
	   level[1] = 1;
	   
	   while(!que.isEmpty()){ //bfs를 사용하여 부모노드와 level을 구해줌
		   int start = que.remove();
		   for(int i : list[start]){
			   
			   if(parent[i]==0){
				   que.add(i);
				   level[i] = level[start]+1;
				   parent[i] = start;
			   }
		   }
	   }
	   
	   int M = Integer.parseInt(br.readLine());
	   for(int i=0;i<M;i++){
		   st = new StringTokenizer(br.readLine());
		   int a = Integer.parseInt(st.nextToken());
		   int b = Integer.parseInt(st.nextToken());
		   
		   int level1 = level[a];
		   int level2 = level[b];
		   
		   if(level1<level2){
			   //level2를 level1에 맞을때까지 
			  solve(a,b,level1,level2);
			   
		   }else{
			   solve(b,a,level2,level1);
		   }
		   System.out.println(ans);
	   }
	   /*
	   arr = new int[N+1];
	   
	  for(int i=1;i<=N;i++){
		 arr[i]  = i;
	 	}
	   for(int i=0;i<N-1;i++){
		   st = new StringTokenizer(br.readLine());
		   int a = Integer.parseInt(st.nextToken());
		   int b = Integer.parseInt(st.nextToken());
		   
		   if(a<b){
			   arr[b] = a;
		   }else{
			   arr[a] = b;
		   }
	   }
	   
//	   for(int i=1;i<=N;i++){
//		   System.out.print(arr[i]+" ");
//	   }System.out.println();
	   int M = Integer.parseInt(br.readLine());
	   for(int i=0;i<M;i++){
		   hash = new HashMap<>();
		   st = new StringTokenizer(br.readLine());
		   int a = Integer.parseInt(st.nextToken());
		   int b = Integer.parseInt(st.nextToken());
		   
		   
		   hash.put(a,1);
		   getParent(a);
		   
		   hash.put(b,1);
		   getParent(b);
		   
		   // 1. hash에 타고 타고 넘어가는 경우를 다 넣고, 중복으로 겹치는게 2번 나왔을때의 최대값이 가장 가까운 공통 조상
		   int max =0;
		   for(int k: hash.keySet()){
			   if(hash.get(k) > 1){
				   max = Math.max(max, k);
			   }
		   }
		   System.out.println(max);
		   System.out.println("------------");
	   }
	   */
	   
	   
	   
	   
	   
}
}