package langModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Set;
import java.util.TreeSet;

import static langModel.MiscUtil.readTextFileAsStringList;


/**
 * Class MyVocabulary: class implementing the interface Vocabulary.
 * 
 * @author ... (2015)
 *
 */
public class MyVocabulary implements Vocabulary {
	/**
	 * The set of words corresponding to the vocabulary.
	 */
	protected Set<String> vocabulary;

	
	/**
	 * Constructor.
	 */
	public MyVocabulary(){
		vocabulary = new TreeSet<String>();
	}
	
	
	@Override
	public int getSize() {
		return vocabulary.size();
	}

	@Override
	public Set<String> getWords() {
		return vocabulary;
	}

	@Override
	public boolean contains(String word) {
		return vocabulary.contains(word);
	}

	@Override
	public void addWord(String word) {
		vocabulary.add(word);
		
	}

	@Override
	public void removeWord(String word) {
		vocabulary.remove(word);
		
	}

	@Override
	public void scanNgramSet(Set<String> ngramSet) {
		for(String s : ngramSet){
			for(String w : s.split("\\s+")){
				addWord(w);
			}
		}
		
		
	}

	@Override
	public void readVocabularyFile(String filePath) {
		for(String line :readTextFileAsStringList(filePath)){
			addWord(line);
		}
		
	}

	@Override
	public void writeVocabularyFile(String filePath) {
		MiscUtil.writeFile("", filePath, false);
		for(String mot : vocabulary){
			MiscUtil.writeFile(mot.concat("\n"), filePath, true);
		}
	}

}
