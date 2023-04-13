
public class SudokuV22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] feldLeer = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        int[][] sudoku8 = {
            {0, 0, 4, 6, 7, 0, 9, 1, 0},
            {6, 0, 2, 1, 0, 5, 3, 0, 0},
            {0, 0, 8, 3, 4, 0, 5, 6, 7},
            {8, 5, 9, 7, 0, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 0, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 0, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 0, 0}
        };

        solve(feldLeer);
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

    public static boolean blockTeilValid(int[][] feld, int feldX, int feldY) {
        // Beispiel Koordinate
        //x 5 und y 3
        // wenn b %3==0, dann zwei zurück

        int feldx2 = feldX;
        int feldy2 = feldY;
        
        int[] c = new int[9];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3;) {
                
                if (feld[feldy2][feldx2] == 0) {
                    return false;
                }

                int d = feld[feldy2][feldx2] - 1;

                c[d]++;
                if (c[d] > 1) {
                    return false;
                }

            }
        }

    }

    public static void rek2(int[][] feld, boolean[][] boolfeld, int feldX, int feldY) {
        int x1 = feldX;
        int y1 = feldY;

        if (feldValid(feld)) {
            System.out.println("Lösung gefunden");
            print(feld);

            System.exit(0);

            // zweite Methode, die anhand der Koordinaten das 3*3 Feld bestimmen,
            // und bei falsch terminaten
        } else if (!feldTeilValid(feld, feldX, feldY)) {
            return;
        }

        print(feld);

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
