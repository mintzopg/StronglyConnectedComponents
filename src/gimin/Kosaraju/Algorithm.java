package gimin.Kosaraju;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by gimin on 12/23/16.
 * Implementation of the Kosaraju algorithm for SCCs.
 *
 * Input: a Graph G(V, E)
 * Output: the number of SCCs and a printout of the clusters.
 *
 * Notes: DFS is implemented both recursively and with a Stack.
 */
public class Algorithm {

    private int[] id; // ids of the SCCs
    private boolean[] marked; // has vertex v been visited, marked[v] = true
    private int count;  // Count SCCs

    public Algorithm(Graph graph) {

        id = new int[graph.getVertices().size()];
        marked = new boolean[graph.getVertices().size()];
        Vertex vertex;

        /* Do 1st DFS on original graph */
        ForwardDFS forwardDFS = new ForwardDFS(graph);

        /* get forwrad queue (ordered lis with chronological/topological order of the discovered vertices during DFS
        on original graph). */
        Deque<Vertex> queue = forwardDFS.getFrwdStack();

        /* trnaspose the grap */
        graph.getTranspose();

        // Do the second DSF; keep popping nodes from the forward queue in LIFO order
        while (! queue.isEmpty()) {
            vertex = queue.removeFirst();
            if (! marked[vertex.getId()]) {
//                dfsRecur(vertex);
                dfsWithStack(vertex);
                count++;

            }
        }
    }

    // dfs implementation with Stack
    Deque<Vertex> stack = new ArrayDeque<>();

    private void dfsWithStack(Vertex vertex) {
        // DFS on the transposed graph accessing nodes in the reverse order they were discovered.
        stack.push(vertex);
        while (! stack.isEmpty()) {
            vertex = stack.pop();
            marked[vertex.getId()] = true;
            id[vertex.getId()] = count;
            vertex.setComponentId(count);

            for(Vertex v: vertex.getAdjacenyList()) {
                if(! marked[v.getId()]) {
                    stack.push(v);
                }
            }
        }
    }

    // Recursive implementation
    private void dfsRecur(Vertex vertex) {
        marked[vertex.getId()] = true;
        id[vertex.getId()] = count;
        vertex.setComponentId(count);

        for (Vertex v : vertex.getAdjacenyList()) {
            if (! marked[v.getId()]) dfsRecur(v);

        }
    }

    public int getCount() {
        return count;
    }
}
