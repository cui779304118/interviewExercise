package com.cuiwei.algorithm.offer;

/**
 *请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HasPath {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        //记录是否被访问
        boolean[] visited = new boolean[rows * cols];
        //路径的索引
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, pathLength, str, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col,
                                int pathLength, char[] str, boolean[] visited) {
        if (pathLength == str.length) {
            return true;
        }
        int index = row * cols + col;
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[index] == str[pathLength]
                && !visited[index]) {
            ++pathLength;
            visited[index] = true;
            //递归搜索上下左右的节点
            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, pathLength, str, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, pathLength, str, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, pathLength, str, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, pathLength, str, visited);
            if (!hasPath){
                --pathLength;
                visited[index] = false;
            }
        }
            return hasPath;
    }

    public static void main(String[] args) {
        String matrixStr = "abtgcfcsjdeh";
        String pathStr = "gshect";
        char[] matrix = matrixStr.toCharArray();
        char[] path = pathStr.toCharArray();
        System.out.println(hasPath(matrix,3,4,path));
    }

}
