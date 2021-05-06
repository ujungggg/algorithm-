package 프_숫자의표현;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		solution(15);
	}
    public static int solution(int n) {
        
    	/*
    	LinkedList<Long> list = new LinkedList<>();
    	long num = 0;
    	int cnt =0;
    	for(int i=0;i<=n;i++){
    		num += i;
    		list.add(num);
    		if(list.contains(num - n)){
    			cnt++;
    		}
    	}
    	
    	*/
    	int cnt =0;
    	for(int i=1;i<=n;i++){
    		int num = 0;
    		for(int j=i;j<=n;j++){
    			num += j;
    			
    			if(num == n){
    				cnt++;
    				break;
    			}else if(num > n){
    				break;
    			}
    		}
    	}
    	int answer = cnt;
    	System.out.println(answer);
        return answer;
    }
}

