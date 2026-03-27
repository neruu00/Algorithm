package 광물운송;

class UserSolution {
	class BaseCamp {
		int id, r, c, root, quantity;
		BaseCamp(int id, int r, int c, int quantity) {
			set(id, r, c, quantity);
		}
		
		void set(int id, int r, int c, int quantity) {
			this.id = id;
			this.r = r;
			this.c = c;
			this.root = size;
			this.quantity = quantity;
		}
	}
	
	int L, N, size;
	BaseCamp camps[] = new BaseCamp[20000];
	BaseCamp min = new BaseCamp(-1, 0, 0, Integer.MAX_VALUE);
	BaseCamp campA, campB, tmp;

	boolean isPriority(BaseCamp a, BaseCamp b) {
		if((b.r == a.r) && (b.c < a.c)) return false;
		else if (b.r < a.r) return false;
		return true;
	}
	
	int findSet(int a) {
		if(a == camps[a].root) return a;
		camps[a].root = findSet(camps[a].root);
		camps[a].quantity = camps[camps[a].root].quantity;
		return camps[a].root;
	}
	
	void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
				
		if(aRoot == bRoot) return;
		
		campA = camps[aRoot];
		campB = camps[bRoot];
		
		int dist = Math.abs(camps[a].r - camps[b].r) + Math.abs(camps[a].c - camps[b].c);
				
		if(dist > L) return;
		
		if(!isPriority(campA, campB)) {
			tmp = campA;
			campA = campB;
			campB = tmp;
		}
		
		System.out.println("union" + a + ":" + aRoot + " " + b + ":" + bRoot);
		
		campB.root = aRoot;
		campA.quantity += campB.quantity;
	}

	void init(int L, int N){
		this.L = L;
		this.N = N;
		size = 0;
	}
	
	int addBaseCamp(int mID, int mRow, int mCol, int mQuantity){
		if(camps[size] == null) {
			camps[size] = new BaseCamp(mID, mRow, mCol, mQuantity);
		} else {
			camps[size].set(mID, mRow, mCol, mQuantity);
		}
		
		for(int i = 0; i < size; i++) {
			 union(i, size);
		}
		
		for(int i = 0; i < size+1; i++) {
			System.out.print(camps[i].root + " ");
		}
		System.out.println();
		
		return camps[findSet(size++)].quantity;
	}
	
	int findBaseCampForDropping(int K){
		min.id = -1;
		min.quantity = Integer.MAX_VALUE;
		
		for(int i = 0; i < size; i++) {
			tmp = camps[findSet(i)];
			if(tmp.quantity < K) continue;
			if(tmp.id == min.id) continue;
			if(tmp.quantity > min.quantity) continue;
			if(tmp.quantity == min.quantity && !isPriority(tmp, min)) continue;
			min.set(tmp.id, tmp.r, tmp.c, tmp.quantity);
		}
		
		return min.id;
	}

}
