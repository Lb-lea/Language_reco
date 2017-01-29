package langModel;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Class MyNgramCounts: class implementing the interface NgramCounts. 
 * 
 * @author N. Hernandez and S. Quiniou (2015)
 *
 */
public class MyNgramCounts implements NgramCounts {
	/**
	 * The maximal order of the n-gram counts.
	 */
	protected int order;

	/**
	 * The map containing the counts of each n-gram.
	 */
	protected Map<String,Integer> ngramCounts;

	/**
	 * The total number of words in the corpus.
	 * In practice, the total number of words will be increased when parsing a corpus 
	 * or when parsing a NgramCounts file (only if the ngram encountered is a unigram one).
	 */
	protected int nbWordsTotal;
	
	
	/**
	 * Constructor.
	 */
	public MyNgramCounts(){
		order = 0;
		ngramCounts = new HashMap<String, Integer>();
		nbWordsTotal = 0;
	}


	/**
	 * Setter of the maximal order of the ngrams considered.
	 * 
	 * In practice, the method will be called when parsing the training corpus, 
	 * or when parsing the NgramCounts file (using the maximal n-gram length encountered).
	 * 
	 * @param order the maximal order of n-grams considered.
	 */
	private void setMaximalOrder (int order) {
		this.order = order;
	}

	
	@Override
	public int getMaximalOrder() {
		return order;
	}

	
	@Override
	public int getNgramCounterSize() {
		return ngramCounts.size();
	}

	
	@Override
	public int getTotalWordNumber(){
		return nbWordsTotal;
	}
	
	
	@Override
	public Set<String> getNgrams() {
		return ngramCounts.keySet();
	}

	
	@Override
	public int getCounts(String ngram) {
		if(ngramCounts.containsKey(ngram))
			return ngramCounts.get(ngram);
		else
			return 0;
	}
	

	@Override
	public void incCounts(String ngram) {

		if(ngramCounts.containsKey(ngram)){
			ngramCounts.put(ngram, ngramCounts.get(ngram)+1);
			if(ngram.split("\\s+").length==1){
				nbWordsTotal++;
			}
		}

		else {

			setCounts(ngram, 1);
		}

	}

	
	@Override
	public void setCounts(String ngram, int counts) {
		ngramCounts.put(ngram, counts);
		if(ngram.split("\\s+").length==1){
			nbWordsTotal+= counts;
		}
	}


	@Override
	public void scanTextString(String text, int maximalOrder) {
		for(String s : text.split("\n")){//Chaque phrase est separee par un \n
			for(String gram : NgramUtil.generateNgrams(s,1, maximalOrder)){
				incCounts(gram);
			}
		}
		setMaximalOrder(maximalOrder);
	}

	
	@Override
	public void scanTextFile(String filePath, int maximalOrder) {
		for(String s : MiscUtil.readTextFileAsStringList(filePath)){
			for(String gram : NgramUtil.generateNgrams(s,1, maximalOrder)){
				incCounts(gram);
			}
		}
		setMaximalOrder(maximalOrder);
	}

	
	@Override
	public void writeNgramCountFile(String filePath) {
		MiscUtil.writeFile("", filePath, false);
		for(String key : ngramCounts.keySet()){
			MiscUtil.writeFile(key.concat("\t").concat(ngramCounts.get(key).toString()).concat("\n"), filePath, true);
		}
		
	}

	
	@Override
	public void readNgramCountsFile(String filePath) {
		int Ordermax = 0;
		for(String ligne : MiscUtil.readTextFileAsStringList(filePath)){
			String[] data = ligne.split("\t");
			String trimmed = data[0].trim();
			int tmp = trimmed.split("\\s+").length;
			setCounts(trimmed,Integer.parseInt(data[1]));
			Ordermax = tmp > Ordermax ? tmp : Ordermax;

		}
		setMaximalOrder(Ordermax);
	}

}
