package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Pair implements Comparable<Pair>{
		int y; int value;
		Pair(int y, int value){
			this.y = y; 
			this.value=value;
		}
		
		@Override
		public int compareTo(Pair p){
			return value -p.value;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

//		int[][] arr = new int[V+1][V+1];  //-> 배열을 사용하면 메모리 초과  20000*20000
		// 참고: 정점과 간선의 최대값이 크므로 인접행렬 말고 인접 리스트로 풀어야한다.
		ArrayList<Pair>[] arr = new ArrayList[V+1];
		for(int i=1;i<=V;i++){
			 arr[i] = new ArrayList<>();
		}
		
		int[] dist = new int[V+1];
//			Arrays.fill(arr[i],100000000);
		Arrays.fill(dist,Integer.MAX_VALUE);
		
		int startPoint = Integer.parseInt(br.readLine());
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			arr[start].add(new Pair(end,value));
		}
		  
			pq.add(new Pair(startPoint,0)); //1이 들어있음 즉 1->i (2,3,4,5,,,V까지의 경우의 수 구함)
			dist[startPoint]= 0;
			boolean[] visit = new boolean[V+1];
			while(!pq.isEmpty()){
				Pair quePoint = pq.poll();
				int point = quePoint.y;


//				for(int j=1;j<=V;j++){
//					if(arr[point][j]+dist[point]<dist[j]){
//						dist[j] = arr[point][j]+dist[point];
//						pq.add(j);
//					}
//				}'

				if(!visit[point]){ //한번 테스트를 해봤던 노드는 다시 검사안해도됨
					visit[point] = true;
					
					for(int s=0;s<arr[point].size();s++){ //배열을 크기대로 다 돌 필요없이, 값이 들어있는 것들만 확인함
						Pair temp = arr[point].get(s);
						int y = temp.y;
						int value = temp.value;
						
						if(value+dist[point]<dist[y]){ //값 + 원래 갱신했던 거리  < 현재 거리
							dist[y] = value+dist[point]; //현재 거리를 갱신
							pq.add(new Pair(y,dist[y])); //갱신한 지점을 que에 다시 넣어서 다른 경로 확인함
							//틀린이유: pq에 정점을 넣어버림. value값을 넣어서 최소 비교를 할 수 있게 해줘야함
						}	 
					}
				}
			}
			for(int a=1;a<=V;a++){
				if(dist[a] == Integer.MAX_VALUE ){
					System.out.println("INF");
				}else{
					System.out.println(dist[a]);
				}
			
			}
	}
}