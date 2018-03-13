package skyscrappers;

import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 https://www.hackerrank.com/challenges/jim-and-the-skyscrapers/problem
 */
public class SkyScrapperGame {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] skyScrappers = new int[n];
        for( int x = 0; x < n; x++ ) {
            skyScrappers[x] = scan.nextInt();
        }

        System.out.println(getRoutes_complexity_On2(skyScrappers));
    }

    public static int getRoutes_complexity_On2( int[] skyScrappers ) {
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
                    stack.pop();

                    if( stack.isEmpty() ) {
                        stack.add( height );
                        break;
                    }
                    else if( stack.peek() == height  ) {
                        if( nodeGroups.size() > 0 ) {
                            if( nodeGroups.peek().height == height ) {
                                nodeGroups.peek().count++;
                            }
                            else {
                                while ( !nodeGroups.isEmpty() && nodeGroups.peek().height < height ) {
                                    NodeGroup gr = nodeGroups.pop();
                                    routesCount += ( gr.count * (gr.count - 1 ) );
                                }
                                addNodeGroup( nodeGroups, height );
                            }
                        }
                        else {
                            nodeGroups.add( new NodeGroup( height, 2 ));
                        }
                        break;
                    }
                    else if(stack.peek() > height ) {
                        stack.add( height );
                        break;
                    }
                }
            }
            else if( stack.peek() == height ) {
                addNodeGroup( nodeGroups, height );
            }
        }

        // calculate total possible routes
        routesCount += nodeGroups.stream().mapToInt( g -> (g.count-1)*g.count ).sum();
//        for( int n = 0; n < nodeGroups.size(); n++ ) {
//            routesCount += (( nodeGroups.get(n).count - 1 ) * nodeGroups.get(n).count);
//        }

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


}
