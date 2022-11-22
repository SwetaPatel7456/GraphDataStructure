package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static Graph.GraphUsingOnlyArrayList.addEdgeInAdjacencyMatrix;

public class TopologicalSortingUsingBfs {

    public static Stack<Integer>stack = new Stack<Integer>();

    public static void main(String[] args) {
        int v = 4;
        int e =10;
        // addEdgeMatrix(1,2,a);
        // addEdgeMatrix(2,3,a);

        //for adjacnecy list initialization
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<= v;i++){
            adj.add(new ArrayList<>());
        }
        addEdgeInAdjacencyMatrix(0,1,adj);
        addEdgeInAdjacencyMatrix(0,2,adj);
        addEdgeInAdjacencyMatrix(1,3,adj);
        addEdgeInAdjacencyMatrix(2,3,adj);
        boolean visited[] = new boolean[v];
        int indegree[] = new int[v];
        for(ArrayList<Integer> list:adj){
            for(Integer f :list){
                indegree[f]++;
            }

        }
        bfs( v,adj,visited,indegree);

    }

    public static void bfs(int v,ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] indegree){

        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> ansList = new ArrayList<>();
        for(int i =0;i<v;i++){
            if(indegree[i]==0){
                queue.add(i);
                ansList.add(i);
                visited[i] =true;
            }
        }
        while (!queue.isEmpty()){
            Integer item = queue.pop();
            List<Integer> list = adj.get(item);
            for(Integer neighbour:list){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.add(neighbour);
                    ansList.add(neighbour);
                    visited[neighbour]=true;
                }
            }
        }
        System.out.println(ansList);
    }

}
