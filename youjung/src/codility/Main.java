package codility;
import java.util.*;


class Solution {
 
 public static Stack<Integer> stack = new Stack<>();

 public static void main(String[] args) {
//	int[] H = {8,8,5,7,9,8,7,4,8};
	 int[] H = {2, 3, 2, 1};
	 solution(H);
}
 public static int solution(int[] H) {
     int need =0;
     
     for(int i=0;i<H.length;i++){
    	 
    	 while(!stack.isEmpty() && stack.peek()> H[i]){
    		 	//stack 위에 있는게 H[i]보다 클때 계속 하는 이유는 언젠가 stack에 딱 맞는 수가 들어있을 수 있으니까
    		 stack.pop();
    	 }
    	 if(stack.isEmpty() || stack.peek() <H[i]){
    		 stack.push(H[i]);
    		 need++;
    	 }
    	 
    	 
     }
     /*
    for(int i=0;i<H.length;i++){
    	
    	
    	
        if(stack.size() ==0){
            stack.push(H[i]);
            need++;
        }
        else {
            int top = stack.peek();
//            for(int a=0;a<stack.size();a++){
//            	System.out.print(stack.get(a)+" ");
//            	
//            }
//            System.out.println();
            if(top == H[i]) continue;
            else if(top < H[i]){
                stack.push(H[i]);
                 need ++;
            }
            else if(top > H[i]){
                while(true){
                	int temp = stack.pop();
                	if(temp < H[i]){
                		stack.push(temp);
                		need++;
                		break;
                	}
                	else if(temp== H[i]){
                		stack.push(temp);
                		break;
                	}
                	else if(stack.size() ==0) { 
                		stack.push(H[i]);
                		need++;
                		break;
                	}
                	
                }
            }
        }
        
    }
    */
    System.out.println(need);
    return need;
 }
}



