package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphUsingOnlyArrayList {

    public static void main(String[] args) {

        int v = 5;
        int e =10;
        int a[][] = new int[v+1][e+1];
       // addEdgeMatrix(1,2,a);
       // addEdgeMatrix(2,3,a);

        //for adjacnecy list initialization
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<= v;i++){
            adj.add(new ArrayList<>());
        }
        addEdgeInAdjacencyMatrix(2,3,adj);
        addEdgeInAdjacencyMatrix(3,4,adj);
        DfsUsingRecursion(2,adj);

    }
    public static void  addEdgeMatrix(int source,int destination,int a[][]){
        a[source][destination]=1;
        a[destination][source]=1;
    }

    public static void addEdgeInAdjacencyMatrix(int source, int destination, ArrayList<ArrayList<Integer>> adj){
        adj.get(source).add(destination);
       // adj.get(destination).add(source);
    }
    public static boolean isReached(ArrayList<ArrayList<Integer>> adj){
        int v = 6;
        int e = 8;

        int pred[] = new int[v+1];
        int dist[] = new int[v+1];
        boolean visited[] = new boolean[v];
        int components =0;
        boolean isreached = BFSTraversal(adj,1,v,dist,pred,6,visited);
        for(int i =1;i<=v;i++){
            if(visited[i]== false){
                components++;
                BFSTraversal(adj,1,v,dist,pred,6,visited);
            }
        }
        return isreached;
    }

    public static boolean BFSTraversal(ArrayList<ArrayList<Integer>> adj, int source, int v, int[] distance, int[] pred, int destination, boolean[] visited){

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i =0;i<v;i++){
            visited[i] = false;
            distance[i] =Integer.MAX_VALUE;
            pred[i] = -1;
        }
        visited[source] =true;
        distance[source] = 0;
        queue.add(source);

        while (!queue.isEmpty()){
            int cur = queue.remove();
            for(int i =0;i<adj.get(cur).size();i++){
                int neighbour =  adj.get(cur).get(i);
                if(visited[neighbour]==false) {
                    visited[neighbour] = true;
                    distance[neighbour] = distance[cur] + 1;
                    pred[neighbour] = cur;
                    queue.add(neighbour);
                    if(neighbour==destination){
                        return true;
                    }
                }
            }

        }
        return false;

    }
    public static void DFSTraversal(ArrayList<ArrayList<Integer>> adj, int source, int v, int[] distance, int[] pred,int destination, boolean[] visited){


        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<v;i++){
            visited[i] = false;
        }
        visited[source] =true;
        stack.push(source);
        while (!stack.isEmpty()){
            int s = stack.pop();
            if(visited[s]==false){
                visited[s] =true;
            }
            List<Integer> list = adj.get(s);
            for(int item:list){
                if(visited[item]==false){
                    stack.push(item);
                    visited[item]=true;
                }
            }
        }

    }

    public static void DfsUsingRecursion(int v ,ArrayList<ArrayList<Integer>> adj){
        boolean visited[] = new boolean[adj.size()];
        List<Integer> ans = new ArrayList<>();
        dfs(v,adj,visited,ans);
        System.out.println(ans);

    }

    private static void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, List<Integer> ans) {
        visited[v] = true;
        ans.add(v);
        for (Integer neighbour :adj.get(v)){
            if(!visited[neighbour]){
                dfs(neighbour,adj,visited,ans);
            }
        }
    }
}
