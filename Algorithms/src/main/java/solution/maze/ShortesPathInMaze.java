package solution.maze;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: slawomir
 * Date: 2/21/18
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShortesPathInMaze {

    private static class Cell {
        int x;
        int y;
        Cell( int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /*
        Calculate minimum number of moves from start to destination. One move may correspond to multiple cells
        if they are "inline" vertically or horizontally and there is no "invalid" cells within the line.
   */
    static int getMinMovesCount( int maze[][], int startX, int startY, int destX, int destY ) {
        int movesCount = 0;

        List<Cell> path = findPath( maze, startX, startY, destX, destY );

        Iterator<Cell> iter = path.iterator();
        Cell previous = iter.hasNext() ? iter.next() : null;
        Cell current  = iter.hasNext() ? iter.next() : null;
        if( current!= null && previous != null ) {
            movesCount = 1;
            boolean checkX = previous.y == current.y;
            do {
                if( checkX ) {
                    if( previous.x == current.x ) {
                        movesCount++;
                        checkX = false;
                    }
                }
                else {
                    if( previous.y == current.y ) {
                        movesCount++;
                        checkX = true;
                    }
                }

                previous = current;
                current = iter.hasNext() ? iter.next() : null;
            }
            while( current != null );
        }

        //path.stream().filter(cell -> cell.x ).count();

        return movesCount;
    }

    static List<Cell> findPath( int maze[][], int startX, int startY, int destX, int destY ){

        // initialize solution grid
        int n = maze.length;
        int solutionGrid[][] = new int[n][n];
        for( int x=0; x < n; x++) {
            for( int y=0; y < n; y++) {
                solutionGrid[x][y] = 0;
            }
        }

        List<Cell> path = new ArrayList<Cell>();
        solvePath( maze, path, startX, startY, destX, destY );

        return path;
    }

    static boolean solvePath( int maze[][], List<Cell> path, int x, int y, int destX, int destY ) {

        // destination is reached
        if( x == destX && y == destY ) {
            path.add( new Cell(x,y) );
            return true;
        }

        if( isSafeToGo(maze, x, y) ) {
            if( visited( path, x, y ) ){
                return false;
            }

            path.add( new Cell(x,y) );

            if( solvePath( maze, path, x + 1, y, destX, destY ) ) {
                return true;
            }
            if( solvePath( maze, path, x, y + 1, destX, destY ) ) {
                return true;
            }
            if( solvePath( maze, path, x - 1, y, destX, destY ) ) {
                return true;
            }
            if( solvePath( maze, path, x, y - 1, destX, destY ) ) {
                return true;
            }

            // If none of the above movements work then BACKTRACK: remove last element from path
            path.remove(path.size() - 1);
        }
        return false;
    }

    static boolean isSafeToGo( int maze[][], int x, int y ) {
        int n = maze.length;
        return  x >= 0 && x < n && y >= 0 && y < n && maze[x][y] != 1;
    }

    static boolean visited(List<Cell> path, int x, int y) {
        for( Cell cell : path ) {
            if( cell.x == x && cell.y == y ) {
                return true;
            }
        }
        return false;
    }

}
