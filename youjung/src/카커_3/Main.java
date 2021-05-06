package īĿ_3;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		int n = 4;
		int[] passenger = {2,1,2,2};
		int[][] train = {{1,2},{1,3},{2,4}}	;
		
		solution(n,passenger,train);
	}
	public static boolean[][] arr;
	public static int[] value;
    public static int[] solution(int n, int[] passenger, int[][] train) {
    	
    	arr = new boolean[n+1][n+1];
    	value = new int[n+1];
    	
    	for(int i=0;i<train.length;i++){
    		arr[train[i][0]][train[i][1]] = true;
    	}
    	/*
    	for(int i=1;i<=n;i++){
    		for(int j=1;j<=n;j++){
    			if(i==1 && arr[i][j]){
    				int num = passenger[i-1] + passenger[j-1];
    				int tempNum = Math.max(num, value[j]);
    				value[j] += tempNum;
    			}else if(i!=1 && arr[i][j]){
    				int tempNum = Math.max(value[i] + passenger[j-1], value[j]);
    				value[j] += tempNum;
    			}
    		}
    	}
    	*/
    	for(int t=0;t<train.length;t++){
    		int i = train[t][0];
    		int j = train[t][1];
    		if(i==1){
				int num = passenger[i-1] + passenger[j-1];
				value[j] += num;
			}else if(i!=1){
				int tempNum = Math.max(value[i] + passenger[j-1], value[j]);
				value[j] += tempNum;
			}
    	}
    	int max =0; 
    	int dest = 0;
    	for(int i=1;i<=n;i++){
    		System.out.print(value[i]+" ");
    	}System.out.println();
    	
    	for(int i=1;i<=n;i++){
    		if(value[i] == max && i>dest){
    			dest = i;
			}else if(value[i]>max){
				max = value[i];
				dest = i;
			}
    			
    			
    		
    	}
        int[] answer = {dest, max};
        System.out.println(dest+ " "+ max);
        return answer;
    }
}