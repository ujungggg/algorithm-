package 부분수열의합_브루트포스;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static boolean[] visit = new boolean[100000000];
	static int N;
	static int max = 0;
	static public void solve(int start, int cnt, int total){
		if(cnt>0 && cnt <= N ){
//			System.out.println(total);
			max = Math.max(max, total);
			visit[total] = true;
		}
		
		for(int i=start;i<N;i++){
			solve(i+1,cnt+1,total+arr[i]);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){	
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0,0,0);
//		System.out.println(max);
		boolean flag = false;
		for(int i=1;i<=max;i++){
			if(!visit[i]){
				System.out.println(i);
				flag = true;
				break;
			}
		}
		if(!flag){
			System.out.println(max+1);
		}
		
		
	}
}

