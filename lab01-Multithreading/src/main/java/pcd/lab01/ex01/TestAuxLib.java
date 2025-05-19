package pcd.lab01.ex01;

import static pcd.lab01.ex01.AuxLib.*;

public class TestAuxLib {

	public static void main(String[] args) {
		
		var sentence = "This is a simple sentence with words ready to fall";

		var wordList = getWordsPos(sentence);
		
		for (var wp: wordList) {
			System.out.println("Word: " + wp.word() + " -- Pos: " + wp.pos());
		}		
	}

}
