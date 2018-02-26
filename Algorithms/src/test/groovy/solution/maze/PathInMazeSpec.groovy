package solution.maze

import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: slawomir
 * Date: 2/20/18
 * Time: 8:35 PM
 * To change this template use File | Settings | File Templates.
 */
class PathInMazeSpec extends Specification {

    def 'solveMaze: find correct path'() {

        given:
            int[][] maze = [ [0,1,0,0,0],
                             [0,1,0,1,0],
                             [0,0,0,1,0],
                             [0,1,0,1,0],
                             [0,1,0,1,0] ]

        when:
            int[][] sol = PathInMaze.solveMaze(maze, 0, 0, 4, 4);
        then:
            for (int i = 0; i < sol[0].length; i++) {
                for (int j = 0; j < sol[0].length; j++) {
                    System.out.print(" " + sol[i][j] + " ");
                }
                System.out.println();
            }
    }


}
