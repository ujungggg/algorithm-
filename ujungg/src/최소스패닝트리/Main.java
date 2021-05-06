package �ּҽ��д�Ʈ��;
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
	public static int getFind(int x){ //����Լ��� ����Ͽ� �� ����� �θ� ��� ã��
		if(parent[x] == x) return x; //����Լ��� ������ �κ� -> �ֻ����� ��忡 �����ϸ� ����
		return parent[x] = getFind(parent[x]);
	}
	
	public static void unionFind(int a, int b){ //����Ǵ� ��带 ��ġ�� ���
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
	  for(int i=0;i<list.size();i++){ //������ ���� ��ŭ ���鼭 Ȯ��
		  Pair temp = list.get(i);
		  
		  int x = temp.x;
		  int y = temp.y;
//		  System.out.println(x+" "+y+" "+temp.value);
		  if(!isSame(x,y)){ //�θ� ��尡 ���� ������ -> ����Ŭ�� �ƴϸ�, 
			  sum += temp.value;
			  unionFind(x,y); //����� ���� parent �迭 �����صα�
		  }
		  
	  }
	   System.out.println(sum);
}
}