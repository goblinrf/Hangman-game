package backend.academy.logic;

import java.util.ArrayList;
import java.util.Arrays;

public class GameState {
    private final char[] wishWord;
    private char[] guessedPart;
    private int attempts;
    private ArrayList<Character> previousLetters;

    public GameState(char[] word, int attempts) {
        this.wishWord = word;
        this.guessedPart = new char[wishWord.length];
        Arrays.fill(this.guessedPart, '_');
        this.attempts = attempts;
        this.previousLetters = new ArrayList<>();
    }

    public boolean letterUsed(char letter) {
        return previousLetters.contains(letter);
    }

    public boolean isPlayerWin() {
        return Arrays.equals(wishWord, guessedPart);
    }

    public boolean isPlayerLose() {
        return attempts == 0;
    }

    public int getAttempts() {
        return attempts;
    }

    public String getWishWord() {
        return new String(wishWord);
    }

    public ArrayList<Character> getPreviousLetters() {
        return new ArrayList<>(previousLetters);
    }

    public char[] getGuessedPart() {
        return guessedPart.clone();
    }

    public void makeGuess(char letter) {
        boolean correctLetter = false;
        char let = Character.toLowerCase(letter);
        for (int i = 0; i < wishWord.length; i++) {
            if (wishWord[i] == let) {
                guessedPart[i] = let;
                correctLetter = true;
            }
        }
        if (!correctLetter) {
            attempts--;
        }
        previousLetters.add(let);
    }
}
