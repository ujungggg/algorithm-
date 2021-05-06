package 보석줍기;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(br.readLine());
			
		}
		
		int cnt =0;
		int localMax = arr[0];
		int globalMax = arr[0];
		
		for(int i=1;i<N;i++){
			localMax = Math.max(localMax+arr[i], arr[i]);
			if(i-1 >= M){
				globalMax = Math.max(localMax, globalMax);
			}
			
		}
		
		if(globalMax >0){
			System.out.println(globalMax);
		}else{
			System.out.println("0");
		}
	}
}



