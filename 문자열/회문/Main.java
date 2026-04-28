import java.io.*;
import java.util.*;

public class Main{
	
	public static boolean checkReverse(String str){
		
		String reverseStr = new StringBuilder(str).reverse().toString();
		
		if(str.equals(reverseStr)){
			return true;
		}
		
		return false;
	}
	
	public static int checkReverse2(String str){
		int lt = 0;
		int rt = str.length() - 1;
		
		while(lt<rt){
			if(str.charAt(lt) == str.charAt(rt)){
				lt+=1;
				rt-=1;
			}else{
				String delLtStr = new StringBuilder(str).deleteCharAt(lt).toString();
				String delRtStr = new StringBuilder(str).deleteCharAt(rt).toString();
				
				if(checkReverse(delLtStr) || checkReverse(delRtStr)){
					return 1;
				}
				return 2;
			}
		}
		return 2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++){
			String str = br.readLine();
			
			if(checkReverse(str)){
				System.out.println(0);
			}else{
				System.out.println(checkReverse2(str));
			}
		}
	}
}