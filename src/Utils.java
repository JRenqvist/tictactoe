import javax.swing.*;
import java.awt.*;

public class Utils {
    public static Point convertArrayToScreenCoordinates(int arrayX, int arrayY, JFrame frame, int size) {
        int x = (frame.getContentPane().getWidth() / size) * arrayX;
        int y = (frame.getContentPane().getHeight() / size) * arrayY;
        return new Point(x, y);
    }

    public static Point convertScreenToArrayCoordinates(int screenX, int screenY, JFrame frame, int size) {
        int x = -1, y = -1;
        for (int i = 0; i < size; i++) {
            if ((frame.getContentPane().getWidth() / size) * (i+1) > screenX) {
                x = i;
                break;
            }
        }

        for (int i = 0; i < size; i++) {
            if ((frame.getContentPane().getHeight() / size) * (i+1) > screenY) {
                y = i;
                break;
            }
        }
        return new Point(x, y);
    }

    public static Point roundScreenCoordinates(int screenX, int screenY, JFrame frame, int size) {
        // First convert to array coordinates and then convert back to screen coordinates
        Point arrayPoint = convertScreenToArrayCoordinates(screenX, screenY, frame, size);
        return convertArrayToScreenCoordinates(arrayPoint.x, arrayPoint.y, frame, size);
    }
}
