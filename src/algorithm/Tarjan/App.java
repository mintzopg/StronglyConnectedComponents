package algorithm.Tarjan;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();

		vertexList.add(new Vertex("a"));
		vertexList.add(new Vertex("b"));
		vertexList.add(new Vertex("c"));
		vertexList.add(new Vertex("d"));
		vertexList.add(new Vertex("e"));
		vertexList.add(new Vertex("f"));
		vertexList.add(new Vertex("g"));
		vertexList.add(new Vertex("h"));

		vertexList.get(0).addNeighbor(vertexList.get(1));

		vertexList.get(1).addNeighbor(vertexList.get(2));
		vertexList.get(1).addNeighbor(vertexList.get(4));
		vertexList.get(1).addNeighbor(vertexList.get(5));

		vertexList.get(2).addNeighbor(vertexList.get(3));
		vertexList.get(2).addNeighbor(vertexList.get(6));

		vertexList.get(3).addNeighbor(vertexList.get(2));
		vertexList.get(3).addNeighbor(vertexList.get(7));

		vertexList.get(4).addNeighbor(vertexList.get(0));
		vertexList.get(4).addNeighbor(vertexList.get(5));

		vertexList.get(5).addNeighbor(vertexList.get(6));

		vertexList.get(6).addNeighbor(vertexList.get(5));

		vertexList.get(7).addNeighbor(vertexList.get(6));
		vertexList.get(7).addNeighbor(vertexList.get(3));

        /*
        vertexList.add(new Vertex("a"));

        vertexList.add(new Vertex("b"));
        vertexList.add(new Vertex("c"));

        vertexList.get(0).addNeighbor(vertexList.get(1));
        vertexList.get(1).addNeighbor(vertexList.get(0));
        //vertexList.get(2).addNeighbor(vertexList.get(0));
        */

        TarjanAlgorithm tarjanAlgorithm = new TarjanAlgorithm(vertexList);
        tarjanAlgorithm.runAlgorithm();
        tarjanAlgorithm.printComponents();
    }
}
