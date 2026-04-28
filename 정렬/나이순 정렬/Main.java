import java.io.*;
import java.util.*;

public class Main{
	
	public static class Member{
		int seq;
		int age;
		String name;
		
		public Member(int seq, int age, String name){
			this.seq = seq;
			this.age = age;
			this.name = name;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		Member[] members = new Member[n];
		
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Member member = new Member(i, age, name);
			members[i] = member;
		}
		
		Arrays.sort(members, new Comparator<Member>(){
			
			@Override
			public int compare(Member o1, Member o2){
				if(o1.age == o2.age){
					return o1.seq - o2.seq;
				}
				return o1.age - o2.age;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(Member member : members){
			sb.append(member.age).append(" ").append(member.name).append("\n");
		}
		
		System.out.println(sb);
	}
	
}