import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char[] charArr = br.readLine().toCharArray();
		
		int sum =0;
		
		for(char c : charArr){
			sum += Integer.parseInt(String.valueOf(c));
		}
		
		System.out.println(sum);
		
	}
}