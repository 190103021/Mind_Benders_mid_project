import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

public  class Graph {
        Integer nodes;
        List<List<Integer>> adjlist;
        boolean[] visited;

        Graph(Integer argNodes) {
            nodes = argNodes;
            adjlist = new ArrayList<>(nodes);
            for (int i=0; i<nodes; i++)
                adjlist.add(new ArrayList<>());
                visited = new boolean[nodes];
        }

        void addEdge(Integer src, Integer dst) {
            adjlist.get(src).add(dst);
            adjlist.get(dst).add(src);
        }

        // DFS recursive implementation
        void dfs(Integer src) {
            visited[src] = true;
            System.out.print(src + " ");
            for (Integer adjNode : adjlist.get(src)) {
                if (!visited[adjNode]) {
                    dfs(adjNode);
                }
            }
        }

        // DFS iterative implementation
        void dfsIterative(int src) {
            Stack<Integer> stk = new Stack<>();
            stk.push(src);
            while (!stk.empty()) {
                src = stk.peek();
                stk.pop();
                if (!visited[src]) {
                    visited[src] = true;
                    System.out.print(src + " ");
                    for (Integer adjNode : adjlist.get(src)) {
                        stk.push(adjNode);
                    }
                }
            }
        }

        // Mark nodes unvisited for next traversal
        void markUnvisited () {
            Arrays.fill(visited, false);
        }
    

    public static void main (String[] args) {

        Graph g = new Graph(7);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,3);
        g.addEdge(3,5);
        g.addEdge(4,6);
        g.addEdge(5,6);

        System.out.println("DFS Recursive Graph Traversal ");
        System.out.print("\nSource Node (0): "); g.dfs(0);

        g.markUnvisited();
        System.out.print("\nSource Node (3): "); g.dfs(3);
        g.markUnvisited();

        System.out.println("\n\nDFS Iterative Graph Traversal");
        System.out.print("\nSource Node (0): "); g.dfsIterative(0);
        g.markUnvisited();
        System.out.print("\nSource Node (3): "); g.dfsIterative(3);
        g.markUnvisited();

        Graph t = new Graph(10);
        t.addEdge(0,1);
        t.addEdge(0,6);
        t.addEdge(0,7);
        t.addEdge(1,2);
        t.addEdge(1,4);
        t.addEdge(1,5);
        t.addEdge(2,3);
        t.addEdge(7,8);
        t.addEdge(7,9);

        System.out.println("\n\nDFS Recursive Tree Traversal");
        System.out.print("\nRoot Node (0): "); t.dfs(0);
        t.markUnvisited();
        System.out.print("\nRoot Node (4): "); t.dfs(4);
        t.markUnvisited();

        System.out.println("\n\nDFS Iterative Tree Traversal");
        System.out.print("\nSource Node (0): "); t.dfsIterative(0);
        t.markUnvisited();
        System.out.print("\nSource Node (4): "); t.dfsIterative(4);
        t.markUnvisited();
    }
}