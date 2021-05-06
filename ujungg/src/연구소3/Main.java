package 연구소3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N; static int M;
	static int[][] arr;
	static int[][] visit;
	static int count =0;
	static int min = 1000000000;
	static int totalSize =0;
	static LinkedList<Pair> list = new LinkedList<>();
//	static LinkedList<Pair> virus = new LinkedList<>(); //선택된 바이러스 넣기
	static int[] virus;
	static class Pair{
		int x; int y;
		Pair(int x, int y){
			this.x = x;
			this.y= y;
		}
	}
	
	public static void solve(int start, int cnt){
		if(cnt == M){
			int time = check();
			min = Math.min(time, min);
			return;
		}else{
			for(int i=start;i<totalSize;i++){
				virus[i]= 1;
				solve(i+1,cnt+1);
				virus[i]= 0;
			}
		}
		
	}
	
	public static int check(){
		int checkCount = count; //0의 개수
		int[][] dir ={{1,0},{-1,0},{0,1},{0,-1}};
		LinkedList<Pair> temps = new LinkedList<>();
		visit = new int[N][N];
		for(int s=0;s<totalSize;s++){
			if(virus[s]==1){
				Pair t = list.get(s);
				temps.add(new Pair(t.x,t.y));
			}
		}
		
//		boolean check = false;
		
		int time =0;
		while(!temps.isEmpty()){
			
			
			int size =temps.size();
			for(int i=0;i<size; i++){
				Pair temp = temps.pollFirst();
				int startX = temp.x;
				int startY = temp.y;
				
				visit[startX][startY] =1;
				for(int d=0;d<4;d++){
					   int x = startX +dir[d][0];
					   int y = startY +dir[d][1];
					   if(x<0 || y<0 || x>=N || y>=N) continue;
					   if(arr[x][y]==0 && visit[x][y]==0){
						   visit[x][y]=1;
						   temps.add(new Pair(x,y));
						   checkCount--; //지워나가야할 영역 하나 없앰
					   }else if(arr[x][y]==2 && visit[x][y]==0){ //비활성화 였던거 활성화로 바꿈
						   visit[x][y]=1;
						   temps.add(new Pair(x,y));
					   }
				}
			  
			}
//			check = false;
//			for(int i=0;i<N;i++){
//				for(int j=0;j<N;j++){ //바이러스가 벽도 아니고 비활성 바이러스도 아닌데 방문을 안한경우 (탐색할거가 더 있음)
//					if(visit[i][j]==0 && arr[i][j]==0){
//						check = true;
//					}
//				}
//			}
			time ++;
			if(time >= min) break; //최소값보다 작거나 크면 더이상 검사할필요 없음.
			if(checkCount ==0){ 
				break;
			}
			
		}
//		System.out.println("---------start------------");
//		for(int i=0;i<N;i++){
//			for(int j=0;j<N;j++){ //바이러스가 벽도 아니고 비활성 바이러스도 아닌데 방문을 안한경우
//				System.out.print(visit[i][j]+" ");
//			}System.out.println();
//		}
		
//		for(int i=0;i<N;i++){
//			for(int j=0;j<N;j++){ //바이러스가 벽도 아니고 비활성 바이러스도 아닌데 방문을 안한경우
//				if(visit[i][j]==0 && arr[i][j]==0){
//					time = 1000000001;
//				}
//			}
//		}
		if(checkCount > 0){
			time = 1000000001;
		}
		return time;
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st;
   
   st = new StringTokenizer(br.readLine());
   N = Integer.parseInt(st.nextToken());
   M = Integer.parseInt(st.nextToken());

   arr = new int[N][N];
   visit = new int[N][N];
   
   count=0;
   for(int i=0;i<N;i++){
	   st = new StringTokenizer(br.readLine());
	   for(int j=0;j<N;j++){
		   arr[i][j] = Integer.parseInt(st.nextToken());
		   if(arr[i][j] ==2){
			   list.add(new Pair(i,j));
		   }
		   if(arr[i][j]==0){
			   count ++; 
		   }
	   }
   }
   totalSize = list.size();
   virus = new int[totalSize];
   
   if(count==0){ //0이 없는 경우는 검사해볼 필요 없음
	   min =0;
   }else{
	   solve(0,0);
   }
  
   if(min == 1000000000){
	   System.out.println("-1");
   }else{
	   System.out.println(min);
   }
  
}
}