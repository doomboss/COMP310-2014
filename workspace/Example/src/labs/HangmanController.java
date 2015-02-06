package labs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

// The console user interface
public class HangmanController {
	private static void view(Hangman game) {
		System.out.format("Guesses remaining: %d\nYou used: %s\nWord: %s\n",
				game.guessesRemaining(),
				game.getGuesses().toString(),
				game.visible());
	}
	public static void consoleUI(Hangman game) {
		Scanner scanner = new Scanner(System.in);
		char letter;
		String line;
		System.out.println("Enter the word's length: ");
		int inputlength = scanner.nextInt();
		while(inputlength>game.getMaxwordlength() || inputlength<1){
			System.out.println("Sorry, the length is too long or too short... please use another length");
			System.out.println("Enter the word's length: ");
			inputlength = scanner.nextInt();
		}
		game.setWordlength(inputlength);
		System.out.println(game.getWordlength());
		game.setWord();
		while (!game.isOver()) {
			view(game);
			System.out.println("Enter a letter: ");
			while ((line = scanner.nextLine()).equals(""));
			letter = line.charAt(0);
			while (!game.makeGuess(letter)) {
				System.out.println("Try another letter: ");
				letter = scanner.nextLine().charAt(0);
			}
		}
		if (game.won()) {
			System.out.println("Yay, you won!");
		} else {
			System.out.println("You lost! It was: " + game.getWord());
		}
	}
	// TODO: change the constructor to use EvilHangman
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		Hangman game = new Hangman();
		EvilHangman game = new EvilHangman();
		
//		game.setWord("fly");
		HangmanController.consoleUI(game);
	}
}
