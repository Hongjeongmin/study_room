import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/status?from_problem=1&problem_id=18230

public class baekjoon_s1_2xN예쁜타일링 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int A = Integer.parseInt(str.nextToken());
		int B = Integer.parseInt(str.nextToken());
		
		int[] tileA = new int[A];
		int[] tileB = new int[B];
		
		
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < A; i++) {
			tileA[i] = Integer.parseInt(str.nextToken());
		}
		
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < B; i++) {
			tileB[i] = Integer.parseInt(str.nextToken());
		}
		
		List<int[]> list = new ArrayList<>();
		int cnt = N / 2;
		
		for(int i = cnt; i >= 0; i--) {
			if(N - 2*i > A || i > B) {
				continue;
			}
			list.add(new int[] {i, N - 2*i});
		}

		
		int maxSum = 0;
		Arrays.sort(tileA);
		Arrays.sort(tileB);
		
		for(int i = 0; i < list.size(); i++) {
			int sum = 0;
			for(int j = 0; j < list.get(i)[0]; j++) {
				sum += tileB[B - 1 -j];
			}
			for(int j = 0; j < list.get(i)[1]; j++) {
				sum += tileA[A - 1 -j];
			}
			if(sum >= maxSum) {
				maxSum = sum;
			}
		}
		
		System.out.println(maxSum);
	}
	
}

