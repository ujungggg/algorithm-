package _1로만들기;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		
		LinkedList<Integer> list = new LinkedList<>();
		arr[N] = 0;
		list.add(N);
		int time =1000000000;
		while(!list.isEmpty()){
			int num = list.remove();
			if(num == 1) {
				time = Math.min(arr[num],time);
			}
			if(num >0 && num%3 ==0 && arr[num%3] ==0){
				arr[num%3] = arr[num] +1;
				list.add(num/3);
//				if(num/3 == 1) {
//					time = arr[num];
//					break;
//					}
			}
			if(num >0 && num%2 ==0 && arr[num%2]==0 ){
				arr[num%2] = arr[num]+1;
				list.add(num/2);
//				if(num/2 == 1) {
//					time = arr[num];
//					break;
//					}
			}
			if(num >0 && arr[num-1] ==0){
				arr[num-1] = arr[num]+1;
				list.add(num-1);
//				if(num-1 == 1) {
//					time = arr[num];
//					break;
//					}
			}
		}
		System.out.println(time);
	}
}

