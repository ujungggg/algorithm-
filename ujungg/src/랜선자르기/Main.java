package 랜선자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		long N = Integer.parseInt(st.nextToken());
		
		long[] length = new long[K];
		
		long right = 0;
		for(int i=0;i<K;i++){
			length[i] = Integer.parseInt(br.readLine());
			right = Math.max(length[i], right);
		}
		
		long left = 1; 
		long max =0;
		while(left<=right){
			long mid = (left+right)/2;
			
			long count =0;
			for(int i=0;i<K;i++){
				count += (length[i]/mid);
			}
			
			if(count>=N){
				max = Math.max(max, mid);
				left = mid+1;
			}else{ //원하는 랜선 길이보다 적게 나오면 더 작은 값으로 나눠야함
				right = mid-1;
			}
		}
		System.out.println(max);
	}
}