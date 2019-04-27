package TP2.Models;

import TP2.DAO.WinnerDAO;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Player implements Runnable {

    private String name;
    private Paper paper;
    private int tries;
    private boolean winner;

    public Player(String name, Paper paper){
        this.name = name;
        this.paper = paper;
        this.tries = 6;
        this.winner = false;
    }

    public boolean isWinner() {
        return winner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }


    @Override
    public void run() {
        boolean guessed;
        char ch;

        while(tries > 0 && !winner){

            try{
                ch = paper.guessLetter();
                guessed = paper.belongsToWord(getName(),ch );


                if(guessed){
                    System.out.printf("%s Guessed letter(%c) belongs to the word\n", name, ch);
                }else{
                    System.out.printf("%s Guessed letter(%c) doesn't belong to the word\n",name,ch);
                    this.tries--;
                }

                if(paper.isWinner()){
                    this.winner = true;
                }

                sleep(1500);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        if(winner){
            WinnerDAO winner= new WinnerDAO();
            winner.save(getName(),paper.getWord());

            System.out.printf("%s is the winner\n",getName());

        }else{
            System.out.printf("%s gets Hanged\n",getName());
        }
    }
}
