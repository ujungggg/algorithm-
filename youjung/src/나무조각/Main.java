package 나무조각;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[6];
		for(int i=1;i<=5;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		while(true){
			boolean flag = true;
			for(int i=1;i<=5;i++){
				if(i!=arr[i]){
					flag = false;
					break;
				}
			}
			if(flag){
				break;
			}
		
			for(int i=1;i<5;i++){
				boolean flag2 = false;
				if(arr[i]> arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					flag2 = true;
				}
				if(flag2){
					for(int a=1;a<=5;a++){
						System.out.print(arr[a]+" ");
					}System.out.println();
				}
				
			}
				
		}
	}
}



