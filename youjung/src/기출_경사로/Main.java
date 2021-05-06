package 기출_경사로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N,L,total;
	static int[][] arr;
	static HashSet<Integer> hash1 = new HashSet<>();
	static HashSet<Integer> hash2 = new HashSet<>();
	public static void goRight(){
		for(int i=0;i<N;i++){
			boolean[] check = new boolean[N];
			
			int j=0;
			
			boolean flag = true;
			while(j<N-1){
				if(Math.abs(arr[i][j] - arr[i][j+1])>1 ){
					flag = false;
					break;
				}
				if( arr[i][j]+1 == arr[i][j+1] ){
					int point = j+1;
					int cnt =1;
					while(cnt<=L){
						if(arr[i][point] == arr[i][point+1]){
							check[point] = true;
							cnt++;
							point++;
						}else{
							flag = false;
							break;
						}
					}
				}else if(arr[i][j] == arr[i][j+1]+1 ){
					int point = j;
					int cnt =1;
					while(cnt<=L){
						if(point-1<0){
							flag = false;
							break;
						}
						if(arr[i][point-1] == arr[i][point] && !check[point-1]){
							check[point] = true;
							cnt++;
							point++;
						}else{
							flag = false;
							break;
						}
					}
				}
				if(!flag) break;
				j++;
			}
			if(flag){
				total++;
			}
			
		}
		System.out.println(total);
	}
	public static void goDown(){
		for(int j=0;j<N;j++){
			
			int i=0;
			int cnt =1;
			boolean flag = true;
			boolean check = false;
			while(i<N-1){
				if(Math.abs(arr[i][j] - arr[i+1][j])>1 ){
					flag = false;
					break;
				}
				if(arr[i][j]== arr[i+1][j]){
					cnt++;
				}else{
					if(check){
						if(cnt>=L){
							check = false;
							cnt = 1;
						}else{
							flag = false;
							break;
						}
					}
					
					if( arr[i][j]+1 == arr[i+1][j] ){
						if(cnt<L) {
							flag = false;
							break;
						}else{
							// 조건에 충족하는 경우
							cnt = 1;
						}
					}else if(arr[i][j] == arr[i+1][j]+1){
						
						 //앞으로 L개가 나오는지 확인헤애힘
							cnt=1; 
							check = true;
						
						
					}
				}
				
				i++;
			}
			if(flag && cnt>=L) {
				total++;
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	L = Integer.parseInt(st.nextToken());
	
	arr = new int[N][N];
	for(int i=0;i<N;i++){
		st = new StringTokenizer(br.readLine());
		for(int j=0;j<N;j++){
			arr[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	goRight();
	goDown();
	System.out.println(total);

}
}
