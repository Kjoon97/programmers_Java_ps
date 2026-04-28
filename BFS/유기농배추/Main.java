import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static boolean[][] visited;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static int T, n, m;
	static class Pos{
		int y;
		int x;
		public Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static public void bfs(int y, int x){
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(y,x));
		visited[y][x] = true;
		
		while(!q.isEmpty()){
			Pos pos = q.poll();
			for(int i=0; i<4; i++){
				int ny = pos.y + dy[i];
				int nx = pos.x + dx[i];
				
				if(ny>=0 && nx>=0 && ny<n && nx<m){
					if(board[ny][nx]== 1 && !visited[ny][nx]){
						visited[ny][nx]= true;
						q.add(new Pos(ny,nx));
					}
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
		
			board = new int[n][m];
			visited = new boolean[n][m];
			
			for(int i=0; i<k; i++){
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				board[y][x] = 1;
			}
			

			int ans =0;
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(board[i][j] == 1 && !visited[i][j]){
						bfs(i,j);
						ans+=1;
					}
				}
			}
			
			System.out.println(ans);
		}

	}
}