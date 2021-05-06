package ÁÂÇ¥Á¤·ÄÇÏ±â;

import java.io.*;
import java.util.*;

public class Main {
	
	static class Pair implements Comparable<Pair>{
		int x; int y;
		Pair(int x, int y){
			this.x= x;
			this.y=y;
	
		}
		
		//ÁÂÇ¥¸¦ yÁÂÇ¥°¡ Áõ°¡ÇÏ´Â ¼øÀ¸·Î, yÁÂÇ¥°¡ °°À¸¸é xÁÂÇ¥°¡ Áõ°¡ÇÏ´Â ¼ø¼­
		@Override
		public int compareTo(Pair p){
			if(this.y == p.y){
				return this.x - p.x;
			}else{
				return this.y - p.y;
			}
		}

		
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st ;
	   
	   st = new StringTokenizer(br.readLine());
	   
	   int N = Integer.parseInt(st.nextToken());
	   
	   ArrayList<Pair> list = new ArrayList<>();
	   for(int i=0;i<N;i++){
		   st = new StringTokenizer(br.readLine());
		   int x = Integer.parseInt(st.nextToken());
		   int y = Integer.parseInt(st.nextToken());
		   list.add(new Pair(x,y));
	   }
	  
	  Collections.sort(list);
	   
	   for(int i=0;i<N;i++){
		   Pair temp = list.get(i);
		   int x = temp.x;
		   int y = temp.y;
		   System.out.println(x+" "+y);
	   }

}
}