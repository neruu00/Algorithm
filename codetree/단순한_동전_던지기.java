import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 단순한_동전_던지기 {
	static int N, sr, sc, er, ec, ans = Integer.MAX_VALUE;
	static List<Point> list = new ArrayList<>();
	
	static class Point {
		int r, c, num;
		Point(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
	
	static void perm(int r, int c, int depth, int start, int dist, String str) {
		if(depth == 3) {
			int finalDist = dist + Math.abs(er - r) + Math.abs(ec - c);
			ans = Math.min(ans, finalDist);
			return;
		}
		
		for(int i = start; i < list.size(); i++) {
			Point next = list.get(i);
			int nr = next.r;
			int nc = next.c;
			int nextDist = dist + Math.abs(nr - r) + Math.abs(nc - c);
			perm(nr, nc, depth+1, i+1, nextDist, str+next.num+" ");
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int r = 0; r < N; r++) {
			String str = br.readLine();
			for(int c = 0; c < N; c++) {
				char tmp = str.charAt(c);
				if(tmp == 'S') {
					sr = r;
					sc = c;
				} else if(tmp == 'E') {
					er = r;
					ec = c;
				} else if (tmp != '.' ) {
					list.add(new Point(r, c, tmp - '0'));
				}
			}
		}
		
		list.sort((o1, o2)->o1.num-o2.num);
		
		perm(sr, sc, 0, 0, 0, " ");
		
		System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
	}
}
