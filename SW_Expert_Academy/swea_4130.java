import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] gears = new int[4];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());

			for (int r = 0; r < 4; r++) {
				st = new StringTokenizer(br.readLine());
				int gear = 0;
				for (int c = 0; c < 8; c++) {
					if (st.nextToken().equals("1")) {
						gear |= (1 << (7 - c));
					}
				}
				gears[r] = gear;
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());

				process(idx, dir);
			}

			int score = 0;
			for (int i = 0; i < 4; i++) {
				if ((gears[i] & (1 << 7)) != 0)
					score += (1 << i);
			}
			sb.append('#').append(tc).append(' ').append(score).append('\n');
		}

		System.out.println(sb);
	}

	static void process(int idx, int dir) {
		int[] dirs = new int[4];
		dirs[idx] = dir;

		for (int i = idx; i > 0; i--) {
			if (getLeftTooth(i) != getRightTooth(i - 1)) {
				dirs[i - 1] = -dirs[i];
			} else
				break;
		}

		for (int i = idx; i < 3; i++) {
			if (getRightTooth(i) != getLeftTooth(i + 1)) {
				dirs[i + 1] = -dirs[i];
			} else
				break;
		}

		for (int i = 0; i < 4; i++) {
			if (dirs[i] != 0)
				gears[i] = rotate(gears[i], dirs[i]);
		}
	}

	static int getLeftTooth(int i) {
		return (gears[i] & (1 << 1)) != 0 ? 1 : 0;
	}

	static int getRightTooth(int i) {
		return (gears[i] & (1 << 5)) != 0 ? 1 : 0;
	}

	static int rotate(int gear, int dir) {
		if (dir == 1) {
			return ((gear >> 1) & 0x7F) | ((gear & 1) << 7);
		} else {
			return ((gear << 1) & 0xFE) | ((gear >> 7) & 1);
		}
	}
}