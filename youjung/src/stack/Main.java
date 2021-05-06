package stack;
//you can also use imports, for example:
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {

 public static void main(String[] args) {
	 String s = "{[()()]}";
	solution(s);
}
 public static Stack<Character> stack = new Stack<>();
 public static int solution(String S) {
     
     for(int s=0; s<S.length();s++){
         char ch = S.charAt(s);

         if(ch == '{' ||ch == '[' ||ch == '('){
             stack.push(ch);
         }else {
             char temp = stack.peek();
             if(ch == '}'){
                 if(temp == '{') stack.pop();
                 else stack.push(ch);
             }else if(ch == ')'){
                 if(temp == '(') stack.pop();
                 else stack.push(ch);
             }else if(ch == ']'){
                 if(temp == '[') stack.pop();
                 else stack.push(ch);
             }
         }
     }
     if(stack.size() ==0) {
    	 System.out.println("1");
    	 return 1;
     }
     else {
    	 System.out.println("0");
    	 return 0;
     }
 }
}




