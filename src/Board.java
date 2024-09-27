import java.util.Arrays;

public class Board {
    private Player[][] squares;
    private int width;
    private int height;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.squares = new Player[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                this.squares[y][x] = Player.EMPTY;
            }
        }

    }

    public void updateItem(int x, int y, Player type) {
        this.squares[y][x] = type;
    }


}
