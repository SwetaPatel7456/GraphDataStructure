package Graph;

import java.util.Arrays;

public class BellmanFordAlgorithm {

    public static void main(String[] args) {
        int[][] edges= new int[6][3];
        int noOfVertex =4;
        bellManFordAlgo(edges,noOfVertex);

    }

    private static void bellManFordAlgo(int[][] edges, int noOfVertex) {

        int [] dist= new int[noOfVertex];
        Arrays.fill(dist,Integer.MAX_VALUE);

        for (int i = 1 ;i<noOfVertex;i++){
            for(int j=0;j<edges.length;j++){
                int source = edges[j][0];
                int destination = edges[j][1];
                int weight = edges[j][2];
                if(dist[source]!=Integer.MAX_VALUE && dist[source]+weight<dist[destination]){
                    dist[destination]=dist[source]+weight;
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}
