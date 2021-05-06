package 숨바꼭질4_bfs_시간초과주의;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int K;
	public static int[] dir = {1,-1};
	public static int[] visit = new int[200001];
	public static int min = 1000000000;
	public static LinkedList<Pair> list = new LinkedList<>();
	public static Stack<Integer> times = new Stack<>();
	static class Pair{
		int x; int time;
		Pair(int x, int time){
			this.x=x;
			this.time= time;
		}
	}
	public static void getRoute(int point){
		
//		System.out.println(point);
		times.push(point);
		if(point == N) return;
		
		getRoute(visit[point]);
	}
	public static void solve(){
		while(!list.isEmpty()){
			
			Pair temp = list.remove();
			int x= temp.x;
			int time = temp.time;
			
			if(x==K){
//				System.out.println(min);
				min = Math.min(min, time);
				getRoute(x);
				return;
			}
			if(x+1 <=100000 && visit[x+1] == -1){
				visit[x+1] = x;
				list.add(new Pair(x+1,time+1));
			}
			if(x-1 <=100000 && x-1>=0 && visit[x-1]== -1){
				visit[x-1]= x;
				list.add(new Pair(x-1,time+1));
			}
			if(x*2 <=100000 && visit[x*2] ==-1){
				
				visit[x*2]= x;
				list.add(new Pair(x*2,time+1));
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Arrays.fill(visit, -1);
		visit[N] = N;
		list.add(new Pair(N,0));
		solve(); //시작점
		System.out.println(min);
//		for(int s=times.size()-1 ; s>=0 ;s--){
//			System.out.print(times.get(s)+" ");
//		}
		while(!times.isEmpty()){
			System.out.print(times.pop()+" ");
		}
	}
}

