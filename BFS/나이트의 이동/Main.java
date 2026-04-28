import java.io.*;
import java.util.*;

public class Main {
	static int[][] board;
	static boolean[][] visited;
	static int n, ey, ex;
	static int[] dy = {2,1,-1,-2,-2,-1,1,2};
	static int[] dx = {1,2,2,1,-1,-2,-2,-1};
	
	static class Pos{
		int y;
		int x;
		public Pos(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	
	public static void bfs(int y, int x){
		Queue<Pos> que = new LinkedList<>();
		que.add(new Pos(y,x));
		visited[y][x]= true;
		
		while(!que.isEmpty()){
			Pos pos = que.poll();
			for(int i=0; i<8; i++){
				int ny = pos.y + dy[i];
				int nx = pos.x + dx[i];
				
				if(ny>=0 && nx>=0 && ny<n && nx<n){
					if(!visited[ny][nx]){
						board[ny][nx]= board[pos.y][pos.x] +1;
						visited[ny][nx] = true;
						que.add(new Pos(ny,nx));
						if(ny == ey && nx == ex){
							return;
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			ey = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			
			board = new int[n][n];
			visited = new boolean[n][n];
			
			bfs(sy,sx);
			
//			for(int[] x: board){
//				System.out.println(Arrays.toString(x));
//			}
			
			System.out.println(board[ey][ex]);
		}

	}

}
