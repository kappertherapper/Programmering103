package moreGraph;

import java.util.*;

public class GraphAlgortihms {
    /**
     * Returnerer en liste af grafens knuder fundet ved et dybddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> dfs(Graph<V> graph, V v) {
        boolean[] isVisited = new boolean[graph.getSize()];
        return DFS(graph, v, isVisited);
    }

    private static <V> List<V> DFS(Graph<V> graph, V v, boolean[] visited) {
        List<V> beenThere = new ArrayList<>();
        int index = graph.getIndex(v);
        visited[index] = true;
        beenThere.add(v);

        List<V> neighbors = graph.getNeighbors(v);
        for (V neighbor : neighbors) {
            int neighborIndex = graph.getIndex(neighbor);
            if (!visited[neighborIndex]) {
                DFS(graph, neighbor, visited);
            }
        }
        return beenThere;
    }

    /**
     * Returnerer en liste af grafens knuder fundet ved et breddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> bfs(Graph<V> graph, V v) {
        List<V> visited = new ArrayList<>();
        Queue<V> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            visited.add(current);

            List<V> neighbors = graph.getNeighbors(current);
            for (V neighbor : neighbors) {
                if (!visited.contains(neighbor) && !queue.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    /**
     * Returnerer om grafen er sammenhængende
     * Pre: grafen er ikke tom
     */
    public static <V> boolean connected(Graph<V> graph) {
        //List<V> g = dfs(graph, graph.getVertex(0));
        //return graph.getVertices().size() == g.size();

        List<V> vertices = graph.getVertices();
        boolean[] visited = new boolean[graph.getSize()];

        for (V vertex : vertices) {
            if (!visited[vertices.indexOf(vertex)]) {
                DFS(graph, vertex, visited);
            }
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returnerer om der er en vej fra v1 til v2 i graph
     */
    public static <V> boolean isPath(Graph<V> graph, V v1, V v2) {
        boolean[] beenThere = new boolean[graph.getSize()];
        return isPathDFS(graph, v1, v2, beenThere);
    }

    public static <V> boolean isPathDFS(Graph<V> graph, V current, V target, boolean[] beenThere) {
        if (current.equals(target)) {
            return true;
        }

        int index = graph.getIndex(current);
        beenThere[index] = true;

        List<V> neighbors = graph.getNeighbors(current);
        for (V neighbor : neighbors) {
            int neighborIndex = graph.getIndex(neighbor);
            if (!beenThere[neighborIndex] && isPathDFS(graph, neighbor, target, beenThere)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returnerer en mængde af grafens kanter der udgør det letteste udspændende træ for grafen.
     * Grafen er en simpel vægtet graf
     */
    public static <V> Set<Edge> mst(Graph<V> graph) {
        // TODO Opgave 7
        return null;
    }

    /** Stoled boi */
    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String source) {
        // Initialize distances with infinity for all vertices except the source
        Map<String, Integer> distances = new HashMap<>();
        for (String vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        // Priority queue to store vertices with their respective distances
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );
        priorityQueue.offer(new AbstractMap.SimpleEntry<>(source, 0));

        while (!priorityQueue.isEmpty()) {
            // Pop the vertex with the smallest distance from the priority queue
            Map.Entry<String, Integer> entry = priorityQueue.poll();
            String currentVertex = entry.getKey();
            int currentDistance = entry.getValue();

            // Visit each neighbor of the current vertex
            for (Map.Entry<String, Integer> neighborEntry : graph.get(currentVertex).entrySet()) {
                String neighbor = neighborEntry.getKey();
                int weight = neighborEntry.getValue();
                int distance = currentDistance + weight;

                // If the distance to the neighbor through the current vertex is shorter
                if (distance < distances.get(neighbor)) {
                    // Update the distance to the neighbor
                    distances.put(neighbor, distance);
                    // Push the neighbor with its updated distance into the priority queue
                    priorityQueue.offer(new AbstractMap.SimpleEntry<>(neighbor, distance));
                }
            }
        }

        return distances;
    }

}
