import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가깝게_만들기 {
	static int N, K, ans = Integer.MAX_VALUE;
	static int arr[];
	
	static void simulate(int index, int result) {
		if(index == N) {
			ans = Math.min(ans, Math.abs(K-result));
			return;
		}
				
		simulate(index+1, result+arr[index]);
		simulate(index+1, result*arr[index]);
		simulate(index+1, result-arr[index]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		simulate(1, arr[0]);
		
		System.out.println(ans);
	}
}
