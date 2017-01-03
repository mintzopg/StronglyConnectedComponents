package algorithm.Tarjan;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
  private String name;
    private List<Vertex> adjacenyList;
    private boolean visited;
    private int lowLink;
    private Vertex predecessor;

    public Vertex(String name) {
        this.name = name;
        adjacenyList = new ArrayList<>();
    }

    public void addNeighbor(Vertex v) {
        adjacenyList.add(v);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vertex> getAdjacenyList() {
        return adjacenyList;
    }

    public void setAdjacenyList(List<Vertex> adjacenyList) {
        this.adjacenyList = adjacenyList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getLowLink() {
        return lowLink;
    }

    public void setLowLink(int lowLink) {
        this.lowLink = lowLink;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public String toString() {
        return name;
    }
}
