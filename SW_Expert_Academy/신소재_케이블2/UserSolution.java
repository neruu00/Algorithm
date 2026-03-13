package 신소재_케이블2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class UserSolution {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    Map<Integer, Integer> deviceMap;
    List<List<Edge>> tree;
    int treeSize;

    public void init(int mDevice) {
        deviceMap = new HashMap<>();
        tree = new ArrayList<>();
        treeSize = 0;
        
        deviceMap.put(mDevice, treeSize++);
        tree.add(new ArrayList<>());
    }

    public void connect(int mOldDevice, int mNewDevice, int mLatency) {
        int oldIdx = deviceMap.get(mOldDevice);
        int newIdx = treeSize++;
        
        deviceMap.put(mNewDevice, newIdx);
        tree.add(new ArrayList<>());
        
        // 무방향 트리 간선 연결
        tree.get(oldIdx).add(new Edge(newIdx, mLatency));
        tree.get(newIdx).add(new Edge(oldIdx, mLatency));
    }

    public int measure(int mDevice1, int mDevice2) {
        int start = deviceMap.get(mDevice1);
        int target = deviceMap.get(mDevice2);
        
        return getDist(start, target);
    }

    public int test(int mDevice) {
        int startNode = deviceMap.get(mDevice);
        
        // 가장 긴 가지의 길이 (max1 >= max2)
        int max1 = 0;
        int max2 = 0; 
        
        for (Edge edge : tree.get(startNode)) {
            int maxDist = getMaxDist(edge.to, startNode) + edge.weight;
            
            if (maxDist >= max1) {
                max2 = max1;
                max1 = maxDist;
            } else if (maxDist > max2) {
                max2 = maxDist;
            }
        }
        
        return max1 + max2;
    }

    private int getDist(int start, int target) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[treeSize];
        
        q.add(new int[]{start, 0});
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int dist = curr[1];
            
            if (node == target) return dist;
            
            for (Edge edge : tree.get(node)) {
                if (!visited[edge.to]) {
                    visited[edge.to] = true;
                    q.add(new int[]{edge.to, dist + edge.weight});
                }
            }
        }
        return -1;
    }

    private int getMaxDist(int startNode, int parentNode) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[treeSize];
        
        q.add(new int[]{startNode, 0});
        visited[startNode] = true;
        visited[parentNode] = true;
        
        int maxDist = 0;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int dist = curr[1];
            
            maxDist = Math.max(maxDist, dist);
            
            for (Edge edge : tree.get(node)) {
                if (!visited[edge.to]) {
                    visited[edge.to] = true;
                    q.add(new int[]{edge.to, dist + edge.weight});
                }
            }
        }
        return maxDist;
    }
}