package 웜홀2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
 
	static int N;
	static int[] dist;
	static LinkedList<Pair>[] list;
	
	static class Pair{
		int y; int value;
		Pair(int y, int value){
			
			this.y=y;
			this.value=value;
		}
	}
	public static boolean bellmanFord(){
		dist[1] = 0;
		boolean check = false;
//		for(int j=1;j<N;j++){
//			check = false;
//			for(int i=1;i<=N;i++){
//				
//				for(Pair temp : list[i]){
//					int y = temp.y;
//					int value = temp.value;
//					
//					if(dist[i] + value <dist[y]){
//						dist[y] = dist[i] + value;
//						check = true; //한개라도 바뀐것이 있음
//					}
//				}
//			}
//			
//			if(!check) break;
//		}
	
		for(int i=1;i<=N;i++){
			
			for(Pair temp : list[i]){
				int y = temp.y;
				int value = temp.value;
				
				if(dist[i] + value <dist[y]){
					dist[y] = dist[i] + value;
					check = true; //한개라도 바뀐것이 있음
				}
			}
		}
		
		
		if(check){
			for(int i=1;i<=N;i++){
				for(Pair temp : list[i]){
					int y = temp.y;
					int value = temp.value;
					
					if(dist[i] + value < dist[y]){
						return true; //한개라도 바뀐것이 있음 -> 음수가 존재한다는것
					}
				}
			}
		}
		return false;
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   int T = Integer.parseInt(st.nextToken());
	   for(int i=0;i<T;i++){
		   st = new StringTokenizer(br.readLine());
		   N = Integer.parseInt(st.nextToken()); // 지점
		   int M = Integer.parseInt(st.nextToken()); //간선
		   int W = Integer.parseInt(st.nextToken()); //웜홀
		   
		   list = new LinkedList[N+1];
		   for(int n=1;n<=N;n++){
			   list[n] = new LinkedList<>();
		   }
		   int index =0;
		   for(int j=0;j<M+W;j++){
			   st = new StringTokenizer(br.readLine());
			   
			   int a = Integer.parseInt(st.nextToken());
			   int b = Integer.parseInt(st.nextToken());
			   int c = Integer.parseInt(st.nextToken());
			  
			   if(j<M){
				   list[a].add(new Pair(b,c));
				   list[b].add(new Pair(a,c));
			   }else{
				   list[a].add(new Pair(b,c * -1));
			   }
			 
		   }
		   
		   dist = new int[N+1];
		   Arrays.fill(dist, 100000000);
		   
		   if(bellmanFord()){
			   System.out.println("YES");
		   }else{
			   System.out.println("NO");
		   }
	   }

}
}