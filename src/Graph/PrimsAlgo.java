package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    public static void main(String[] args) {

    }

    public static int prims(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean visited[] = new boolean[adj.size()];
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>();
        priorityQueue.add(new Pair(0, 0));
        int ans = 0;

        while (!priorityQueue.isEmpty()) {
            Pair cur = priorityQueue.remove();
            int v = cur.vertice;
            if (visited[v]) {
                continue;
            }
            ans = ans + cur.weight;
            visited[v] = true;
            ArrayList<ArrayList<Integer>> neighbours = adj.get(cur.vertice);
            for (ArrayList<Integer> neigbour : neighbours) {
                int u = neigbour.get(0);
                int weight = neigbour.get(1);
                if (!visited[u])
                    priorityQueue.add(new Pair(u, weight));
            }
        }
        return ans;
    }
}

