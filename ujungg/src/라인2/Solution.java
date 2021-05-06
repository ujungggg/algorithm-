package 라인2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
	public static void main(String[] args) {
		int n= 74325;
		
		
		solution(n);
	}
	static int min =100000000;
	static int resultNumber =0;
	public static void solve(int cnt,int start,int num){//더하기 개수. 값
		String number = Integer.toString(num);
		if(number.length() == 1){
			if(cnt<min){
				min = cnt;
				resultNumber = num;
			}
			
			return;
		}else{
			for(int i= start; i<number.length();i++ ){
				if(i+1<number.length()){
					if( number.charAt(i+1) !='0'){
						
						if(i+1<number.length() && number.charAt(i) == '0'){
//							System.out.println(number.substring(0,i));
//							System.out.println(number.substring(i,number.length()));
							int result = Integer.parseInt(number.substring(0,i+1)) + Integer.parseInt(number.substring(i+1,number.length()));
							solve(cnt+1, i, result);
						}else{
//							System.out.println(number.substring(0,i));
//							System.out.println(number.substring(i,number.length()));
							int result = Integer.parseInt(number.substring(0,i)) + Integer.parseInt(number.substring(i,number.length()));
							solve(cnt+1, i, result);
						}
						
					}
				}
				
				else{ //두자리수일때
					int result = Integer.parseInt(number.substring(0,1)) + Integer.parseInt(number.substring(1,2));
					solve(cnt+1, start, result);
				}
			}
		}
	}
	
	public static int[] solution(int n) {
        
		String number = Integer.toString(n);
		
		if(number.length()>1){
			for(int i=1;i<number.length();i++){
				System.out.println(number.charAt(i));
				if(number.charAt(i+1) !='0'){
					if(i+1<number.length() && number.charAt(i) == '0'){
						int result = Integer.parseInt(number.substring(0,i+1)) + Integer.parseInt(number.substring(i,number.length()));
//						System.out.println(result);
						solve(1,1, result);
					}else{
						int result = Integer.parseInt(number.substring(0,i)) + Integer.parseInt(number.substring(i,number.length()));
//						System.out.println(result);
						solve(1,1, result);
					}
					
				}
			}
		}else{
			min = 0;
			resultNumber = n;
		}
		
		System.out.println("min"+min);
		System.out.println("resultNumber"+resultNumber);
		int[] answer = {};
        return answer;
        
    }
}