
import java.io.*;
import java.util.Stack;

public class Monkey {
    private int sum;
    private int maxSum;
    private int startRow;
    private int startCol;
    private int currentRow;
    private int currentCol;

    private Stack<int []> path;

    public Monkey(String filename) throws IOException {
        this.sum = 0;
        this.maxSum = 0;
        this.startRow = 0;
        this.startCol = 0;
        this.currentRow = 0;
        this.currentCol = 0;

        this.path = new Stack<int[]>();
    }

    
    
    public char[][] constructTree(String filename) throws IOException {
        path.push(new int[] {startRow, startCol, 0});


        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String[] lines = reader.readLine().split(" ");

        int row = Integer.parseInt(lines[0]);
        int col = Integer.parseInt(lines[1]);

        char[][] tree = new char[row][col];

        String line;
        int j = 0;
        while ((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                tree[j][i] = line.charAt(i);
            }
            j++;
        }
        return tree;

    }

    public void calculateMaxPath(int height, int width, char[][] tree) {
        int[][] maxPathSums = new int[height][width];

        for (int col = 0; col < width; col++) {
            if (tree[height - 1][col] == '|') {
                startRow = height - 1;
                startCol = col;
                currentRow = startRow;
                currentCol = startCol;
                return;
            }
        }

        for (int col = 0; col < width; col++) {
            if (tree[height - 1][col] == 'W') {
                startRow = height - 1;
                startCol = col;
                currentRow = startRow;
                currentCol = startCol;
                return;
            }
        }

        if (!path.isEmpty()) {
            int[] pos = path.peek();
            currentRow = pos[0];
            currentCol = pos[1];
            int depth = pos[2];


        if (Character.isDigit(tree[currentRow][currentCol])) {
            int value = Character.getNumericValue(tree[currentRow][currentCol]);
            if (value > 0) {
                sum += value;
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
            System.out.println("Soma atual:" + sum);
        }
        }

        for (int j = 0; j < width; j++) {
            if (Character.isDigit(tree[height - 1][j])) {
                maxPathSums[height - 1][j] = Character.getNumericValue(tree[height - 1][j]);
            }
        }

        for (int i = height - 2; i >= 0; i--) {
            for (int j = 0; j < width; j++) {
                if (tree[i][j] == '/' || tree[i][j] == '\\' || tree[i][j] == '|' || tree[i][j] == 'V'
                        || tree[i][j] == 'W') {
                    int left = (j > 0) ? maxPathSums[i + 1][j - 1] : Integer.MIN_VALUE;
                    int right = (j < width - 1) ? maxPathSums[i + 1][j + 1] : Integer.MIN_VALUE;
                    int straight = maxPathSums[i + 1][j];

                    maxPathSums[i][j] = Math.max(Math.max(left, right), straight);

                    if (tree[i][j] == 'V' || tree[i][j] == 'W') {
                        maxPathSums[i][j] += 1;
                    }
                    //

                    if (Character.isDigit(tree[i][j])) {
                        maxPathSums[i][j] += Character.getNumericValue(tree[i][j]);
                    }
                    System.out.println("Soma maxima atual:" + maxPathSums[i][j]);

                }
            }
        }

    }
}

// // Atualiza a soma quando encontra um número
// if (Character.isDigit(tree[currentRow][currentCol])) {
// int value = Character.getNumericValue(tree[currentRow][currentCol]);
// if (value > 0) {
// currentSum += value;
// }
// if (currentSum > maxSum) {
// maxSum = currentSum;
// saveMaxPath();
// }
// }
