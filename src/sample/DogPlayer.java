package sample;

import javafx.scene.input.KeyCode;

public class DogPlayer {
    private String location = "/Dog.jpg";
    private int xPos;
    private int yPos;
    private int sceneWidth;
    private int sceneHeight;
    private static final int PICTURESIZE = 30;


    public DogPlayer(int sceneWidth, int sceneHeight) {
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;

        this.xPos = (sceneWidth/2)-(PICTURESIZE /2);
        this.yPos = (sceneHeight/2)-(PICTURESIZE /2);
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public String getLocation() {
        return location;
    }

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
