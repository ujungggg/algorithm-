package ��Ȧ;

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
		dist[1] =0;
		
		boolean check = false;
		for(int x=1;x<=N;x++){ // ---? 
//			for(int j=1;j<=N;j++){ //��� ������ ���ؼ� �Ÿ� ���� ����
				
				for(Pair temp : list[x]){ //
					int y = temp.y;
					int value = temp.value;
					
					if( dist[x] + value < dist[y]){
						dist[y] = dist[x] + value;
						check = true;
					}
				}
//			}
			if(!check) break;
		}
		if(check){
			for(int x=1;x<=N;x++){ //��� ������ ���ؼ� �Ÿ� ���� ����
				for(Pair temp : list[x]){ //
					int y = temp.y;
					int value = temp.value;
					
					if( dist[x] + value < dist[y]){
						//���� ���ŵǴ°� �ִٴ� ���� ���� ������ �����Ѵٴ� ��
						return true;
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
		   N = Integer.parseInt(st.nextToken()); // ����
		   int M = Integer.parseInt(st.nextToken()); //����
		   int W = Integer.parseInt(st.nextToken()); //��Ȧ
		   
		   list = new LinkedList[N+1];
		   for(int n=0;n<=N;n++){
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
		   Arrays.fill(dist, Integer.MAX_VALUE);
		   
		   if(bellmanFord()){
			   System.out.println("YES");
		   }else{
			   System.out.println("NO");
		   }
	   }

}
}