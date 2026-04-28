import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static int[][] board;
	static boolean[][] visited;
	static int n, m;
	static int maxSize = 0;
	
	public static class Pos{
		int y, x;
		public Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
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
		int cnt =0;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(board[i][j]==1 && !visited[i][j]){
					visited[i][j] = true;
					bfs(i,j);
					cnt+=1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append('\n').append(maxSize);
		System.out.println(sb);
	}
	
	public static void bfs(int y, int x){
		Queue<Pos> que = new LinkedList<>();
		que.add(new Pos(y,x));
		int picSize =1;
		
		while(!que.isEmpty()){
			Pos pos = que.poll();
			
			for(int i=0; i<4; i++){
				int ny = pos.y + dy[i];
				int nx = pos.x + dx[i];
				
				if(ny>=0 && ny < n && nx >=0 && nx <m){
					if(board[ny][nx]==1 && !visited[ny][nx]){
						que.add(new Pos(ny,nx));
						visited[ny][nx] = true;
						picSize+=1;
					}
				}
			}
		}
		
		maxSize = Math.max(maxSize, picSize);
	}
}