package ¼û¹Ù²ÀÁú1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int K;
	static int[] visit;
	static LinkedList<Pair> list;
	static int min =1000000000;
	static int finalTime = 0;
	static int count = 0;
	static class Pair{
		int x; int time;
		Pair(int x, int time){
			this.x=x;
			this.time =time;
		}
	}
	public static void solve(){
		while(!list.isEmpty()){
			Pair temp = list.remove();
			int x =temp.x;
			int time = temp.time;
			if(time < min){
				if(x == K) {
					min = Math.min(time, min);
				}
				visit[x] = 1;
				if(x+1<=100000 && visit[x+1] ==0){
//					visit[x+1] = 1;
					list.add(new Pair(x+1,time+1));
				}
				if(x-1 >= 0 && visit[x-1]==0){
//					visit[x-1] = 1;
					list.add(new Pair(x-1,time+1));
				}
				if(x*2<=100000 && visit[x*2] ==0){
//					visit[x*2] = 1;
					list.add(new Pair(x*2,time));
				}
			}
		}
	}
   public static void main(String[] args) throws NumberFormatException, IOException {

	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   N= Integer.parseInt(st.nextToken());
	   K = Integer.parseInt(st.nextToken());
	   list = new LinkedList<>();
	   visit = new int[10000000];
	   
	   list.add(new Pair(N,0));
	   visit[N] = 1;
	   solve();
	   System.out.println(min);
}
}