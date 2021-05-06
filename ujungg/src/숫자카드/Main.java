package 숫자카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean binarySearch(int N, int[] list,int num){
		
			int start = 0;
			int fin = N-1;
			
			while(true){
				int mid = (start+fin)/2 ;
				if(start > fin) {
					return false;
				}
				if(num == list[mid]){
					return true;
				}else if(num > list[mid]){
					start = mid + 1;
				}else if(num < list[mid]){
					fin = mid - 1;
				}
			}
			
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] list = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Integer> answer = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++){
			
			boolean ans = binarySearch(N, list, Integer.parseInt(st.nextToken()));
			if(ans){
				System.out.print("1 ");
			}else{
				System.out.print("0 ");
			}
		}
		
		
	}
}