import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2357 {
	static int N, M;
	static int numbers[];
	static int minTree[];
	static int maxTree[];
	
	static int initMin(int start, int end, int index) {
		if(start == end) return minTree[index] = numbers[start];
		int mid = (start + end) / 2;
		return minTree[index] = Math.min(initMin(start, mid, index*2), initMin(mid+1, end, index*2+1));
	}
	
	static int initMax(int start, int end, int index) {
		if(start == end) return maxTree[index] = numbers[start];
		int mid = (start + end) / 2;
		return maxTree[index] = Math.max(initMax(start, mid, index*2), initMax(mid+1, end, index*2+1));
	}
	
	static int getMin(int start, int end, int index, int left, int right) {
		if(left > end || right < start) return Integer.MAX_VALUE;
		if(left <= start && end <= right) return minTree[index];
		int mid = (start + end) / 2;
		return Math.min(getMin(start, mid, index*2, left, right), getMin(mid+1, end, index*2+1, left, right));
	}

	static int getMax(int start, int end, int index, int left, int right) {
		if(left > end || right < start) return Integer.MIN_VALUE;
		if(left <= start && end <= right) return maxTree[index];
		int mid = (start + end) / 2;
		return Math.max(getMax(start, mid, index*2, left, right), getMax(mid+1, end, index*2+1, left, right));
	}
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];		
		minTree = new int[N * 4];
		maxTree = new int[N * 4];
		
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		initMin(0, N-1, 1);
		initMax(0, N-1, 1);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken())-1;
			int right = Integer.parseInt(st.nextToken())-1;
			
			System.out.println(getMin(0, N-1, 1, left, right)+" "+getMax(0, N-1, 1, left, right));
		}
	}
}
