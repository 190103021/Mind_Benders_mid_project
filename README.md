# Mind_Benders_mid_project
#Explanation of DFS algorithm                                                                                                                                                  
If we consider the algorithm of this graph. Let's start from zero. If it is green, it is added to the stack, and if it is large pink, it marks as visited. Then we add zero to the stack. After it visited then it is removed from the stack. Then we add all
neighbours. They go on the stack. Eight, three, one.   We marked 1 as visited, it will removed from stack. Then we add seven to stacks, after it marked as visited will  removed from stack. We push to stack neighbour of seven - 2. 2 will visited, then will deleted from stack. But will added neighbours of 2, that is 3 and 5. 3 is already pushed to stack, so its color pink in stack. Then 3 will be visited, it will deleted, 4 will pushed to stack. 4 will visited and it is neighbour is 8, 8 is also already pushed to stack, so color of 8 will be changed to pink in a stack. 4 will removed from stack. After 8 marks as visited, then also removed. There is no other way, so we will come back to 2. 5 will be visited, it will removed, neighbour of 5 - 6 pushes to stack, then it will marked as visited. 6 will be removed. After 3 then 8 will be removed from stack which pushed at the start. That is how dfs algorithm works. 

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#Explanation of java code.                                                                                                                                    
Firstly, in main method I created variable of type Graph, then invoked object of Graph class, this is graph, 7 means number of vertices. 
 Called addEdge method. By addEdge method I can add source and destination vertices and edge between them, source vertex is a vertex which edge begins,
 destination vertex is a vertex which edge ends.  By adjlist.get(src).add(dst); I will get src from List adjList and add dst. After I added all vertices 
 and edges, I invoked dfs method. dfs method is recursive implementation of DFS. In dfs method I marked src vertex as visited (visited[src] = true), then
 it will printed with space. In for-each loop I will check all src vertices is it visited or not by variable adjNode. If this src vertex not visited then 
 I will invoke dfs method recursively. It will invoke recursively and if not visited, mark as visited. So will print vertices. And this method store in 
 parameter int src, it means in which vertex in will start to check. Then I call markUnvisited method, this method marks nodes unvisited for next traversal,
 for one more time call methods. Arrays.fill(visited, false), visited is the array to be filled, false is the value to be stored in all elements of the array.
 Then I invoked dfs method one more time for experiment, in this case it will start with another vertex.
    Then, I called method dfsIterative, this also dfs algoritm, but not recursively, it is iterative version. In this method I used Stack, as you know DFS uses 
Stack.  I declared stack which accept integers. Then will push src vertex to stack. Remember that, src vertex here is a vertex which algorithm will start, 
that is root vertex. While stack not empty, src will equal to first element in stack because, peek() method retrieves first element in stack. After by stk.pop()
element will popped from the top of the stack and removed from the same. If src vertex not visited, it will visited, that is will marked as visited, then will 
printed with space.  In for-each loop I will check all src vertices is it visited or not by variable adjNode, then will push to stack. In parameter accept int 
src variable, it means in which vertex in will start to check. Then I call markUnvisited method again, this method marks nodes unvisited for next traversal. 
Then I invoked dfsIterative method one more time for experiment, in this case it will start with another vertex.
  Then I again created variable of type Graph, then invoked object of Graph class, this is tree, 10 means number of vertices. After again called method dfs, 
  dfsIterative, markUnvisited, addEdge.
Graph class contain datafields  Integer nodes, List<List<Integer>> adjlist, boolean[] visited; nodes is for number of nodes, vertices, adjList is for adding vertices 
and edges, array visited is for mark vertices as visited. Then contain constructor, constructor accept variable argNodes. ArgNodes in number of nodes which user
give and it will equal to nodes in datafield. In next line  adjlist = new ArrayList<>(nodes) adjList will equal to arraylist. In for loop i will check all nodes,
and will add new arraylists. After that visited array initialized
 
 Graph and tree which used:
 
