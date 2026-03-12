package 신소재_케이블2;

//1 1
//15
//100 1
//200 1 2 2
//200 2 3 6
//200 3 4 4
//200 2 5 8
//200 3 6 5
//300 1 4 12
//400 2 19
//400 1 13
//200 3 7 8
//400 3 22
//300 7 1 16
//200 1 8 9
//400 2 25
//400 4 21

class UserSolution
{
	private static final int MAX_DEVICES_SIZE = 10001;
	
	static int deviceList[] = new int[MAX_DEVICES_SIZE];
	static int latencyList[][] = new int[MAX_DEVICES_SIZE][MAX_DEVICES_SIZE];
	static int treeSize;
	
	static boolean isPrint = true;
	
	// 각 테스트 케이스 시작 시 init() 함수가 한 번 호출된다.
	// mDevice : 초기 장비 번호 (1 ≤ mDevice ≤ 1,000,000,000)
	public void init(int mDevice) {
		deviceList[0] = mDevice;
		treeSize = 1;
		
		if(isPrint) System.out.println("#init : "+ deviceList[0] + ", " + treeSize);
	}
	
	public int findIndex(int mDevice) {
		for(int i = 0; i < treeSize; i++) {
			if(deviceList[i] == mDevice) {
				if(isPrint) System.out.println("find : "+mDevice+" = "+i);
				return i;
			}
		}
		return -1;
	}
	
	// 각 테스트 케이스에서 connect() 함수의 호출 횟수는 10,000 이하이다.
	// mOldDevice : 이미 존재하는 장비 번호 (1 ≤ mOldDevice ≤ 1,000,000,000)
	// mNewDevice : 새롭게 추가되는 장비 번호 (1 ≤ mNewDevice ≤ 1,000,000,000)
	// mLatency :  케이블의 전송 속도 (1 ≤ mLatency ≤ 10,000)
	public void connect(int mOldDevice, int mNewDevice, int mLatency)
	{
		if(isPrint) System.out.println("#connect");
		int oldIndex = findIndex(mOldDevice);
		int newIndex = treeSize;
		deviceList[treeSize++] = mNewDevice;
				
		latencyList[newIndex][oldIndex] = mLatency;
		
		for(int i = 0; i < treeSize; i++) {
			if(latencyList[oldIndex][i] == 0) continue;
			latencyList[newIndex][i] = latencyList[oldIndex][i] + mLatency;
		}
		
		for(int i = 0; i < treeSize-1; i++) {
			latencyList[i][newIndex] = latencyList[i][oldIndex] + mLatency;
		}
		
		
		if(isPrint) {
			for(int r = 0; r < treeSize; r++) {
				for(int c = 0; c < treeSize; c++) {
					System.out.print(latencyList[r][c] + " ");
				}
				System.out.println();
			}
		}
		
		return;
	}
	
	// 각 테스트 케이스에서 measure() 함수의 호출 횟수는 1,000 이하이다.
	public int measure(int mDevice1, int mDevice2)
	{
		if(isPrint) System.out.println("#measure");
		
		int aIndex = findIndex(mDevice1);
		int bIndex = findIndex(mDevice2);
		
		if(isPrint) System.out.println(latencyList[aIndex][bIndex]);
		
		return latencyList[aIndex][bIndex];
	}
	
	// 각 테스트 케이스에서 test() 함수의 호출 횟수는 1,000 이하이다.
	public int test(int mDevice)
	{
		int aSum = 0;
		int bSum = 0;
		
		if(isPrint) System.out.println("#test");
		
		int index = findIndex(mDevice);
		for(int i = 1; i < treeSize; i++) {
			int latency = latencyList[index][i];
			if(latency >= aSum) {
				bSum = aSum;
				aSum = latency;
			} else if(latency > bSum) {
				bSum = latency;
			}
		}
		
		if(isPrint) System.out.println(aSum+"+"+bSum+"="+(aSum+bSum);
		
		return aSum+bSum;
	}
}