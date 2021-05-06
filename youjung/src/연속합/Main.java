package ¿¬¼ÓÇÕ;
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
	
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		 st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int localMax = arr[0];
		int globalMax = arr[0];
		
		
		for(int i=1;i<N;i++){
			localMax = Math.max(arr[i],  localMax+arr[i]);
			globalMax = Math.max(localMax, globalMax);
		}
		System.out.println(globalMax);
	}
}



