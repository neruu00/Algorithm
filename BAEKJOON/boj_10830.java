import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10830 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, mat[][];
	static long B;
	
	static int[][] div(long b) {
		if(b == 1) return mat;
		
		if(b % 2 == 1) {
			return mul(pow(div((b-1)/2)));
		} else {
			return pow(div(b/2));
		}
	} 
	
	// 파라미터를 제곱하는 함수
	static int[][] pow(int a[][]) {
		int result[][] = new int[N][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				int sum = 0;
				for(int i = 0; i < N; i++) {
					sum += a[r][i] * a[i][c];
				}
				result[r][c] = sum % 1000;
			}
		}
		return result;
	}
	
	// 파라미터와 mat^1을 곱하는 함수
	static int[][] mul(int a[][]) {
		int result[][] = new int[N][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				int sum = 0;
				for(int i = 0; i < N; i++) {
					sum += a[r][i] * mat[i][c];
				}
				result[r][c] = sum % 1000;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		mat = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				// 초기 mat의 값도 1000으로 나눈 나머지로 저장함
				// 이거 안하면 mat^1이 답일 때 입력값에 1000이 있으면 반례 발생
				mat[r][c] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		
		int ans[][] = div(B);
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				System.out.print(ans[r][c]);
				if(c != N -1) System.out.print(" ");
			}
			if(r != N -1) System.out.println();
		}
	} 
}
