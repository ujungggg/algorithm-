package 낚시왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static int M;
	static Pair[][] arr;
	static int[][] visit;
	static int result = 0;
	static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
	static LinkedList<Pair> que = new LinkedList<>();
	static class Pair implements Comparable<Pair>{
		int x; int y; int s; int d; int z;
		
		Pair(int x, int y, int s, int d, int z){
			this.x=x ;
			this.y=y ;
			this.s=s ;
			this.d=d ;
			this.z=z ;
		}
		@Override
		public int compareTo(Pair p){
			return this.x - p.x;
		}
	}
	
	public static void solve(){
		int c = 0;
		
		while(c<C){
			Collections.sort(que);
			LinkedList<Pair> tempList = new LinkedList<>();
			for(int s= 0;s<que.size();s++){
				if(que.get(s).y == c){
					result += que.remove(s).z;
					break;
				}
			}
			
			/*
			int size = que.size();
			for(int si=size-1;si>=0;si--){
				Pair temp = que.remove(si);
				int d = temp.d;
				
				int x = temp.x; int y = temp.y;
				
				for(int s=0;s<temp.s; s++){
					x += dir[d][0];
					y += dir[d][1];
					
					if(x<0 || y<0 || x>=R || y>= C){
						if(d==0) d =1;
						else if(d==1) d=0;
						else if(d==2) d=3;
						else if(d==3) d=2;
						
						x += dir[d][0];
						y += dir[d][1];
						x += dir[d][0];
						y += dir[d][1];
					}
				}
				
				que.add(new Pair(x,y,temp.s,d,temp.z));
			}
			*/
			
			arr = new Pair[R][C];
			
			int queSize = que.size();
			for(int s=queSize-1;s>=0;s--){
				Pair temp = que.get(s);
//				System.out.println(temp.x+" "+temp.y+" "+temp.d);
				if(arr[temp.x][temp.y] == null){
					
					arr[temp.x][temp.y] = temp;
				}else{ //이미 그 위치에 상어가 있는 경우
					if(arr[temp.x][temp.y].z < temp.z){ //원래 있던게 더 작으면 원래 있던거 삭제
						que.remove(arr[temp.x][temp.y]);
						arr[temp.x][temp.y] = temp; //현재 상어의 정보로 다 바꿔줌
					}else{ //원래 있던게 더 크면 현재꺼 삭제
						que.remove(temp);
					}
				}
			}
			
			c++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new Pair[R][C];
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			
//			arr[x][y] = new Pair(x,y,s,d,z);
			que.add(new Pair(x,y,s,d,z));
		}
		
	
		
		solve();
		System.out.println(result);
	}
}