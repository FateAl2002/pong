import java.awt.event.KeyEvent;
import java.util.Set;
import static utils.Constants.*;

public class Paddle extends Sprite {
    private final int upKey;
    private final int downKey;

    public Paddle(int xPos, int upKey, int downKey) {
        super(PADDLE_IMAGE_PATH, xPos, 0, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.upKey = upKey;
        this.downKey = downKey;

        resetPaddle();
    }

    private void resetPaddle() {
        pos.y = BOARD_HEIGHT / 2 - PADDLE_HEIGHT / 2;
    }

    @Override
    public void tick() {
        pos.y = Math.clamp(pos.y, 0, BOARD_HEIGHT - PADDLE_HEIGHT);

    }

    public void handleActiveKeys(Set<Integer> activeKeyCodes) {
        if (activeKeyCodes.contains(upKey)) {
            pos.y -= PADDLE_SPEED;
        }
        if (activeKeyCodes.contains(downKey)) {
            pos.y += PADDLE_SPEED;
        }
    }
}
