import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String str = br.readLine();
			if(str == null){
				break;
			}
			
			StringTokenizer st = new StringTokenizer(str);
			
			String s = st.nextToken();
			String t = st.nextToken();
			
			int index = 0;
			
			for(int i=0; i<t.length(); i++){
				if(s.charAt(index) == t.charAt(i)){
					index+=1;
				}
				if(index == s.length()){
					break;
				}
			}
			
			if(index == s.length()){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}
}