import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14002 {
	static int N, size, ver;
	static int arr[];
	static int vis[][];
	
	static void bSearch(int value) {
		int left = 0;
		int mid = 0;
		int right = size;
		vis[ver][size] = Integer.MAX_VALUE;
		
		while(left <= right) {
			mid = (left + right) / 2;
			
			if(value == vis[mid]) return;
			if(value > vis[mid]) left = mid + 1;
			else right = mid - 1;
		}
		
		if(mid == size) vis[size++] = value;
		else if(vis[mid] < value && value < vis[mid+1]) vis[mid+1] = value;
		else vis[mid] = value;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		vis = new int[N][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		vis[ver][0] = arr[0];
		size = 1;
		
		for(int i = 1; i < N; i++) {
			bSearch(arr[i]);
		}
		
		System.out.println(size);
	}
}
