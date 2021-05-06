package 행성터널;


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
	static LinkedList<Pair> listX;
	static LinkedList<Pair> listY;
	static LinkedList<Pair> listZ;
	static int[] parent;
	
	static class Pair implements Comparable<Pair>{
		int num; //정점
		long point;
		
		Pair(int num, long point ){
			this.num = num;
			this.point = point;
		}
		
		@Override
		public int compareTo(Pair p){
			return (int) (this.point - p.point);
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
	
	static public void makeGraph(int point1, int point2){
//		int point1 = findUnion(x);
//		int point2 = findUnion(y); // 이전에 바뀐 부모들 다시 계산해주기 위해 
		
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
	   
	   listX = new LinkedList<Pair>();
	   listY = new LinkedList<Pair>();
	   listZ = new LinkedList<Pair>();
	   
	   for(int i=1;i<=N;i++){
		   st = new StringTokenizer(br.readLine());
		   long x = Long.parseLong(st.nextToken());
		   long y = Long.parseLong(st.nextToken());
		   long z = Long.parseLong(st.nextToken());
		   
		   listX.add(new Pair(i,x));
		   listY.add(new Pair(i,y));
		   listZ.add(new Pair(i,z));
	   }
	   Collections.sort(listX);
	   Collections.sort(listY);
	   Collections.sort(listZ);
	   
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
	   
	  

	   PriorityQueue<Edge> list = new PriorityQueue<>();
	   //x 기준으로 먼저 시작
	   for(int x=1;x<listX.size();x++){
		   Pair temp1 = listX.get(x-1);
		   Pair temp1_1 = listX.get(x);
//		   System.out.println("111@@@"+ temp1.num+" "+temp1_1.num);
		   
		   Pair temp2 = listY.get(x-1);
		   Pair temp2_1 = listY.get(x);
//		   System.out.println("@@@"+ temp2.num+" "+temp2_1.num);
		   
		   Pair temp3 = listZ.get(x-1);
		   Pair temp3_1 = listZ.get(x);
//		   System.out.println("333@@@"+ temp3.num+" "+temp3_1.num);
		   list.add(new Edge(temp1.num,temp1_1.num, Math.abs(temp1.point - temp1_1.point)));
		   list.add(new Edge(temp2.num,temp2_1.num, Math.abs(temp2.point - temp2_1.point)));
		   list.add(new Edge(temp3.num,temp3_1.num, Math.abs(temp3.point - temp3_1.point)));
	   }
	   
	   /*
	   for(int x=0;x<listY.size()-1;x++){
		   Pair temp2 = listY.get(x);
		   Pair temp2_1 = listY.get(x+1);
		   System.out.println("222@@@"+ temp2.num+" "+temp2_1.num);
		   System.out.println();
	   }
	   
	   for(int x=0;x<listZ.size()-1;x++){
		   Pair temp3 = listZ.get(x);
		   Pair temp3_1 = listZ.get(x+1);
//		   System.out.println("333@@@"+ temp3.num+" "+temp3_1.num);
		   list.add(new Edge(temp3.num,temp3_1.num, Math.abs(temp3.point - temp3_1.point)));
	   }
	   */
//	   Collections.sort(list); //value값 낮은걸로 정렬
	   
	   parent = new int[N+1]; // 부모 노드를 파악하기 위한 -> 모두 한개의 부모로 연결 되어있어야함
	   for(int i=1;i<=N;i++){
		   parent[i] = i;
	   }
	   
	   long value =0;
	   int visit = 1;
	   int[] check = new int[N+1];
	   
	   while(!list.isEmpty()){
		   Edge temp = list.remove();
		   int point1 = findUnion(temp.point1);
		   int point2 = findUnion(temp.point2);
//		   System.out.println(point1+" "+point2+" "+temp.value);
			   if(point1!=point2){  // 이 두개의 부모가 같은지 확인 
				 //부모가 같다는 말 : 이미 이어져 있는 선
				   
				   makeGraph(point1,point2);
				   value += temp.value;
				   visit++;
			   }
		
		   //같지 않으면 이어주고, 간선정보 바꿔둠
//		   for(int i=1;i<=N;i++){
//			   System.out.print(parent[i]+" ");
//		   }System.out.println();
	   }
	   
//	   for(int i=1;i<=N;i++){
//		   System.out.print(parent[i]+" ");
//	   }
//	   
	   System.out.println(value);
	   
	   
}
}