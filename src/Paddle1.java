import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Set;
import static utils.Constants.*;
import static utils.Constants.BALL_SPEED;

public class Paddle1 extends Sprite {
    private int upKey;
    private int downKey;

    public Paddle1() {
        super(PADDLE1_IMAGE_PATH, 640, PADDLE1_WIDTH / 2, PADDLE1_WIDTH, PADDLE1_HEIGHT);

    }

    @Override
    public void tick() {
        pos.translate((int)pos.x, (int)pos.y);

        pos.y = Math.clamp(pos.y, 0, BOARD_HEIGHT - PADDLE1_HEIGHT);

    }

    public void handleActiveKeys(Set<Integer> activeKeyCodes) {
        pos.x = 0;
        pos.y = 0;

        if (activeKeyCodes.contains(KeyEvent.VK_UP)) {
            pos.y -= PADDLE1_SPEED;
        }
        if (activeKeyCodes.contains(KeyEvent.VK_DOWN)) {
            pos.y += PADDLE1_SPEED;
        }
    }
}
