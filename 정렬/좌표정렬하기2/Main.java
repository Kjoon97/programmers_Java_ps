import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		for(int i=0; i<n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i][0] = a;
			arr[i][1] = b;
		}
		
		Arrays.sort(arr, new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b){
				if(a[1]==b[1]){
					return a[0] - b[0];
				}
				return a[1] - b[1];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int[] x: arr){
			sb.append(x[0]).append(" ").append(x[1]).append('\n');
		}
		System.out.println(sb);
	}

}