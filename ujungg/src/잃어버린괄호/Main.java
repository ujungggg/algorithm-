package 잃어버린괄호;


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
	static int M;
	static int[][] arr;
	static int[][] move;
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   String str1 = br.readLine();
	   String[] str =str1.split("-"); 
	   //str에는 -가 나오기 이전까지의 값이 담겨있음
	   
	   int ans = Integer.MAX_VALUE;
	   
	   for(int i=0;i<str.length;i++){
		   int temp =0;
		   //str[i] 안에는 + 로 이어진 수들이 있음 -> 그 안에서의 + 계산을 모두 해줌
		   String[] arr = str[i].split("\\+"); // +로 split 해줄때는 \\을 넣어야함
		   for(int s=0;s<arr.length;s++){
			   temp += Integer.parseInt(arr[s]);
		   }
		   if(ans == Integer.MAX_VALUE){
			  ans = temp; // 첫번째 나온 숫자면 ans 에 temp를 넣어줌
		   }else{
			   ans -= temp; //첫번째 이후부터는 나온 값들을 빼주면 됨
		   }
		   
	   }
	 System.out.println(ans);
} 
}