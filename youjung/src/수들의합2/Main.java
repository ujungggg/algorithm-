package 수들의합2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static long[] sum;
	public static int N;
	public static long M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		arr  =  new int[N+1];
		sum  =  new long[N+1];
		 M = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = (sum[i-1] + arr[i]);
		}
		
		// i~j까지의 합은 sum[j] - sum[i-1]
		int cnt =0;
		for(int j=N ; j>= 1;j--){
			int start = j-1;
			
			while(true){
				if(start < 0) break;
				if(sum[j] - sum[start] == M ) {
					cnt++;
					break;
				}else if(sum[j] - sum[start] > M) break;
				
				start --;
			}
		}
		System.out.println(cnt);
		
	}
}

