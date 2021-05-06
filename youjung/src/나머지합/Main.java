package 나머지합;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		long[] sum = new long[N];
		long[] cnt = new long[N];
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sum[0] = arr[0];
		cnt[0] = sum[0] % M;
		for(int i=1;i<N;i++){
			sum[i] = sum[i-1] + arr[i];
			cnt[i] = sum[i] %M;
		}
		
		long[] total = new long[M];
		
		for(int i=0;i<N;i++){
			total[(int) cnt[i]] ++;
		}
		
		long tot = total[0];
		for(int i=0;i<M;i++){
			tot += ((total[i] * (total[i]-1))/2);
		}
		
		System.out.println(tot);
	}
}

