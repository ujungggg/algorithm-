package k��°��;


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
	   int end = K; // ���ϴ� ���� K���� �۰ų� �������ۿ� ����. �ִ� K�� ������ ������ end�� K�� ����
	   
	   int ans = 0;
	   while(start <=end){
		   int mid = (start+end)/ 2;
		   
		   //1. i��°�� ������ mid ���� ���� ���� ������ ����
		   // ���Ϸ��� ���� / i : i������ ���ں��� ���� ������ ������ ���� �� ����  --> 
		   int cnt =0;
		   for(int i=1;i<=N;i++){
			   cnt += Math.min(mid/i, N);
		   }
		   
		   if(cnt >= K ){ // �����ߴ� ���ڴ� K��° ������ ū��
			   ans = mid;
			   end = mid-1;
		   }else if(cnt<K){ //K��°��� �����ߴ� ���ڴ� K��°���� ������
			   start = mid+1;
		   }
	   }
	   
	   System.out.println(ans);
}
}