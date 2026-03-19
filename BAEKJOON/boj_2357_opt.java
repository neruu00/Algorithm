import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2357_opt {
	static int N, M;
	static int numbers[];
	static int segmentTree[][];
	
	static void init(int start, int end, int index) {
		if(start == end) {
			segmentTree[0][index] = numbers[start];
			segmentTree[1][index] = numbers[start];
			return;
		}
		int mid = (start + end)>>1;
		
		int left = index<<1;
		int right = (index<<1)|1;
		init(start, mid, left);
		init(mid+1, end, right);
		
		segmentTree[0][index] = Math.min(segmentTree[0][left], segmentTree[0][right]);
		segmentTree[1][index] = Math.max(segmentTree[1][left], segmentTree[1][right]);
	}
	
	static int getMin(int start, int end, int index, int left, int right) {
		if(left > end || right < start) return Integer.MAX_VALUE;
		if(left <= start && end <= right) return segmentTree[0][index];
		int mid = (start + end)>>1;
		return Math.min(getMin(start, mid, index<<1, left, right), getMin(mid+1, end, (index<<1)|1, left, right));
	}

	static int getMax(int start, int end, int index, int left, int right) {
		if(left > end || right < start) return Integer.MIN_VALUE;
		if(left <= start && end <= right) return segmentTree[1][index];
		int mid = (start + end)>>1;
		return Math.max(getMax(start, mid, index<<1, left, right), getMax(mid+1, end, (index<<1)|1, left, right));
	}
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];		
		segmentTree = new int[2][N * 4];
		
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		init(0, N-1, 1);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken())-1;
			int right = Integer.parseInt(st.nextToken())-1;
			
			sb.append(getMin(0, N-1, 1, left, right)).append(' ');
			sb.append(getMax(0, N-1, 1, left, right)).append('\n');
		}
		System.out.println(sb);
	}
}
