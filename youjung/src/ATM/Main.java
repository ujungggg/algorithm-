package ATM;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int[] visit;
	static int[] check;
	static int N;
	static int min = 1000000000;
	public static void solve(int start,int cnt){
		if(cnt == N+1){
			int count =0; int total =0;
			for(int i=1;i<=N;i++){
//				System.out.print(visit[i]+" ");
				count += arr[visit[i]];
				total += count;
			}
//			System.out.println();
			min = Math.min(total, min);
			return;
		}else{
			for(int i=1;i<=N;i++){
				if(check[i] ==0){
					check[i] = 1;
					visit[cnt] = i;
					solve(i+1, cnt+1);
					check[i] =0;
				}
				
				
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
	
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		visit = new int[N+1];
		check = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		solve(1,1);
		Arrays.sort(arr);
		int count =0;
		int total =0;
		for(int i=1;i<=N;i++){
			count +=arr[i];
			total+= count;
		}
		System.out.println(total);
	}
}

