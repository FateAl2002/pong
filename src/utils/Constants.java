package utils;

public final class Constants {
    private Constants() {
        // prevents instantiation
    }

    public static final int BOARD_WIDTH = 640;
    public static final int BOARD_HEIGHT = 640;
    // A delay of 25 milliseconds results in a frame rate of 45 FPS.
    public static final int TICK_DELAY = 25;

    public static final String WALL_IMAGE_PATH = "resources/wall.png";
    public static final int WALL_WIDTH = 640;
    public static final int WALL_HEIGHT = 80;

    public static final String BALL_IMAGE_PATH = "resources/ball.png";
    public static final int BALL_WIDTH = 80;
    public static final int BALL_HEIGHT = 80;
    public static final int BALL_SPEED = 1;

    public static final String PADDLE_IMAGE_PATH = "resources/paddle1.png";
    public static final int PADDLE_WIDTH = 80;
    public static final int PADDLE_HEIGHT = 160;
    public static final int PADDLE_SPEED = 2;
}
