# Mind_Benders_mid_project
#Explanation to maze.                                                
In the DFS slide, we gave examples of where we can use DFS in real life. One of them was a maze game. So we decided to write a code for this, and opened the maze folder, if we open that folder we will see the .java classes(DFS, Game, Map, MyPlayer, Player, Position) and Map5.txt file. So let me explain how it works. To create a maze we need a map and player, with help of DFS we will find the path between the start point and endpoint. This MyPlayer, Player .java class is for the ball, that will move on this maze, Position class is to get ball position. The main class is Game class where we will get a text file and send it to the Map class and control other classes.  In-text file written matrix with values 0 and 1, 0 the wall cells, 1 is opened cell where the ball can move and by the help of this matrix we will creat maze, but before creating maze we will take all of the cells with value as a vertex, and took the top, bottom, right, left cells values to connect these vertexes. And DFS class we have the addVertex method where we will add connected vertexes. And in the end, we will get adjMatrix where we can see vertex neighbors. And by using this matrix, start and endpoints, and algorithm of DFS  we will find a path between two points on the pathDFS method. When stack will pop vertexes we will add these values to our ArrayList and it will be cells that we visited in the DFS, and after all this, we create the maze map where walls will black color, violet open cells color, grey DFS visited cells, yellow it is a start and end position. Also in DFS class we have shortDFS method it works recursively, here we will add the start vertex and add this for the stack and then add the first connected vertex to the stack in the matrix and again add the next connected vertex last added vertex it will works until next vertex will be an end point, but when there is do not have any connected vertex of last added vertex and it is not endpoint then the stack will pop this vertex. So in the end we will get stack with a path between start and endpoint but it is not a short path. So in this way our maze works.
