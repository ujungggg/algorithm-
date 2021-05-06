package 나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   
	   int N = Integer.parseInt(st.nextToken());
	   long M = Long.parseLong(st.nextToken());
	   
	   long[] arr = new long[N];
	   st = new StringTokenizer(br.readLine());
	   long end = 0;
	  
	   for(int i=0;i<N;i++){
		   arr[i] = Long.parseLong(st.nextToken());
		   end   = Math.max(end,arr[i]); 
	   }
	   
	   long start =0;
	   long ans = 0;
	   long mid =0;
	   while(start<=end){
		   mid = (start + end)/2;
		   long cutTree = 0;
		   for(int i=0;i<N;i++){
			   if(arr[i]>=mid){
				   cutTree += (arr[i]-mid);
//				   if(cutTree > M){
//					   break;
//				   }
			   }
			  
		   }
		   
		   if(cutTree == M){
			   end = mid;
			   break;
		   }
//		   else 
			   if(cutTree >= M){ //너무 많이 자른거니까 mid값 중가
			   start = mid +1;
		   }else if(cutTree <M){ // 더 잘라야하니까 mid 값 감소
			   end = mid-1;
		   }
	   }
	   
	   System.out.println(end);

}
}