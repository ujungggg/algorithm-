package 트리순회;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static LinkedList<String> list[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		list = new LinkedList[2];
		for(int i=0;i<N;i++){
			list[i] = new LinkedList<>();
		}
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			String node = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			
			list[0].add(left);
			list[1].add(right);
		}
		       
		
	}
}

