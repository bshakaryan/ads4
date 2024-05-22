class Edge<T> {
    private final Vertex<T> vertex;
    private final double weight;

    public Edge(Vertex<T> vertex, double weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public Edge(Vertex<T> vertex) {
        this(vertex, 1.0); // Default weight for unweighted edges
    }

    public Vertex<T> getVertex() {
        return vertex;
    }

    public double getWeight() {
        return weight;
    }
}