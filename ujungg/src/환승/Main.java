package ȯ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] visit;
	static int N;
	static LinkedList<Integer> per;
	static ArrayList<Integer>[] list;
	
	public static void dfs(int cnt){
		if(cnt==2){
			int a = 0; int b=0;
			for(int i=1;i<=N;i++){
				if(visit[i]==1){
					if( a==0 && b==0){
						a = i;
					}else if (a!=0 && b==0){
						b = i;
					}
				}
			}
			
			list[a].add(b);
			
		}else{
			for(int i=0;i<per.size() ;i++){
//				System.out.println("Ȯ��"+ per.get(i));
				if(visit[per.get(i)]==0){
					visit[per.get(i)] = 1;
					dfs(cnt+1);
					visit[per.get(i)] = 0;
				}
			}
		}
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   N = Integer.parseInt(st.nextToken());
	   int K = Integer.parseInt(st.nextToken());
	   int M = Integer.parseInt(st.nextToken());
	   
	   visit = new int[N+1];
	   list = new ArrayList[N+M+2]; // N+1 ~ N+M : Dummy Node�� ���Ե�
	   for(int i=1;i<=N+M+1;i++){
		   list[i] = new ArrayList<>();
	   }
	   
	   /*
	   //1. �ð� �ʰ� -> per ����Ʈ�� ���پ� ���ڸ� �־ ��� ����� ���� �������� �����س�
	   for(int i=0;i<K;i++){
		   per = new LinkedList<>();
		   st = new StringTokenizer(br.readLine());
		   for(int j=0;j<M;j++){
			   per.add(Integer.parseInt(st.nextToken())); //�Է¹��� ������ per�� ����
		   }
		   // per list�� ���ִ� �͵� �߿��� 2������ �̾Ƽ� ������ �������
		   dfs(0);
		 }
	  */
	   
	   //2. Dummy Node ����ؼ� Ǯ��
	   for(int i=1;i<=M;i++){
		   st = new StringTokenizer(br.readLine());
		   for(int j=0;j<K;j++){
			   int node = Integer.parseInt(st.nextToken());
			   list[node].add(N+i); //1�� ���: 10 2�����: 10 3�����: 10 
			   list[N+i].add(node); // 10�� �����ʹ� 10 : 1,2,3 / 11: 1,4,5 ��尡 ����
			  
		   }
	   }
	   
	   int[] dist = new int[N+M+1];
	   Arrays.fill(dist, 100000000);
	   PriorityQueue<Integer> pq = new PriorityQueue<>();
	   pq.add(1); //1���� �־���
	   dist[1] = 0;
	   
	   while(!pq.isEmpty()){
		   int now = pq.remove();
//		   if(now == M) break;
		   
		   for(int i=0;i<list[now].size();i++){ //1�� ��忡 �ִ� �͵� 10,11�� 
			   int arrive = list[now].get(i); 
			   
			   if(dist[now] + 1 < dist[arrive]){
				   dist[arrive] = dist[now]+1;
				   pq.add(arrive);
			   }
		   }
	   }
	   
	   for(int i=10;i<=19;i++){
		   System.out.print(dist[i]+" ");
	   }
//	   System.out.println(dist[N]);
	   
}
}