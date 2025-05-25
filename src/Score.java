import java.awt.*;
import javax.swing.Timer;
import static utils.Constants.*;

public class Score {
    private int player1Score;
    private int player2Score;
    private boolean showWinMessage = false;
    private int winner = 0;
    private Timer resetTimer;

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
        if (!showWinMessage) {
            if (ball.getPos().x <= -BALL_WIDTH) {
                player1Score++;
                ball.resetBall();
            } else if (ball.getPos().x >= BOARD_WIDTH) {
                player2Score++;
                ball.resetBall();
            }
        }

        if (player1Score == 11 || player2Score == 11) {
            showWinMessage = true;
            winner = (player1Score == 11) ? 1 : 2;

            resetTimer = new Timer(60000, e -> {
                player1Score = 0;
                player2Score = 0;
                showWinMessage = false;
                resetTimer.stop();
            });
            resetTimer.setRepeats(false);
            resetTimer.start();
        }
    }

    public void displayScore(Graphics graphics) {
        graphics.setFont(new Font("Arial", Font.BOLD, 25));
        graphics.setColor(Color.RED);
        graphics.drawString("Player 1 Score: " + player1Score, 0, 30);
        graphics.drawString("Player 2 Score: " + player2Score, 400, 30);

        if (showWinMessage) {
            graphics.drawString("Player " + winner + " Won!", 220, 240);
        }
    }
}
