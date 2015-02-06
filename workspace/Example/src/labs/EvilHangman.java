package labs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * In Evil Hangman, the computer maintains a list of every word in the
 * English language, then continuously pares down the word list to try
 * to dodge the player's guesses as much as possible.
 *
 * Details here:
 * http://nifty.stanford.edu/2011/schwarz-evil-hangman/Evil_Hangman.pdf
 */
public class EvilHangman extends Hangman {
	EvilHangman() throws FileNotFoundException, IOException {
		super();
		FileReader file = new FileReader("resources/dictionary.txt");
		BufferedReader reader = new BufferedReader(file);
		String tmp;
		int wordSize = 0, counter =0;
		while((tmp = reader.readLine())!=null){
			counter++;
			if(tmp.length()>wordSize)
				wordSize = tmp.length();//find the longest word in the dictionary
			if(library.containsKey(tmp.length()))
				library.get(tmp.length()).add(tmp);
			else{
				library.put(tmp.length(), new ArrayList<String>());
				library.get(tmp.length()).add(tmp);
			}
				
		}
		setMaxwordlength(wordSize);
//		System.out.println("size "+wordSize);
//		System.out.println("counter "+counter);
		Scanner scanner = new Scanner(reader);
		// TODO: build up a data structure here
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
	}
	// TODO: extend existing methods to be evil
}
