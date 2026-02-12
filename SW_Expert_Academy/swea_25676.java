import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_25676 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] arr;
	static boolean[] visited;
	static int N;

	public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
			arr = new int[N];
			visited = new boolean[N];
			int ans = 0;
			
        	st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
			for(int i = 0; i < N; i++) {
				int tmp = recu(i);
				if(tmp > ans) ans = tmp;
			}
			sb.append("#").append(tc).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	public static int recu (int a) {
		visited[a] = true;
		int rtn = 0;
		int max = 0;
		
		int left = -1;		
		for(int i = a - 1; i >= 0; i--) {
			if(visited[i]) continue;
			left = i;
			break;
		}
		
		int right = -1;
		for(int i = a + 1; i < N; i++) {
			if(visited[i]) continue;
			right = i;
			break;
		}

		
		if(left >= 0 && right >= 0) rtn = arr[left] * arr[right];
		else if(left >= 0) rtn = arr[left];
		else if(right >= 0) rtn = arr[right];
		else rtn = arr[a];
		
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			int tmp = recu(i);
			if(tmp > max) max = tmp;
		}
		
		visited[a] = false;
		return rtn + max;
	}

}