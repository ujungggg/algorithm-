package 프_수식최대화;
import java.util.*;

class Solution {
	
	static LinkedList<Long> list;
	static LinkedList<Character> op;
	static boolean[] visit;
	static int[] check;
	static long max =0;
	public static void main(String[] args) {
		String str  ="50*6-3*2";
//		String str = "100-200*300-500+20";
		solution(str);
	}
	
	public static void solve(int cnt){
		if(cnt == 3){
			long value = math();
//			System.out.println(value);
			max = Math.max(Math.abs(value), max);
			return;
		}else{
			//0: + 1:- 2:*
			for(int i=0 ; i<3;i++){
				if(!visit[i]){
					visit[i] = true;
					check[cnt] = i;
					solve(cnt+1);
					visit[i] = false;
				}
			}
		}
	}
	/*
	public static int math(){
		LinkedList<Integer> tempList = new LinkedList<>(list);
		LinkedList<Character> tempOp = new LinkedList<>(op);
		
		//
		for(int i=0;i<op.size();i++){
			
			
			char nowOp = op.get(check[i]);
			
			while(tempOp.contains(nowOp)){
				int place = tempOp.indexOf(nowOp);
				tempOp.remove(place);
				int num1 = tempList.remove(place);
				int num2 = tempList.remove(place);
				
				int value =0;
				if(nowOp =='+'){
					value = num1 + num2;
				}else if(nowOp =='-'){
					value = num1 - num2;
				}else if(nowOp =='*'){
					value = num1 * num2;
				}
				
				tempList.add(place,value);
			}
			
			
		}
		
		return tempList.get(0);
	}
	
	*/
	
	public static long math(){
		LinkedList<Long> tempList = new LinkedList<>(list);
		LinkedList<Character> tempOp = new LinkedList<>(op);
		
		for(int i=0;i<3;i++){
			int prior = check[i];
			
			char nowOp = ' ';
			if(prior == 0){
				 nowOp = '+';
				
			}else if(prior ==1){
				 nowOp = '-';
				
			}else if(prior ==2){
				 nowOp = '*';
				
			}
			while(tempOp.contains(nowOp)){
				int place = tempOp.indexOf(nowOp);
				tempOp.remove(place);
				long num1 = tempList.remove(place);
				long num2 = tempList.remove(place);
				
				long value =0;
				if(nowOp =='+'){
					value = num1 + num2;
				}else if(nowOp =='-'){
					value = num1 - num2;
				}else if(nowOp =='*'){
					value = num1 * num2;
				}
				
				tempList.add(place,value);
			}
		}
		
		return tempList.get(0);
	}
	 public static long solution(String expression) {
		 
		 list = new LinkedList<>();
		 op = new LinkedList<>();
		 String num = "";
		for(int i=0;i<expression.length();i++){
			if(expression.charAt(i)>='0' && expression.charAt(i)<='9'){
				num += expression.charAt(i);
			}else{
				list.add(Long.parseLong(num));
				num = "";
				op.add(expression.charAt(i));
			}
		}
		list.add(Long.parseLong(num));
		visit = new boolean[op.size()];
		check= new int [op.size()];
		solve(0);  // start, cnt, value
	        long answer = max;
//	        System.out.println("max"+max);
	        return answer;
	    }
}

