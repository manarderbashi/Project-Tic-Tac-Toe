
package Page1;
import javax.swing.*;
import java.awt.*;


public class Board {

    private String[][] cells = new String[3][3];

    public Board() {
        reset();
    }

    public void setCells(int r, int c, String val) {
        if (r >= 0 && r < 3 && c >= 0 && c < 3) {
            cells[r][c] = val;
        } else {
            System.out.println("Invalid row or column index");
        }
    }

    public String getCells(int r, int c) {
        if (r >= 0 && r < 3 && c >= 0 && c < 3) {
            return cells[r][c];
        }

        System.out.println("Invalid row or column index");
        return "";
    }

    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = "";
            }
        }
    }
    public void resetBoard(JButton[][] board) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c].setText("");
                board[r][c].setForeground(Color.WHITE);
                board[r][c].setBackground(Color.DARK_GRAY);
            }
        }

        reset();
    }

}
