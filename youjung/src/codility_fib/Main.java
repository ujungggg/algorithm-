package codility_fib;
import java.util.*;

class Solution {
    public static class Pair{
        int x; int time;
        Pair(int x, int time){
            this.x=x;
            this.time = time;
        }
    }
    
    public static void main(String[] args) {
    	int[] A ={0,0,0,1,1,0,1,0,0,0,0};
//    	int[] A ={1};
		solution(A);
	}
    
    public static Map<Integer,Integer> fibo = new HashMap<>();
    public static int getFibo(int num){
    	if(num ==0 ) return 0;
    	if(num==1) return 1;
    	if(fibo.containsKey(num)) return fibo.get(num);
    	fibo.put(num, fibo.get(num-1) + fibo.get(num-2));
    	return fibo.get(num);
    }
    public static int solution(int[] A) {
      
    	
       int N = A.length;
       fibo.put(0, 0);
       fibo.put(1, 1);
       for(int i=0;i<=N+1;i++){
           getFibo(i);
           
       }

       ArrayList<Integer> fib = new ArrayList<>(fibo.values());
       Collections.reverse(fib);

       boolean flag = false;
       LinkedList<Pair> que = new LinkedList<>();
       int[] visit = new int[N];
      
       que.add(new Pair(-1,0));

        int totalTime = 0;
       while(!que.isEmpty()){

           Pair temp = que.remove();
           int tx = temp.x; int time = temp.time;

            for(int s=0;s<fib.size();s++){
                
                int x = tx + fib.get(s);
                
                if(x == N){
                	flag = true;
                    return time+1;
                }  
                else if(x>=0 && x< N &&  A[x]==1 && visit[x] ==0 ){
                	visit[x] = 1;
                    que.add(new Pair(x,time+1));
                }
                 
            }
       }
       return -1;

    }
}