package 가장먼노드;

import java.util.*;
class Solution {
   public static void main(String[] args){
       int[][] edgs ={{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
       solution(6,edgs);
   }
    public static int solution(int n, int[][] edge) {
        
        ArrayList<Integer>[] list = new ArrayList[n+1];
        int[] dist = new int[n+1];
        for(int i=1;i<=n;i++){
        	list[i] = new ArrayList<>();
		}
        Arrays.fill(dist,100000000);
        for(int i=0;i<edge.length;i++){
            int x = edge[i][0];
            int y = edge[i][1];
            list[x].add(y);
        }
        LinkedList<Integer> que = new LinkedList<>();
        
        que.add(1); //시작점인 1추가
        dist[1] = 0; //시작점과의 거리는 0
        while(!que.isEmpty()){
            int point = que.poll();
            
            for(int s=0;s<list[point].size();s++){
                int y = list[point].get(s);
                
                if(dist[y]> dist[point]+1){//dist에 원래 저장되어있던 값 > 이전 지점 +1
                    dist[y] = dist[point]+1;
                    que.add(y);
                }
                
                
                
            }
        }
        
         for(int s=1;s<=n;s++){
             System.out.print(dist[s]+" ");
         }
        int answer = 0;
        return answer;
    }
}