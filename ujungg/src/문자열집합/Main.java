package ���ڿ�����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   int N = Integer.parseInt(st.nextToken());
	   int M = Integer.parseInt(st.nextToken());
	   
	   HashMap<String,Integer> list1 = new HashMap<>();
	   LinkedList<String> list2 = new LinkedList<>();
	   for(int i=0;i<N;i++){
		   list1.put(br.readLine(),1);
	   }
	   
	   int cnt =0;
	   for(int i=0;i<M;i++){
		   String str = br.readLine();
		   if(list1.get(str) != null) cnt++;
		   
	   }
	
	   /*
	   for(int i=0;i<N;i++){
		   String str = list1.get(i);
		   if(list2.contains(str)) cnt++;   
		   
		   /*
		    *  ArrayList.contains() ȣ��� �ش� ���� list�� �ִ��� �Ǵ��ϱ� ���� ����������
		    *   indexOf(object) �޼��带 ����Ѵ�. 
		    *   indexOf(object) �޼���� array ��ü�� �ݺ��ؼ� ���� ������ element�� �񱳸� ������.
					: O(n) �� �ð��� �ɸ�
		   
	   }
   			*/
	   
	   System.out.println(cnt);
}
}