package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import static Graph.GraphUsingOnlyArrayList.addEdgeInAdjacencyMatrix;

public class DijktrasAlgorithm {

    public static void main(String[] args) {

    }

    public static int[] dijkstras(ArrayList<ArrayList<ArrayList<Integer>>> adj,int source) {

        PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
        boolean visited[] = new boolean[adj.size()];
        int ans[] = new int[adj.size()];
        Arrays.fill(ans,Integer.MAX_VALUE);
        queue.add(new Pair(source,0));
        ans[0]=0;
        while (!queue.isEmpty()){
            Pair cur = queue.remove();
            int vertex = cur.vertice;
            int weight = cur.weight;
            if(visited[vertex]){
                continue;
            }
            visited[vertex]=true;
            ArrayList<ArrayList<Integer>> neighbours = adj.get(vertex);
            for (ArrayList<Integer> neighbour: neighbours){
                if(ans[neighbour.get(0)]>ans[vertex]+weight){
                    ans[neighbour.get(0)]=ans[vertex]+weight;
                    queue.add(new Pair(neighbour.get(0),neighbour.get(1)));
                }
            }
        }
        return ans;

    }
}
