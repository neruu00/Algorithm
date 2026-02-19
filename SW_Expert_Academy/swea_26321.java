import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_26321 {
    static List<Unit> list;
    static boolean visited[];
    static boolean hunt[];
    static int N, count, ans;

    static class Unit {
        int no, r, c;

        Unit(int no, int r, int c) {
            this.no = no;
            this.r = r;
            this.c = c;
        }
    }

    static void perm(int dist, int r, int c, int depth) {
        if (dist >= ans) return;

        if (depth == count) {
            ans = Math.min(ans, dist);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (visited[i]) continue;

            Unit next = list.get(i);
            visited[i] = true;

            if (next.no > 0) {
                hunt[next.no] = true;
                int nextDist = dist + Math.abs(next.r - r) + Math.abs(next.c - c);
                perm(nextDist, next.r, next.c, depth + 1);
                hunt[next.no] = false;
            } else if (hunt[-next.no]) {
                int nextDist = dist + Math.abs(next.r - r) + Math.abs(next.c - c);
                perm(nextDist, next.r, next.c, depth + 1);
            }

            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');

            int N = Integer.parseInt(br.readLine());
            list = new ArrayList<Unit>();

            count = 0;
            for (int r = 1; r <= N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 1; c <= N; c++) {
                    int no = Integer.parseInt(st.nextToken());
                    if (no != 0) {
                        list.add(new Unit(no, r, c));
                        count++;
                    }
                }
            }

            ans = Integer.MAX_VALUE;
            visited = new boolean[count];
            hunt = new boolean[count / 2 + 1];

            perm(0, 1, 1, 0);
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}