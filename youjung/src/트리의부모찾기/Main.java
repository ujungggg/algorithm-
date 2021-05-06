package 트리의부모찾기;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] parent;
	public static boolean[] visit;
	public static ArrayList<Integer>[] list ;
	public static void dfs(int node){
		
		for(int i=0;i<list[node].size();i++){
			int num = list[node].get(i);
			
			if(!visit[num]){
				visit[num] = true;
				parent[num] = node;
				dfs(num);
				
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		visit = new boolean[N+1];
		list = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++){
			list[i] = new ArrayList<>();
		}
		
		
		
		for(int i=0;i<N-1;i++){
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
			
			
		}
		visit[1] = true;
		parent[1] = 1;
		dfs(1);
		for(int k=2;k<=N;k++){
			System.out.println(parent[k]);
		}
	}
}

