package 순열사이클;

import java.io.*;
import java.util.*;

public class Main {
	public static int[] parent;
	public static class Pair implements Comparable<Pair>{
		int x; int y;
		
		Pair(int x, int y){
			this.x = x; 
			this.y=y;
		}
		
		@Override
		public int compareTo(Pair p){
			return this.x - p.x;
		}
	}
	public static int getFind(int x){
		if(parent[x] == x) return x;
		else return  parent[x] = getFind(parent[x]);
	}
	
	public static void unionFind(int a, int b){
		
		int x = getFind(a);
		int y = getFind(b);
		
		  if(x!=y){
			   if(x<y){
				   parent[y] = x;
			   }else{
				   parent[x] = y;
			   }
		   }
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st ;
	   
	   st = new StringTokenizer(br.readLine());
	   int T = Integer.parseInt(st.nextToken());
	   int[] total = new int[T+1];
	   for(int t=0;t<T;t++){
		   st = new StringTokenizer(br.readLine());
		   int N = Integer.parseInt(st.nextToken());
		   
		   ArrayList<Pair> list = new ArrayList<>();
		   parent = new int[N+1];
		   st = new StringTokenizer(br.readLine());
		   for(int n=1;n<=N;n++){
			   int m = Integer.parseInt(st.nextToken());
			   list.add(new Pair(n,m));
		   }
		   
		   for(int i=1;i<=N;i++){
			   parent[i] = i;
		   }
		   Collections.sort(list);
		   for(int s =0;s<list.size();s++){ //리스트에 있는 경우의 수 돌면서 확인
			   Pair temp = list.get(s);
			   int x= temp.x;
			   int y = temp.y;
			   
			   
			  unionFind(x,y);
			  for(int k =1;k<=N;k++){
				   System.out.print(parent[k]+" ");
			   }System.out.println();
		   }
		   int[] ans = new int[N+1];
		   Arrays.fill(ans, 0);
		   for(int s =1;s<=N;s++){
			   ans[parent[s]]++;
//			   System.out.print(parent[s]+" ");
		   }
		   int cnt =0;
		   
		   int[] visit = new int[N+1];
		   for(int s=1;s<=N;s++){
			   int root = getFind(parent[s]);
			   visit[root]++;
		   }
		   for(int s=1;s<=N;s++){
			   if(visit[s]!=0){
				   cnt++;
			   }
//			   if(ans[s]!=0){
//				   cnt++;
//			   }
		   }
		   System.out.println(cnt);
	   }

}
}