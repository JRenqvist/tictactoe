import javax.swing.*;
import java.awt.*;

public class Grid extends JComponent {
    private Color color;
    private int size;
    private int frameWidth;
    private int frameHeight;
    public Grid(Color color, int size, int frameWidth, int frameHeight) {
        this.color = color;
        this.size = size;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;
        draw(g2d);
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        // Draw the vertical lines
        for (int i = 1; i < size; i++) {
            float x = ((float) i / (float) size) * frameWidth;
            g2d.drawRect((int) x, 0, 1, frameHeight);
        }

        // Draw the horizontal lines
        for (int i = 1; i < size; i++) {
            float y = ((float) i / (float) size) * frameHeight;
            g2d.drawRect(0, (int) y, frameWidth, 1);
        }
    }
}
