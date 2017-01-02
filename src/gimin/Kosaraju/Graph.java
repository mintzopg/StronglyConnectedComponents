package gimin.Kosaraju;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gimin on 12/21/16.
 */
public class Graph {

    private List<Vertex> vertices;
    private List<Edge> edges;

    private Graph() {
/*
        Private constructor (only create this type of object inside this class).
        Vertices list is mutated when getting the transposed graph. To get the vertices (with adjacencies) of the
        original graph we need to do transpose(transpoed graph).
        Initialize edges because I set the transpose graph edges anew  (although I don't really needed the edges list
         for the algorithm.)
        */
        edges = new ArrayList<>();
    }

    public Graph(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;

        // set up the adjacencies for the graph
        for (Edge edge : this.edges) {
            edge.getStartVertex().addNeighbor(edge.getTargetVertex());
        }
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public Graph getTranspose() {
        // Create and return the transposed Graph

        Graph transposeGraph = new Graph();

        /*
        All lists used hold objects of types Eertex and Edge. Changing Vertex objects impacts both graphs as
        references point to the same objects in memory.
        Set up the edges of the transposed Graph & the adjacencies for the vertices; the loop mutates vertices by
        changing their adjacency lists which happens for both graphs, as graph and transposed graph have the same
        vertices (same object references).

        Need to reset all adjacencies to avoid putting the new ones along with the old ones as we add them in the
        list. */

        vertices.forEach(v -> v.setAdjacenyList(new ArrayList<>()));

        for (Edge edge : this.edges) {
            transposeGraph.edges.add(new Edge(edge.getTargetVertex(), edge.getStartVertex(), edge
                    .getWeight()));
            edge.getTargetVertex().addNeighbor(edge.getStartVertex());
        }
        transposeGraph.setVertices(vertices);
        transposeGraph.setEdges(transposeGraph.edges);

        return transposeGraph;
    }

}
