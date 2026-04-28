import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new TreeMap<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++){
			String str = br.readLine();
			String ext = str.split("\\.")[1];    
			
			map.put(ext, map.getOrDefault(ext, 0)+1);
		}
		
		map.forEach((k,v) -> {
			sb.append(k).append(" ").append(v).append("\n");
		});
		
		System.out.println(sb);
	}
}