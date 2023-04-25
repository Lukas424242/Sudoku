
public class SudokuV22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        solve(sudoku9);
    }

   public static void print(int[][] b) {
        System.out.println("* Feld Anfang *");

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                System.out.print(b[y][x] + (x % 3 == 2 ? "  " : " "));
            }

            if (y == 8) {
                System.out.print("\n");
            } else {
                System.out.print(y % 3 == 2 ? "\n\n" : "\n");
            }
        }

        System.out.println("* Feld Ende *");
    }

    public static void solve(int[][] feld) {
        boolean[][] boolfeld = new boolean[9][9];

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (feld[y][x] == 0) {
                    boolfeld[y][x] = false;
                } else {
                    boolfeld[y][x] = true;
                }
            }
        }

        rek2(feld, boolfeld, 0, 0);
    }

    public static boolean feldValid(int[][] feld) {
        // vertikal
        for (int y = 0; y < 9; y++) {

            int[] c = new int[9];

            for (int x = 0; x < 9; x++) {

                if (feld[y][x] == 0) {
                    return false;
                }

                int d = feld[y][x] - 1;

                c[d]++;
                if (c[d] > 1) {
                    return false;
                }

            }
        }

        // horizontal
        for (int x = 0; x < 9; x++) {

            int[] c = new int[9];

            for (int y = 0; y < 9; y++) {

                if (feld[y][x] == 0) {
                    return false;
                }

                int d = feld[y][x] - 1;

                c[d]++;
                if (c[d] > 1) {
                    return false;
                }

            }
        }

        return true;

    }

    public static boolean feldTeilValid(int[][] feld, int feldX, int feldY) {
        // vertikal
        int[] boolarray = new int[9];
        for (int y = 0; y < 9; y++) {
            int d = feld[y][feldX];

            if (d != 0) {
                d = d - 1;

                boolarray[d]++;

                if (boolarray[d] > 1) {
                    return false;
                }
            }
        }

        int[] boolarray2 = new int[9];

        for (int x = 0; x < 9; x++) {
            int d = feld[feldY][x];

            if (d != 0) {
                d = d - 1;

                boolarray2[d]++;

                if (boolarray2[d] > 1) {
                    return false;
                }

            }
        }

        return true;
    }

    public static boolean blockTeilValid2(int[][] feld, int feldX, int feldY) {
        int[] üfeld = new int[9];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int d = feld[feldY + i][feldX + j];
                if (d != 0) {
                    d = d - 1;

                    üfeld[d]++;

                    if (üfeld[d] > 1) {
                        return false;
                    }

                }

            }

        }
        return true;
    }

    public static boolean blockTeilValidcomp(int[][] feld) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!blockTeilValid2(feld, x, y)) {
                    return false;
                }
                x = x + 3;

            }
            y = y + 3;
            x = 0;

        }
        return true;
    }

    public static void rek2(int[][] feld, boolean[][] boolfeld, int feldX, int feldY) {
        int x1 = feldX;
        int y1 = feldY;
        
        

        //System.out.println(feldX);
        if (feldValid(feld) && blockTeilValidcomp(feld)) {
            // Blöcke prüfen

            print(feld);
            System.exit(0);
            System.out.println("Lösung gefunden");

            // zweite Methode, die anhand der Koordinaten das 3*3 Feld bestimmen,
            // und bei falsch terminaten
            // Logisch oder
        } else if (feldX % 3 == 0 && feldY % 3 == 0) {
            if (!blockTeilValid2(feld, feldX, feldY)) {
                return;
            }

        } else if (!feldTeilValid(feld, feldX, feldY)) {
            return;
        }
        //print(feld);
        // Feld ist `teilvalid`...
        // 
        if (boolfeld[y1][x1]) {
            // Zelle ist fest

            x1++;

            if (x1 == 9) {
                y1 = y1 + 1;
                x1 = 0;

                if (y1 == 9) {
                    // Ende vom Feld erreicht
                    return;
                }
            }

            rek2(feld, boolfeld, x1, y1);

        } else {
            // Zelle nicht fest

            boolfeld[y1][x1] = true;

            for (int i = 1; i <= 9; i++) {
                feld[y1][x1] = i;

                rek2(feld, boolfeld, x1, y1);

                feld[y1][x1] = 0;
            }

            boolfeld[y1][x1] = false;
        }

    }

}
