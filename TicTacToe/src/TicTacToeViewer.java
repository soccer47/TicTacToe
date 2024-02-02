import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame{
    // Instance variables
    private Image[] markerImages;
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;
    private TicTacToe t;

    private static final int BOARD_ORIGIN = 100;

    // Constructor
    public TicTacToeViewer(TicTacToe tictac){
        // Initialize instance variables
        t = tictac;
        markerImages = new Image[2];

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }



    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(Color.RED);
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString("0", BOARD_ORIGIN + 100, BOARD_ORIGIN - 25);
        g.drawString("1", BOARD_ORIGIN + 300, BOARD_ORIGIN - 25);
        g.drawString("2", BOARD_ORIGIN + 500, BOARD_ORIGIN - 25);
        g.drawString("0", BOARD_ORIGIN - 50, BOARD_ORIGIN + 100);
        g.drawString("1", BOARD_ORIGIN - 50, BOARD_ORIGIN + 300);
        g.drawString("2", BOARD_ORIGIN - 50, BOARD_ORIGIN + 500);
        g.setColor(Color.BLACK);
        Square[][] gameBoard = t.getBoard();
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                gameBoard[i][j].draw(g);
            }
        }
        if (t.getGameOver()){
            if (!t.checkTie()){
                g.setColor(Color.RED);
                g.setFont(new Font("Serif", Font.PLAIN, 40));
                g.drawString(t.getWinner() + " wins", BOARD_ORIGIN + 200, BOARD_ORIGIN + 650);
            }
            else {
                g.setColor(Color.RED);
                g.setFont(new Font("Serif", Font.PLAIN, 40));
                g.drawString("It's a tie", BOARD_ORIGIN + 200, BOARD_ORIGIN + 650);
            }
        }
    }



}
