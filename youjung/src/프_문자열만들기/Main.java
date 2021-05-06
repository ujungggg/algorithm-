package 프_문자열만들기;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		String str = "3people unFollowed me";
		solution(str);
	}
    public static String solution(String s) {
        String str = "";
         if(s.charAt(0)>='a' && s.charAt(0) <= 'z'){
        	 	String temp = s.charAt(0)+"";
                str += temp.toUpperCase();
            }else{
            	str += s.charAt(0);
            }
        for(int i=1 ;i<s.length();i++){
           if(s.charAt(i-1)==' '){
        	   String temp = s.charAt(i)+"";
               str += temp.toUpperCase();
           }else{
        	   String temp = s.charAt(i)+"";
                str += temp.toLowerCase();
           }
        }
                String answer = str;
        System.out.println(answer);
        return answer;
    }
}
