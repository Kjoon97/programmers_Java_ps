import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int m;
	static int[][] graph;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static boolean[][] visited;
	
	static class Pos{
		int y;
		int x;
		public Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static void bfs(int y, int x){
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(y,x));
		visited[y][x] = true;
		
		while(!q.isEmpty()){
			Pos curPos = q.poll();
			for(int i=0; i<4; i++){
				int ny = curPos.y + dy[i];
				int nx = curPos.x + dx[i];
				if(0<=ny && ny<n && 0<=nx && nx<m){
					if(!visited[ny][nx] && graph[ny][nx]==1){
						visited[ny][nx] = true;
						graph[ny][nx] = graph[curPos.y][curPos.x]+1;
						q.add(new Pos(ny,nx));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++){
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<m; j++){
				graph[i][j] = Character.getNumericValue(temp[j]);
			}
		}
		
		bfs(0,0);
		
		System.out.println(graph[n-1][m-1]);
	}
}