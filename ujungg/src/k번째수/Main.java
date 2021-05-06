package k번째수;


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
	
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   int N = Integer.parseInt(st.nextToken());
	   st = new StringTokenizer(br.readLine());
	   int K = Integer.parseInt(st.nextToken());
	   
	   int start = 1;
	   int end = K; // 원하는 답은 K보다 작거나 같을수밖에 없음. 최대 K가 나오기 때문에 end를 K로 지정
	   
	   int ans = 0;
	   while(start <=end){
		   int mid = (start+end)/ 2;
		   
		   //1. i번째의 열에서 mid 보다 작은 수의 개수를 구함
		   // 구하려는 숫자 / i : i열에서 숫자보다 작은 값들의 개수를 구할 수 있음  --> 
		   int cnt =0;
		   for(int i=1;i<=N;i++){
			   cnt += Math.min(mid/i, N);
		   }
		   
		   if(cnt >= K ){ // 예상했던 숫자는 K번째 수보다 큰수
			   ans = mid;
			   end = mid-1;
		   }else if(cnt<K){ //K번째라고 예상했던 숫자는 K번째보다 작은수
			   start = mid+1;
		   }
	   }
	   
	   System.out.println(ans);
}
}