import java.io.*;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numArr = new int[n];
		
		for(int i=0; i< n; i++){
			numArr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(numArr);
		
		for(int i=0; i< n; i++){
			System.out.println(numArr[i]);
		}
	}
}