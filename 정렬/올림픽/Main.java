import java.io.*;
import java.util.*;

public class Main {
	
	static class Country{
		int num, gold, silver, bronze, rank;
		
		public Country(int num, int gold, int silver, int bronze, int rank){
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this.rank = rank;
		}
		
		public void setRank(int rank){
			this.rank = rank;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int countryNum = Integer.parseInt(st.nextToken());
		
		Country[] countries = new Country[n];
		
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			countries[i] = new Country(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),1);
		}
		
		Arrays.sort(countries, new Comparator<Country>(){
			@Override
			public int compare(Country c1, Country c2){
				if(c1.gold == c2.gold && c1.silver == c2.silver){
					return c2.bronze - c1.bronze;
				}else if(c1.gold == c2.gold){
					return c2.silver - c1.silver;
				}else{
					return c2.gold - c1.gold;
				}
			}
		});
		
		for(int i=1; i<n; i++){
			Country country1 = countries[i-1];
			Country country2 = countries[i];
			if(country1.gold == country2.gold && country1.silver == country2.silver && country1.bronze == country2.bronze){
				country2.rank = country1.rank;
			}else {
				country2.rank = i+1;
			}
			
		}
		
		for(Country x: countries){
			if(x.num == countryNum){
				System.out.println(x.rank);
				break;
			}
//			System.out.println(x.num + " " + x.gold + " " + x.silver + " "+ x.bronze + " " + x.rank);
		}
	}

}