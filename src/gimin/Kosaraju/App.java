package gimin.Kosaraju;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gimin on 12/21/16.
 */
public class App {

    public static void main(String[] args) {

        Vertex a = new Vertex(0, "a");
        Vertex b = new Vertex(1, "b");
        Vertex c = new Vertex(2, "c");
        Vertex d = new Vertex(3, "d");
        Vertex e = new Vertex(4, "e");
        Vertex f = new Vertex(5, "f");
        Vertex g = new Vertex(6, "g");
        Vertex h = new Vertex(7, "h");

        final List<Vertex> vertexList = Arrays.asList(a, b, c, d, e, f, g, h);

        Edge e0 = new Edge(a, c, 1);
        Edge e1 = new Edge(b, a, 1);
        Edge e2 = new Edge(b, d, 1);
        Edge e3 = new Edge(c, b, 1);
        Edge e4 = new Edge(c, d, 1);
        Edge e5 = new Edge(c, e, 1);
        Edge e6 = new Edge(d, f, 1);
        Edge e7 = new Edge(e, f, 1);
        Edge e8 = new Edge(e, g, 1);
        Edge e9 = new Edge(f, d, 1);
        Edge e10 = new Edge(g, e, 1);
        Edge e11 = new Edge(g, h, 1);
        Edge e12 = new Edge(h, g, 1);
        Edge e13 = new Edge(h, f, 1);

        final List<Edge> edgeList = Arrays.asList(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13);

        Graph graph = new Graph(vertexList, edgeList);

/*
ForwardDFS test = new ForwardDFS(graph);
while(!test.getFrwdStack().isEmpty()) System.out.println(test.getFrwdStack().remove());
*/

        Algorithm scc = new Algorithm(graph);
        System.out.println("Number of Strongly Connected Components = " + scc.getCount());

        System.out.println("Printing SCCs: ");

        vertexList.forEach(v -> System.out.println(v + " - " + v.getComponentId()));

    }
}
