package skyscrappers;

import java.util.Scanner;
import java.util.Stack;

/**
 * Developers Greenfield
 *
 * Created with IntelliJ IDEA.
 * User: slawomir
 * Date: 2/21/18
 * Time: 8:09 PM
 */
public class SkyscrapperGame {

    /**
     * Slow solution  - not recommended
     * @param skyScrappers
     * @return
     */
    public static int getRoutes_On2( int[] skyScrappers ) {
        int routes = 0;
        for( int i = 0; i < skyScrappers.length; i++ ) {
            for( int j = i + 1; j < skyScrappers.length; j++ ) {
                if( skyScrappers[i] < skyScrappers[j] ) {
                    break;
                }
                else if( skyScrappers[i] == skyScrappers[j] ) {
                    routes++;
                }
            }
        }

        routes *= 2;
        return routes;
    }

    /**
     * Faster solution
     * @param skyScrappers
     * @return
     */
    public static long getRoutes_On( int[] skyScrappers ) {
        long routesCount = 0;
        Stack<Integer> stack = new Stack<>();

        for( int i = 0; i < skyScrappers.length; i++ ) {
            if( stack.isEmpty() || stack.peek() >= skyScrappers[i] ) {
                stack.add( skyScrappers[i] );
            }
            else if( stack.peek() < skyScrappers[i] ) {
                while( !stack.isEmpty() && stack.peek() < skyScrappers[i] ) {
                    long s1, cnt = 0;
                    do {
                        s1 = stack.pop();
                        cnt++;
                    } while( !stack.isEmpty() && stack.peek() == s1 );
                    if( cnt >= 2 ) {
                        routesCount += ((cnt-1)*cnt);
                    }
                }
                stack.add( skyScrappers[i] );
            }
        }

        long cnt = 0, s1 = -1;
        while( !stack.isEmpty() ) {
            if( s1 == -1 || stack.peek() == s1 ) {
                s1 = stack.pop();
                cnt++;
            }
            else {
                routesCount += ( cnt > 1 ? ((cnt-1)*cnt) : 0 );
                s1 = stack.pop();
                cnt = 1;
            }
        }
        routesCount += ( cnt > 1 ? ((cnt-1)*cnt) : 0 );
        return routesCount;
    }


    /*
     private static class NodeGroup {
        int count;
        int height;
        NodeGroup( int height, int count ) {
            this.height = height;
            this.count  = count;
        }
    }

    public static int getRoutes_complexity_On( int[] skyScrappers ) {
        int routesCount = 0, height = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<NodeGroup> nodeGroups = new Stack<>();

        // store node groups having same height without higher node in path between them...
        for( int i = 0; i < skyScrappers.length; i++ ) {
            height = skyScrappers[i];
            if( stack.isEmpty() ) {
                stack.add( height );
            }
            else if( stack.peek() > height ) {
                stack.add( height );
            }
            else if( stack.peek() < height ) {
                while( true ) {
                    if( stack.isEmpty() ) {
                        stack.add( height );
                    }
                    else if(  stack.peek() < height ) {
                        stack.pop();
                        continue;
                    }
                    else if(  stack.peek() == height  ) {
                        if( nodeGroups.size() > 0 ) {
                            if( nodeGroups.peek().height == height ) {
                                addNodeGroup( nodeGroups, height );
                            }
                            else {
                                while ( !nodeGroups.isEmpty() && nodeGroups.peek().height < height ) {
                                    NodeGroup gr = nodeGroups.pop();
                                    routesCount +=  ( gr.count * (gr.count - 1 ) );
                                }
                                addNodeGroup( nodeGroups, height );
                            }
                        }
                        else {
                            addNodeGroup( nodeGroups, height );
                        }
                    }
                    else if(  stack.peek() > height ) {
                        stack.add( height );
                    }
                    break;
                }
            }
            else if( stack.peek() == height ) {
                addNodeGroup( nodeGroups, height );
            }
        }

        // calculate total possible routes
        routesCount += nodeGroups.stream().mapToInt( g -> (g.count-1)*g.count ).sum();

        return routesCount;
    }

    public static void addNodeGroup( Stack<NodeGroup> nodeGroups, int height) {
        if( nodeGroups.size() > 0 && nodeGroups.peek().height == height) {
            nodeGroups.peek().count++;
        }
        else {
            nodeGroups.add( new NodeGroup( height, 2 ));
        }
    }
     */
}
