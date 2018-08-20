package sample;

import javafx.scene.input.KeyCode;

import java.security.Key;

/**
 * This class contains the location of the image in the directory, and the positions of the image on the scene
 * and the image size. It also contains the scene width and height.
 * @author Charlie Cox
 * @version 20/08/2018
 */
public class DogPlayer {
    private String location = "/Dog.jpg";
    private int xPos;
    private int yPos;
    private int sceneWidth;
    private int sceneHeight;
    boolean up, down, left, right, sprint;
    private static final int PICTURESIZE = 30;


    /**
     * Constructor
     * @param sceneWidth width of the scene
     * @param sceneHeight height of the scene
     */
    public DogPlayer(int sceneWidth, int sceneHeight) {
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;

        this.xPos = (sceneWidth/2)-(PICTURESIZE /2);
        this.yPos = (sceneHeight/2)-(PICTURESIZE /2);
    }

    /**
     * Getter for position of the x (top left of image)
     * @return xPos
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * Getter for position of the y (top left of image)
     * @return yPos
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * Getter for the location of the image to be displayed.
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Getter for the size of the player/image
     * @return PICTURESIZE
     */
    public static int getPICTURESIZE() {
        return PICTURESIZE;
    }

    /**
     * Updates the appropriate boolean variable to true accordingly.
     * @param code The key that has been pressed by the user
     */
    public void move(KeyCode code) {
        System.out.println(code);
        switch (code) {
            case UP: {
                moveUp();
                break;
            }
            case W: {
                moveUp();
                break;
            }
            case DOWN: {
                moveDown();
                break;
            }
            case S: {
                moveDown();
                break;
            }
            case LEFT: {
                moveLeft();
                break;
            }
            case A: {
                moveLeft();
                break;
            }
            case RIGHT: {
                moveRight();
                break;
            }
            case D: {
                moveRight();
                break;
            }
            case SHIFT: {
                moveSprint();
                break;
            }
        }
    }

    /**
     * Updates the appropriate boolean variable to false accordingly.
     * @param code The key that has been pressed by the user
     */
    public void stopMove(KeyCode code) {
        System.out.println(code + " release");
        switch (code) {
            case UP: {
                stopUp();
                break;
            }
            case W: {
                stopUp();
                break;
            }
            case DOWN: {
                stopDown();
                break;
            }
            case S: {
                stopDown();
                break;
            }
            case LEFT: {
                stopLeft();
                break;
            }
            case A: {
                stopLeft();
                break;
            }
            case RIGHT: {
                stopRight();
                break;
            }
            case D: {
                stopRight();
                break;
            }
            case SHIFT: {
                stopSprint();
                break;
            }
        }
    }

    /**
     * Updates the up variable to true
     */
    private void moveUp() {
        this.up = true;
    }

    /**
     * Updates the down variable to true
     */
    private void moveDown() {
        this.down = true;
    }

    /**
     * Updates the left variable to true
     */
    private void moveLeft() {
        this.left = true;
    }

    /**
     * Updates the right variable to true
     */
    private void moveRight() {
        this.right = true;
    }

    /**
     * Updates the sprint variable to true
     */
    private void moveSprint() {
        this.sprint = true;
    }

    /**
     * Updates the up variable to false
     */
    private void stopUp() {
        this.up = false;
    }

    /**
     * Updates the down variable to false
     */
    private void stopDown() {
        this.down = false;
    }

    /**
     * Updates the left variable to false
     */
    private void stopLeft() {
        this.left = false;
    }

    /**
     * Updates the right variable to false
     */
    private void stopRight() {
        this.right = false;
    }

    /**
     * Updates the sprint variable to false
     */
    private void stopSprint() {
        this.sprint = false;
    }

    /**
     * Updates the y position so the player moves up the screen but does not leave the screen.
     */
    public void updateUp() {
        int speed = 1;
        if(sprint) {
            speed++;
        }

        //checks whether it is at the end of the screen or not
        if (this.yPos - speed < 0) {
            return;
        } else {
            this.yPos-=speed;
            System.out.println(yPos);
        }
    }

    /**
     * Updates the y position so the player moves down the screen but does not leave the screen.
     */
    public void updateDown() {
        int speed = 1;
        if(sprint) {
            speed++;
        }

        if (this.yPos + speed + PICTURESIZE > this.sceneHeight) {
            return;
        } else {
            this.yPos+=speed;
            System.out.println(yPos);
        }
    }

    /**
     * Updates the x position so the player moves left along the screen but does not leave the screen.
     */
    public void updateLeft() {
        int speed = 1;
        if(sprint) {
            speed++;
        }

        if(this.xPos-speed<0) {
            return;
        } else {
            this.xPos-=speed;
            System.out.println(xPos);
        }
    }

    /**
     * Updates the x position so the player moves right along the screen but does not leave the screen.
     */
    public void updateRight() {
        int speed = 1;
        if(sprint) {
            speed++;
        }

        if(this.xPos+speed+PICTURESIZE>this.sceneWidth) {
            return;
        } else {
            this.xPos+=speed;
            System.out.println(xPos);
        }
    }
}
