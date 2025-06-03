import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.Constants.*;

public class Board extends JPanel implements ActionListener, KeyListener {

    private final Ball ball;
    private final Paddle paddle1;
    private final Paddle paddle2;
    private final Wall wall1;
    private final Wall wall2;
    private final Score score;
    private int rallyCounter;
    private final List<Sprite> sprites;
    private final Set<Integer> activeKeyCodes;

    public Board() {
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.LIGHT_GRAY);

        rallyCounter = 0;
        ball = new Ball();
        paddle1 = new Paddle(0, KeyEvent.VK_W, KeyEvent.VK_S);
        paddle2 = new Paddle(BOARD_WIDTH - PADDLE_WIDTH, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        wall1 = new Wall(0, 0);
        wall2 = new Wall(0, BOARD_HEIGHT - WALL_HEIGHT);
        score = new Score(BOARD_WIDTH);
        sprites = new ArrayList<>(List.of(ball, paddle1, paddle2, wall1, wall2));

        activeKeyCodes = new HashSet<>();

        new Timer(TICK_DELAY, this).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paddle1.handleActiveKeys(activeKeyCodes);
        paddle2.handleActiveKeys(activeKeyCodes);

        for(Sprite sprite : sprites) {
            sprite.tick();
        }

        if (ball.isColliding(paddle1)) {
            ball.bounceRight();
        } else if (ball.isColliding(paddle2)) {
            ball.bounceLeft();
        }

        if (ball.isColliding(paddle1) || ball.isColliding(paddle2) || ball.isColliding(wall1) || ball.isColliding(wall2)) {
            rallyCounter = rallyCounter + 1;
        }

        score.updateScore(ball);

        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        graphics.setFont(new Font("Arial", Font.BOLD, 25));
        graphics.setColor(Color.RED);

        for(Sprite sprite : sprites) {
            sprite.draw(graphics, this);
        }

        graphics.drawString("Rally: " + rallyCounter, 250, 30);
        score.displayScore(graphics);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        // Unused
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        activeKeyCodes.add(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        activeKeyCodes.remove(keyEvent.getKeyCode());
    }
}
