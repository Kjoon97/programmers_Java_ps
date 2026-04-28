import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
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
			public int compare(int[] o1, int[] o2){
				if (o1[0] == o2[0]){
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int[] x : arr){
			sb.append(x[0]).append(" ").append(x[1]).append("\n");
		}
		
		System.out.println(sb);
		
	}
}