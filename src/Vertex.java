import java.util.*;

class Vertex<T> {
    private final T value;
    private final List<Vertex<T>> adjacents;
    private final Map<Vertex<T>, Double> weights;

    public Vertex(T value) {
        this.value = value;
        this.adjacents = new ArrayList<>();
        this.weights = new HashMap<>();
    }

    public T getValue() {
        return value;
    }

    public List<Vertex<T>> getAdjacents() {
        return adjacents;
    }

    public double getWeight(Vertex<T> vertex) {
        return weights.getOrDefault(vertex, 1.0); // Default weight is 1.0 for unweighted edges
    }

    public void addAdjacent(Vertex<T> vertex, double weight) {
        adjacents.add(vertex);
        weights.put(vertex, weight);
    }

    public void addAdjacent(Vertex<T> vertex) {
        adjacents.add(vertex);
        weights.put(vertex, 1.0); // Default weight for unweighted edges
    }
}
