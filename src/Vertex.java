import java.util.*;

class Vertex<T> {
    private final T value;
    private final List<Edge<T>> adjacents;

    public Vertex(T value) {
        this.value = value;
        this.adjacents = new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public List<Edge<T>> getAdjacents() {
        return adjacents;
    }

    public void addAdjacent(Vertex<T> vertex, double weight) {
        adjacents.add(new Edge<>(vertex, weight));
    }

    public void addAdjacent(Vertex<T> vertex) {
        adjacents.add(new Edge<>(vertex));
    }
}