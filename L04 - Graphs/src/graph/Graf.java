package graph;

public class Graf {
    public static void main(String[] args) {
        //EdgeListGraph graph = new EdgeListGraph<>();
        AdjacencyEdgeListGraph graph = new AdjacencyEdgeListGraph();

        graph.addVertex(15);
        graph.addVertex(6); //1
        graph.addVertex(38);
        graph.addVertex(123);
        graph.addVertex(66);

        graph.addEdge(0, 2, 10);
        graph.addEdge(0, 1,23);
        graph.addEdge(0, 3, 90);
        graph.addEdge(1, 4, 8);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 4, 2);
        graph.addEdge(2, 3, 55);

        //-------------------------------------------------

        graph.printEdges();

        System.out.println();

        graph.remove(0,2);

        System.out.println();

        graph.printEdges();

        //graph.removee(6);

        System.out.println();

        graph.printEdges();

    }
}
