package 라인2.copy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
	public static void main(String[] args) {
		int n= 9;
		
		
		solution(n);
	}
	static int min =100000000;
	static int resultNumber =0;
	public static void solve(int cnt,int start,int num){//더하기 개수. 값
		String number = Integer.toString(num);
		if(number.length() == 1){
			
			if(cnt<min){
//				System.out.println("바뀜");
//				System.out.println(cnt+" "+num);
				min = cnt;
				resultNumber = num;
			}
			
			return;
		}else{
			for(int i= start; i<number.length();i++ ){
				if(Integer.parseInt(number.substring(i,i+1)) != 0){
//					System.out.println(number.substring(0,i));
//					System.out.println(number.substring(i,number.length()));
//					System.out.println("---------------");
					int result = Integer.parseInt(number.substring(0,i)) + Integer.parseInt(number.substring(i,number.length()));
					solve(cnt+1, start, result);
				}
				
				}
			}
		}
		
	public static int[] solution(int n) {
        
		String number = Integer.toString(n);
		
		if(number.length()>1){
			for(int i=1;i<number.length();i++){
				if(Integer.parseInt(number.substring(i,i+1)) != 0){
					int result = Integer.parseInt(number.substring(0,i)) + Integer.parseInt(number.substring(i,number.length()));
//					System.out.println(result);
					solve(1,1, result);
				}
//				System.out.println(number.charAt(i));
//				System.out.println(number.substring(0,i));
//				System.out.println(number.substring(i,number.length()));
				
				}
		}else{
			min = 0;
			resultNumber = n;
		}
		
		System.out.println("min"+min);
		System.out.println("resultNumber"+resultNumber);
		int[] answer = new int[2];
		answer[0]= min;
		answer[1]= resultNumber;
        return answer;
        
    }
}