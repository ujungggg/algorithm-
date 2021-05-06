package 나무재태크2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1. ArrayList보단 LinkedList가 성능이 더 좋다.
	2. LinkedList를 자주 add하고 poll하는것은 많은 스택오버플로우를 낼 수 있다. 따라서 get으로 접근하거나 iterator를 적절히 사용하는 것이 성능에 좋다.
	3. 센스있게 답이 구해졌다 싶으면 바로 프로세스를 종료할 수 있는 로직을 짜야한다.
 * */
public class Main {
	static int[][] arr;
	static int[][] map;
	static int N; 
	
	static ArrayList<Pair> list = new ArrayList<>();
	static ArrayList<Pair> liveTree = new ArrayList<>();
	static ArrayList<Pair> deadTree = new ArrayList<>();
	
	static class Pair implements Comparable<Pair>{
		int x; int y; int age; boolean alive;
		Pair(int x, int y,int age,boolean alive){
			this.x = x;
			this.y = y;
			this.age = age;
			this.alive = alive;
			
		}
		
		@Override
		public int compareTo(Pair p){
			return this.age - p.age;
		}
	}
	
	static void solve(int time){
		int t =0;
		while(t<time){
			
			 
			 liveTree = new ArrayList<>();
			 deadTree = new ArrayList<>();		
			 
			 Collections.sort(list);
			 
			//봄
			for(Pair s: list){
				if(map[s.x][s.y] >= s.age){
					map[s.x][s.y] -= s.age;
					s.age ++;
					liveTree.add(new Pair(s.x,s.y,s.age,true));
				}else{
					//양분없으면 죽음
					deadTree.add(new Pair(s.x,s.y, s.age,false));
				
				}
			}
			list.clear();
			list.addAll(liveTree);
			
			//여름		 
			for(Pair s: deadTree){
				map[s.x][s.y] += (s.age/2);
			}
			//가을
			int size = list.size();
			for(int si=0;si<size;si++){
//			for(Pair s : list){
				Pair s = list.get(si);
				if(s.age > 0 && s.age %5 ==0){
					int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
					for(int d=0;d<8;d++){
						int x = s.x + dir[d][0];
						int y = s.y + dir[d][1];
						
						if(x<1 || y<1 || x>N || y>N) continue;
						list.add(new Pair(x,y,1,true)); //새로운 배열에 1을 넣어줌
					}
				}
			}
			
			if(t==time-1) { //시간 단축. 없어도됨
                return;
            }
			//겨울
			for(int i=1;i<=N;i++){
				for(int j=1;j<=N;j++){
					map[i][j] += arr[i][j]; //양분추가
				}
			}
			
			t++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		map = new int[N+1][N+1];
		
				
		int M = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		for(int[] row : map){
			Arrays.fill(row, 5);  //시간 단축
		}
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
//				map[i][j] = 5; //변경해줌
			}
		}
		for(int m=0;m<M;m++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			list.add(new Pair(x,y,age,true));
		}
		
		solve(time);
		int count =0;
		
		for(Pair s: list){
//			System.out.println(s.x+" "+s.y+" "+s.age+" "+s.alive);
			if(s.alive){
				count++;
			}
		}
		System.out.println(count);
	}
}