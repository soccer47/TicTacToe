import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    private Image XImage, OImage;
    private int squareOriginX;
    private int squareOriginY;

    private static final int BOX_SIDE_LENGTH = 200;
    private TicTacToeViewer game;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;

        squareOriginX = 100 + row * BOX_SIDE_LENGTH;
        squareOriginY = 100 + col * BOX_SIDE_LENGTH;

        OImage = new ImageIcon("Resources/O.png").getImage();
        XImage = new ImageIcon("Resources/X.png").getImage();

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }



    // new stuff

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(squareOriginX, squareOriginY, BOX_SIDE_LENGTH, BOX_SIDE_LENGTH);
        if (isEmpty()){
            return;
        }
        else if (this.marker.equals("X")){
            if (this.isWinningSquare){
                g.setColor(Color.GREEN);
                g.fillRect(squareOriginX, squareOriginY, BOX_SIDE_LENGTH, BOX_SIDE_LENGTH);
            }
            g.drawImage(XImage, squareOriginX, squareOriginY, BOX_SIDE_LENGTH, BOX_SIDE_LENGTH, game);
        }
        else {
            if (this.isWinningSquare) {
                g.setColor(Color.GREEN);
                g.fillRect(squareOriginX, squareOriginY, BOX_SIDE_LENGTH, BOX_SIDE_LENGTH);
            }
            g.drawImage(OImage, squareOriginX, squareOriginY, BOX_SIDE_LENGTH, BOX_SIDE_LENGTH, game);
        }
    }


    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
}
