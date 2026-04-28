import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = new String[5];
		int[] strLenArr = new int[5];
		int maxLen = 0; 
		
		for(int i=0; i<5; i++){
			String str = br.readLine();
			strArr[i] = str;
			int strLen = str.length();
			strLenArr[i] = strLen;
			
			if(strLen > maxLen){
				maxLen = strLen;
			}
		}
		
		StringBuilder ans = new StringBuilder();
		for(int i=0; i<maxLen; i++){
			for(int j=0; j<5; j++){
				String strOut = strArr[j];
				
				if(i<strOut.length()){
					ans.append(strOut.charAt(i));
				}
			}
		}
		
		System.out.println(ans);
	}
}