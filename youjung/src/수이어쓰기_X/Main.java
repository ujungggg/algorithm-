package 수이어쓰기_X;

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
		
		st = new StringTokenizer(br.readLine());
		
//		int N = Integer.parseInt(st.nextToken());
		String N = st.nextToken();
		
		long total = 0;
		
	    int num = Integer.parseInt(N);
		if(N.length() ==1){
			total += num;
		}else if(N.length() ==2){
			total+= 9;
			total += ((num-9)*2);
		}else if(N.length() ==3){
			total+= (9 + (99-9)*2);
			total += ((num-99)*3);
		}else if(N.length() ==4){
			total+= (9 + (99-9)*2 + ((999-99)*3));
			total += ((num-999)*4);
		}else if(N.length() ==5){
			total+= (9 + (99-9)*2 + ((999-99)*3) + (9999-999) *4);
			total += ((num-9999)*5);
		}else if(N.length() ==6){
			total+= (9 + (99-9)*2 + ((999-99)*3) + (9999-999) *4 + (99999-9999) *5);
			total += ((num-99999)*6);
		}else if(N.length() ==7){
			total+= (9 + (99-9)*2 + ((999-99)*3) + (9999-999) *4 + (99999-9999) *5 + (999999-99999) *6);
			total += ((num-999999)*7);
		}else if(N.length() ==8){
			total+= (9 + (99-9)*2 + ((999-99)*3) + (9999-999) *4 + (99999-9999) *5 + (999999-99999) *6
					+ (9999999-999999) *7);
			total += ((num-9999999)*8);
		}	
		
		System.out.println(total);
		
		
		
		
	}
}
