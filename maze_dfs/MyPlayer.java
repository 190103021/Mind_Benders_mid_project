package sample;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyPlayer implements  Player{
    private Circle ball;
    private Map map;
    private Position position;

    public MyPlayer(Map map){
        this.map=map;
        int n = map.getUnit()/2;
        ball = new Circle();
        ball.setRadius(n);
        ball.setFill(Color.WHITE);
        double x = ((map.getStartPosition()).getX()*map.getUnit())+n;
        double y = ((map.getStartPosition()).getY()*map.getUnit())+n;
        ball.setCenterX(x);
        ball.setCenterY(y);
    }


    public void getBall(){
        map.getChildren().add(ball);
    }
    @Override
    public void moveRight() {
        try{
            int u = map.getUnit();
            int c = (int)(ball.getCenterX()+u)/u;
            int r = (int) ball.getCenterY()/u;
            int n = this.map.getValue( r,c);
            if(c<map.getSize() && r<map.getSize() && n!=0) {
                ball.setCenterX(ball.getCenterX() + u);
            }
            else{System.out.println("");}
        } catch(Exception e) {
            System.out.println("Invalid position!");
        } }


    @Override
    public void moveLeft() {
        try {
            int u = map.getUnit();
            int c = (int)(ball.getCenterX()-u)/u;
            int r = (int) ball.getCenterY()/u;
            int n = this.map.getValue( r,c);
            if(c<map.getSize() && n!=0 && 0<=c &&  0<(ball.getCenterX()-u)/u ) {
                ball.setCenterX(ball.getCenterX() - u);
               }
            else {
                System.out.println("");
            } } catch(Exception e) {
            System.out.println("Invalid position!");
        } }

    @Override
    public void moveUp() {
        try {
            int u = map.getUnit();
            int r = (int)(ball.getCenterY()-u)/u;
            int c = (int) ball.getCenterX()/u;
            int n = this.map.getValue(r, c);
            if(r< map.getSize() && n!=0 && 0<=r && 0<(ball.getCenterY()-u)/u) {
                ball.setCenterY(ball.getCenterY() - u);
               }
            else{ System.out.println("");}
        } catch(Exception e) {
            System.out.println("Invalid position!");
        } }

    @Override
    public void moveDown() {
        try {
            int u = map.getUnit();
            int r = (int)(ball.getCenterY()+u)/u;
            int c = (int) ball.getCenterX()/u;
            int n = this.map.getValue( r,c);
            if(c< map.getSize() && r< map.getSize() && n!=0) {
                ball.setCenterY(ball.getCenterY() + u);
            }
            else{System.out.println("");}
        } catch(Exception e) {
            System.out.println("Invalid position!");
        } }

    public Position getPosition() {
        int n = map.getUnit()/2;
        position = new Position((int)((ball.getCenterX()+n)/map.getUnit())-1,(int)((ball.getCenterY()+n)/map.getUnit())-1);
        return position;
    }}
