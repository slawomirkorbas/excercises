package solution.maze;

import java.util.*;
import java.util.stream.IntStream;

/**
    getMinMovesCount -  Calculate minimum number of moves from start to destination. One move may correspond to multiple cells
    if they are "inline" vertically or horizontally and there is no "invalid" cells within the line.
    Solution uses BFS - Breadth First Search algorithm.
 */

public class MinMovesInCastle {

    static final int FORBIDDEN_CELL = 1;

    static private class Cell {
        int x;
        int y;
        Cell parent = null;
        Cell ( int x, int y ) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if( this == obj ) {
                return true;
            }
            if( obj != null ) {
                return ( this.x == ((Cell)obj).x && this.y == ((Cell)obj).y );
            }
            return false;
        }

        @Override
        public int hashCode() {
            return 31 * this.x * this.y + 31 * this.x;
        }
    }

    /*
           Calculate minimum number of moves from start to destination. One move may correspond to multiple cells
           if they are "inline" vertically or horizontally and there is no "invalid" cells within the line.
     */
    static int getMinMovesCount( int maze[][], int startX, int startY, int goalX, int goalY ) {
        // call bfs and find possible paths in a maze
        List<Cell> path = bfs(maze, new Cell( startX, startY ), new Cell( goalX, goalY ));

        printPath(maze[0].length, path);

        return calculateMovesCount(path);
    }


    static List<Cell> bfs(int maze[][], Cell start, Cell goal) {

        List<Cell> path = new ArrayList<>();
        Set<Cell> visited = new HashSet<>();
        Queue<Cell> queue = new LinkedList<>();
        queue.add(start);

        while( !queue.isEmpty() ) {
            Cell current = queue.peek();

            if( current.x == goal.x && current.y == goal.y ) {
                // collect all cells leading to destination
                return resolvePath(current);
            }

            queue.remove();

            Cell parent = current;
            for( int x = current.x - 1; x >= 0 && maze[x][current.y] != FORBIDDEN_CELL && parent != null; x-- ) {
                parent = addToQueue(new Cell( x, current.y), parent, queue, visited );
            }
            parent = current;
            for( int x = current.x + 1; x < maze.length && maze[x][current.y] != FORBIDDEN_CELL && parent != null; x++ ) {
                parent = addToQueue(new Cell( x, current.y), parent, queue, visited );
            }
            parent = current;
            for( int y = current.y - 1; y >= 0 && maze[current.x][y] != FORBIDDEN_CELL && parent != null; y-- ) {
                parent = addToQueue(new Cell( current.x, y), parent, queue, visited );
            }
            parent = current;
            for( int y = current.y + 1; y < maze.length && maze[current.x][y] != FORBIDDEN_CELL && parent != null; y++ ) {
                parent = addToQueue(new Cell( current.x, y), parent, queue, visited );
            }
        }

        return path;
    }

    static Cell addToQueue( Cell cell, Cell parent, Queue<Cell> queue, Set<Cell> visited ) {
        if( !visited.contains(cell) ) {
            cell.parent = parent;  // set parent
            queue.add( cell );     // add to queue
            visited.add( cell );   // mark as visited
            return cell;
        }
        return null;
    }

    /*
    Resolve full path by traversing from endCell parent by parent
     */
    static List<Cell> resolvePath( Cell endCell ) {
        List<Cell> path = new ArrayList<>();
        do {
            path.add( endCell );
            endCell = endCell.parent;
        }
        while( endCell != null );
        return path;
    }

    static int calculateMovesCount(List<Cell> path) {
        int movesCount = 0;
        boolean first = true;
        if( path != null ) {
            boolean checkX = false;
            for( Cell c : path) {
                if( first ) {
                    if( c.parent != null ) {
                        checkX = (c.y == c.parent.y);
                    }
                    first = false;
                }

                if( c.parent != null ) {
                    if( checkX && c.parent.x != c.x) {
                        movesCount++;
                        checkX = false;
                    }
                    else if( !checkX && c.parent.y != c.y) {
                        movesCount++;
                        checkX = true;
                    }
                }
            }
        }
        return movesCount;
    }


    static void printPath(int mazeSize, List<Cell> path ) {
        for( int x = 0 ; x < mazeSize; x++ ) {
            for( int y = 0 ; y < mazeSize; y++ ) {
                boolean cellInPath = false;
                for( Cell c : path ) {
                    if( c.x == x && c.y == y ){
                        cellInPath = true;
                        break;
                    }
                }
                System.out.print( ( cellInPath ? 1 : 0 ) + " " );
            }
            System.out.println("");
        }
    }
}
