package 아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int[][] visit;
	static int size =2;
	static int count =0;
//	static int minCnt = 100000000;
	static LinkedList<Pair> que = new LinkedList<>();
	static LinkedList<Pair> fish = new LinkedList<>();
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static class Pair{
		int x; int y ; int cnt;
		Pair(int x, int y, int cnt){
			this.x = x; this.y=y; this.cnt = cnt;
		}
	}
	
	static void solve(){
		
		int eat =0;
		while(!que.isEmpty()){
			
			boolean flag = false;
//			for(int i=0;i<N;i++){ // 이제 더이상 먹을게 없으면 끝남
//				for(int j=0;j<N;j++){
//					System.out.print(arr[i][j]+" ");
//				}System.out.println();
//			}System.out.println();
			
			for(int i=0;i<N;i++){ // 이제 더이상 먹을게 없으면 끝남
				for(int j=0;j<N;j++){
					if(arr[i][j] !=0 && arr[i][j]<size){
						flag = true;
						break;
					}
				}
			}
			
			int sizes = que.size();
			for(int q=0;q<sizes;q++){
				Pair temp = que.remove();
				int startX = temp.x;
				int startY = temp.y;
				int cnt  = temp.cnt;
				if(!flag) {
					
					count = cnt;
					return;
				}
				for(int d=0;d<4;d++){
					int x = startX + dir[d][0];
					int y = startY + dir[d][1];
					
					if(x<0 || y<0 || x>=N || y>=N) continue;
					if(visit[x][y]==0 && arr[x][y] <= size){
						visit[x][y]=1;
						que.add(new Pair(x,y,cnt+1));
						if(arr[x][y]!=0  && arr[x][y] < size){ //먹을수 있는 거면
							fish.add(new Pair(x,y,cnt+1)); //fish큐에 넣고 좌표비교
						}
					}
				}
			}
			

			
			if(fish.size() == 1){
				que = new LinkedList<>();
				visit = new int[N][N];
				
				Pair temps = fish.remove();
				int x = temps.x;
				int y = temps.y;
				int cnt1 = temps.cnt;
				arr[x][y] = 0;
				count = cnt1;
				que.add(new Pair(x,y,cnt1));
				
				eat++;
				if(eat == size){ //상어가 자기 몸만큼 먹었으면 크기 늘어남
					eat =0;
					size ++;
				}
			}else if(fish.size()> 1){
				int minX = 10000000;
				int minY  = 10000000;
				int minCnt = 10000000;
				
				int cnt1 =0;
				for(int s1=0;s1<fish.size();s1++){
					Pair temps = fish.get(s1);
					int x = temps.x;
					int y = temps.y;
					cnt1 = temps.cnt;
//					System.out.println("fish" +x+" "+y+" "+cnt1 );
				}
				int fishSize = fish.size();
				for(int s1=0;s1<fishSize;s1++){
					Pair temps = fish.remove();
					int x = temps.x;
					int y = temps.y;
					cnt1 = temps.cnt;
					if(cnt1<= minCnt){
						if(cnt1<minCnt){
							//그냥 이걸로 바꿔야함
							minX = x;
							minY = y;
							minCnt = cnt1;
							count = cnt1;
						}else if (cnt1 == minCnt){
							//거리 비교 해야함
							if(x<=minX){
								if(x<minX){ // x가 작은게 우선
									minX = x;
									minY = y;
									minCnt = cnt1;
									count = cnt1;
								}else if(x==minX){
									//y값 비교
									if(y<minY){
										minX = x;
										minY = y;
										minCnt = cnt1;
										count = cnt1;
									}
								}
							}
							
						}
					}
				}
//				System.out.println(minX + " "+ minY);
				fish = new LinkedList<>();
				que = new LinkedList<>();
				arr[minX][minY] = 0;
				eat++;
				if(eat == size){ //상어가 자기 몸만큼 먹었으면 크기 늘어남
					eat =0;
					size ++;
				}
				que.add(new Pair(minX,minY,cnt1));
				visit = new int[N][N];
			}
			
			
			
		}
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st;
	  
	  st = new StringTokenizer(br.readLine());
	  N = Integer.parseInt(st.nextToken());
	  arr = new int[N][N];
	  visit = new int[N][N];
	  for(int i=0;i<N;i++){
		  st = new StringTokenizer(br.readLine());
		  for(int j=0;j<N;j++){
			  arr[i][j] = Integer.parseInt(st.nextToken());
			  if(arr[i][j]==9){
				  que.add(new Pair(i,j,0));
				  visit[i][j] =1;
				  arr[i][j] =0;
			  }
		  }
	  }
  
  solve();
  System.out.println(count);
  

}
}