package Ã£±â;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
//	   st = new StringTokenizer(br.readLine());
	   
	   String s1 = br.readLine();
	   String s2 = br.readLine();
	  LinkedList<Integer> a1 = new LinkedList<>();
	  int count=0;
	   for(int s=0;s<s1.length()-s2.length();s++){
		   if(!s1.substring(s,s+1).equals(s2.substring(0,1))) continue;
		   String temp = s1.substring(s,s+s2.length());
//		   System.out.println(temp);
		   if(temp.equals(s2)){
			   count++;
			   a1.add(s);
		   }
	   }
	   
	   System.out.println(count);
	   for(int s=0;s<a1.size();s++){
		   int point = a1.get(s);
		   System.out.print((point+1)+" ");
	   }
	   
}
}