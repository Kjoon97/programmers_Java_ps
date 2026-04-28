import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] board;
	static boolean[][] boardShadow;
	static boolean[][] visited;
	static int n, m, cnt;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static class Pos{
		int y,x;
		public Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static void bfsForCount(int y, int x){
		Queue<Pos> que = new LinkedList<>();
		que.add(new Pos(y, x));
		
		while(!que.isEmpty()){
			Pos pos = que.poll();
			for(int i=0; i<4; i++){
				int ny = pos.y + dy[i];
				int nx = pos.x + dx[i];
				
				if(ny>0 && nx>0 && ny<=n && nx<=m){
					if(board[ny][nx] !=0 && !visited[ny][nx]){
						visited[ny][nx]= true;
						que.add(new Pos(ny,nx));
					}
				}
			}
		}
	}
	
	static void melt(int y, int x){
		Pos pos = new Pos(y,x);

		for(int i=0; i<4; i++){
			int ny = pos.y + dy[i];
			int nx = pos.x + dx[i];
				
			if(ny>=0 && nx>=0 && ny<n && nx<m){
				if(board[ny][nx] == 0 && !boardShadow[ny][nx]){
					if(board[pos.y][pos.x]>0){
						board[pos.y][pos.x] = board[pos.y][pos.x]- 1;
					}
				}			
			}
				
		}

	}
	
	static int countBingha(){
		cnt =0;
		visited = new boolean[n][m];
		//개수 세기
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(board[i][j]!=0 && !visited[i][j]){
					cnt+=1;
					bfsForCount(i,j);
				}
			}
		}
		return cnt;
	}
	
	static boolean isAllMelt(){
		
		boolean res = true;
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(board[i][j] !=0 ){
					res = false;
					return res;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day =0;
		while(true){
			boardShadow = new boolean[n][m];
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(board[i][j]!=0){
						boardShadow[i][j] = true;
					}
				}
			}

			if(countBingha() >= 2){
				break;
			}
			
			if(isAllMelt()){
				day=0;
				break;
			}
			
			day+=1;
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(board[i][j]!=0){
						melt(i,j);
					}
				}
			}
			
		}
		System.out.println(day);
		
	}

}