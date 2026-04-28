import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++){
			String str = br.readLine();
			Map<Character, Integer> map = new HashMap<>();
			
			for(int j=0; j<str.length(); j++){
				char c = str.charAt(j);
				if(c>='a' && c<='z'){
					map.put(c, map.getOrDefault(c,0)+1);
				}
			}
			
			int maxValue = 0;
			
			for(int val : map.values()){
				maxValue = Math.max(val, maxValue);
			}
			int cnt =0 ;
			char ans = '?';
			
			for(char key : map.keySet()){
				if(maxValue == map.get(key)){
					cnt+=1;
					ans = key;
				}
			}
			
			if(cnt == 1){
				System.out.println(ans);
			}else{
				System.out.println('?');
			}
		}
	}
}