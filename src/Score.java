import java.awt.*;

import static utils.Constants.*;
import static utils.Constants.BALL_HEIGHT;

public class Score {
    private int Player1Score;
    private int Player2Score;
    private final int BoardWidth;

    public Score(int boardWidth) {
        this.BoardWidth = boardWidth;
    }

    public int getPlayer1Score() {
        return Player1Score;
    }
    public int getPlayer2Score() {
        return Player2Score;
    }

    public void updateScore(Ball ball) {
        Player1Score = 0;
        Player2Score = 0;
        if (ball.getPos().x <= 0) {
            Player1Score++;
            ball.resetBall();
        } else if (ball.getPos().x >= BoardWidth - BALL_WIDTH) {
            Player2Score++;
            ball.resetBall();
        }
    }

    public void displayScore(Graphics graphics) {
        graphics.setFont(new Font("Arial", Font.BOLD, 25));
        graphics.setColor(Color.RED);
        graphics.drawString("Player 1 Score: " + Player1Score, 0, 30);
        graphics.drawString("Player 2 Score: " + Player2Score, 400, 30);

        if (Player1Score == 11) {
            graphics.drawString("Player 1 won", 320, 240);
        } else if (Player2Score == 11) {
            graphics.drawString("Player 2 won", 320, 240);
        }
    }

}
