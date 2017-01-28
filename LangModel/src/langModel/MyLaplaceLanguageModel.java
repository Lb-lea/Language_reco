package langModel;


/**
 * Class MyLaplaceLanguageModel: class inheriting the class MyNaiveLanguageModel by creating 
 * a n-gram language model using a Laplace smoothing.
 * 
 * @author ... (2015)
 *
 */
public class MyLaplaceLanguageModel extends MyNaiveLanguageModel {

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

		//Lissage
		occ_ngram ++;
		occ_count += this.ngramCounts.getTotalWordNumber();

		double prob = 0;
		for (String check : ngram.split("\\s+")){	//If one word is unknow, return 0
			if (!this.ngramCounts.getNgrams().contains(check)){
				return prob;
			}
		}
			prob = occ_ngram / occ_count;
		return prob;
	}
}
