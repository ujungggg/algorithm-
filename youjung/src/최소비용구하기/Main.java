package 최소비용구하기;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int N, end;
	public static int[][] arr;
	public static int[] dist;
	public static PriorityQueue<Pair> list = new PriorityQueue<>();
	
	public static class Pair{
		int x; int value;
		Pair(int x, int value){
			this.x=x;
			this.value=value;
		}
		
	}
	
	public static void solve(){
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		dist = new int[N+1];
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=N;i++){
			Arrays.fill(arr[i], 1000000001);
		}
		
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(arr[a][b] > c){
				arr[a][b] = c;
			}
			
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		
		list.add(new Pair(start,0));
		Arrays.fill(dist, 1000000001);
		
		dist[start] = 0;
		while(!list.isEmpty()){
//			int starts = list.remove();
			Pair temp = list.remove();
			int starts = temp.x;
		
			
			if(starts == end) break;
			for(int i=1; i<=N; i++){
					if(dist[starts] + arr[starts][i] < dist[i]){
						dist[i] = dist[starts] + arr[starts][i];
						list.add(new Pair(i,dist[i]));
					}
				
			}
			
//			Collections.sort(list);
		}
		
		System.out.println(dist[end]);
	}
}

