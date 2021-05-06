package 단어변환;



class Solution {
	
	static int[] visit ; 
	static int min = 10000000;
	 public static void main(String[] args) {
	 
	 String begin ="hit";
	 String target = "cog";
	 String[] words ={"hot", "dot", "dog", "lot", "log"};
	
	 solution(begin, target,words);
		}
	 
	
	 public static int check(String word, String begin){
		 int same =0;
		 for(int i=0;i<word.length();i++){
			 if(word.charAt(i) == begin.charAt(i)){
				 same++;
			 }
		 }
		 return same;
	 }
	 
	 public static void solve(String target, String word, int cnt, String[] words){
		 if(word.equals(target)){
			 min = Math.min(cnt,min);
//			 System.out.println(min);
			 return;
		 }else{
			 for(int a=0;a<words.length;a++){
					if(visit[a] ==0 && check(words[a],word)>=words[a].length()-1){
						visit[a]=1;
						solve(target, words[a],cnt+1, words);
						visit[a]=0;
					}
				}
		 }
	 }
	 public static int solution(String begin, String target, String[] words) {
		 visit = new int[words.length];
		 
		 int answer =0;
		 boolean flag = false; 
		for(int i=0;i<words.length; i++){
			if(words[i].equals(target)){
				flag =true;
			}
		}
		if(!flag){
			min = 0;
		}else{
			for(int a=0;a<words.length;a++){
				if(visit[a] ==0 && check(words[a],begin)>=words[a].length()-1){
					visit[a]=1;
					solve(target, words[a],1,words);
					visit[a]=0;
				}
			}
		}
	 
		answer =min;
		System.out.println("answer"+answer);
	 return answer;
    	
    }
   
}