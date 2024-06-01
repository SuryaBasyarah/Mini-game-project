public class Map {
    public static final int SIZE = 10;
    private String[][] map;

    public Map() {
        map = new String[][]{
            {" X ", " X ", " X ", " X ", " X ", " X ", " X ", " X ", " X ", " X "},
            {" X ", "   ", "   ", "   ", "   ", "   ", " ? ", "   ", "   ", " X "},
            {" X ", "   ", " X ", " X ", " X ", " ? ", " X ", " X ", "   ", " X "},
            {" X ", " ? ", " X ", "   ", " X ", "   ", "   ", " X ", "   ", " X "},
            {" X ", "   ", " X ", "   ", "   ", "   ", " X ", " X ", "   ", " X "},
            {" X ", "   ", "   ", " ? ", " X ", " X ", "   ", "   ", " ? ", " X "},
            {" X ", " X ", " X ", "   ", "   ", " ? ", " X ", " X ", "   ", " X "},
            {" X ", "   ", "   ", "   ", " X ", "   ", "   ", " ? ", "   ", " X "},
            {" X ", " ? ", " X ", " X ", " X ", "   ", " X ", " X ", "   ", " X "},
            {" X ", " X ", " X ", " X ", " X ", " X ", " X ", " X ", " X ", " X "}
        };
    }

    public void printMap(Player player, Boss boss) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == player.getX() && j == player.getY()) {
                    System.out.print(" P ");
                } else if (i == boss.getX() && j == boss.getY()) {
                    System.out.print(" B ");
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE && map[x][y] != " X ";
    }

    public String getTile(int x, int y) {
        return map[x][y];
    }

    public void clearInteraction(int x, int y) {
        if (map[x][y] == " ? ") {
            map[x][y] = "   ";
        }
    }
}
