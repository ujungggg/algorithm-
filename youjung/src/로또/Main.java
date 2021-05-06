package ·Î¶Ç;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	static int[] visit;
	
	public static void solve(int start,int cnt){
		if(cnt == 6){
			for(int i=0; i<6; i++){
				System.out.print(visit[i]+" ");
			}System.out.println();
		}else{
			for(int i = start;i<N;i++){
				visit[cnt] = arr[i];
				solve(i+1, cnt+1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true){
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			if(N==0) break;
			visit = new int[6];
				
			arr = new int[N];
			
			for(int i=0;i<N;i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			solve(0,0);
			System.out.println();
		}
		
		
		
	}
}

