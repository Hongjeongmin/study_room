import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_s1_컨베이어벨트위의로봇 {
	
	static int N,K;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		// 컨베이어벨트 길
		N = Integer.parseInt(str.nextToken());
		
		// 내구도 0 개수
		K = Integer.parseInt(str.nextToken());
		
		int[] belt = new int[2 * N + 1];
		boolean[] isRobot = new boolean[2 * N + 1];
		str = new StringTokenizer(br.readLine());
		for(int i = 1; i <= 2 * N; i++) {
			belt[i] = Integer.parseInt(str.nextToken());
		}
		
		int step = 0;
		int brokenCnt = 0;
		
		
//		for(int i = 1; i <= N; i++) {
//			isRobot[i] = true;
//		}
//		
//		isRobot[1] = true;
		
		while(brokenCnt < K) {
			step++;
			brokenCnt = 0;
			isRobot[N] = false;			
			
			// 벨트 회전
			int lastBelt = belt[2 * N];
			for(int i = 2 * N - 1; i >= 1; i--) {
				belt[i + 1] = belt[i];
				isRobot[i + 1] = isRobot[i];
			}
			isRobot[N] = false;

			
			belt[1] = lastBelt;
			isRobot[1] = false;
			
			// 로봇 이동
			isRobot[N] = false;
			for(int i = N - 1; i >= 1; i--) {
				if(isRobot[i] && belt[i + 1] > 0 && !isRobot[i + 1]) {
					isRobot[i + 1] = isRobot[i];
					isRobot[i] = false;
					belt[i + 1]--;
				}
			}
			
			
			if(belt[1] != 0) {
				belt[1]--;
				isRobot[1] = true;
			}
			
//			System.out.println(Arrays.toString(isRobot));
			
			for(int i = 1; i <= 2 * N; i++ ) {
				if(belt[i] == 0) {
					brokenCnt++;
				}
			}

		}
		
		System.out.println(step);
		
		
		
	}
	
}
