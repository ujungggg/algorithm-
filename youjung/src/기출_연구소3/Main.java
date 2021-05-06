package 기출_연구소3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	static int N,M;
	static int[][] arr;
	static int total;
	static int min = 1000000000;
	static LinkedList<Pair> list;
	static LinkedList<Pair> virusList;
	
	static class Pair{
		int x; int y;
		Pair(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void solve(int start, int cnt){
		if(cnt==M){
			int totalTime = virus();
			min  = Math.min(totalTime, min);
			return;
		}else{
			for(int s=start;s<list.size();s++){
				Pair temp = list.get(s);
				virusList.add(temp);
				
				solve(s+1,cnt+1);
				virusList.remove(temp);
			}
		}
	}
	public static int virus(){
		LinkedList<Pair> tempList = new LinkedList<>(virusList);
		int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
		int[][] visit = new int[N][N];
		int tempTotal = total;
		int times =0;
		while(tempTotal>0 && !tempList.isEmpty()){ //virus가 다 퍼질때까지
			int size = tempList.size();
			for(int s=0;s<size;s++){
				Pair temp = tempList.remove();
				int x = temp.x;
				int y = temp.y;
				for(int d=0;d<4;d++){
					int nx = x+dir[d][0];
					int ny = y+dir[d][1];
					if(nx<0||ny<0 || nx>=N || ny>=N) continue;
					if(arr[nx][ny]==0 && visit[nx][ny]==0){
						visit[nx][ny]=1;
						tempTotal--;
						tempList.add(new Pair(nx,ny));
					}else if(arr[nx][ny]==2 && visit[nx][ny]==0){
						visit[nx][ny]=1;
						tempList.add(new Pair(nx,ny));
					}
				}
			}
			times++;
		}
		if(tempTotal>0){
			//다 퍼트릴수 없는 경우
			return 1000000000;
		}
		return times;
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new LinkedList<>();
		virusList = new LinkedList<>();
		arr = new int[N][N];
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2){
					list.add(new Pair(i,j));
				}else if(arr[i][j]==0){
					total++;
				}
			}
		}
		
		if(total>0){
			solve(0,0);
			if(min == 1000000000){
				System.out.println("-1");
			}else{
				System.out.println(min);
			}
		}else{
			System.out.println("0");
		}
		
	}
}


