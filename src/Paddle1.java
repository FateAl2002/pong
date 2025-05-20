import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Set;
import static utils.Constants.*;
import static utils.Constants.BALL_SPEED;

public class Paddle1 extends Sprite {
    private int wKey;
    private int sKey;

    public Paddle1() {
        super(PADDLE1_IMAGE_PATH, PADDLE1_WIDTH, BOARD_HEIGHT / 2 - PADDLE1_HEIGHT / 2, PADDLE1_WIDTH, PADDLE1_HEIGHT);
        resetPaddle1();
    }

    private void resetPaddle1() {
        pos.x = PADDLE1_WIDTH;
        pos.y = BOARD_HEIGHT / 2 - PADDLE1_HEIGHT / 2;
    }

    @Override
    public void tick() {
        pos.translate((int)pos.x, (int)pos.y);

        pos.y = Math.clamp(pos.y, 0, BOARD_HEIGHT - PADDLE1_HEIGHT);

    }

    public void handleActiveKeys(Set<Integer> activeKeyCodes) {
        pos.x = 0;
        pos.y = 0;

        if (activeKeyCodes.contains(KeyEvent.VK_W)) {
            pos.y -= PADDLE1_SPEED;
        }
        if (activeKeyCodes.contains(KeyEvent.VK_S)) {
            pos.y += PADDLE1_SPEED;
        }
    }
}
