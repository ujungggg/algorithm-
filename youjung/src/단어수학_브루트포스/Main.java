package 단어수학_브루트포스;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<String> list = new LinkedList<>();
	static int total =0;
	static boolean[] check = new boolean[31];
	static int[] arr = new int[31];
	static boolean[] visit = new boolean[11];
	static int max =0;
	
	public static void make(int num, int cnt){
		if(cnt == total){
			max = Math.max(calculate(),max);
			return;
		}else{
			if(check[num]){
				for(int i=0 ; i<=9; i++){
					if(!visit[i]){
						visit[i] = true;
						arr[num] = i;
						make(num+1, cnt+1);
						visit[i] = false;
					}
				}
			}
			else{
				make(num+1 ,cnt);
			}
		}
	}
	
	public static int calculate(){
		
		int totalNum = 0;
		for(int i=0;i<list.size();i++){
			String num = list.get(i);
			String strs = "";
			int temp =0;
			for(int s=0;s<num.length();s++){
				temp *= 10;
				temp += arr[num.charAt(s)-'A'];
			}
//			System.out.println(strs);
//			totalNum += Integer.parseInt(temp);
			totalNum += temp;
		}
//		System.out.println("= "+totalNum);
//		System.out.println("---------------------");
		return totalNum;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++){
			String str = br.readLine();
			list.add(str);
			
			for(int j=0;j<str.length();j++){
				int num = str.charAt(j) -'A';
				if(!check[num]){
					total++;
					check[num] = true;
				}
				
			}
		}
		
		make(0,0); //start , cnt
		System.out.println(max);
	}
}



