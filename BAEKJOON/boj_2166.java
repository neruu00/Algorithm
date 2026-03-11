import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2166 {
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, count;
	static double ans;
	static Point points[];
	static boolean visited[];
	
	static double distance(Point a, Point b) {
		return Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2);
	}
	
	static double area(Point a, Point b, Point c) {
		return Math.abs(a.x*b.y+b.x*c.y+c.x*a.y)-(a.y*b.x+b.y*c.x+c.y*a.x) / 2;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		points = new Point[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i] = new Point(x, y);
		}
		
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			Point a = points[i];
			Point bc[] = new Point[2];
			bc[0] = null;
			bc[1] = null;
			
			double bDist = Double.MAX_VALUE;
			double cDist = Double.MAX_VALUE;
			
			for(int j = 0; j < N; j++) {
				if(visited[j]) continue;
				
				Point tmp = points[j];
				double dist = distance(a, tmp);
				
				if(dist <= bDist) {
					bc[1] = bc[0];
					bc[0] = tmp;
					cDist = bDist;
					bDist = dist;
				} else if(dist < cDist) {
					bc[1] = tmp;
					cDist = dist;
				}
			}
			ans += area(a, bc[0], bc[1]);
			if(++count == N-2) break;
		}
		
		System.out.printf("%.1f", (double)(Math.round(ans * 10) / 10));
	}
}
