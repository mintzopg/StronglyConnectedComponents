package gimin.Kosaraju;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gimin on 12/21/16.
 */
public class Vertex {

    private int id;
    private String name;
    private boolean visited;
    private List<Vertex> adjacenyList;
    private int componentId;

    public Vertex(int id, String name) {
        this.id = id;
        this.name = name;
        adjacenyList = new ArrayList<>();
    }

    public void addNeighbor(Vertex x) {
        adjacenyList.add(x);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjacenyList() {
        return adjacenyList;
    }

    public void setAdjacenyList(List<Vertex> adjacenyList) {
        this.adjacenyList = adjacenyList;
    }

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    @Override
    public String toString() {
        return "Vertex: " + name;
    }


}
