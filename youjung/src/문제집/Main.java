package 문제집;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] arr = new ArrayList[N+1] ;
		for(int i=1;i<=N;i++){
			arr[i] = new ArrayList<>(); //LinkedList로 했을때 시간초과가 남
		}
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		int[] degree = new int[N+1];
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			degree[b] ++;
			
		}
		
		//진입차수가 0인 노드를 큐에 삽입
		for(int i=1;i<=N;i++){
			if(degree[i] ==0){
				que.add(i);
			}
		}
		
		//위상정렬이 완전히 수행되려면 노드의 수만큼인 N번 수행한다
		while(!que.isEmpty()){
			//n개를 방문하기 전에 이미 que가 empty가 되면 사이클이 발생한것
			
		
			int num = que.remove();
			System.out.print(num+" ");
			
			int size = arr[num].size();
			for(int s=0;s<size;s++){
				int temp = arr[num].get(s);
				degree[temp] --;
				if(degree[temp]==0){
					que.add(temp);
				}
			}
			
		}
	
		
	}
}



