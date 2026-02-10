import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_5648 {
    static int N, ans;
    static List<Atom> atoms;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};  
    static int[][] map = new int[4001][4001];

    static class Atom {
        int x, y, d, k;
        Atom(int x, int y, int d, int k) {
            this.x = x; this.y = y; this.d = d; this.k = k;
        }
    }

    static void solve() {
        for (int t = 0; t <= 4000; t++) {
            if (atoms.size() < 2) break;
            
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < atoms.size()-1; i++) {
				Atom a = atoms.get(i);
				for(int j = i+1; j < atoms.size(); j++) {
					Atom b = atoms.get(j);
					if(a.d == b.d) continue;
					min = Math.min(min, Math.abs(a.x-b.x) + Math.abs(a.y-b.y));
				}
			}
			
			if(min == Integer.MAX_VALUE) break;
			min /= 2;

            for (int i = atoms.size() - 1; i >= 0; i--) {
            	Atom a = atoms.get(i);
                a.x += dx[a.d] * min;
                a.y += dy[a.d];

                if (a.x < 0 && a.x > 4000 && a.y < 0 && a.y > 4000) {
                    atoms.remove(i);
                    continue;
                } else {
                    map[a.x][a.y] += a.k;
                }
            }

            
            for (int i = atoms.size() - 1; i >= 0; i--) {
                Atom a = atoms.get(i);
                map[a.y][a.x]++;
            }
            
            for (Atom a : atoms) {
                map[a.x][a.y] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            atoms = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
                int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
                int d = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                atoms.add(new Atom(x, y, d, k));
            }

            ans = 0;
            solve();
            System.out.println("#" + tc + " " + ans);
        }
    }
}