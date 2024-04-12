package graph;

import java.util.*;

public class AdjacencyEdgeListGraph<V> implements Graph {
    private List<List<Edge>> adjacencyList;

    protected List<V> vertices = new ArrayList<>();
    protected List<Edge> edges = new ArrayList<>();

    /**
     * Construct an empty graph
     */
    public AdjacencyEdgeListGraph() {
        adjacencyList = new ArrayList<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.add(new ArrayList<>());
    }

    @Override
    /** Return the number of vertices in the graph */
    public int getSize() {
        return adjacencyList.size();
    }

    @Override
    /** Return the number of edges in the graph */
    public int getNumEdges() {
        int count = 0;
        for (int i = 0; i < adjacencyList.size(); i++) {
            for (Edge edge : adjacencyList.get(i)) {
                count++;
            }
        }
        return count;
    }

    @Override
    /** Return the vertices in the graph */
    public List getVertices() {
        List<List<Edge>> vertices = new ArrayList<>();
        for (int i = 0; i < adjacencyList.size(); i++) {
            vertices.add(adjacencyList.get(i));
        }
        return vertices;
    }

    @Override
    /** Return the edges in the graph */
    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < adjacencyList.size(); i++) {
            for (Edge edge : adjacencyList.get(i)) {
            edges.add(edge);
            }
        }
        return edges;
    }

    @Override
    /** Return the object for the specified vertex */
    public Object getVertex(int index) {
        return adjacencyList.get(index);
    }

    @Override
    /** Return the index for the specified vertex object */
    public int getIndex(Object o) {
        return adjacencyList.indexOf(o);
    }

    @Override
    /** Return the neighbors of the specified vertex */
    public List getNeighbors(Object o) {
        int index = getIndex(o);
        Set<Object> result = new HashSet<>();
        for (Edge edge : getEdges())
            if (edge.u == index) {
                result.add(getVertices().get(edge.u));
            } else if (edge.v == index) {
                result.add(getVertices().get(edge.v));
            }
        return new ArrayList<Object>(result);
    }

    @Override
    /** Return the indexes neighbors of the specified vertex */
    public List<Integer> getNeighborsIndex(Object o) {
        int index = getIndex(o);
        Set<Integer> result = new HashSet<>();
        for (Edge edge : getEdges()) {
            if (edge.u == index) {
                result.add(edge.v);
            } else if (edge.v == index) {
                result.add(edge.u);
            }
        }
        return new ArrayList<>(result);
    }

    @Override
    /** Return the incident edges of vertex v */
    public List<Edge> getIncidentEdges(Object o) {
        int index = getIndex(o);
        Set<Edge> result = new HashSet<>();
        for (Edge edge : getEdges()) {
            if (edge.u == index) {
                result.add(edge);
            } else if (edge.v == index) {
                result.add(edge);
            }
        }
        return new ArrayList<>(result);
    }

    @Override
    /** Return the degree for a specified vertex */
    public int getDegree(Object o) {
        return getNeighbors(o).size();
    }

    @Override
    /** Print the edges */
    public void printEdges() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            List<Edge> edges = adjacencyList.get(i);
            for (Edge edge : edges)
                System.out.println("Vertex " + i + " to Vertex " + edge.v + ": " + edge.e);
        }
    }

    @Override
    /** Clear the graph */
    public void clear() {
        adjacencyList.clear();
    }

    @Override
    /** Add a vertex to the graph */
    public boolean addVertex(Object vertex) {
        if (!adjacencyList.contains(vertex)) {
            adjacencyList.add(new ArrayList<>());
            return true;
        } else {
            return false;
        }
    }

    /** Add an edge to the graph */
    @Override
    public boolean addEdge(int u, int v, int e) {
        return adjacencyList.get(u).add(new Edge(u,v,e)) && adjacencyList.get(v).add(new Edge(v,u,e));
    }

    /** Add an edge to the graph */
    @Override
    public boolean addEdge(int u, int v) {
        return adjacencyList.get(u).add(new Edge(u,v,0)) && adjacencyList.get(v).add(new Edge(v,u,0));
    }

    @Override
    /** Remove vertex o and return true if successful */
    public boolean remove(Object o) {
        int index = adjacencyList.indexOf(o);
        if (index == -1) {
            return false;
        }

        Iterator<List<Edge>> outerIterator = adjacencyList.iterator();
        while (outerIterator.hasNext()) {
            List<Edge> edges = outerIterator.next();

            Iterator<Edge> innerIterator = edges.iterator();
            while (innerIterator.hasNext()) {
                Edge edge = innerIterator.next();

                if (edge.u == index || edge.v == index) {
                    innerIterator.remove();
                }
            }
        }
        adjacencyList.remove(index);
        return true;
    }

    @Override
    /** Remove edge (u, v) and return true if successful */
    public boolean remove(int u, int v) {
        boolean removed = false;
        for (int i = 0; i < adjacencyList.size(); i++) {
            List<Edge> edges = adjacencyList.get(i);
            for (int j = 0; j < edges.size(); j++) {
                Edge edge = edges.get(j);
                if (edge.u == u && edge.v == v || (edge.u == v && edge.v == u)) {
                    edges.remove(j);
                    removed = true;
                    i--;
                }
            }
        }
        return removed;
    }



    public void printGraph() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            for (Edge edge : adjacencyList.get(i)) {
                System.out.println(i + " - " + edge.v);
            }
        }
    }
}
