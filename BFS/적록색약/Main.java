import java.util.*;
import java.io.*;

public class Main {
	
	static char[][] board;
	static boolean[][] visited;
	static int n;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static class Pos{
		int y, x;
		public Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static public void bfs(int y, int x){
		Queue<Pos> que = new LinkedList<>();
		que.add(new Pos(y,x));
		visited[y][x] = true;
		
		while(!que.isEmpty()){
			Pos pos = que.poll();
			
			for(int i=0; i<4; i++){
				int ny = pos.y + dy[i];
				int nx = pos.x + dx[i];
				
				if(ny>=0 && nx>=0 && ny<n && nx<n){
					if(board[ny][nx] == board[pos.y][pos.x] & !visited[ny][nx]){
						que.add(new Pos(ny,nx));
						visited[ny][nx] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		visited = new boolean[n][n];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++){
			board[i] = br.readLine().toCharArray();
		}
		
//		for(char[] x : board){
//			System.out.println(Arrays.toString(x));
//		}
		int ans = 0;
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if((board[i][j] == 'R' || board[i][j] =='G' || board[i][j]=='B') && !visited[i][j]){
					bfs(i,j);
					ans+=1;
				}
			}
		}
		sb.append(ans).append(" ");
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(board[i][j]=='R'){
					board[i][j] = 'G';
				}
			}
		}
		ans =0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if((board[i][j] =='G' || board[i][j]=='B') && !visited[i][j]){
					bfs(i,j);
					ans+=1;
				}
			}
		}
		sb.append(ans);
		System.out.println(sb);
		
	}
}
