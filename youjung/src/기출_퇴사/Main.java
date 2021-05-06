package ±âÃâ_Åð»ç;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int max =0;
	static int[] value;
	
	public static void solve(int start, int total){
//		if(start >= N){
////			System.out.println(max);
//			max = Math.max(total, max);
//			return;
//		}else{
			for(int i = start; i<N;i++){
				if(i + arr[0][i] <= N){
					solve(i+arr[0][i], total+arr[1][i]);
				}
			}
			max = Math.max(total, max);
//		}
	}
	
	public static void dp(int now){
		for(int i=now;i<N;i++){
			int next = i+ arr[0][i];
			if(next <= N){
				if(value[next] < value[i] + arr[1][i]){
					value[next] = value[i] +arr[1][i];
					dp(next);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[2][N];
		value = new int [N+1];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			arr[0][i] = T;
			arr[1][i] = P;
		}
		
//		for(int i=0;i<N;i++){
//			if(i+ arr[0][i]<=N){
//				solve(i+arr[0][i], arr[1][i]);
//			}
//			
//		}
		for(int i=0;i<N;i++){
			int next = i+ arr[0][i];
			if(next <= N){
				if(value[next] < value[i] + arr[1][i]){
					value[next] = value[i] +arr[1][i];
					dp(next);
				}
				
			}
		}
		for(int i=0;i<=N;i++){
			System.out.print(value[i]+" ");
			max = Math.max(value[i], max);
		}
		System.out.println();
		System.out.println(max);
	}
}

