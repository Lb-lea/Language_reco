package langModel;


import java.util.List;

/**
 * Class MyNaiveLanguageModel: class implementing the interface LanguageModel by creating a naive language model,
 * i.e. a n-gram language model with no smoothing.
 * 
 * @author ... (2015)
 *
 */
public class MyNaiveLanguageModelLog implements LanguageModel {
	/**
	 * The NgramCounts corresponding to the language model.
	 */
	protected NgramCounts ngramCounts;

	/**
	 * The vocabulary of the language model.
	 */
	protected Vocabulary vocabulary;


	/**
	 * Constructor.
	 */
	public MyNaiveLanguageModelLog(){
		this.ngramCounts = new MyNgramCounts();
		this.vocabulary = new MyVocabulary();
	}

	/**
	 * Setter associating the current language model to a NgramCounts object.
	 * It also scans the set of ngrams of the ngram counts structure and builds a vocabulary with it.
	 *
	 * @param ngramCounts the NgramCounts object to set.
	 */
	@Override
	public void setNgramCounts(NgramCounts ngramCounts) {
		this.ngramCounts = ngramCounts;
		this.vocabulary.scanNgramSet(this.ngramCounts.getNgrams());
	}
	/**
	 * Getter of the language model order.
	 * In practice it will get the maximal order of the NgramCounts structure.
	 * @return the maximal order of the language model.
	 */
	@Override
	public int getLMOrder() {
		return this.ngramCounts.getMaximalOrder();
	}
	/**
	 * Getter of the size of the vocabulary.
	 * @return the size of the vocabulary.
	 */
	@Override
	public int getVocabularySize() {
		return this.vocabulary.getSize();
	}
	/**
	 * Method computing and returning the probability of the given n-gram,
	 * using the NgramCounts structure.
	 *
	 * @param ngram the n-gram whose probability to compute.
	 * @return the probability of the given n-gram.
	 */
	@Override
	public Double getNgramProb(String ngram) {
		double occ_count ;
		//getting the the before-lasts words of the ngram (of the size of our model order)
		String before_words = NgramUtil.getHistory(ngram, this.getLMOrder());
		if(before_words.equals("")) {//meaning there nothing before the ngram
			occ_count = this.ngramCounts.getTotalWordNumber();//all words
		} else {
			occ_count = this.ngramCounts.getCounts(before_words);//all occurences of the before_words

		}
		double  occ_ngram = this.ngramCounts.getCounts(ngram);//all occurences of our ngram as a whole

		double prob = 0;
		if(occ_count!=0){//just in case there are no word in the ngram count yet
			 prob = occ_ngram / occ_count;
		}
		return Math.log10(prob);
	}

	/**
	 * Method computing and returning the probability of the given sentence,
	 * according to its n-grams.
	 *
	 * @param sentence the sentence whose probability to compute.
	 * @return the probability of the given sentence.
	 */
	@Override
	public Double getSentenceProb(String sentence) {
		double  prob = 0.0;
		List<String> nGrams = NgramUtil.decomposeIntoNgrams(sentence,this.getLMOrder());
		for(String nGram : nGrams){
			prob = prob + getNgramProb(nGram);
		}
		return -prob;
	}

}
