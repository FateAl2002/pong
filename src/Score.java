import java.awt.*;

public class Score {
    private int Player1Score;
    private int Player2Score;

    public int getPlayer2Score() {
        return Player2Score;
    }

    public void

    public void setPlayer2Score(int player2Score, Object paddle1, Sprite ball) {
        Player2Score = 0;
        if (ball.isColliding((Sprite) paddle1)) {
            Player2Score += 1;
        }
    }

    public int getPlayer1Score() {
        return Player1Score;
    }

    public void setPlayer1Score(int player1Score, Object paddle2, Sprite ball) {
        Player1Score = 0;
        if (ball.isColliding((Sprite) paddle2)) {
            Player1Score += 1;
        }
    }
}
