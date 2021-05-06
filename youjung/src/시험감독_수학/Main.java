package 시험감독_수학;
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
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long total = 0;
		for(int i=0;i<N;i++){
			if(arr[i]-B > 0){
				if( (arr[i]-B ) %C ==0) {
					total+= (arr[i]-B ) /C;
				}else{
					total+= (arr[i]-B ) /C;
					total++;
				}
			}
			
		}
		total += N;
		System.out.println(total);
	}
}

