package 최대공약수와최소공배수;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	static int[] visit;
	
	public static int GCD(int a, int b){
		
		if(b==0) return a;
		else return GCD(b, a%b);
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int num = GCD(A,B);
		System.out.println(num);
		
		int total = (A/num) * (B/num) * num;
		System.out.println(total);
	}
}

