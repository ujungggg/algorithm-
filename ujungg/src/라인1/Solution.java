package ∂Û¿Œ1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
	public static void main(String[] args) {
		int[][] boxes = {{1, 2}, {2, 3}, {3, 1}};
		
		
		solution(boxes);
	}
	public static int solution(int[][] boxes) {
		int[] visit = new int[1000000];
		
		for(int i=0;i<boxes.length;i++){
		   for(int j=0;j<2;j++){
			   visit[boxes[i][j]] ++;
		   }
		}
		
		int result =0;
		for(int s=0;s<visit.length;s++){
			if(visit[s]%2 !=0){
				result++;
			}
		}
		
        int answer = result/2 ;
        System.out.println(answer);
        return answer;
    }
}