![???????????? ???????????? (105)](https://user-images.githubusercontent.com/78644880/111902651-b0a88c80-8a68-11eb-8e98-f4d37b75ea12.png)
![???????????? ???????????? (106)](https://user-images.githubusercontent.com/78644880/111902656-b3a37d00-8a68-11eb-9781-3c1072fff141.png)

  
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
 
 #When we use DFS?                                                                                                                                                         
 We use DFS algorithm in next cases:                                                                                                                                       
 1)Detecting cycle in a graph 
A graph has cycle if and only if we see a back edge during DFS. So we can run DFS for the graph and check for back edges.
For every visited vertex 'V' if there is an adjacent 'u' such that u is already visited and u is not parent of v,  then there is a cycle in graph
2)Path finding
We can specialize the DFS algorithm to find a path between two given vertices u and z.
i) Call DFS(G, u) with u as the start vertex.
ii) Use a stack S to keep track of the path between the start vertex and the current vertex.
iii) As soon as destination vertex z is encountered, return the path as the
contents of the stack
 3)Topological Sorting 
 Topological Sorting is mainly used for scheduling jobs from the given
dependencies among jobs. In computer science, applications of this type
arise in instruction scheduling, ordering of formula cell evaluation when
recomputing formula values in spreadsheets, logic synthesis, determining
the order of compilation tasks to perform in makefiles, data serialization,
and resolving symbol dependencies in linkers
4)To test if a graph is
bipartite or not
We can augment either BFS or DFS when we first discover a new vertex,
color it opposited its parents, and for each other edge, check it doesn???t link
two vertices of the same color. The first vertex in any connected
component can be red or black!
Method:
Use a two coloring scheme, start with a vertex and give it a color
Run DFS from this vertex
-For each new vertex, color it opposite its parent
-Check for edges that it does not link two vertices of the same color.
5)Finding Strongly
Connected
Components of a
graph
A directed graph is strongly connected if there is a path between all pairs
of vertices. A strongly connected component (SCC) of a directed graph is a
maximal strongly connected graph. 
Kosaraju's algorithm uses 2 passes of dfs
Tarjan's algorithm: uses a single pass of dfs
6)Solving puzzles problem:
maze related problems, obstacles in a matrix.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


#Explanation to maze.                                                
In the DFS slide, we gave examples of where we can use DFS in real life. One of them was a maze game. So we decided to write a code for this, and opened the maze folder, if we open that folder we will see the .java classes(DFS, Game, Map, MyPlayer, Player, Position) and Map5.txt file. So let me explain how it works. To create a maze we need a map and player, with help of DFS we will find the path between the start point and endpoint. This MyPlayer, Player .java class is for the ball, that will move on this maze, Position class is to get ball position. The main class is Game class where we will get a text file and send it to the Map class and control other classes.  In-text file written matrix with values 0 and 1, 0 the wall cells, 1 is opened cell where the ball can move and by the help of this matrix we will creat maze, but before creating maze we will take all of the cells with value as a vertex, and took the top, bottom, right, left cells values to connect these vertexes. And DFS class we have the addVertex method where we will add connected vertexes. And in the end, we will get adjMatrix where we can see vertex neighbors. And by using this matrix, start and endpoints, and algorithm of DFS  we will find a path between two points on the pathDFS method. When stack will pop vertexes we will add these values to our ArrayList and it will be cells that we visited in the DFS, and after all this, we create the maze map where walls will black color, violet open cells color, grey DFS visited cells, yellow it is a start and end position. Also in DFS class we have shortDFS method it works recursively, here we will add the start vertex and add this for the stack and then add the first connected vertex to the stack in the matrix and again add the next connected vertex last added vertex it will works until next vertex will be an end point, but when there is do not have any connected vertex of last added vertex and it is not endpoint then the stack will pop this vertex. So in the end we will get stack with a path between start and endpoint but it is not a short path. So in this way our maze works.
