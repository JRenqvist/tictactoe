import javax.swing.*;
import java.awt.*;

public class Piece extends JComponent {
    private int x, y;
    private Player type;
    private Color color;
    private JFrame frame;
    private Board board;
    private Dimension tileSize;

    public Piece(int screenX, int screenY, Player type, JFrame frame, Board board, Dimension tileSize) {
        this.x = screenX;
        this.y = screenY;
        this.type = type;
        this.frame = frame;
        this.board = board;
        this.tileSize = tileSize;

        if (type == Player.O) {
            this.color = Color.BLUE;
        } else if (type == Player.X) {
            this.color = Color.RED;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        System.out.println("shbsldhbvj");

        g2d.setColor(this.color);
        setBounds(10, 10, 100, 100);
        g2d.fillRect(10, 10, 100, 100);
        // Draw X on the board structure
        Point arrayCoordinates = Utils.convertScreenToArrayCoordinates(this.x, this.y, frame, Main.getSize());
        board.updateItem(arrayCoordinates.x, arrayCoordinates.y, this.type);

    }

    @Override
    public Dimension getPreferredSize() {
        return tileSize;
    }
}
