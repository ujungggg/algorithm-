package 퍼즐;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static class Pair{
		String str; int time;
		Pair(String str, int time){
			this.str= str;
			this.time = time;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String answer = "123456780";
		
		String strs = "";
		for(int i=0;i<3;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++){
				strs += st.nextToken();
			}
		}
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	//	boolean[] visit = new boolean[987654321];
		boolean flag = false;
		
		LinkedList<Pair> list = new LinkedList<>();
		HashSet<String> set = new HashSet<>();
		
		int totalTime =0;
		list.add(new Pair(strs,0));
		while(!list.isEmpty()){
			
			Pair temp = list.remove();
			String str = temp.str;
			int time = temp.time;
//			System.out.println(str);
			if(str.equals(answer)) {
				totalTime = time;
				flag = true;
				break;
			}
			
			int point = str.indexOf('0');
			int x = point/3;
			int y = point%3;
			
			for(int d=0;d<4;d++){
				int newX = x+ dir[d][0];
				int newY = y+ dir[d][1];
				if(newX<0 || newY<0 || newX>=3 || newY>=3) continue;
				
				int newPoint =  newX*3 + newY ;
				//arr[newX][newY]에 있는거랑 arr[x][y](현재 0의 자리)의 값을 바꾼다
				//그 자리는 newX*3 + newY 
				
				 StringBuilder sb = new StringBuilder(str);
			     sb.setCharAt(point, str.charAt(newPoint));
			     sb.setCharAt(newPoint, str.charAt(point));
			     
			     String tmpString = sb.toString();
			     
			     if(! set.contains(tmpString)){
		    		 set.add(tmpString);
		    		 list.add(new Pair(tmpString, time+1));
		    	 }	 
			    
			}
		}
//		System.out.println(totalTime);
		if(flag) {
			System.out.println(totalTime);
		}else{
			System.out.println("-1");
		}
		
		
		
		
	}
}

