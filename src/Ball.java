import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Set;
import java.util.random.RandomGenerator;

import static utils.Constants.*;

public class Ball extends Sprite {
    private double vx;
    private double vy;
    private Random random;

    public Ball() {
        super(BALL_IMAGE_PATH, 80, 560, BALL_WIDTH, BALL_HEIGHT);
        resetBall();
    }

    public void resetBall() {
        pos.x =  BOARD_WIDTH / 2 - BALL_WIDTH / 2;
        pos.y = BOARD_HEIGHT / 2 - BALL_HEIGHT / 2;

        vx = BALL_SPEED;
        vy = BALL_SPEED;
        Random random = new Random();
        int randNum = random.nextInt(4);
        if (randNum == 0) {
            vx = BALL_SPEED;
            vy = -BALL_SPEED;
        } else if (randNum == 1) {
            vx = BALL_SPEED;
            vy = BALL_SPEED;
        } else if (randNum == 2) {
            vx = -BALL_SPEED;
            vy = BALL_SPEED;
        } else {
            vx = -BALL_SPEED;
            vy = -BALL_SPEED;
        }

    }

    @Override
    public void tick() {
        pos.translate((int)vx, (int)vy);

        if (pos.y <= 80 || pos.y >= 560 - BALL_HEIGHT) {
            vy = -vy;
        }
    }

    public void bounceRight() {
        vx = Math.abs(vx) * 1.1;
    }

    public void bounceLeft() {
        vx = -Math.abs(vx) * 1.1;
    }
}
