package TP2.Models;

import java.util.Random;

public class Paper {

    private String word;
    private String abc;
    private StringBuilder sb;
    private int successes;
    private int success_aux;
    private Random dado;
    private boolean available;
    private boolean winner;

    public Paper(String word){
        this.word = word;
        this.successes = 0;
        this.success_aux = 0;
        this.available = true;
        this.winner = false;
        this.abc = "abcdefghijklmnopqrstuvwxyz";
        this.sb = new StringBuilder(this.abc);
        this.dado = new Random();
    }

    public String getWord() {
        return word;
    }

    public void successesNeeded(){// la cantidad de aciertos que necesita el jugador depende de la cantidad de letras adivinadas sin contar repeticiones
        String aux = removeRepeated();
        this.successes = aux.length();
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public synchronized boolean isWinner(){
        return this.winner;
    }

    public synchronized boolean belongsToWord(String name, char ch){
        while(!available ){
            try{
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        this.available = false;
        boolean result = false;
        if(!winner) {

            if (charExists(ch)) {

                success_aux++;
                result = true;

            }

            if (success_aux == this.successes) {
                this.winner = true;
            }
        }
        this.available = true;
        notifyAll();
        return result;
    }

    public char guessLetter(){//se adivina una letra dentro del abecedario
        int index = dado.nextInt(abc.length());
        char ch = abc.charAt(index);
        this.abc = sb.deleteCharAt(index).toString();//luego se elimina la letra adivinada

        return ch;
    }

    public boolean charExists(char ch){
        boolean exists = false;
        char[] letters = word.toCharArray();

        for(char letter : letters){
            if(letter == ch){
                exists = true;
            }
        }

        return exists;
    }

    public String removeRepeated(){
        String result;
        StringBuilder sb_aux = new StringBuilder();
        char[] letters = word.toCharArray();

        for(char letter: letters){
            if(sb_aux.indexOf(String.valueOf(letter)) != -1){
                continue;
            }else{
                sb_aux.append(letter);

            }
        }
        result = sb_aux.toString();
        return result;
    }

}
