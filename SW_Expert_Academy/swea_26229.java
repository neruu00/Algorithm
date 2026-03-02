import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea_26229 {
    static int dr[] = { 0, 1, 0, -1 };
    static int dc[] = { 1, 0, -1, 0 };
    static int N, appleCount, curR, curC, curD, ans;
    static int map[][];

    static class Point implements Comparable<Point> {
        int r, c, d, t;

        Point(int r, int c, int d, int t) {
            this.r = r; this.c = c; this.d = d; this.t = t;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.t, o.t); 
        }
    }

    static int simulate(int target) {
        boolean visited[][][] = new boolean[4][N][N];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(curR, curC, curD, 0));
        
        while(!pq.isEmpty()) {
            Point p = pq.poll();
            int r = p.r;
            int c = p.c;
            int d = p.d;
            int t = p.t;
            
            if(r < 0 || r >= N || c < 0 || c >= N || visited[d][r][c]) continue; 
            
            if(map[r][c] == target) {
                curR = r; 
                curC = c;
                curD = d;
                return t; 
            }
            
            visited[d][r][c] = true;
            
            pq.offer(new Point(r + dr[d], c + dc[d], d, t));
            
            int nextD = (d + 1) % 4;
            pq.offer(new Point(r + dr[nextD], c + dc[nextD], nextD, t + 1));
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            appleCount = 0;

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if (map[r][c] != 0) appleCount++;
                }
            }

            curR = 0;
            curC = 0;
            curD = 0;
            ans = 0;
            
            for (int i = 1; i <= appleCount; i++) {
                ans += simulate(i);
            }
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }
        System.out.println(sb);
    }
}