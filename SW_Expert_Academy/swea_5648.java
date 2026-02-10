import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class swea_5648 {
	static int N, minDist, ans;
	static List<Atom> atoms;
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {1, -1, 0, 0};
	
	static class Atom {
		int x, y, d, k;
		Atom(int x, int y, int d, int k) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.k = k;
		}
	}
	
	static void solve() {
		while(atoms.size() > 1) {
			
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
			
			for(int i = atoms.size()-1; i >= 0; i--) {
				Atom a = atoms.get(i);
				a.x += dx[a.d] * min;
				a.y += dy[a.d] * min;
				if(a.x < -2000 || a.x > 2000 || a.y < -2000 || a.y > 2000) {
					atoms.remove(i);
				}
			}
			
			boolean flag = false;
			int remove[] = new int[atoms.size()];
			
			for(int i = 0; i < atoms.size()-1; i++) {
				Atom A = atoms.get(i);
				for(int j = i+1; j < atoms.size(); j++) {
					Atom B = atoms.get(j);
					if(A.x==B.x && A.y==B.y) {
						remove[i] = 1;
						remove[j] = 1;
						flag = true;
					}
				}
			}
			
			if(flag) {
				for(int i = atoms.size()-1; i >= 0; i--) {
					if(remove[i] == 1) {
						ans+=atoms.get(i).k;
						atoms.remove(i);
					} else if(remove[i] == 2) {
						atoms.remove(i);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			atoms = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())*2;
				int y = Integer.parseInt(st.nextToken())*2;
				int d = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				atoms.add(new Atom(x, y, d, k));
			}
			
			ans = 0;
			solve();
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}	
		System.out.println(sb);
	}
}