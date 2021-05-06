package 프_다음큰숫자;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		solution(78);
	}
	public static int count(int n){
		int cnt = 0;
		while(n != 0){
			if(n%2 == 1){
				cnt++;
			}
			n = n/2;
			
		}
		
		return cnt;
	}
	
	public static int getCount(String str){
		int cnt =0;
		for(int i=0;i<str.length();i++){
    		if(str.charAt(i) == '1') cnt++;
    	}
		return cnt;
	}
    public static int solution(int n) {
    	
//    	int first = count(n);
    	
    	String binaryN = Integer.toBinaryString(n);
    	
    	int cnt = getCount(binaryN);
    	
    	int num = n+1;
    	while(getCount(Integer.toBinaryString(num)) != cnt){
    		num++;
    	}
    	
    	System.out.println(num);
        int answer = num;
        return answer;
    }
}
