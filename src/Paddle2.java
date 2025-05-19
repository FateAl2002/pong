import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Set;
import static utils.Constants.*;
import static utils.Constants.BALL_SPEED;

public class Paddle2 extends Sprite {
    private int upKey;
    private int downKey;

    public Paddle2() {
        super(PADDLE2_IMAGE_PATH, BOARD_WIDTH - PADDLE2_WIDTH, BOARD_HEIGHT / 2 - PADDLE2_HEIGHT / 2, PADDLE2_WIDTH, PADDLE2_HEIGHT);
        resetPaddle2();
    }

    private void resetPaddle2() {
        pos.x =  BOARD_WIDTH - PADDLE2_WIDTH;
        pos.y = BOARD_HEIGHT / 2 - PADDLE2_HEIGHT / 2;
    }

    @Override
    public void tick() {
        pos.translate((int)pos.x, (int)pos.y);

        pos.y = Math.clamp(pos.y, 0, BOARD_HEIGHT - PADDLE2_HEIGHT);

    }

    public void handleActiveKeys(Set<Integer> activeKeyCodes) {
        pos.x = 0;
        pos.y = 0;

        if (activeKeyCodes.contains(KeyEvent.VK_UP)) {
            pos.y -= PADDLE2_SPEED;
        }
        if (activeKeyCodes.contains(KeyEvent.VK_DOWN)) {
            pos.y += PADDLE2_SPEED;
        }
    }
}
