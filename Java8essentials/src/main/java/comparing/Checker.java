package comparing;

import java.util.Comparator;


class Checker implements Comparator<Player> {

    public int compare( Player p1, Player p2 ) {
        if( p1.score < p2.score ) {
            return 1;
        }
        else if( p1.score > p2.score ) {
            return -1;
        }
        else {
            return p1.name.compareToIgnoreCase( p2.name );
        }
    }
}

