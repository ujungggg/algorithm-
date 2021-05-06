package 기출_치킨배달;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static LinkedList<Pair> home;
	public static LinkedList<Pair> chicken;
	
	static int M;
	static class Pair{
		int x; int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int min = 1000000000;
	public static int getCount(LinkedList<Pair> tempList){ //치킨거리 구하기 (가장 최소값을 구하자)
		
		int total = 0;
		
		for(int i=0;i<home.size();i++){
			int tMin = 1000000000;
			Pair homeDir = home.get(i);
			int x = homeDir.x;
			int y = homeDir.y;
			
			for(int s=0;s<tempList.size();s++){
				Pair temp = tempList.get(s);
				
				int tx = temp.x; int ty = temp.y;
				tMin = Math.min((Math.abs(x-tx) + Math.abs(y-ty)), tMin);
//				total += (Math.abs(x-tx) + Math.abs(y-ty));
			}	
			total+= tMin;
		}
		
		
		return total; // 한지점에서의 치킨거리
	}
	
	public static void solve(int start, int cnt,LinkedList<Pair> tempList){
		if(cnt == M){
			
			min = Math.min(min, getCount(tempList));
			return;
			
		}else{
			for(int i = start ; i<chicken.size();i++){
				Pair temp = chicken.get(i);
				tempList.add(temp);
				solve(i+1, cnt+1, tempList);
				tempList.remove(temp);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		chicken = new LinkedList<>();
		home = new LinkedList<>();
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2){
					chicken.add(new Pair(i,j));
					
				}else if(arr[i][j]==1){
					home.add(new Pair(i,j));
				}
			}
		}
 		solve(0,0, new LinkedList<>());
		System.out.println(min);
		
	}
}

