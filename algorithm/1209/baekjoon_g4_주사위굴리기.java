import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_g4_주사위굴리기 {
	
	static int y,x = 0;
	static int[][] map;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		y = Integer.parseInt(str.nextToken());
		x = Integer.parseInt(str.nextToken());
		int posY = Integer.parseInt(str.nextToken());
		int posX = Integer.parseInt(str.nextToken());
		int commandCnt = Integer.parseInt(str.nextToken());
		
		map = new int[y][x];
		
		for(int i = 0; i < y; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		int[] diceX = new int[3];
		int[] diceY = new int[3];
		int bottom = 0;
		
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < commandCnt; i++) {
			int nextDir = Integer.parseInt(str.nextToken());
			
			if(nextDir == 1) {
				if(0 <= posX + 1 && posX + 1 < x) {
					int tmp = diceX[2];
					diceX[2] = diceX[1];
					diceX[1] = diceX[0];
					diceX[0] = bottom;
					diceY[1] = diceX[1];
					posX += 1;
					if(map[posY][posX] == 0) {
						map[posY][posX] = tmp;
						bottom = tmp;
					} else {						
						bottom = map[posY][posX];	
						map[posY][posX] = 0;
					}				
					System.out.println(diceX[1]);
				}

			} else if(nextDir == 2) {
				if(0 <= posX - 1 && posX - 1 < x) {		
					int tmp = diceX[0];
					diceX[0] = diceX[1];
					diceX[1] = diceX[2];
					diceX[2] = bottom;
					diceY[1] = diceX[1];
					posX -= 1;
					if(map[posY][posX] == 0) {
						map[posY][posX] = tmp;
						bottom = tmp;
					} else {						
						bottom = map[posY][posX];
						map[posY][posX] = 0;
					}
					System.out.println(diceX[1]);
				}

			} else if(nextDir == 3) {
				if(0<= posY - 1 && posY - 1 < y) {
					int tmp = diceY[0];
					diceY[0] = diceY[1];
					diceY[1] = diceY[2];
					diceY[2] = bottom;
					diceX[1] = diceY[1];
					posY -= 1;
					if(map[posY][posX] == 0) {
						map[posY][posX] = tmp;
						bottom = tmp;
					} else {						
						bottom = map[posY][posX];
						map[posY][posX] = 0;
					}
					System.out.println(diceX[1]);
				}

			} else if(nextDir == 4) {
				if(0<= posY + 1 && posY + 1 < y) {
					int tmp = diceY[2];
					diceY[2] = diceY[1];
					diceY[1] = diceY[0];
					diceY[0] = bottom;
					diceX[1] = diceY[1];
					posY += 1;
					if(map[posY][posX] == 0) {
						map[posY][posX] = tmp;
						bottom = tmp;
					} else {						
						bottom = map[posY][posX];
						map[posY][posX] = 0;
					}
					System.out.println(diceX[1]);
				}
			}
//			showDice(diceX,diceY,bottom);

		}
		
		
	}

	private static void showDice(int[] diceX, int[] diceY, int bottom) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(diceX));
		System.out.println(Arrays.toString(diceY));
		System.out.println(bottom);
	}
	
}
