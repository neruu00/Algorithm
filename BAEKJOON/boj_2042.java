import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2042 {
	static int N, M, K;
	static long numbers[];
	static long segmentTree[];
	
	static long init(int start, int end, int index) {
		if(start == end) return segmentTree[index] = numbers[start];
		int mid = (start+end)>>1;
		return segmentTree[index] = init(start, mid, index<<1) + init(mid+1, end, (index<<1)|1);
	}
	
	static long get(int start, int end, int index, int left, int right) {
		if(end < left || right < start) return 0;
		if(left <= start && end <= right) return segmentTree[index];
		int mid = (start+end)>>1;
		return get(start, mid, index<<1, left, right) + get(mid+1, end, (index<<1)|1, left, right);
	}
	
	static void update(int start, int end, int index, int target, long delta) {
		if(target < start || end < target) return;
		
		segmentTree[index] += delta;
		
		if(start == end) return;
		
		int mid = (start+end)>>1;
		update(start, mid, index<<1, target, delta);
		update(mid+1, end, (index<<1)|1, target, delta);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		numbers = new long[N];
		segmentTree = new long[N * 4];
		
		for(int i = 0; i < N; i++) {
			numbers[i] = Long.parseLong(br.readLine());
		}
		
		init(0, N-1, 1);
		
		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a == 1) {
				int b = Integer.parseInt(st.nextToken())-1;
				long c = Long.parseLong(st.nextToken());
				long delta = c - numbers[b];
				numbers[b] = c;
				update(0, N-1, 1, b, delta);
			} else {
				int b = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken())-1;
				sb.append(get(0, N-1, 1, b, c)).append('\n');
			}
		}
		System.out.println(sb);
	}
}
