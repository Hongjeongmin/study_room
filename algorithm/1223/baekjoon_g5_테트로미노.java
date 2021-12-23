import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 하드코딩 말고 다시 풀어봐야할듯
// https://www.acmicpc.net/problem/14500

public class baekjoon_g5_테트로미노 {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int result = Integer.MIN_VALUE;
		int tetromino = 0;
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		int[][] map = new int[N + 3][M + 3];
		
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken()); 
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tetromino = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1];
				if(tetromino >= result) {
					result = tetromino;
				}
				
				tetromino = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
				if(tetromino >= result) {
					result = tetromino;
				}
				
				tetromino = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j+3];
				if(tetromino >= result) {
					result = tetromino;
				}
				
				tetromino = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j];
				if(tetromino >= result) {
					result = tetromino;
				}
				
				tetromino = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j+1];
				if(tetromino >= result) {
					result = tetromino;
				}
				
				tetromino = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j+2];
				if(tetromino >= result) {
					result = tetromino;
				}
				tetromino = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i][j + 1];
				if(tetromino >= result) {
					result = tetromino;
				}
				
				tetromino = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1];
				if(tetromino >= result) {
					result = tetromino;
				}
				
				tetromino = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
				if(tetromino >= result) {
					result = tetromino;
				}
				tetromino = map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i][j];
				if(tetromino >= result) {
					result = tetromino;
				}
				
				tetromino = map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i][j + 1];
				if(tetromino >= result) {
					result = tetromino;
				}
				
				tetromino = map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i][j + 2];
				if(tetromino >= result) {
					result = tetromino;
				}
				tetromino = map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1] + map[i][j];
				if(tetromino >= result) {
					result = tetromino;
				}
				
				tetromino = map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1] + map[i + 1][j];
				if(tetromino >= result) {
					result = tetromino;
				}
				
				tetromino = map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1] + map[i + 2][j];
				if(tetromino >= result) {
					result = tetromino;
				}
				tetromino = map[i][j + 1] + map[i][j + 2] + map[i + 1][j] + map[i + 1][j + 1];
				if(tetromino >= result) {
					result = tetromino;
				}
				
				tetromino = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
				if(tetromino >= result) {
					result = tetromino;
				}
				tetromino = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
				if(tetromino >= result) {
					result = tetromino;
				}
				
				tetromino = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j];
				if(tetromino >= result) {
					result = tetromino;
				}
			}
		}
	
		System.out.println(result);
		
		
	}
}
