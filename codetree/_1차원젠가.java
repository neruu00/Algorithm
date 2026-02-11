import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1차원젠가 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		int total = N;
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			total -= e-s+1;
			
			int tmp[] = new int[total+1];
			int index = 1;
			for(int j = 1; j < arr.length; j++) {
				if(j < s || e < j) {
					tmp[index++] = arr[j];
				}
			}
			arr = tmp;
		}
		
		System.out.println(total);
		for(int i = 1; i <= total; i++) {
			System.out.println(arr[i]);
		}
	}
}
