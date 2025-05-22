import java.awt.*;

import static utils.Constants.*;

public class Score {
    private int player1Score;
    private int player2Score;

    public Score(int boardWidth) {
        player1Score = 0;
        player2Score = 0;
    }

    public int getPlayer1Score() {
        return player1Score;
    }
    public int getPlayer2Score() {
        return player2Score;
    }

    public void updateScore(Ball ball) {
        if (ball.getPos().x <= -BALL_WIDTH) {
            player2Score++;
            ball.resetBall();
        } else if (ball.getPos().x >= BOARD_WIDTH) {
            player1Score++;
            ball.resetBall();
        }
    }

    public void displayScore(Graphics graphics) {
        graphics.setFont(new Font("Arial", Font.BOLD, 25));
        graphics.setColor(Color.RED);
        graphics.drawString("Player 1 Score: " + player1Score, 0, 30);
        graphics.drawString("Player 2 Score: " + player2Score, 400, 30);

        if (player1Score == 11) {
            graphics.drawString("Player 1 won", 220, 240);
            player1Score = 0;
        } else if (player2Score == 11) {
            graphics.drawString("Player 2 won", 220, 240);
            player2Score = 0;
        }
    }

}
