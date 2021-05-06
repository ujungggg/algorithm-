package 프_문자열압축;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		solution("a");
		
		
	}
    public static int solution(String s) {
    	int min = 1000000000;
    	int length = s.length();
    	if(length>1){
    	for(int i=1;i<= length/2;i++){ //압축할 문자열 길이
    		int cnt = 1;
    		String first, last = "";
    		String temp =""; String total = ""; 
    		boolean flag = false;
    		
    		
    			for(int j=0 ; j<= length/i; j++){
        			
        			first = last;
        			if(i*(j+1) > length){ //짜르는 길이가 length 넘어가면 그냥 끝까지
        				last = s.substring(i * j ,length);
        			}else{
        				last = s.substring(i * j , i* (j+1));
        			}
        			
        			flag = false;
        			if(first.equals(last)){
        				cnt++;
        				temp = cnt + first;
        				flag = true;
        			}else{
        				if(temp.length()>1){
            				total = total + temp;
        				}else{
        				    total += first;
        				}
        				cnt = 1;
        				temp = "";
        			}
        		}
        		if(flag){
        			total += temp;
        		}else{
        			total += last;
        		}
        		
        		System.out.println(total+ "   total");
        		min = Math.min(total.length(), min);
        		
        	}
    		}else{
    			min = 1;
    		}
    		
    			
        int answer = min;
        System.out.println(min +" max");
        return answer;
    }
}

