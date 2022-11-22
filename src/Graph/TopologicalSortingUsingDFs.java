package Graph;

import java.util.ArrayList;
import java.util.Stack;

import static Graph.GraphUsingOnlyArrayList.addEdgeInAdjacencyMatrix;

public class TopologicalSortingUsingDFs {

    public static Stack<Integer>stack = new Stack<Integer>();

    public static void main(String[] args) {
        int v = 6;
        int e =10;
        // addEdgeMatrix(1,2,a);
        // addEdgeMatrix(2,3,a);

        //for adjacnecy list initialization
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<= v;i++){
            adj.add(new ArrayList<>());
        }
        addEdgeInAdjacencyMatrix(2,3,adj);
        addEdgeInAdjacencyMatrix(3,4,adj);
        addEdgeInAdjacencyMatrix(4,5,adj);
        boolean visited[] = new boolean[v];
        dfs(2,adj,visited);

    }

    public static void dfs(int v , ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[v]=true;

        for(Integer neighbour :adj.get(v)){
            if(!visited[neighbour]) {
                dfs(neighbour, adj, visited);
            }
        }
        System.out.println(v);
        stack.push(v);
    }
}
