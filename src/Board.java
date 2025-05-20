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
    private final Paddle2 paddle2;
    private final Paddle1 paddle1;
    private final List<Sprite> sprites;
    private final Set<Integer> activeKeyCodes;

    public Board() {
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.GRAY);

        ball = new Ball();
        paddle1 = new Paddle1();
        paddle2 = new Paddle2();
        sprites = new ArrayList<>(List.of(ball, paddle1, paddle2));

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


        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        for(Sprite sprite : sprites) {
            sprite.draw(graphics, this);
        }

        graphics.setFont(new Font("Arial", Font.PLAIN, 42));
        graphics.setColor(Color.RED);
        graphics.drawString("Hello world!", 20, 100);
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
