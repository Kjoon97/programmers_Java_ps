import java.io.*;
import java.util.*;

public class Main {
	
	static class Student{
		String name;
		int koreaGrade;
		int englishGrade;
		int mathGrade;
		
		public Student(String name, int koreaGrade, int englishGrade,int mathGrade){
			this.name = name;
			this.koreaGrade = koreaGrade;
			this.englishGrade = englishGrade;
			this.mathGrade = mathGrade;
		}
		
		@Override
		public String toString(){
			return name + " " + koreaGrade + " " + englishGrade + " " + mathGrade;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		Student[] students = new Student[n];
		
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(students, new Comparator<Student>(){
			@Override
			public int compare(Student st1, Student st2){
				
				if(st1.koreaGrade == st2.koreaGrade && st1.englishGrade == st2.englishGrade && st1.mathGrade == st2.mathGrade){
					return st1.name.compareTo(st2.name);
				}else if(st1.koreaGrade == st2.koreaGrade && st1.englishGrade == st2.englishGrade){
					return st2.mathGrade - st1.mathGrade;
				}else if(st1.koreaGrade == st2.koreaGrade){
					return st1.englishGrade - st2.englishGrade;
				}else{
					return st2.koreaGrade - st1.koreaGrade;
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(Student student : students){
			sb.append(student.name).append('\n');
		}
		
		System.out.println(sb);
	}
}