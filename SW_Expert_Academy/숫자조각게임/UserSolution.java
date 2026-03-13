package 숫자조각게임;

class UserSolution {
	/**
	 * 1. 각 테스트 케이스 시작 시 init() 함수가 호출된다.
	 * 2. 각 테스트 케이스에서 putPuzzle() 함수는 최대 100,000 회 호출된다.
	 * 3. 각 테스트 케이스에서 clearPuzzles() 함수는 최대 1,000 회 호출된다.
	 * 4. 각 테스트 케이스에서 주어지는 조각이 1번 규칙에 만족하는 위치는 최대 500개, 평균 70개 이하이다.
	 */
	
	static int grid[][], R, C;
	static boolean used[][];
	
	static int blockSize[] = {1, 2, 2, 3, 4};
	static int block1[][] = {{0}, {1}};
	static int block2[][] = {{0, 0}, {1, 1}};
	static int block3[][] = {{1, 1}, {0, 0}};
	static int block4[][] = {{0, 1, 0}, {1, 0, 1}};
	static int block5[][] = {{1, 0, 0, 1}, {0, 1, 1, 0}};

	/**
	 * @param mRows : 게임판의 행의 개수 (5 ≤ mRows ≤ 40)
	 * @param mCols : 게임판의 열의 개수 (5 ≤ mCols ≤ 30)
	 * @param mCells[][] : 게임판 내의 셀에 적힌 숫자 (1 ≤ mCells[][] ≤ 5)
	 */
	public void init(int mRows, int mCols, int mCells[][])
	{
		R = mRows;
		C = mCols;
		grid = mCells;
		used = new boolean[mRows][mCols];
	}

	/**
	 * @param mPuzzle : 주어지는 조각의 정보 (0 ≤ mPuzzle[][] ≤ 5)
	 * @return Result.row : 주어진 조각이 규칙에 맞게 놓이는 위치의 행 번호(놓을 위치가 없는 경우 -1)
	 * @return Result.col : 주어진 조각이 규칙에 맞게 놓이는 위치의 열 번호(놓을 위치가 없는 경우 -1)
	 */
	public Solution.Result putPuzzle(int mPuzzle[][])
	{
		int type;
		int block[][];
		
		if(mPuzzle[1][1] == 0) {
			if(mPuzzle[0][1] > 0) {
				if(mPuzzle[0][2] == 0) {
					type = 1;
					block = block1;
				}
				else {
					type = 2;
					block = block2;
				}
			} else {
				type = 3;
				block = block3;
			}
		} else {
			if(mPuzzle[0][1] > 0) {
				type = 4;
				block = block4;
			}
			else {
				type = 5;
				block = block5;
			}
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				int diff = grid[r][c] - mPuzzle[0][0];
				for(int i = 0; i < blockSize[type]; i++) {
					int nr = r + block[0][i];
					int nc = c + block[1][i];
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				}
			}
		}
		
		Solution.Result ret = new Solution.Result(-1, -1);
		return ret;
	}

	public void clearPuzzles()
	{
		return;
	}

}