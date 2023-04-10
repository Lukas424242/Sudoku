
/**
 *
 * @author lukas
 */
public class SudokuV22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] eingabefeld = {{0, 3, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 0, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 0, 6, 0, 0, 0},
        {4, 0, 0, 8, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 2, 0, 0, 0, 0},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 0, 0, 0, 7, 0}};

        int[][] eingabefeld2 = {{0, 3, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 0, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 0, 6, 0, 0, 0},
        {4, 0, 0, 8, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 2, 0, 0, 0, 0},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 0, 0, 0, 7, 0}};

        //solve(eingabefeld2);
        int[][] sudoku = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        //System.out.println("b" + feldvalid(sudoku));
        int[][] sudoku2 = {
            {5, 0, 4, 6, 7, 8, 9, 1, 2},
            {0, 7, 0, 0, 0, 0, 0, 0, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 0},
            {0, 5, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 6, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 0, 0, 0, 0, 0, 0, 0},
            {0, 4, 0, 0, 0, 0, 0, 0, 0}
        };

        //solve(sudoku2);
        //System.out.println("hier" + feldvalid(sudoku2));
        //System.out.println("lösbar " + solve(eingabefeld2));
        //System.out.println("Ootput " + feldteilvalid(sudoku2, 8, 8));
        //System.out.println("Ootput2 " + feldteilvalid(sudoku2, 0, 1));
        //solve(eingabefeld2);
        int[][] sudoku4 = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        //solve(sudoku4);
        int[][] sudoku5 = {
            {0, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        // statt 2 0, dann funktioniert es nicht
        int[][] sudoku8 = {
            {0, 3, 4, 6, 7, 0, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 0, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 0, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 0, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 0, 0}
        };

        //solve(sudoku8);
        // Hier Index out of bounce exception
        int[][] sudoku42 = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 0, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        int[][] sudokuprob = {
            {0, 3, 4, 6, 7, 0, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 0, 1, 4, 2, 3},
            {4, 0, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 0, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 0, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 0, 0}
        };

        //solve(sudokuprob);
        int[][] sudprob2 = {{0, 3, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 0, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 0, 6, 0, 0, 0},
        {4, 0, 0, 8, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 2, 0, 0, 0, 0},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 0, 0, 0, 7, 0}};

        solve(sudprob2);
        //System.out.println("w" + feldvalid(sudoku42));
        //System.out.println("w2" + feldvalid2(sudoku42));
    }

    public static void print(int[][] b) {
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {
                System.out.print(b[i][j]);
            }
        }

    }

    public static void solve(int[][] eingabefeld) {
        boolean[][] boolfeld = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
                if (eingabefeld[i][k] == 0) {
                    boolfeld[i][k] = false;
                } else {
                    boolfeld[i][k] = true;
                }

            }

        }
        rek2(eingabefeld, boolfeld, 0, 0);

    }

    public static boolean feldvalid2(int[][] b) {
        // Seite 
        for (int i = 0; i < 9; i++) {

            int[] c = new int[9];

            for (int j = 0; j < 9; j++) {

                if (b[i][j] == 0) {
                    return false;

                }

                int d = b[i][j] - 1;
// oder mit booleans und xor
                c[d]++;
                if (c[d] > 1) {
                    return false;

                }

            }
        }

        // unten
        for (int i = 0; i < 9; i++) {

            int[] c = new int[9];

            for (int j = 0; j < 9; j++) {

                if (b[j][i] == 0) {
                    return false;

                }

                int d = b[j][i] - 1;

                c[d]++;
                if (c[d] > 1) {
                    return false;

                }

            }
        }

        return true;

    }

    public static boolean feldvalid(int[][] b) {
        // Seite 
        for (int i = 0; i < 9; i++) {

            int[] c = new int[9];

            for (int j = 0; j < 9; j++) {

                if (b[i][j] == 0) {
                    return false;

                }

                int d = b[i][j] - 1;
// oder mit booleans und xor
                c[d]++;
                if (c[d] > 1) {
                    return false;

                }

            }
        }

        // unten
        for (int i = 0; i < 9; i++) {

            int[] c = new int[9];

            for (int j = 0; j < 9; j++) {

                if (b[i][j] == 0) {
                    return false;

                }

                int d = b[i][j] - 1;

                c[d]++;
                if (c[d] > 1) {
                    return false;

                }

            }
        }

        return true;

    }

    public static boolean feldteilvalid(int[][] b, int x, int y) {
        // wir checken jetzt, ob bei der Position, die Reihen und spalten
        // diese eingaben zulassen 
        // Vertikal
        int[] boolarray = new int[9];
        for (int i = 0; i < 9; i++) {
            //System.out.print(b[x][i]);

            int d = b[x][i];
            if (d == 0) {
                continue;
            } else {
                d = d - 1;

                boolarray[d]++;

                if (boolarray[d] > 1) {
                    return false;

                }

            }
        }

        //System.out.println();
        int[] boolarray2 = new int[9];

        for (int i = 0; i < 9; i++) {
            //System.out.print(b[i][y]);

            int d = b[i][y];
            if (d == 0) {
                continue;
            } else {

                d = d - 1;

                boolarray2[d]++;

                if (boolarray2[d] > 1) {
                    return false;

                }

            }

        }
        return true;
    }

    public static void rek2(int[][] b, boolean[][] boolfeld, int x, int y) {

        int x1 = x;
        int y1 = y;
        if (feldvalid2(b)) {
            System.out.println("Lösung gefunden");
            print(b);

        } else if (!feldteilvalid(b, x, y)) {

            //System.out.println("stoppt hier");
        } else {

            if (boolfeld[y1][x1]) {

                if (x1 == 9 && y1 == 9) {
                    return;
                }
                if (x1 == 8) {
                    y1 = y1 + 1;
                    if (y1 == 9) {
                        System.out.println("keine lösung");
                        return;
                    } else {
                        x1 = 0;
                        rek2(b, boolfeld, x1, y1);
                    }
                } else {
                    rek2(b, boolfeld, x1 + 1, y1);

                }

            } else {
                if (x1 == 9 && y1 == 9) {
                    return;
                }
                for (int i = 1; i <= 9; i++) {
                    b[y1][x1] = i;
                    boolfeld[y1][x1] = true;
                    rek2(b, boolfeld, x1, y1);
                    //System.out.println(i);

                }

                // so wird das 8 Feld niemals aufgerufen
                // durch return zu Ende
                if (x1 == 8) {
                    x1 = 0;
                    y1++;
                    if (y1 == 9) {
                        System.out.println("keine Lösung");
                        return;

                    }

                } else {
                    x1++;

                }

            }

        }

    }

}
