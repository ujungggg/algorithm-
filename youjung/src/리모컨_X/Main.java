package 리모컨_X;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static int N;
	public static LinkedList<Integer> list = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		String str = br.readLine();
		
		arr = new int[str.length()];
		for(int s=0;s<str.length();s++){
			arr[s] = str.charAt(s) - '0';
		}
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			list.add(Integer.parseInt(st.nextToken()));
		}
	
		//solve(0, str.length()); //시작점, 총길이
		
	}
}

