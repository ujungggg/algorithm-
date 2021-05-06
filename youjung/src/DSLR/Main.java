package DSLR;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arrA;
	static int[] arrB;
	static HashSet<String> visit ;
	static LinkedList<Pair> list;
	static String B;
	static String lastWord ;
	
	
	public static class Pair{
		String str;
		String word;
		Pair(String str, String word){
			this.str = str;
			this.word = word;
		}
	}
	public static void solve(){
		while(!list.isEmpty()){
			Pair temp = list.remove();
			String strA = temp.str;
			String word = temp.word;
			
			System.out.println("strA"+ strA);
			if(strA.equals(B)){
				lastWord = word;
				return;
			}
			
			//D : 2n % 1000
			int tempD = Integer.parseInt(strA);
			tempD = (tempD*2);
			if(tempD >9999){
				tempD %= 10000;
			}
			
			String lastD = Integer.toString(tempD);
			String wordD = word+"D";
			
			if(!visit.contains(lastD)){
				visit.add(lastD);
				list.add(new Pair(lastD,wordD));
			}
			
			
			//S : n-1
			
			int tempS = Integer.parseInt(strA);
			tempS -=1;
			if(tempS ==0){
				tempS = 9999;
			}
			
			String lastS = Integer.toString(tempS);
			String wordS = word+"S";
			
			if(!visit.contains(lastS)){
				visit.add(lastS);
				list.add(new Pair(lastS,wordS));
			}
			//L : 왼쪽으로
			
			String tempL = strA;
			
			System.out.println("tempL "+ tempL);
			String tempL2 = "";
			for(int i=1; i< tempL.length(); i++){
				tempL2 += (tempL.charAt(i)-'0');
			}
			tempL2 += (tempL.charAt(0) -'0');
			
			int intL = Integer.parseInt(tempL2);
			tempL2 = Integer.toString(intL);
			
//			if(tempL2.length()!=4){
//				System.out.println("이경우는?");
//				while(!(tempL2.length()==4)){
//					tempL2 += ("0");
//					System.out.println("변회되는 문자" +tempL2);
//				}
//			}
			String wordL = word+"L";
			
			if(!visit.contains(tempL2)){
				visit.add(tempL2);
				list.add(new Pair(tempL2,wordL));
			}
			
			//R : 오른쪽으로
			String tempR = strA;
			
			String tempR2 = Integer.toString(strA.charAt(strA.length()-1) -'0');
			for(int i=0; i< tempL.length()-2; i++){
				tempR2 += (tempR.charAt(i)-'0');
			}
			int intR = Integer.parseInt(tempR2);
			tempR2 = Integer.toString(intR);
			if(tempR2.length()!=4){
				System.out.println("이경우는?" +tempR2);
				while(!(tempR2.length()==4)){
					tempR2 += ("0");
					System.out.println("변회되는 문자" +tempR2);
				}
			}
			String wordR = word+"R";
			
			if(!visit.contains(tempR2)){
				visit.add(tempR2);
				list.add(new Pair(tempR2,wordR));
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++){
			st =new StringTokenizer(br.readLine());
			String A = st.nextToken();
			B = st.nextToken();
			
			arrA = new int[A.length()];
			arrB = new int[B.length()];
			visit = new HashSet<>();
			list = new LinkedList<>();
			
			lastWord = "";
			
			for(int a=0;a<A.length();a++){
				arrA[a] = A.charAt(a) -'0';
			}
			for(int b=0;b<B.length();b++){
				arrB[b] = B.charAt(b) -'0';
			}
			
			visit.add(A);
			list.add(new Pair(A,""));
			
			solve();
			System.out.println(lastWord);
		}
		
	}
}

