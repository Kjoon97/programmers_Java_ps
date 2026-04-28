import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int m;
	static int[][] board;
	static boolean[][] visited;
	static Queue<Pos> q;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static class Pos{
		int y;
		int x;
		public Pos(int y, int x){
			this.y =y;
			this.x =x;
		}
		@Override
		public String toString(){
			return "[ " + y + " ," + x +" ]";
		}
	}
	
	static void bfs(){
		while(!q.isEmpty()){
			Pos curPos = q.poll();
			for(int i=0; i<4; i++){
				int ny = curPos.y + dy[i];
				int nx = curPos.x + dx[i];
				if(0<=ny && ny<n && 0<=nx && nx<m){
					if(board[ny][nx]==0 && !visited[ny][nx]){
						board[ny][nx] = board[curPos.y][curPos.x] +1;
						q.add(new Pos(ny,nx));
						visited[ny][nx] = true;
					}
				} 
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		visited = new boolean[n][m];
		q = new LinkedList<>();
		
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==1){
					q.add(new Pos(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		bfs();
		
		boolean ansflag = true;
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(board[i][j] == 0){
					ansflag = false;
					break;
				}
				ans = Math.max(ans, board[i][j]);
			}
		}
		
		if(ansflag){
			System.out.println(ans-1);
		}else{
			System.out.println(-1);
		}
		
	}
	
}