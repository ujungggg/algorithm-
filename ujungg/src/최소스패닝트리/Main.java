package 최소스패닝트리;
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
	

	static int[] parent;
	static class Pair implements Comparable<Pair>{
		int x; int y; long value; 
		Pair(int x, int y, long value){
			this.x = x;
			this.y=y;
			this.value=value;
		}
		@Override
		public int compareTo(Pair p) {
			return Long.compare(this.value, p.value);
		}
	}
	public static int getFind(int x){ //재귀함수를 사용하여 각 노드의 부모 노드 찾기
		if(parent[x] == x) return x; //재귀함수가 끝나는 부분 -> 최상위의 노드에 도착하면 끝남
		return parent[x] = getFind(parent[x]);
	}
	
	public static void unionFind(int a, int b){ //연결되는 노드를 합치는 경우
		int x = getFind(a);
		int y = getFind(b);
		
		if(x!=y){
			if(x<y) {
				parent[y] = x;
			}else{
				parent[x] = y;
			}
		}
		
		
	}
	
	public static boolean isSame(int x, int y){
		x = getFind(x);
		y = getFind(y);
		if(x==y) return true;
		else return false;
		
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   
	   int V = Integer.parseInt(st.nextToken());
	   int E = Integer.parseInt(st.nextToken());
	   
	   parent = new int[V+1];
	   ArrayList<Pair> list = new ArrayList<>();
	   
	   for(int i=0;i<E;i++){
		   st = new StringTokenizer(br.readLine());
		   int x = Integer.parseInt(st.nextToken());
		   int y = Integer.parseInt(st.nextToken());
		   long value = Long.parseLong(st.nextToken());
		   
		   list.add(new Pair(x,y,value));
	   }
	 
	  for(int i=1;i<=V;i++){
		  parent[i] = i;
	  }

	  Collections.sort(list);
	  
	  
	  long sum = 0;
	  for(int i=0;i<list.size();i++){ //접점의 개수 만큼 돌면서 확인
		  Pair temp = list.get(i);
		  
		  int x = temp.x;
		  int y = temp.y;
//		  System.out.println(x+" "+y+" "+temp.value);
		  if(!isSame(x,y)){ //부모 노드가 같지 않으면 -> 사이클이 아니면, 
			  sum += temp.value;
			  unionFind(x,y); //연결된 선은 parent 배열 변경해두기
		  }
		  
	  }
	   System.out.println(sum);
}
}