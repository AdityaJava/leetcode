package leetcode.graphs.graphsandvertices;
//Given an integer n representing number of vertices.
// Find out how many undirected graphs (not necessarily connected) can be constructed out of a given n number of vertices.

public class GraphsAndVertices {

    static long count(int n) {
        int numberOfVertices = n;

        //numberOfEdges = numberOfVerticesC2 that is the combination;
        int numberOfEdges = calculateCombination(numberOfVertices, 2);
        long numberOfGraphs = Double.valueOf(calculateNumberOfGraphs(numberOfEdges)).longValue();
        return numberOfGraphs;
    }

    private static double calculateNumberOfGraphs(int numberOfEdges) {
        return Math.pow(Integer.valueOf(2).doubleValue(), Integer.valueOf(numberOfEdges).doubleValue());
    }

    //nCr = n(n-1)/r
    private static int calculateCombination(int n, int r) {
        return (n * (n - 1)) / r;
    }


    public static void main(String[] args) {

    }
}
