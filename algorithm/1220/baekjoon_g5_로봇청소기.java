import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_g5_로봇청소기 {

	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static int[][] map;
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int clearCnt = 0;
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		str = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(str.nextToken());
		int x = Integer.parseInt(str.nextToken());
		int direction = Integer.parseInt(str.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken()); 
			}
		}
		
		int orderCnt = 0;
		outer: while(orderCnt < 4) {
			orderCnt++;
			
			if(map[y][x] == 0) {
				map[y][x] = 2;
				clearCnt++;				
			}
			
//			printMap();
			
			int rotationCnt = 0;
			inner: while(rotationCnt < 4) {
				int nextDirection = (direction + 3 * (rotationCnt + 1)) % 4;
				
				int ny = y + dy[nextDirection];
				int nx = x + dx[nextDirection];
				if(check(ny,nx) && map[ny][nx] == 0) {
					y = ny;
					x = nx;
					direction = nextDirection;
					orderCnt = 0;
					break inner;
				}
				
				rotationCnt++;
				if(rotationCnt == 4) {
					nextDirection = (direction + 2) % 4;
				
					y = y + dy[nextDirection];
					x = x + dx[nextDirection];
					orderCnt = 0;
					
					if(check(y,x) && map[y][x] == 1) {
						break outer;
					}
					break inner;
				}
			}
		}
		System.out.println(clearCnt);

		
		
		
	}

	private static void printMap() {
		// TODO Auto-generated method stub
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean check(int ny, int nx) {
		// TODO Auto-generated method stub
		return 0 <= ny && ny < N && 0 <= nx && nx < M;
	}
}
