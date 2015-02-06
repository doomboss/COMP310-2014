package labs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Hangman {
	private String word;
	HashMap<Integer, ArrayList<String>> library = new HashMap<Integer, ArrayList<String>>();
	private int totalguesses, wordlength, maxwordlength;
	
	public int getMaxwordlength() {
		return maxwordlength;
	}
	public void setMaxwordlength(int maxwordlength) {
		this.maxwordlength = maxwordlength;
	}
	public int getWordlength() {
		return wordlength;
	}
	public void setWordlength(int wordlength) {
		this.wordlength = wordlength;
	}
	public int getTotalguesses() {
		return totalguesses;
	}
	public void setTotalguesses(int totalguesses) {
		this.totalguesses = totalguesses;
	}
	private Set<Character> guesses = new HashSet<Character>();
	private Set<Character> correct = new HashSet<Character>();
	// Reset the game
	public void reset() {
		guesses.clear();
		correct.clear();
	}
	// Begin the game
	public void setWord(String word) {
		this.word = word;
	}
	// Get the word
	public String getWord() {
		return word;
	}
	public void setWord(){
		if(getWordlength()>1){
			Random rand = new Random();
			int ranNum = rand.nextInt(library.get(getWordlength()).size() - 0 + 1) + 0;			
			this.word = library.get(getWordlength()).get(ranNum-1);
		}
	}
	// Get guesses
	public Set<Character> getGuesses() {
		return guesses;
	}
	// Make a guess. Returns whether the guess was added
	public boolean makeGuess(char letter) {
		if (guesses.contains(letter)) {
			return false;
		}
		guesses.add(letter);
		if (word.contains("" + letter)) {
			correct.add(letter);
		}
		return true;
	}
	// What can the player see?
	public String visible() {
		StringBuilder b = new StringBuilder();
		for (char letter : word.toCharArray()) {
			b.append(guesses.contains(letter) ? letter : '*');
		}
		return b.toString();
	}
	// Did the player win?
	public boolean won() {
		return word.equals(visible());
	}
	// How many guesses remain?
	public int guessesRemaining() {
		return 6 - (guesses.size() - correct.size());
	}
	// Is the game over?
	public boolean isOver() {
		return (guessesRemaining() <= 0) || won();
	}
}
