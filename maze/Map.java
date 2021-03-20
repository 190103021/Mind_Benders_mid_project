package sample;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Stack;

public class Map extends Pane {//create place where we will play
    private int UNIT;// size of one cell
    private int size;//size of row and column
    private int[][] map;//array for 1 and 0,we will use this for creating walls
    public int start_r;
    public int start_c;
    public int[][] vertex;//vertex index
    public int count = 1;
    public int start_num;
    public int end_num;
    private Position start;// it is balls start position
    public GridPane grid;
    private DFS path;
    public ArrayList<Integer> path_way;
    public Map(String a,int s,int e){//takes string and get size,map arrays element ,create lines and walls
        this.start_num = s+1;
        this.end_num = e+1;
        size =Character.getNumericValue(a.charAt(0));
        a=a.substring(1);
        vertex = new int[size][size];
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = Character.getNumericValue(a.charAt(0));
                if(map[i][j] == 1 || map[i][j] == 2 ){
                    vertex[i][j] = count;
                    count++;
                }else{
                    vertex[i][j] = 0;
                }
                a=a.substring(1);
            } }
        this.path = new DFS(count-1);
        for (int i = 0;i<vertex[0].length;i++){
            for (int j = 0;j<vertex[0].length;j++){
                int n = vertex[0].length-1;
                if(vertex[i][j] != 0){
                    if(i == 0 && j == 0){
                        addN(i,j+1,vertex[i][j]);
                        addN(i+1,j,vertex[i][j]);
                    } if(0<j && j<n){
                        if(i==0){
                            addN(i,j+1,vertex[i][j]);
                            addN(i,j-1,vertex[i][j]);
                            addN(i+1,j,vertex[i][j]);
                        }if(i == n){
                            addN(i,j+1,vertex[i][j]);
                            addN(i,j-1,vertex[i][j]);
                            addN(i-1,j,vertex[i][j]);
                        }
                    } if(i == 0 && j == n){
                        addN(i,j-1,vertex[i][j]);
                        addN(i+1,j,vertex[i][j]);
                    } if(0<i && i<n){

                        if(j==0){
                            addN(i-1,j,vertex[i][j]);
                            addN(i+1,j,vertex[i][j]);
                            addN(i,j+1,vertex[i][j]);
                        }if(j == n){
                            addN(i-1,j,vertex[i][j]);
                            addN(i+1,j,vertex[i][j]);
                            addN(i,j-1,vertex[i][j]);
                        }
                    } if(j == 0 && i == n ){
                        addN(i,j+1,vertex[i][j]);
                        addN(i-1,j,vertex[i][j]);
                    } if(i == n && j == n){
                        addN(i,j-1,vertex[i][j]);
                        addN(i-1,j,vertex[i][j]);
                    }if(0<j && j<n&&0<i && i<n){
                        addN(i,j+1,vertex[i][j]);
                        addN(i,j-1,vertex[i][j]);
                        addN(i-1,j,vertex[i][j]);
                        addN(i+1,j,vertex[i][j]);
                    }
                }
            }
        }
        System.out.println("Short: ");
        ArrayList<Integer> n;
        Stack<Integer> stack1 = new Stack<>();
        boolean[] visited1 = new boolean[count-1];

        System.out.println( path.shortDFS(start_num-1,end_num-1,visited1,stack1,false));
       // path.pathDFS(start_num-1,end_num-1);
        int[] ind = getIndex(start_num);
        start_r = ind[0];
        start_c = ind[1];
        System.out.println();
        for(int i = 0; i<vertex[0].length;i++){
            for(int j = 0; j<vertex[0].length;j++){
                if(vertex[i][j] < 10)
                System.out.print(vertex[i][j] + "  ");
                if(vertex[i][j] >= 10)
                    System.out.print(vertex[i][j] + " ");

            }
            System.out.println();
        }
        path_way = path.wey_path;
        System.out.println("After dfs:");
        System.out.println(path.wey_path);
        this.UNIT=40;
        grid= new GridPane();
        for(int i = 0; i < size; i++) {
            ColumnConstraints column = new ColumnConstraints(40);
            grid.getColumnConstraints().add(column); }
        for(int i = 0; i < size; i++) {
            RowConstraints row = new RowConstraints(40);
            grid.getRowConstraints().add(row); }
        grid.setStyle("-fx-background-color: DARKVIOLET; -fx-grid-lines-visible: true");
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {

                if(map[r][c] == 0) {
                 Rectangle rec = new Rectangle();
                    rec.setWidth(40);
                    rec.setHeight(40);
                    rec.setFill(Color.BLACK);
                    GridPane.setRowIndex(rec, r);
                    GridPane.setColumnIndex(rec, c);
                    grid.getChildren().addAll(rec);
                } if(path_way.contains(vertex[r][c]-1) && vertex[r][c] != start_num && vertex[r][c]!=end_num){

                    Rectangle rec = new Rectangle();
                    rec.setWidth(40);
                    rec.setHeight(40);
                    rec.setFill(Color.GREY);
                    GridPane.setRowIndex(rec, r);
                    GridPane.setColumnIndex(rec, c);
                    grid.getChildren().addAll(rec);

                }
                if (vertex[r][c] == start_num || vertex[r][c]==end_num){
                    Rectangle rec = new Rectangle();
                    rec.setWidth(40);
                    rec.setHeight(40);
                    rec.setFill(Color.YELLOW);
                    GridPane.setRowIndex(rec, r);
                    GridPane.setColumnIndex(rec, c);
                    grid.getChildren().addAll(rec);
                }
            } }
        this.getChildren().addAll(grid);
       /* System.out.println("Short: ");
        path.shortDFS(start_num-1,end_num-1);*/
    }
    public int getUnit(){
        return UNIT;
    }
    public int getSize() {
        return size;
    }
    public int getValue(int r,int c){
        int result;
        if (map[r][c] == 1) { result = 1; }
        else if(map[r][c] == 2){ result = 2;}
        else{ result=0;}
        return result;
    }
    public Position getStartPosition(){
        start=new Position(start_c,start_r);
        return start;
    }
    public int[] getIndex(int num){
        int[] a = new int[2];
        for (int i = 0; i < vertex[0].length; i++) {
            for (int j = 0; j < vertex[0].length; j++) {

                if (vertex[i][j] == num) {
                   a[0] = i;
                   a[1] = j;
                }
            }
        }
        return a;
    }
    public void addN(int i,int j, int n){
        if(vertex[i][j] != 0){
            path.addVertex(n-1,vertex[i][j]-1);
        }
    }

}
