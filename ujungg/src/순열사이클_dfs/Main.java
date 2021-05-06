package 순열사이클_dfs;

import java.io.*;
import java.util.*;

public class Main {
	public static int[] arr;
	public static int[] visit;
	public static int N;
	public static int cnt =0;
	
	public static void dfs(int start){
		if(visit[start] == 1){
			cnt++;
		}
		if(visit[start] ==0){
			visit[start] = 1;
			dfs(arr[start]);
		}
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st ;
	   
	   st = new StringTokenizer(br.readLine());
	   int T = Integer.parseInt(st.nextToken());
	   int[] total = new int[T+1];
	   for(int t=0;t<T;t++){
		   cnt = 0;
		   st = new StringTokenizer(br.readLine());
		   N = Integer.parseInt(st.nextToken());
		   
		   arr = new int[N+1];
		   visit = new int[N+1];
		   
		   st = new StringTokenizer(br.readLine());
		   for(int i=1;i<=N;i++){
			   arr[i] = Integer.parseInt(st.nextToken());
		   }
		   
		   for(int i=1;i<=N;i++){
			   if(visit[i] ==0){
				   dfs(i);
			   }
		   }
		   System.out.println(cnt);
		  
	   }
	  

}
}