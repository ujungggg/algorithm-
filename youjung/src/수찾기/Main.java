package ¼öÃ£±â;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Arrays.sort(arr);
		for(int i=0;i<M;i++){
			int num = Integer.parseInt(st.nextToken());
			
			 	int answer = 0;
		        int l = 0;
		        int r = N - 1;
		        while (l <= r) {
		            int m = (l + r) / 2;
		            
		            if (arr[m] > num) {
		                r = m - 1;
		            } 
		            else {
		                l = m + 1;
		                answer = m;
		            }
		        }
		        if(arr[answer] == num){
		        	System.out.println("1");
		        }else{
		        	System.out.println("0");
		        }
//		        System.out.println(answer);
//		        if(l!=0){
//		        	System.out.println("1");
//		        }else{
//		        	System.out.println("0");
//		        }
		       
		}
	}
}

