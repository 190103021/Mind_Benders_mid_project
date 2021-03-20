package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Game extends Application {

    public  int start;
    public int end;
    private Map map;
    private Player player;

    public void start(Stage stage){
        Scanner input = new Scanner(System.in);
        String st = "Map5.txt";
        String a ="";
        try{
            Scanner br = new Scanner(new FileReader(st)); String s;
            while (br.hasNextLine()){
                s=br.next();a+=s; } }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
            System.exit(0);

        }
        System.out.print("Enter start number (0-17): ");
        this.start = input.nextInt();
        System.out.print("Enter goal number (0-17): ");
        this.end = input.nextInt();
        map = new Map(a,start,end);




        player = new MyPlayer(map);
        player.getBall();
            Scene scene = new Scene(map, map.getSize()*map.getUnit(),map.getSize()*map.getUnit() );
            stage.setTitle("GaMe");
            stage.setScene(scene);
        ArrayList<Integer> arr = map.path_way;

            scene.setOnKeyPressed(e -> {
                switch (e.getCode()) {
                    case DOWN: player.moveDown();break;
                    case UP:player. moveUp();break;
                    case LEFT: player.moveLeft();break;
                    case RIGHT: player.moveRight();break;
                    default: }

            });
            arr.remove(0);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
