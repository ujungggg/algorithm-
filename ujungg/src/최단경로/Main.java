package �ִܰ��;

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

//		int[][] arr = new int[V+1][V+1];  //-> �迭�� ����ϸ� �޸� �ʰ�  20000*20000
		// ����: ������ ������ �ִ밪�� ũ�Ƿ� ������� ���� ���� ����Ʈ�� Ǯ����Ѵ�.
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
		  
			pq.add(new Pair(startPoint,0)); //1�� ������� �� 1->i (2,3,4,5,,,V������ ����� �� ����)
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

				if(!visit[point]){ //�ѹ� �׽�Ʈ�� �غô� ���� �ٽ� �˻���ص���
					visit[point] = true;
					
					for(int s=0;s<arr[point].size();s++){ //�迭�� ũ���� �� �� �ʿ����, ���� ����ִ� �͵鸸 Ȯ����
						Pair temp = arr[point].get(s);
						int y = temp.y;
						int value = temp.value;
						
						if(value+dist[point]<dist[y]){ //�� + ���� �����ߴ� �Ÿ�  < ���� �Ÿ�
							dist[y] = value+dist[point]; //���� �Ÿ��� ����
							pq.add(new Pair(y,dist[y])); //������ ������ que�� �ٽ� �־ �ٸ� ��� Ȯ����
							//Ʋ������: pq�� ������ �־����. value���� �־ �ּ� �񱳸� �� �� �ְ� �������
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