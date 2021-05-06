package 일곱난쟁이_브루투포스;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	static int[] visit;
	static boolean flag = false;
	public static void solve(int start,int cnt, int total){
		if(cnt == 7 ){
			if(total == 100){
				Arrays.sort(visit);
				for(int i=0;i<7;i++){
					System.out.println(visit[i]);
				}
				flag = true;
			}
			return;
		}
		if(flag) return;
		else{
			for(int i=start;i<9;i++){
				visit[cnt] = arr[i];
				solve(i+1,cnt+1,total+arr[i]);
				visit[cnt] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new int[9];
		visit = new int[7];
		
		for(int i=0;i<9;i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		solve(0,0,0);
		
		
		
	}
}