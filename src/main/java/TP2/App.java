package TP2;

import TP2.DAO.WinnerDAO;
import TP2.DAO.WordDAO;
import TP2.Models.Paper;
import TP2.Models.Player;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        WordDAO dictionary = new WordDAO();

        Paper sharedppr = new Paper(dictionary.selectWord());
        sharedppr.successesNeeded();

        Player p1 = new Player("Player 1",sharedppr);
        Player p2 = new Player("Player 2",sharedppr);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        t1.start();
        t2.start();

    }
}
