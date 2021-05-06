package Cubeditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int max =0;
	public static void getLength(String str){
		
//		String[] str = st.split("");
		int[] newArr = new int[str.length()];
		int j=0;
		
		for(int i=1;i<str.length();i++){
			 while(j>0 &&  str.charAt(i) !=str.charAt(j)){
				   j = newArr[j-1];
			   	}
				   if(str.charAt(i) ==str.charAt(j)){
					   newArr[i] = ++j;
					   max = Math.max(max, newArr[i]);
				   }
		}
		
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   String str = br.readLine();
	   
	   int j =0;
	   for(int i=0;i<str.length();i++){
		   getLength(str.substring(i,str.length()));
		   
	   }
	   
	  System.out.println(max);
	   
}
}