// https://www.acmicpc.net/problem/2133

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon_s2_꽃길 {

	static int N;
	static int[][] map;
	static int result;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int cost = 0;
		result = Integer.MAX_VALUE;
		
		N = Integer.parseInt(str.nextToken());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		for(int i = 1; i < N - 1; i++) {
			for(int j = 1; j < N-1; j++) {
				boolean[][] visited = new boolean[N][N];
				
				// 꽃 심기(y,x,꽃 수, 화단)
				visited[i][j] = true;
				visited[i - 1][j] = true;
				visited[i][j + 1] = true;
				visited[i + 1][j] = true;
				visited[i][j - 1] = true;
				
				cost += map[i][j] + map[i - 1][j] + map[i][j + 1] + map[i + 1][j] + map[i][j - 1];
				plantFlower(i,j,1, visited, cost);	
				visited[i][j] = false;
				visited[i - 1][j] = false;
				visited[i][j + 1] = false;
				visited[i + 1][j] = false;
				visited[i][j - 1] = false;
				cost -= map[i][j] + map[i - 1][j] + map[i][j + 1] + map[i + 1][j] + map[i][j - 1];
			}
		}
		
		System.out.println(result);
	}

	private static void plantFlower(int y, int x, int cnt, boolean[][] visited, int cost) {

		
		// TODO Auto-generated method stub
		if(cnt == 3) {
			// 비용 계산
			
//			printMap(visited);
			
			if(cost <= result) {
				result = cost;
			}
			return;
		}
		
		for(int i = 1; i < N - 1; i++) { 
			for(int j = 1; j < N - 1 ; j++) {
				// 화단 체크
				if(
					visited[i][j] ||
					visited[i - 1][j] ||
					visited[i][j + 1] ||
					visited[i + 1][j] ||
					visited[i][j - 1]
				) {
					continue;
				}
				
				visited[i][j] = true;
				visited[i - 1][j] = true;
				visited[i][j + 1] = true;
				visited[i + 1][j] = true;
				visited[i][j - 1] = true;
				cost += map[i][j] + map[i - 1][j] + map[i][j + 1] + map[i + 1][j] + map[i][j - 1];
				
				plantFlower(i,j,cnt + 1, visited, cost);
				
				visited[i][j] = false;
				visited[i - 1][j] = false;
				visited[i][j + 1] = false;
				visited[i + 1][j] = false;
				visited[i][j - 1] = false;
				cost -= map[i][j] + map[i - 1][j] + map[i][j + 1] + map[i + 1][j] + map[i][j - 1];
			}
		}
		
		
	}

	private static void printMap(boolean[][] visited) {
		// TODO Auto-generated method stub
		for(int i = 0; i < N; i++ ) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j]) {
					System.out.print("o" + " ");
					continue;
				} 
				System.out.print("x" + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
