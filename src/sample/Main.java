package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private int width=500;//width and height of the scene
    private int height=500;
    private ImageView imageView;
    private DogPlayer dog;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //creating the player object
        dog = new DogPlayer(width, height);

        //using the dog object to load an image into an imageview and ensuring it is the correct size.
        Image dogImage = new Image(getClass().getResource(dog.getLocation()).toExternalForm());
        imageView = new ImageView(dogImage);
        imageView.setPreserveRatio(false);
        imageView.setFitWidth(dog.getPICTURESIZE());
        imageView.setFitHeight(dog.getPICTURESIZE());
        imageView.setCache(true);//to improve performance

        //putting the dog in the starting position (centre of the scene)
        //imageView.relocate(dog.getxPos(), dog.getyPos());
        drawPlayer();

        //group to put the player image into
        Group playArea = new Group(imageView);

        //putting everything onto the scene
        Scene scene = new Scene(playArea, width, height, Color.GREEN);

        //defining button actions
        scene.setOnMouseClicked(e -> System.out.println("mouse click"));
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                dog.move(event.getCode());//updates the positions of where dogplayer should be
                drawPlayer();
            }
        });

        primaryStage.setTitle("Movement Test using Scene");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Timer
       // AnimationTimer timer = new AnimationTimer() {
            //@Override
            //public void handle(long now) {

                //drawPlayer();//actually moves the image
            //}
       // };
        //timer.start();
    }

    public void drawPlayer() {
        imageView.relocate(dog.getxPos(), dog.getyPos());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
