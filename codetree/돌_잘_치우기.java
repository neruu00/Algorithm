import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 돌_잘_치우기 {
    static int N, K, M, ans;
    static int[][] map;
    static List<Point> stones = new ArrayList<>();
    static List<Point> startPoints = new ArrayList<>();
    static Point[] selectedStones;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 1) {
                    stones.add(new Point(r, c)); // 돌 위치 저장
                }
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            startPoints.add(new Point(r, c)); // 시작 지점 저장
        }

        selectedStones = new Point[M];
        findCombination(0, 0);

        System.out.println(ans);
    }

    static void findCombination(int index, int cnt) {
        if (cnt == M) {
            ans = Math.max(ans, bfs());
            return;
        }

        for (int i = index; i < stones.size(); i++) {
            selectedStones[cnt] = stones.get(i);
            findCombination(i + 1, cnt + 1);
        }
    }

    static int bfs() {

        boolean[][] visited = new boolean[N][N];
        Queue<Point> queue = new ArrayDeque<>();


        int[][] tempMap = new int[N][N];
        for(int i=0; i<N; i++) tempMap[i] = map[i].clone();
        for(Point p : selectedStones) {
            tempMap[p.r][p.c] = 0;
        }

        int count = 0;
        for (Point p : startPoints) {
            queue.offer(p);
            visited[p.r][p.c] = true;
            count++;
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && tempMap[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    queue.offer(new Point(nr, nc));
                    count++;
                }
            }
        }
        return count;
    }
}