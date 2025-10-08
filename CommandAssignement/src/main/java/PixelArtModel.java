public class PixelArtModel {
    private final int[][] grid = new int[8][8];
    private int cursorRow = 0, cursorCol = 0;

    public int[][] getGrid() { return grid; }
    public int getCursorRow() { return cursorRow; }
    public int getCursorCol() { return cursorCol; }

    public void moveCursor(int dRow, int dCol) {
        cursorRow = Math.max(0, Math.min(7, cursorRow + dRow));
        cursorCol = Math.max(0, Math.min(7, cursorCol + dCol));
    }

    public void togglePixel() {
        grid[cursorRow][cursorCol] = grid[cursorRow][cursorCol] == 0 ? 1 : 0;
    }

    public void printCodeToConsole() {
        System.out.println("int[][] pixelArt = {");
        for (int r = 0; r < 8; r++) {
            System.out.print("    {");
            for (int c = 0; c < 8; c++) {
                System.out.print(grid[r][c]);
                if (c < 7) System.out.print(", ");
            }
            System.out.println(r < 7 ? "}," : "}");
        }
        System.out.println("};");
    }
}
