package ∫ŒµÓ»£;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] visit = new int[10];
	public static int[] numArr ;
	static String[] arr; 
	static String maxString, minString ="";
	static int N = 0;
//	static long min = 9999999999;
//	static long max = Long.MAX_VALUE;
	static LinkedList<String> list = new LinkedList<>();
	
	public static void solve(int cnt){
		if(cnt == N+1 ){
			int num =0;
//			for(int i=0;i<=N;i++){
//				num += (numArr[N-i] * Math.pow(10, i));
//			}
//			System.out.println(num);
			maxString = "";
			for(int i=0;i<=N;i++){ 
				maxString += numArr[i];
			}
			list.add(maxString);
			/*
			if(max < num){
				max = num;
				maxString = "";
				for(int i=0;i<=N;i++){ 
					maxString += numArr[i];
				}
			}
			if(min > num){
				min = num;
				minString ="";
				for(int i=0;i<=N;i++){ 
					minString += numArr[i];
				}
			}
//			max = Math.max(max, num);
//			min = Math.min(min, num);
			 */
			
			return;
		}else{
			String temp = arr[cnt-1];
			if(temp.equals("<")){
				for(int i=numArr[cnt-1];i<=9;i++){
					if(visit[i] ==0){
						visit[i] = 1;
						numArr[cnt] = i;
						solve(cnt+1);
						visit[i] = 0;
					}
				}
			}else if(temp.equals(">")){
				for(int i=0;i<numArr[cnt-1];i++){
					if(visit[i] ==0){
						visit[i] = 1;
						numArr[cnt] = i;
						solve(cnt+1);
						visit[i] = 0;
					}
				}
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		numArr = new int[N+1];
		arr = new String[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			arr[i] = st.nextToken();
		}
		
		
		for(int i=0;i<=9;i++){
			numArr[0] = i;
			visit[i] = 1;
			solve(1);
			visit[i] = 0;
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}
}

