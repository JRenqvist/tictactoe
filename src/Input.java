import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input {
    private Point mouseLocation = null;
    private boolean mousePressed = false;

    public Input(JFrame frame) {

        // Get the mouse location
        MouseMotionListener mouseMotionListener = new MouseMotionListener()
        {
            @Override public void mouseDragged(final MouseEvent e) {

            }

            @Override public void mouseMoved(final MouseEvent e) {
                // Gets called when you move the mouse. Also sets mouseLocation to updated value
                Point mouseLocation = e.getPoint();
                setMouseLocation(mouseLocation);
            }
        };

        // Get if the mouse is clicked or not
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setMousePressed(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setMousePressed(false);
            }
        };

        frame.getContentPane().addMouseMotionListener(mouseMotionListener);
        frame.getContentPane().addMouseListener(mouseListener);
    }

    public void setMouseLocation(Point mouseLocation) {
        this.mouseLocation = mouseLocation;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public Point getMouseLocation() {
        return mouseLocation;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }
}
