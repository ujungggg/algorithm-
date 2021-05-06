package 경사로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N; 
	static int L;
	static int[][] arr;
	static int[][] visit;
	static int total = 0;
	public static void solveRow(){
		for(int i=0;i<N;i++){
			int startJ = 0;
			int j=0;
			boolean check = true;
			while(j<N){
				if(arr[i][j]!=arr[i][startJ]){
					if(Math.abs(arr[i][startJ]-arr[i][j]) !=1) { //높이가 1이 아닐경우에는 그냥 만들수 없음
						check = false;
						break;
					}
					if(arr[i][startJ]> arr[i][j]){ //이전이 더 높은경우
						int a =0;
						int length=0;
						while(j+a<N && length<L){
							length++;
							a++;
						}
						if(length<L) { //경사로 길이보다 짧은경우
							check = false;
							break;
						}
						if(check){ //경사로를 둘수있는 경우
							for(int s = startJ+1 ; s<j+a;s++){
								if(visit[i][s]==0){
									visit[i][s] =1;
								}else{
									check = false;
									break;
								}
								
							}
							startJ = j+a-1;
							j = j+a;
						}else{
							break;
						}
						
					
					}
					else if(arr[i][startJ]<arr[i][j]){
						if(j-startJ<L) {
							check = false;
							break;
						}
						for(int s=startJ;s<j;s++){
							if(visit[i][s] == 0){
								visit[i][j] =1;
								
							}else{
								check = false;
								break;
							}
						}
						startJ = j;
					}
				}else{
//				    startJ ++;
					j++;
				}				
			}
			if(check){
				total++;
			}
		
		}
	}
	public static void solveColumn(){
		for(int j=0;j<N;j++){
			int startI = 0;
			int i=0;
			boolean check = true;
			while(i<N){
				if(arr[i][j]!=arr[startI][j]){
					if(Math.abs(arr[startI][j]-arr[i][j]) !=1) {
						check = false;
						break;
					}
					if(arr[startI][j]> arr[i][j]){
						int a =0;
						int length=0;
						while(i+a<N && arr[i+a][j]==arr[i][j]){
							length++;
							a++;
						}
						if(length<L) {
							check = false;
							break;
						}
						
						if(check){
							startI = i+a-1;
							i = i+a;
						}else{
							break;
						}
					}
					else if(arr[startI][j]<arr[i][j]){
						if(i-startI<L) {
							check = false;
							break;
						}
						startI = i;
					}
				}else{
					i++;
				}				
			}
			if(check){
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
		visit = new int[N][N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solveRow();
		System.out.println(total);
		visit = new int[N][N];
		solveColumn();
		System.out.println(total);
	}
}