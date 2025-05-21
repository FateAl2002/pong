import java.awt.*;

import static utils.Constants.BALL_WIDTH;

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
        updateScore(ball);
    }

    public void displayScore(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.setColor(Color.RED);
        g.drawString("Player 1 Score: " + Player1Score, 0, 30);
        g.drawString("Player 2 Score: " + Player2Score, 400, 30);
    }

}
