import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11722 {
	static int N;
	static int arr[];
	static int vis[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		vis = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		vis[0] = arr[0];
		int size = 1;
		
		for(int i = 1; i < N; i++) {
			if(arr[i] < vis[size-1]) {
				vis[size++] = arr[i];
				continue;
			}
			
			for(int j = 0; j < size; j++) {
				if(arr[i] > vis[j]) {
					vis[j] = arr[i];
					break;
				}
				if (arr[i] == vis[j]) break;
			}
			
		}
		System.out.println(size);
	}
}
