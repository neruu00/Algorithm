package 신소재_케이블2;

// 어차피 붙는 위치를 알려주는데 path compression이 필요한가?

class UserSolution
{
	private static final int MAX_DEVICES_SIZE = 10001;
	
	static int deviceList[] = new int[MAX_DEVICES_SIZE];
	static int latencyList[][] = new int[MAX_DEVICES_SIZE][MAX_DEVICES_SIZE];
	static int treeSize;
	
	public int findIndex(int mDevice) {
		for(int i = 0; i < treeSize; i++) {
			if(deviceList[i] == mDevice) return i;
		}
		return -1;
	}
	
	public int addDevice(int mDevice) {
		deviceList[treeSize++] = mDevice;
		return treeSize-1;
	}
	
	// 각 테스트 케이스 시작 시 init() 함수가 한 번 호출된다.
	// mDevice : 초기 장비 번호 (1 ≤ mDevice ≤ 1,000,000,000)
	public void init(int mDevice) {
		treeSize = 0;
		addDevice(mDevice);
	}
	
	// 각 테스트 케이스에서 connect() 함수의 호출 횟수는 10,000 이하이다.
	// mOldDevice : 이미 존재하는 장비 번호 (1 ≤ mOldDevice ≤ 1,000,000,000)
	// mNewDevice : 새롭게 추가되는 장비 번호 (1 ≤ mNewDevice ≤ 1,000,000,000)
	// mLatency :  케이블의 전송 속도 (1 ≤ mLatency ≤ 10,000)
	public void connect(int mOldDevice, int mNewDevice, int mLatency)
	{
		int oldIndex = findIndex(mOldDevice);
		int newIndex = addDevice(mNewDevice);
		
		System.out.println(oldIndex + " " + newIndex + " " + treeSize);
		
		latencyList[newIndex][oldIndex] = mLatency;
		
		
		for(int i = 0; i < treeSize; i++) {
			if(latencyList[oldIndex][i] == 0) continue;
			latencyList[newIndex][i] = latencyList[oldIndex][i] + mLatency;
		}
		
		for(int i = 0; i < treeSize-1; i++) {
			latencyList[i][newIndex] = latencyList[i][oldIndex] + mLatency;
		}
		
		return;
	}
	
	// 각 테스트 케이스에서 measure() 함수의 호출 횟수는 1,000 이하이다.
	public int measure(int mDevice1, int mDevice2)
	{
		int aIndex = findIndex(mDevice1);
		int bIndex = findIndex(mDevice2);
		
		return latencyList[aIndex][bIndex];
	}
	
	// 각 테스트 케이스에서 test() 함수의 호출 횟수는 1,000 이하이다.
	public int test(int mDevice)
	{
		int aSum = 0;
		int bSum = 0;
		
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
		
		return aSum+bSum;
	}
}