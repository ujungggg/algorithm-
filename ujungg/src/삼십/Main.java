package 삼십;

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
	
	public static boolean flag = false;
	public static int[] visit;
//	public static String before = "";
	public static int max  =0;
	public static String[] list;
	
	public static void solve(String str, String temp,int start ,int cnt,String before){
		if(cnt==str.length()){
//			System.out.println(temp);
			if(Integer.parseInt(temp) % 30 ==0){
				max = Math.max(max, Integer.parseInt(temp));
				flag = true;
			}
			return;
		}else{
			for(int i= start;i<str.length();i++){
				if(flag) break;
				 if(visit[i]==0){
					   visit[i]=1;
					   before = temp;
					   temp+= list[i];
					   
					   solve(str,temp,start+1,cnt+1,before);
					   if(flag) break;
					   visit[i]=0;
//					   System.out.println(before);
					   temp = before;
				   }
			}
		}
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
//	   st = new StringTokenizer(br.readLine());
	 
	   String str = br.readLine();
	   visit = new int[str.length()+1];
	   list = new String[str.length()+1];
	   list = str.split("");
	   
	   Arrays.sort(list , Collections.reverseOrder());
	   
	   boolean flags = false;
	   String maxs = "";
	   int total = 0;
	   for(int s=0;s<list.length;s++){
		   maxs += list[s];
		   total += Integer.parseInt(list[s]);
		   if(list[s].equals("0") ){
			   flags = true;
		   }
	   }
	   
	   if(!flags ||  total %3 !=0) {
		  System.out.println("-1");
	   }else{
		   System.out.println(maxs);
	   }
	   //1. 내림차순 정렬후 조합 방법 생각 -> 메모리 초과
	   /*
	   String temp = "";
	   for(int i=0;i<str.length();i++){
		   if(visit[i]==0){
			   visit[i]=1;
			   String before = temp;
			   temp+= list[i];
			   
			   solve(str,temp,i,1,before);
			   visit[i]=0;
			   temp = before;
		   }
		   
		   
	   }
	   
	   if(max ==0){
		   System.out.println(-1);
	   }else{
		   System.out.println(max);
	   }
	 
	   */
	   
}
}