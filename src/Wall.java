import static utils.Constants.*;

public class Wall extends Sprite {
    private double vy;

    public Wall(int x, int y) {
        super(WALL_IMAGE_PATH, x, y, WALL_WIDTH, WALL_HEIGHT);
    }

    public void bounceUpOrDown(Ball ball, Sprite wall2, Sprite wall1) {
        if (ball.isColliding(wall2) || ball.isColliding(wall1)) {
            vy = -vy;
        }
    }

    @Override
    public void tick() {
    }

}
