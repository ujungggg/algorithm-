package 프_거스름돈;
import java.util.*;
class Solution {
    static LinkedList<Integer> list = new LinkedList<>();
    
    public static void findArr(int[] money){
        for(int i=0;i<money.length;i++){
        
            boolean flag = false;
            if(money[i] == 1) continue;
            if(money[i] == 2){
            	 flag = false; //소수가 아님
                 
            }
            else if(money[i]>2){
                for(int j=2;j< money[i];j++){
                if(money[i] % j ==0){
                    flag = true; //소수가 아님
                    break;
                }
            }
            }
            
            if(!flag){
                list.add(money[i]); //소수라는 뜻
            }
        }
    }
    
    public static boolean getTrue(int num){
        for(int s=0; s<list.size(); s++){
            int n = list.get(s);
//            System.out.println( n+" ??");
            if(num % n ==0) return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
		int n = 5;
		int[] money = {1,2,5};
		
		solution(n,money);
	}
    public static int solution(int n, int[] money) {
        
        findArr(money);
      
        int[] total = new int[n+1];
        
        total[money[0]] = 1; //money에서 가장 작은 값이 시작점이 됨
        
        for(int i=2 ; i<=n;i++){
            if(getTrue(i)){
                total[i] = (total[i-1] +1) % 1000000007;
            }else{
            	total[i] = total[i-1] % 1000000007;
            }
        }
        
        
        int answer = total[n];
        System.out.println(answer);
        return answer;
    }
}
