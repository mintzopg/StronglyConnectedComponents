package gimin.Kosaraju;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by gimin on 12/21/16.
 */
public class ForwardDFS {

    private Deque<Vertex> frwdQueue; // this is the queue for the kosaraju algo.
    private Deque<Vertex> stack; // this is the stack for the DFS

    public ForwardDFS(Graph graph) {
        stack = new ArrayDeque<>();
        frwdQueue = new ArrayDeque<>();
        for (Vertex vertex : graph.getVertices()) {
            if (! vertex.isVisited()) {
//                dfsRecur(vertex);
                dfsWithStack(vertex);
            }
        }
    }

    private void dfsWithStack(Vertex vertex) {
        //  Traverse the graph in a DFS manner keeping track of node discovery sequence (in frwdQueue).
        vertex.setVisited(true);
        stack.push(vertex);
        while (! stack.isEmpty()) {
            vertex = stack.peek();
            boolean foundUnvisited = false;
            for (Vertex v : vertex.getAdjacenyList()) {
                if (! v.isVisited()) {
                    foundUnvisited = true;
                    v.setVisited(true);
                    stack.push(v);
                    break;
                }
            }
            if (! foundUnvisited) {
                stack.pop();
                frwdQueue.addFirst(vertex); // addFirst(): prepend element in queue
            }
        }
    }

    private void dfsRecur(Vertex vertex) {
        vertex.setVisited(true);

        for (Vertex v : vertex.getAdjacenyList()) {
            if (! v.isVisited()) dfsRecur(v);
        }

        frwdQueue.addFirst(vertex); // important add at the end of the ArrayDeque
    }

    public Deque<Vertex> getFrwdStack() {
        return frwdQueue;
    }

}
