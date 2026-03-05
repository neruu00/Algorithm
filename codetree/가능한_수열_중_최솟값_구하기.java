import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 가능한_수열_중_최솟값_구하기 {
	static int N;
	static int arr[];
	
	static void solve(int depth) {
		if(depth == N) {
			for(int i = 2; i <= N/2; i++) {
				for(int j = 0; j + i * 2 <= N; j++) {
					int cnt = 0;
					for(int k = 0; k < i; k++) {
						if(arr[k+j] == arr[k+j+i]) cnt++;
					}
					if(cnt == i) return;
				}
			}
			for(int a: arr) System.out.print(a);
			System.exit(0);
		}
		
		if(arr[depth-1] != 4) {
			arr[depth] = 4;
			solve(depth+1);
		}
		if(arr[depth-1] != 5) {
			arr[depth] = 5;
			solve(depth+1);
		}
		if(arr[depth-1] != 6) {
			arr[depth] = 6;
			solve(depth+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		arr[0] = 4;		
		
		solve(1);
	}
}
