package 소수찾기_수학;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr  =  new int[N];
		st = new StringTokenizer(br.readLine());
		
		int cnt =0;
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
			int num = 2;
			boolean flag = false;
			if(arr[i] == 1) continue;
			while(num < arr[i]){
				
				if(arr[i] %num ==0) {
					flag = true;
					break;
				}
				num++;
			}
			
			if(!flag) cnt++;
		}
		
		System.out.println(cnt);
		
	}
}

