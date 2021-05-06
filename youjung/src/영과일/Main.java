package ¿µ°úÀÏ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static int N ;
	public static long last ;
	public static boolean flag = false;
	public static void solve(long num,int length){
		if(Long.toString(num).length()>100) return;
		if(num%N ==0 ){
			last = num;
			flag = true;
			return;
		}else{
			if(flag) return;
			for(int i=0;i<2;i++){
				String temp = Long.toString(num);
				temp += i;
				long temp2 = Long.parseLong(temp);
				
				solve(temp2,temp.length());
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			N = Integer.parseInt(br.readLine());
			last = 0;
			flag = false;
			solve(1,1);
			System.out.println(last);
		}
	}
}

