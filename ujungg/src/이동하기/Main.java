package 이동하기;

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
	StringTokenizer st ; 
	
	st = new StringTokenizer(br.readLine());
	int N = Integer.parseInt(st.nextToken());
	int M = Integer.parseInt(st.nextToken());
	
	int[][] arr = new int[N+1][M+1];
	for(int i=1;i<=N;i++){
		st = new StringTokenizer(br.readLine());
		for(int j=1;j<=M;j++){
			arr[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	

	for(int i=1; i<=N;i++){
		for(int j=1;j<=M;j++){
			arr[i][j] += Math.max(arr[i-1][j-1], Math.max(arr[i][j-1], arr[i-1][j]));
		}
	}
	
	System.out.println(arr[N][M]);
}
}