import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int n = str.length();
		String[] words = new String[n];
		
		for(int i=0; i<n; i++){
			words[i] = str.substring(i);
		}
		Arrays.sort(words);
		
		for(String x: words){
			sb.append(x).append('\n');
		}
		System.out.println(sb);
	}
}