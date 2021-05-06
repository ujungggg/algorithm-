package 기출_사다리조작;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N; static int H;
	static int[][] arr; //int로 바꿔서 시간 차이 보기
	static boolean flag = false;
	static int min = 1000000000;
	
	public static void solve(int cnt,int start){
		
		if(cnt>3 || cnt >= min) return;	
		if(( cnt>0 && cnt<=3) && play()){
			min = Math.min(min, cnt);
//			System.out.println(cnt);
			return;
		}
		
		for(int i=start;i<=N;i++){
			for(int j=1;j<H;j++){
				
				if(arr[i][j-1]==0 && arr[i][j+1] ==0&& arr[i][j]==0){
					arr[i][j] = 1;
					solve(cnt+1,i);
					arr[i][j] = 0;
				}
			}
		}
		
		
		
		
	}
	public static boolean play(){
//		for(int i=1;i<=N;i++){
//			for(int j=1;j<=H;j++){
//				System.out.print(arr[i][j]+" ");
//			}System.out.println();
//		}System.out.println("-------------------");
		for(int j=1;j<=H;j++){
			int move = j;
			int i=1;
			while(i<=N){
				
				if(arr[i][move]==1){
					move++;
				}else if(move-1>= 1 && arr[i][move-1]==1){
					move--;
				}
				i++;
				
			}
			if(j!=move) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken()); //y
		int M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); //x
		
		arr = new int[N+2][H+2];
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = 1;
		}
		if(!play()){
			solve(0,1);
			if(min == 1000000000 ){
				System.out.println("-1");
			}else{
				System.out.println(min);
			}
		}else{
			System.out.println("0");
		}
		
		
		
		
	}
		
}

