package pcd.lab01.ex01;

import java.util.ArrayList;
import java.util.List;

public class AuxLib {

	record WordPos (String word, int pos) {}

	/**
	 * Simple (and limited) function to split a sentence into words,
	 * getting the words position too
	 * 
	 * @param sentence
	 * @return
	 */
	static public List<WordPos> getWordsPos(String sentence){
		int from = 0;
		int index = 0;
		var words = sentence.split("\\s+");
		var wordList = new ArrayList<WordPos>();
		
		if (words.length > 0) {
			if (words.length == 1) {
				wordList.add(new WordPos(words[0], 0));
			} else {
				for (var w: words) {					
					var word = w;					
					if (index != 0) {
						word = " " + word;
					}
					
					if (index != words.length - 1) {
						word = word + " ";
					}					
					var pos = sentence.indexOf(word, from);
					
					if (index != 0) {
						pos++;
					}
					wordList.add(new WordPos(w, pos));
					from = pos;
					index++;
				}
			}		
		}
		
		return wordList;
	}
	
}
