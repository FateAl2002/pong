import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Set;
import java.util.random.RandomGenerator;

import static utils.Constants.*;

public class Ball extends Sprite {
    private double vx;
    private double vy;
    private Random random = new Random();

    public Ball() {
        super(BALL_IMAGE_PATH, 0, 0, BALL_WIDTH, BALL_HEIGHT);
        resetBall();
    }

    private void resetBall() {
        pos.x =  BOARD_WIDTH / 2 - BALL_WIDTH / 2;
        pos.y = BOARD_HEIGHT / 2 - BALL_HEIGHT / 2;

        vx = BALL_SPEED;
        vy = BALL_SPEED;
        Random random1 = random;


    }

    @Override
    public void tick() {
        pos.translate((int)vx, (int)vy);

        pos.x = Math.clamp(pos.x, 0, BOARD_WIDTH - BALL_WIDTH);

        if (pos.y <= 0 || pos.y >= BOARD_HEIGHT - BALL_HEIGHT) {
            vy = -vy;
        }
    }

    public void bounceRight() {
        vx = Math.abs(vx) * 1.1;
    }

    public void bounceLeft() {
        vy = Math.abs(vy) * 1.1;
    }
}
