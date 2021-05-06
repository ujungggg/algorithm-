package 프_줄서는방법;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		int n = 3;
		long k = 5;
		solution(n,k);
	}
    public static int[] visit ,finall, answer;
	
    public static int total = 0;
    public static boolean flag = false;
    public static HashSet<Integer> hash = new HashSet<>();
    /*
    public static void solve(int cnt, int n, long k){
        if(cnt == n){
        	total++;
        	System.out.println(total +" ???");
            if(total == k){
                 for(int i=0;i<n;i++){
                	 System.out.print(answer[i]+" ");
                	 finall[i] = answer[i];
                }System.out.println();
                 flag = true;
               return;
            }
           return;
        }else{
        	if(flag) return;
            for(int i=1; i<= n;i++){
                if(visit[i] == 0){
                    visit[i] = 1;
                    answer[cnt] = i;
                    solve(cnt+1, n, k);
                    visit[i] = 0;
                    answer[cnt] = 0;
                }
            }
        }
    }
    */
    
    public static void solve(int cnt, int n, long newk){
        if(cnt == n){
        	total++;
            if(total == newk){
            	
            	finall = Arrays.copyOf(answer, answer.length);
//            	finall = answer;
//                 for(int i=0;i<n;i++){
//                	 System.out.print(answer[i]+" ");
//                	 finall[i] = answer[i];
//                }System.out.println();
                 flag = true;
               return;
            }
           return;
        }else{
        	if(flag) return;
            for(int i=1; i<= n;i++){
//                if(visit[i] == 0){
            	if(!hash.contains(i)){
//                    visit[i] = 1;
            		hash.add(i);
                    answer[cnt] = i;
                    solve(cnt+1, n, newk);
//                    visit[i] = 0;
                    hash.remove(i);
                    answer[cnt] = 0;
                }
            }
        }
    }
    public static int[] solution(int n, long k) {
        visit = new int[n+1];
        answer = new int[n];
        finall = new int[n];
        
        int newTurn = 0;
        long newK = 0;
        int fac = 1;
        int temp = n-1;
        while(temp != 1){
        	fac*= temp;
        	temp--;
        }
        newTurn = (int) k / fac ;
        newK = (int) k % fac ;
        //newTurn 번째의 수에 newK 번째 값을 구하면 됨
        // 여기서 newTurn번째는 start가 i인것
//        for(int i=1;i<=n;i++){
//        System.out.println(newTurn+" "+newK);
//        	 visit[newTurn+1] =1;
        	 hash.add(newTurn+1);
        	 answer[0] = newTurn+1;
        	 solve(1,n,newK);
//        	 visit[0] = 0; 
        	 hash.remove(newTurn+1);
        	 answer[0] = 0;
//        }
       for(int i=0;i<n;i++){
    	   System.out.print(finall[i]+" ");
       }
      
        return finall;
    }
}
