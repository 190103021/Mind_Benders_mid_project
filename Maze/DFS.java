package sample;
import java.util.*;

public class DFS {
        public ArrayList<Integer> wey_path;
        public int start_num;
        private int V; //number of vertex
        private int[][] adjMatrix;// adjMatrix
        public DFS(int v){
            this.V = v;
            adjMatrix = new int[v][v];
            wey_path = new ArrayList();
        }
        public void addVertex(int v1, int v2){
            adjMatrix[v2][v1] = 1;
            adjMatrix[v1][v2] = 1;
            //;
        }
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i< adjMatrix.length;i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                str.append(adjMatrix[i][j] + "  ");
            }
            str.append("\n");
        }
        return str.toString();
    }
        public void pathDFS(int start,int end){
            System.out.print("Path: ");
            this.start_num = start;
            boolean[] visited = new boolean[V];
            Stack<Integer> stack = new Stack<>();
            stack.push(start);

            while (!stack.isEmpty()){
                int nu = 0;
                int v = stack.peek();
                int h = stack.pop();
                System.out.println((h+1) + " <- pop");
                if(!visited[v]){
                    visited[v] = true;
                    wey_path.add(v);
                    System.out.println( "Visited: "+(v+1) + " ");
                    if(v == end){
                        break;
                    }
                    for (int i = 0; i < V;i++){
                        if(adjMatrix[v][i] == 1 && !visited[i]){
                            nu+=1;
                            stack.push(i);
                            System.out.println((v+1)+" connected : "+ (i+1) + " ");
                        }
                    }

                    System.out.println(wey_path.toString());

                }

            }
        }


}
