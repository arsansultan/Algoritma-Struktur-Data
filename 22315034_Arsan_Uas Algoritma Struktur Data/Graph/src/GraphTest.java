public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        System.out.println("Adjency list dari tiap mode:");
        for (int v = 0; v < graph.V(); v++) {
            System.out.println(v + ": ");
            for (int w : graph.adj(v)) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}
