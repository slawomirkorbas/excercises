package solution.maze;

/**
    Uses Backtracking recursive algorithm.
    Finds one possible way to get from start to destination cell in a maze. There may be more possible ways out.
    PS: in order to find the shortest path BFS algorithm is needed.
 */
public class PathInMaze {

    static int[][] solveMaze( int maze[][], int startX, int startY, int destX, int destY ){

        // initialize solution grid
        int n = maze.length;
        int solutionGrid[][] = new int[n][n];
        for( int x=0; x < n; x++) {
            for( int y=0; y < n; y++) {
                solutionGrid[x][y] = 0;
            }
        }

        solvePath( maze, solutionGrid, startX, startY, destX, destY );

        return solutionGrid;
    }

    static boolean solvePath( int maze[][], int solutionGrid[][], int x, int y, int destX, int destY ) {

        // destination is reached
        if( x == destX && y == destY ) {
            solutionGrid[x][y] = 1;
            return true;
        }

        if( isSafeToGo(maze, x, y) ) {
            if( visited( solutionGrid, x, y ) ){
                return false;
            }

            solutionGrid[x][y] = 1;

            if( solvePath( maze, solutionGrid, x + 1, y, destX, destY ) ) {
                return true;
            }
            if( solvePath( maze, solutionGrid, x, y + 1, destX, destY ) ) {
                return true;
            }
            if( solvePath( maze, solutionGrid, x - 1, y, destX, destY ) ) {
                return true;
            }
            if( solvePath( maze, solutionGrid, x, y - 1, destX, destY ) ) {
                return true;
            }

            // If none of the above movements work then BACKTRACK: unmark x,y as part of solution path
            solutionGrid[x][y] = 0;
        }
        return false;
    }

    static boolean isSafeToGo( int maze[][], int x, int y ) {
        int n = maze.length;
        return  x >= 0 && x < n && y >= 0 && y < n && maze[x][y] != 1;
    }

    static boolean visited(int[][] solutionGrid, int x, int y) {
        return solutionGrid[x][y] == 1;
    }

    private static class Cell {
        int x;
        int y;
        Cell( int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
