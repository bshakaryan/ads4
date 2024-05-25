import java.util.*;

class DijkstraSearch<T> implements Search<T> {
    private final Map<T, T> edgeTo;
    private final Map<T, Double> distTo;
    private final PriorityQueue<Pair<T>> pq;
    private final T start;

    public DijkstraSearch(WeightedGraph<T> graph, T start) {
        this.edgeTo = new HashMap<>();
        this.distTo = new HashMap<>();
        this.pq = new PriorityQueue<>(Comparator.comparingDouble(Pair::getWeight));
        this.start = start;

        for (Vertex<T> vertex : graph.getVertices()) {
            distTo.put(vertex.getValue(), Double.POSITIVE_INFINITY);
        }
        distTo.put(start, 0.0);

        pq.add(new Pair<>(start, 0.0));
        while (!pq.isEmpty()) {
            T v = pq.poll().getVertex();
            Vertex<T> vertex = graph.getVertex(v);
            for (Vertex<T> adj : vertex.getAdjacents()) {
                relax(vertex, adj);
            }
        }
    }

    private void relax(Vertex<T> v, Vertex<T> w) {
        double weight = v.getWeight(w);
        T from = v.getValue();
        T to = w.getValue();
        if (distTo.get(to) > distTo.get(from) + weight) {
            distTo.put(to, distTo.get(from) + weight);
            edgeTo.put(to, from);
            pq.add(new Pair<>(to, distTo.get(to)));
        }
    }

    public boolean hasPathTo(T v) {
        return distTo.get(v) < Double.POSITIVE_INFINITY;
    }

    public Iterable<T> pathTo(T v) {
        if (!hasPathTo(v)) return null;
        LinkedList<T> path = new LinkedList<>();
        for (T x = v; x != start; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(start);
        return path;
    }

    private static class Pair<T> {
        private final T vertex;
        private final double weight;

        public Pair(T vertex, double weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public T getVertex() {
            return vertex;
        }

        public double getWeight() {
            return weight;
        }
    }
}
