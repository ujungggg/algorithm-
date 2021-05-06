package 연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] cal = new int[4];
	static int N;
	static int min = 1000000000;
	static int max =0;
	public static void solve(int tot,int time){
		if(time == N ){
			min = Math.min(tot, min);
			max = Math.max(tot, max);
		}else{
			for(int i=0;i<4;i++){
				if(cal[i] >0){
					cal[i]--;
					if(i==0){
						solve(tot+arr[time],time+1);
					}else if(i==1){
						solve(tot-arr[time],time+1);
					}else if(i==2){
						solve(tot*arr[time],time+1);
					}else if(i==3){
						solve(tot/arr[time],time+1);
						}
					cal[i]++;
				}
			}
		}
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	   StringTokenizer st;
	   N = Integer.parseInt(br.readLine());
	   arr = new int[N];
	   
	   st = new StringTokenizer(br.readLine());
	   
	   for(int i=0;i<N;i++){
		   arr[i]= Integer.parseInt(st.nextToken());
	   }
	   st = new StringTokenizer(br.readLine());
	   for(int i=0;i<4;i++){
		   cal[i] = Integer.parseInt(st.nextToken());
	   }
	   
	  solve(arr[0],1);
	  System.out.println(max);
	  System.out.println(min);
}
}