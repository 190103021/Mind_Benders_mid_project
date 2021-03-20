package sample;

public class Position {//balls and food positions
    private int x ;
    private int y ;
    public Position(int x,int y){// here get index of ball or food
        this.x=x;
        this.y=y; }
    public int getX(){
        return x;
    }//return x position
    public int getY(){
        return y;
    }//return y position
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public boolean equals(Position o){//compare ball and food position
        boolean n =false;
        if(x==o.getX() && y==o.getY()){
            n=true;
        }
        return n;
    }
}
