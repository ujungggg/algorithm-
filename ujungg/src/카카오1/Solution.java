package 카카오1;

import java.util.ArrayList;

class Solution {
	
	 public static void main(String[] args) {
	
		 String new_id= "...!@BaT#*..y.abcdefghijklm.";
		 solution(new_id);
		}
	 
	 static int total= 0;
	
	 public static String solution(String new_id) {
		 
		 String step1 = new_id.toLowerCase(); //1. 대문자를 소문자로
		
		 String step2 = step1.replaceAll("[^a-z0-9-_.]","");
		 String step3 = step2.replaceAll("[.]{2,}",".");
		 
		 System.out.println(step3);
		 if(step3.charAt(0)=='.'){
			 step3 = step3.substring(1,step3.length());
		 }
		 if(step3.length()> 1 && step3.charAt(step3.length()-1) =='.'){
			 step3 = step3.substring(0,step3.length()-1);
		 }
		 
		 System.out.println(step3);
		 if(step3.length()==0){
			 step3 = "a";
		 }
		 
//		 String step6 = "";
		 if(step3.length() > 15){
			 step3 = step3.substring(0,15);
			 if(step3.charAt(step3.length()-1) == '.') {
	                step3 = step3.substring(0, step3.length() - 1);
	            }
		 }
		 if(step3.length() <= 2) {
	            char last = step3.charAt(step3.length() - 1);
	            while(step3.length() < 3) {
	                step3 += last;
	            }
	        }
		 
	        String answer = step3;
	        System.out.println(answer);
	        
	        return answer;
	    }
   
}