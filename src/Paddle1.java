import java.awt.event.KeyEvent;

import static utils.Constants.PLAYER_SPEED;

public class Paddle1 extends Sprite {
    private int upKey;
    private int downKey;

    public Paddle1(int upKey, int downKey, int xpos) {
        super(Paddle1_IMAGE_PATH, 0, 0, Paddle1_WIDTH, Paddle1_HEIGHT);
    }
}
