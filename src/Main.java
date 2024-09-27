import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main {
    private static final int SIZE = 3;
    private static Player currentPlayer = Player.O;
    private static Player lastPlayer = Player.O;
    public static void main(String[] args) {
        JFrame frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 600));
        frame.setTitle("TicTacToe");
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setVisible(true);

        // Create the board
        Board board = new Board(SIZE, SIZE);

        // Create the grid
        Grid grid = new Grid(Color.black, SIZE,
                frame.getContentPane().getWidth(),
                frame.getContentPane().getHeight());
        frame.getContentPane().add(grid);

        // Create inputs using mouse
        Input input = new Input(frame);

        // Create the main game loop
        Timer timer = new Timer(10, e -> {

            if (input.isMousePressed() && currentPlayer == lastPlayer) {

                /* TODO
                Place thing at location
                Check if someone won
                Keep count of a score
                If board is full, reset board, no one gets points
                 */

                Point roundedScreenCoordinates = Utils.roundScreenCoordinates(input.getMouseLocation().x,
                        input.getMouseLocation().y, frame, SIZE);

                int tileWidth = frame.getContentPane().getWidth() / SIZE;
                int tileHeight = frame.getContentPane().getHeight() / SIZE;
                Dimension tileSize = new Dimension(tileWidth, tileHeight);
                Piece piece = new Piece(roundedScreenCoordinates.x, roundedScreenCoordinates.y,
                        currentPlayer, frame, board, tileSize);

                frame.getContentPane().add(piece);

                // Change current player
                if (currentPlayer == Player.O) {
                    currentPlayer = Player.X;
                } else if (currentPlayer == Player.X) {
                    currentPlayer = Player.O;
                }
                System.out.println(Arrays.toString(frame.getContentPane().getComponents()));
            } else if (!input.isMousePressed()) {
                lastPlayer = currentPlayer;
            }
        });
        timer.start();
    }

    public static int getSize() {
        return SIZE;
    }
}