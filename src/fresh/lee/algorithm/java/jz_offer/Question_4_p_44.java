package fresh.lee.algorithm.java.jz_offer;

public class Question_4_p_44 {
    private static int[][] arr = new int[][]{
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
    };

    public static void main(String[] args) {
        System.out.println(findNumberIn2DimenArray(arr, 6) ? "found!" : "not found!");
    }

    public static boolean findNumberIn2DimenArray(int[][] matrix, int number) {
        //check parameters
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            throw new IllegalArgumentException("please input right matrix");
        }
        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean find = false;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column > 0) {
            if (matrix[row][column] == number) {
                find = true;
                break;
            } else if (matrix[row][column] > number) {
                --column;
            } else {
                ++row;
            }
        }

        return find;
    }
}
