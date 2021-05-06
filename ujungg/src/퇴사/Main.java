package Επ»η;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] T;
	static int[] P;
	static int max =0;
	
	
   public static void solve(int day, int money){
	 
	if(day> N ){
		max = Math.max(money, max); 
//		System.out.println(max);
		return;
	}else{
		for(int i= day;i<=N;i++){
			if(i+T[i]-1<=N){
				solve(i+T[i],money+P[i]);
			}else{
				max = Math.max(money,max);
			}
		
		}
	}
   }
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st;
   
   N = Integer.parseInt(br.readLine());
   T = new int[N+1];
   P = new int[N+1];
   for(int i=1;i<=N;i++){
	   st = new StringTokenizer(br.readLine());
	   
	   T[i] = Integer.parseInt(st.nextToken());
	   P[i] = Integer.parseInt(st.nextToken());
	   
//	   System.out.println(T[i]);
//	   System.out.println(P[i]);
	   
   }
   
   for(int i=1;i<=N;i++){
	   if(i+T[i]-1<=N){
		   solve(i+T[i], P[i]);
	   }
	  
   }
   System.out.println(max);

}
}