package �Ҿ������ȣ;


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
	   //str���� -�� ������ ���������� ���� �������
	   
	   int ans = Integer.MAX_VALUE;
	   
	   for(int i=0;i<str.length;i++){
		   int temp =0;
		   //str[i] �ȿ��� + �� �̾��� ������ ���� -> �� �ȿ����� + ����� ��� ����
		   String[] arr = str[i].split("\\+"); // +�� split ���ٶ��� \\�� �־����
		   for(int s=0;s<arr.length;s++){
			   temp += Integer.parseInt(arr[s]);
		   }
		   if(ans == Integer.MAX_VALUE){
			  ans = temp; // ù��° ���� ���ڸ� ans �� temp�� �־���
		   }else{
			   ans -= temp; //ù��° ���ĺ��ʹ� ���� ������ ���ָ� ��
		   }
		   
	   }
	 System.out.println(ans);
} 
}