package 점프점프;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
        int[] dp = new int[N+1];
       
        //간단한 코드
//        dp[0] = 1;
        
        for(int i=0;i<N;i++){
        	for(int j=1;j<=arr[i];j++){
        		if(i+j <N && (i==0 || dp[i]!=0 )&& ( dp[i+j]> dp[i]+1 || dp[i+j] ==0)){
        			dp[i+j] = dp[i]+1;
        		}
        	}
        }
//        for(int i=0;i<N;i++){
//      	System.out.print(dp[i]+" ");
//      }
        if(N==1){
        	System.out.println("1");
        }
        else if(dp[N-1] ==0){
        	System.out.println("-1");
        }else{
        	System.out.println(dp[N-1]);
        }
        /*//내가 푼 방식
        int answer = 100000000;
        boolean flag = false;
        if(N==1){
        	System.out.println("1");
        }else{
        	  for(int i=0;i<N;i++){
              	if(i==0 || dp[i]!=0){
              		   for(int j=1;j<=arr[i];j++){
                         	if(i+j > N-1) continue;
                             if(i+j ==N-1) {
//                             	System.out.println(i+"???");
                                 answer = Math.min(answer, dp[i] + 1);
                             }
                             else if(dp[i+j]!=0){
                                 dp[i+j] = Math.min(dp[i+j],dp[i] +1);
                             }else{
                                 dp[i+j] = dp[i] + 1;
                             }
                             
                         }    
              	}
               
              }
//              for(int i=0;i<N;i++){
//              	System.out.print(dp[i]+" ");
//              }
              
            if(answer == 100000000){
          	  System.out.println("-1");
            }else{
          	  System.out.println(answer);
            }
        }
      */
       
            
	}
}

