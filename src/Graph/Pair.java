package Graph;

public class Pair implements Comparable<Pair>{

    int vertice ;
    int weight;
    public Pair(int v, int weight) {
        this.vertice= v;
        this.weight=weight;
    }

    @Override
    public int compareTo(Pair o) {
        return 0;
    }
}
