package 행성터널2;


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
	static int N;
	static Pair[] list;
	static int[] parent;
	
	static class Pair{
		int i; long x; long y; long z;
		
		Pair(int i,long x, long y, long z){
			this.i = i;
			this.x = x;
			this.y=y;
			this.z=z;
		}
	}
	
	static class Edge implements Comparable<Edge>{ //이어지는 간선들의 정보
		int point1;
		int point2;
		long value;
		
		Edge(int point1, int point2, long value ){
			this.point1 = point1;
			this.point2 = point2;
			this.value = value;
		}
		
		@Override
		public int compareTo(Edge e){
			return (int) (this.value - e.value);
		}
	}
	
	static public int findUnion(int x){
		if(parent[x] == x) return x;
		else{
			return parent[x] = findUnion(parent[x]);
		}
	}
	static public boolean findParent(int x, int y){
		
		int a = findUnion(x);
		int b = findUnion(y);
		
		if(a == b){
			return false;
		}
//		parent[b] = a;
		return true;
	}
	
	static public void makeGraph(int x, int y){
		int point1 = findUnion(x);
		int point2 = findUnion(y); // 이전에 바뀐 부모들 다시 계산해주기 위해 
		
		 if(point1<point2){
			   parent[point2] =point1;
		   }else{
			   parent[point1] = point2;
		   }
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   N = Integer.parseInt(st.nextToken());
	   
	   list = new Pair[N];
	  
	   for(int i=0;i<N;i++){
		   st = new StringTokenizer(br.readLine());
		   long x = Long.parseLong(st.nextToken());
		   long y = Long.parseLong(st.nextToken());
		   long z = Long.parseLong(st.nextToken());
		   list[i] = new Pair(i,x,y,z);
	   }
	  
	   
	   // x,y,z 좌표를 각각 정렬한다음에 인접한 수의 모든 경우의 수를 하나의 리스트에 넣음
	   
	   // x를 기준으로 짧은 거리를 하나씩 이어줌 
	   //x: -1 10 11 14 19 -> x를 기준으로 먼저 간선 이어줌 
	   //y: -15 -5 -4 -4 -1
	   //z: 0  -> 10 ->4 ->20
	   
	   /*
	    * 3->4 (11) 4->1(1) 1->2(3) 2->5(5)
	    * 1->2 (10) 2->4 (1) 4->5 (0) 5->3(3)
	    * 
	    * */

	   LinkedList<Edge> pq = new LinkedList<>();
	   //x 기준으로 먼저 시작
	   Arrays.sort(list,(p1, p2) -> (int) (p1.x - p2.x));
	   for(int i=0; i<N-1; i++){
		   long temp1 = list[i].x;
		   long temp1_1 = list[i+1].x;
		  
		   pq.add(new Edge(list[i].i,list[i+1].i, Math.abs(temp1 - temp1_1)));
	   }
	 
	   Arrays.sort(list,(p1, p2) -> (int) (p1.y - p2.y));
	   for(int i=0; i<N-1; i++){
		   long temp1 = list[i].y;
		   long temp1_1 = list[i+1].y;
		  
		   pq.add(new Edge(list[i].i,list[i+1].i, Math.abs(temp1 - temp1_1)));
	   }
	   
	   Arrays.sort(list,(p1, p2) -> (int) (p1.z - p2.z));
	   for(int x=0; x<N-1; x++){
		   long temp1 = list[x].z;
		   long temp1_1 = list[x+1].z;
		  
		   pq.add(new Edge(list[x].i,list[x+1].i, Math.abs(temp1 - temp1_1)));
	   }
	   
	   
	   parent = new int[N]; // 부모 노드를 파악하기 위한 -> 모두 한개의 부모로 연결 되어있어야함
	   for(int i=0;i<N;i++){
		   parent[i] = i;
	   }
	   
	   long value =0;
	   int visit = 1;
	   int[] check = new int[N+1];
	   
	   Collections.sort(pq);
	   while(!pq.isEmpty()){
		   Edge temp = pq.remove();
//		   int point1 = findUnion(temp.point1);
//		   int point2 = findUnion(temp.point2);
		  
		   int point1 = temp.point1;
		   int point2 = temp.point2;
		   
//		   if(point1!=point2){  // 이 두개의 부모가 같은지 확인 
		   if(findParent(point1,point2)){
				 //부모가 같다는 말 : 이미 이어져 있는 선
//			   System.out.println(point1+" "+point2+" "+temp.value);
				   makeGraph(point1,point2);
				   value += temp.value;
				   visit++;
				   
//				   for(int i=0;i<N;i++){
//					   System.out.print(parent[i]+" ");
//				   }System.out.println();
			   }   
		   //같지 않으면 이어주고, 간선정보 바꿔둠
		  
	   }
	   
//	   for(int i=1;i<=N;i++){
//		   System.out.print(parent[i]+" ");
//	   }
//	   
	   System.out.println(value);
	   
	   
}
}