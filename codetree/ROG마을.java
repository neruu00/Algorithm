import java.io.*;
import java.util.*;

public class ROG마을 {
    static int N, A;
    static int[][] map;
    static int x1, y1, x2, y2;
    static int[] dx = {-1, 1, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y1 = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        x2 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(bfs());
    }

    static int bfs() {
        boolean[][][] visited = new boolean[N][N][3 * A];
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{x1, y1, 0});
        visited[x1][y1][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int time = curr[2];

            if (x == x2 && y == y2) return time;

            int nextTime = time + 1;
            int nextCycle = nextTime % (3 * A);

            for (int i = 0; i < 5; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int nextColor = getCellColor(nx, ny, nextTime);

                    if (i == 4 || nextColor == 2) {
                        if (!visited[nx][ny][nextCycle]) {
                            visited[nx][ny][nextCycle] = true;
                            q.offer(new int[]{nx, ny, nextTime});
                        }
                    }
                }
            }
        }

        return -1; // 도달 불가능한 경우
    }

    static int getCellColor(int r, int c, int time) {
        if (map[r][c] != 1) return map[r][c];

        int status = (time / A) % 3;
        if (status == 0) return 1;
        if (status == 1) return 2;
        return 0; // R
    }
}