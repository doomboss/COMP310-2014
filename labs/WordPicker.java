import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


public abstract class WordPicker {
	ArrayList<String> words;
	ArrayList<Map<Character,HashSet<Integer>>> cool = new ArrayList<HashMap<Character, HashSet<Integer>>>;
	
	public WordPicker() throws IOException {
		URL url = new URL("https://raw.githubusercontent.com/lawrancej/COMP310-2014/master/labs/american-english.txt");
		
		InputStream stream = url.openStream();
		BufferedReader reader = new BufferedReader
				(new InputStreamReader(stream));
		
		String word;
		
		System.currentTimeMillis();
		// Read line by line
		while ((word = reader.readLine()) != null) {
			words.add(word);
		}
	}
	
	//one subclass(linearworkdpicker)  implements a simple  linear search
	//iterate through and see if you find the string
	//the other subclass will have a set<string> to access
	//set<string> (the set of words in the dictionary)
	//implementation type could be a hashset<string>
	
	
	public abstract boolean isWord(String string);
	
	//linearwordpicker will use the string as a pattern
	//it will just use the matches method in the string class to build up a list of matching words
	//the gist of it is: grep pattern words
	//iterate through and do the string match, as you build up a list of words
	
	//fancywordpicker wont match all possible regexen
	//instead, it will be able to match regex of this formL letter or anything for each spot in a string
	//for each possible character in a sequence, have a set of indices
	//arraylist<map<character, set<integer>>>
	public abstract List matchingWords(String pattern)
}
