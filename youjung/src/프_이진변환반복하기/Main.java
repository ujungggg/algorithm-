package 프_이진변환반복하기;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		String s = "01110";
		solution(s);
	}
    public static int[] solution(String s) {
        
    	int cnt =0; 
    	int erase =0;
        while(!s.equals("1")){
            String temp = "";
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '1'){
                    temp+= s.charAt(i);
                }else{
                	erase++;
                }
            }
          
           
            if(s.equals("1")) break;
            s =Integer.toBinaryString(temp.length());
            cnt++;
        }
        System.out.println(cnt+ " "+ erase);
        int[] answer = {cnt, erase};
        return answer;
    }
}