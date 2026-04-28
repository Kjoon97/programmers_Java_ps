import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		HashMap<Integer, Integer> map = new LinkedHashMap<>();
		
		while(st.hasMoreTokens()){
			int num = Integer.parseInt(st.nextToken());
			if(!map.containsKey(num)){
				map.put(num, 1);
			}else{
				map.put(num, map.get(num)+1);
			}
		}
		
		List<Integer> arr = new ArrayList<>(map.keySet());
		
		Collections.sort(arr, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2){
				return map.get(o2) - map.get(o1);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		Iterator<Integer> it = arr.iterator();
		
		while(it.hasNext()){
			int key = it.next();
			int cnt = map.get(key);
			
			for(int i=0; i<cnt; i++){
				sb.append(key).append(" ");
			}
		}
		
		System.out.println(sb);
	}

}