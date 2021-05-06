package 프_짝지어제거하기;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		String str = "baabaa";
		//solution(str);
	}

	/*
	public static int solution(String s)
    {
		String temp ="";
		for(int i=0;i<s.length();i++){
			if(s.length()-i < temp.length()) return 0;
			System.out.println(temp.toString());
			if(temp.length()>0){
				char before = temp.charAt(temp.length()-1);
				char now = s.charAt(i);
				
				if(before == now){
					temp = temp.substring(0, temp.length()-1);
				}else{
					temp += now;
				}
			}else{
				temp += s.charAt(i);
			}
		}
		
		if(temp.length()==0) return 1;
		else return 0;
//        int answer = 0;
//
//        System.out.println("Hello Java");
//
//        return answer;
    }
    */
	
	public int solution(String s)
    {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<s.length();i++){
			if(stack.size()>0){
				char top = stack.peek();
				if(top == s.charAt(i)){
					stack.pop();
				}else{
					stack.add(s.charAt(i));
				}
			}else{
				stack.add(s.charAt(i));
			}
		}
		
		
        if(stack.size()==0){
        	return 1;
        }else{
        	return 0;
        }
    }
}
