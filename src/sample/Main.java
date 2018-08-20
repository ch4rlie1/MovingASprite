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

/**
 * This class moves the image as per user key presses. To move the sprite, use WASD or arrow keys.
 * To sprint (move faster) hold the shift key, and release to stop sprinting.
 * @author Charlie Cox
 * @version 20/08/2018
 */
public class Main extends Application {
    private int width=500;//width and height of the scene
    private int height=500;
    private ImageView imageView;
    private DogPlayer dog;

    /**
     * Start method which loads in the image, ensures the size of the image is correct,
     * puts the image in the centre of the scene to begin and handles the key press events.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
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
        drawPlayer();

        //group to put the player image into
        Group playArea = new Group(imageView);

        //putting everything onto the scene
        Scene scene = new Scene(playArea, width, height, Color.GREEN);

        //defining button actions when pressed and released
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                dog.move(event.getCode());//updates the positions of where dogplayer should be
                drawPlayer();
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                dog.stopMove(event.getCode());
                drawPlayer();
            }
        });

        //displaying the stage
        primaryStage.setTitle("Movement Test using Scene");
        primaryStage.setScene(scene);
        primaryStage.show();

        //timer
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (dog.up)
                    dog.updateUp();

                if (dog.down)
                    dog.updateDown();

                if (dog.left)
                    dog.updateLeft();

                if (dog.right)
                    dog.updateRight();

                drawPlayer();
            }
        };
        timer.start();
    }

    /**
     * Moves the image using x and y positions associated with the dogPlayer object.
     */
    public void drawPlayer() {
        imageView.relocate(dog.getxPos(), dog.getyPos());
    }

    /**
     * Main method to launch the program.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
