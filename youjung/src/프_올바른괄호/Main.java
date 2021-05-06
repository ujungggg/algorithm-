package 프_올바른괄호;
import java.util.*;

class Solution {
	static int max =0;
	
	public static void main(String[] args) {
		
		solution("()))((()");
	}

	 static boolean solution(String s) {
		 
		 Stack<Character> stack = new Stack<>();
		 
		 boolean answer = false;
		 /*
		 for(int i=0;i<s.length();i++){
			 char ch = s.charAt(i);
			 
			 if(i==0){
				 if(ch==')'){
					 stack.push(ch);
//					 answer = false;
					 break;
				 }else{
					 stack.add(ch);
				 }
			 }else{
				 if(ch == ')'){
					 if(stack.size()>0){
						 char peek = stack.peek();
						 if(peek=='('){
							 stack.pop();
						 }else{ // 위에서 꺼낸게 ')'이면
							 stack.add(ch);
						 }
					 }else{
						 stack.add(ch);
						 break;
					 }
					
				 }else{
					 stack.add(ch);
				 }
			 }
			 
		 }
	     
	     */
		 //간단한 방법..
		 for(int i=0;i<s.length();i++){
			 if(s.charAt(i) == '('){
				 stack.add(s.charAt(i));
			 }else{
				 if(!stack.isEmpty()){
					 stack.pop();
				 }else{
					 return false;
				 }
				
			 }
		 }
		 if(stack.size()==0) answer = true;
//		 System.out.println(answer);
		 return answer;
	    }
}
