package 도시분할계획;
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
		int x; int y; int value;
		Pair(int x, int y, int value){
			this.x= x;
			this.y=y;
			this.value= value;
		}
		
		@Override
		public int compareTo(Pair o) {
			return this.value - o.value;
		}
		
	}
	
	public static int getUnion(int x){
		if(parent[x] == x) return x;
		return parent[x] = getUnion(parent[x]);
	}
	
	public static void getLine(int a, int b){ //부모 노드를 이어줌 
		int x = getUnion(a);
		int y = getUnion(b);
		
		if(x!=y){
			if(x<y){ // 2 3 parent[3] = 2
				parent[y] = x;
			}else{
				parent[x] = y;
			}
		}
	}
	public static boolean isParent(int x, int y){
		x = getUnion(x);
		y = getUnion(y);
		if(x == y) return true;
		else return false;
	}

   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   
	   int N = Integer.parseInt(st.nextToken());
	   int M = Integer.parseInt(st.nextToken());
	   
	   ArrayList<Pair> list = new ArrayList<>();
	   for(int i=0;i<M;i++){
		   st = new StringTokenizer(br.readLine());
		   int x = Integer.parseInt(st.nextToken());
		   int y = Integer.parseInt(st.nextToken());
		   int value = Integer.parseInt(st.nextToken());
		   
		   list.add(new Pair(x,y,value));
	   }
	   
	   parent = new int[N+1];
	   for(int i=1;i<=N;i++){
		   parent[i] = i;
	   }
	   
	   Collections.sort(list);
	   
	   
	   long sum =0;
	   int cnt =0 ;
	   for(int i=0;i<list.size();i++){
		   if(cnt == N-2) break; //모든 도시를 연결하기 위해선 N-1개의 간선 연결해야함.
		    					 // 마지막으로 추가되는 간선이 제일 큰 값이니까 이거 제외하면 마을 분리됨
		   
		   Pair temp = list.get(i);
		   int x =temp.x;
		   int y = temp.y;
		   int value =temp.value;
		   System.out.println(x+" "+y+" "+value);
		   if(!isParent(x,y)){
			   cnt++;
			   sum+=value;
			   getLine(x,y);
		   }
		   
		   for(int t =1;t<=N;t++){
			   System.out.print(parent[t]+" ");
		   }System.out.println();
	   }
	   System.out.println(sum);
}


}