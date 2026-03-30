package 광물운송;

class UserSolution {
	int L, N, size;
	
	int r[] = new int[20000];
	int c[] = new int[20000];
	int q[] = new int[20000];
	int id[] = new int[20000];
	
	int parent[] = new int[20000];
	int sum[] = new int[20000];

	boolean isBetter(int a, int b) {
		if(q[a] != q[b]) return q[a] < q[b];
		if(r[a] != r[b]) return r[a] < r[b];
		return c[a] < c[b];
	}
	
	int findSet(int a) {
		int root = a;
		while(root != parent[root]) {
			root = parent[root];
		}
		return root;
	}
	
	void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
				
		if(rootA == rootB) return;
								
		if(isBetter(rootA, rootB)) {
			parent[rootB] = rootA;
			sum[rootA] += sum[rootB];
		} else {
			parent[rootA] = rootB;
			sum[rootB] += sum[rootA];
		}
	}

	void init(int L, int N){
		this.L = L;
		this.N = N;
		size = 0;
	}
	
	int addBaseCamp(int mID, int mRow, int mCol, int mQuantity){
		int u = size++;
		id[u] = mID;
		r[u] = mRow;
		c[u] = mCol;
		q[u] = mQuantity;
		parent[u] = u;
		sum[u] = mQuantity;
		
		for(int i = 0; i < u; i++) {
			if(Math.abs(r[i] - r[u]) + Math.abs(c[i] - c[u]) > L) continue;
			union(i, u);
		}
		
		return sum[findSet(u)];
	}
	
	int findBaseCampForDropping(int K){
		int ans = -1;
		
		for(int i = 0; i < size; i++) {
			if(parent[i] != i || sum[i] < K) continue;
			if(ans == -1 || isBetter(i, ans)) {
				ans = i;
			}
		}
		return ans == -1 ? -1 : id[ans];
	}
}
