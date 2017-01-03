package algorithm.Tarjan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TarjanAlgorithm {
  private Deque<Vertex> stack;
    private List<Vertex> vertexList;
    private List<List<Vertex>> connectedComponentsList;
    private int count;

    public TarjanAlgorithm(List<Vertex> vertexList) {
        this.vertexList = vertexList;
        stack = new ArrayDeque<>();
        connectedComponentsList = new ArrayList<>();
    }

    public void runAlgorithm() {

        for (Vertex vertex : vertexList) {
            if (! vertex.isVisited())
                dfs(vertex);
        }
    }

    private void dfs(Vertex vertex) {
        vertex.setLowLink(count++);
        vertex.setVisited(true);
        stack.push(vertex);
        boolean isComponentRoot = true;

        for (Vertex v : vertex.getAdjacenyList()) {
            if (! v.isVisited()) dfs(v);

            if (vertex.getLowLink() > v.getLowLink()) {
                vertex.setLowLink(v.getLowLink());
                isComponentRoot = false;
            }
        }

        if (isComponentRoot) {
            List<Vertex> component = new ArrayList<>();

            while (true) {
                Vertex actualVertex = stack.pop();
                component.add(actualVertex);
                actualVertex.setLowLink(Integer.MAX_VALUE);

                if (actualVertex.getName().equals(vertex.getName())) break;
            }

            connectedComponentsList.add(component);
        }
    }

    public void printComponents() {
        System.out.println(connectedComponentsList);
    }
}
