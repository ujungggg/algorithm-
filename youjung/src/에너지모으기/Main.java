package 에너지모으기;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int[] arr;
	public static int[] visit;
	public static int max =0;
	
	public static void solve(int cnt, int total){
		if(cnt == N-2){
			max = Math.max(total, max);
			
		}else{
			for(int i=1;i<N-1;i++){
				int left =0; int right =0;
				if(visit[i]==0){
					int leftX = i-1;
					while(leftX>=0 && visit[leftX]!=0){
						leftX--;
					}
					left += arr[leftX];
					
					int rightX = i+1;
					while(rightX <N && visit[rightX]!=0){
						rightX++;
					}
					right += arr[rightX];
					
					visit[i] = 1;
					solve( cnt+1,total+(left*right));
					visit[i] = 0;
				}
			}
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		visit = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0,0);
		System.out.println(max);
	}
}

