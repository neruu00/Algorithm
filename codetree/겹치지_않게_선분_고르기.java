import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 겹치지_않게_선분_고르기 {
	static List<Pair> list = new ArrayList<>();
	static boolean visited[] = new boolean[1001];
	static int N, ans;

	static class Pair {
		int a, b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	static boolean check(Pair p1, Pair p2) {
		if(p1.b < p2.a) return true;
		return false;
	}
	
	static void dfs(int last, int curr, int count) {
		if(curr == N) {
			if(count > ans) ans = count;
			return;
		}
		
		if(curr == 0 || check(list.get(last), list.get(curr))) dfs(curr, curr+1, count+1);
		dfs(last, curr+1, count);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Pair(a, b));
		}

		list.sort((p1, p2) -> {
		    if (p1.b != p2.b)  return Integer.compare(p1.b, p2.b);
		    return Integer.compare(p1.a, p2.a);
		});
		
		dfs(0, 0, 0);
		
		System.out.println(ans);
	}
}
