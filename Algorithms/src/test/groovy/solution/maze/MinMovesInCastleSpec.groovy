package solution.maze

import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: slawomir
 * Date: 2/21/18
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */
class MinMovesInCastleSpec extends Specification {    def 'getMinMovesCount 1x1: calculate correct number of moves'() {

        given:
            int[][] maze = [[0]]

        when:
            int  moves = MinMovesInCastle.getMinMovesCount(maze, 0, 0, 0, 0);
        then:
            moves == 0;
    }

    def 'getMinMovesCount 2x2: calculate correct number of moves'() {

        given:
            int[][] maze = [[0,0],
                            [0,0]]

        when:
            int  moves = MinMovesInCastle.getMinMovesCount(maze, 0, 0, 1, 1);
        then:
            moves == 2;
    }

    def 'getMinMovesCount 3x3: calc ulate correct number of moves'() {

        given:
        int[][] maze = [[0,1,0],
                        [0,1,0],
                        [0,0,0]]

        when:
            int  moves = MinMovesInCastle.getMinMovesCount(maze, 0, 0, 0, 2);
        then:
            moves == 3;
    }

    def 'getMinMovesCount 2: calculate correct number of moves'() {

        given:
        int[][] maze = [[0,1,0,0,0],
                        [0,1,0,1,0],
                        [0,0,0,1,0],
                        [0,1,0,1,0],
                        [0,1,0,1,0]]

        when:
            int  moves = MinMovesInCastle.getMinMovesCount(maze, 0, 0, 4, 4);
        then:

            moves == 5;
    }

    def 'getMinMovesCount 3: calculate correct number of moves'() {

        given:
        int[][] maze = [[0,0,0,1,0],
                        [1,1,0,0,0],
                        [0,0,0,1,1],
                        [0,1,1,0,0],
                        [0,0,0,0,0]]

        when:
            int  moves = MinMovesInCastle.getMinMovesCount(maze, 3, 3, 0, 0);
        then:
            moves == 6;
    }

    def 'getMinMovesCount 6x6: calculate correct number of moves'() {

        given:
        int[][] maze = [[0,1,0,0,0,0],
                        [0,1,0,1,0,0],
                        [0,1,0,1,1,0],
                        [0,0,1,1,0,0],
                        [0,1,0,0,0,0],
                        [0,0,0,1,0,0]]

        when:
            int  moves = MinMovesInCastle.getMinMovesCount(maze, 2, 2, 0, 0);
        then:
            moves == 7;
    }


    def 'getMinMovesCount 7x7: calculate correct number of moves'() {

        given:
        int[][] maze = [[0,1,0,0,0,1,0],
                        [0,0,0,1,0,0,0],
                        [0,1,0,1,1,0,1],
                        [0,1,0,1,1,0,0],
                        [0,1,0,0,0,0,0],
                        [0,1,1,1,1,1,0],
                        [0,0,0,0,0,0,0]]

        when:
        int  moves = MinMovesInCastle.getMinMovesCount(maze, 0, 0, 4, 6);
        then:
            moves == 3;
    }

    def 'getMinMovesCount 7x7 2: calculate correct number of moves'() {

        given:
        int[][] maze = [[0,0,0,0,0,0,0],
                        [0,1,0,1,1,1,0],
                        [0,1,0,1,0,1,0],
                        [0,1,0,1,0,1,0],
                        [0,1,0,1,0,0,0],
                        [0,1,1,1,1,1,0],
                        [0,0,0,0,0,0,0]]

        when:
        int  moves = MinMovesInCastle.getMinMovesCount(maze, 0, 0, 4, 4);
        then:
        moves == 3;
    }

}
