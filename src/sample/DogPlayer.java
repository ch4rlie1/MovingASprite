package sample;

import javafx.scene.input.KeyCode;

/**
 * This class contains the location of the image in the directory, and the positions of the image on the scene
 * and the image size. It also contains the scene width and height.
 * @author Charlie Cox
 * @version
 */
public class DogPlayer {
    private String location = "/Dog.jpg";
    private int xPos;
    private int yPos;
    private int sceneWidth;
    private int sceneHeight;
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
     * Updates the position points of the player.
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
        }
    }

    /**
     * Updates the y position so the player moves up the screen but does not leave the screen.
     */
    private void moveUp() {
        if (this.yPos-1<0) {
            return;
        } else {
            this.yPos--;
            System.out.println(yPos);
        }
    }

    /**
     * Updates the y position so the player moves down the screen but does not leave the screen.
     */
    private void moveDown() {
        if (this.yPos+1+PICTURESIZE>this.sceneHeight) {
            return;
        } else {
            this.yPos++;
            System.out.println(yPos);
        }
    }

    /**
     * Updates the x position so the player moves left along the screen but does not leave the screen.
     */
    private void moveLeft() {
        if(this.xPos-1<0) {
            return;
        } else {
            this.xPos--;
            System.out.println(xPos);
        }
    }

    /**
     * Updates the x position so the player moves right along the screen but does not leave the screen.
     */
    private void moveRight() {
        if(this.xPos+1+PICTURESIZE>this.sceneWidth) {
            return;
        } else {
            this.xPos++;
            System.out.println(xPos);
        }
    }
}
