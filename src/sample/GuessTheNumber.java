package sample;

import java.util.Random;

public class GuessTheNumber {
    private int attempts;
    private int hiddenNumber;
    Random random = new Random();

    public GuessTheNumber(int numberTries) {
        this.attempts = numberTries;
        this.hiddenNumber = random.nextInt(10) + 1;
    }

    public int guess(int num){
        if(num == hiddenNumber) return 0;
        return num > hiddenNumber ? 1 : -1;
    }

    public int getAttempts() {
        return attempts;
    }

    public void decreaseAttempts(){
        attempts--;
    }

    public void reload(int numberTries) {
        this.attempts = numberTries;
        this.hiddenNumber = random.nextInt(10) + 1;
    }
}
