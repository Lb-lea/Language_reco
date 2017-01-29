package langModel;


import java.util.ArrayList;
import java.util.List;


/**
 * Class NgramUtil: class containing useful functions to deal with n-grams.
 * 
 * @author N. Hernandez and S. Quiniou (2015)
 *
 */
public class NgramUtil {

	/**
	 * Method counting the number of words in a given sequence 
	 * (the sequence can be a n-gram or a sentence).
	 * 
	 * @param sequence the sequence to consider.
	 * @return the number of words of the given sequence.
	 */
	public static int getSequenceSize (String sequence) {
		return sequence.split("\\s+").length;
	}

	
	/**
	 * Method parsing a n-gram and returning its history, i.e. the n-1 preceding words.
	 * 
	 * Example: 
	 *   let the ngram be "l' historique de cette phrase";
	 *   the history will be given for the last word of the ngram, here "phrase":
	 *   if the order is 2 then the history will be "cette"; 
	 *   if the order is 3 then it will be "de cette".
	 * 
	 * @param ngram the n-gram to consider.
	 * @param order the order to consider for the n-gram.
	 * @return history of the given n-gram (the length of the history is order-1).  
	 */
	public static String getHistory (String ngram, int order) {
		String ret_String= "";
		if (order > 1){//otherwise the history is empty
			String[] splitted  = ngram.split("\\s+");
			if(splitted.length >1)//otherwise there is no history
			{
				// We read the ngram from [size-order or 0]until the beforelast index
				for (int i = Math.max(getSequenceSize(ngram)-order,0) ; i < getSequenceSize(ngram)-1; i++) {
					ret_String += splitted[i]+" ";
				}
				ret_String = ret_String.trim();//deleting that extra space
			}

		}
		return ret_String;
	}


	/**
	 * Method decomposing the given sentence into n-grams of the given order.
	 * 
	 * This method will be used in the LanguageModel class for computing 
	 * the probability of a sentence as the product of the probabilities of its n-grams. 
	 * 
	 * Example
	 * given the sentence "a b c d e f g", with order=3,
	 * it will result in the following list:
	 * [a, a b, a b c, b c d, c d e, d e f, e f g] 
	 * 
	 * @param sentence the sentence to consider.
	 * @param order the maximal order for the n-grams to create from the sentence.
	 * @return the list of n-grams constructed from the sentence.
	 */
	public static List<String> decomposeIntoNgrams (String sentence, int order) {
		String[] splitted  = sentence.split("\\s+");
		List<String> returned_list = new ArrayList<String>();
		//First we add the firsts n-grams that are shorter than the actual order
		int it_order = 0; //iterator
		String ngram;
		while( it_order < order -1) {
			ngram = "";
			for (int i = 0; i <= it_order; i++) {
				ngram+= splitted[i]+" ";
			}
			ngram = ngram.trim();
			returned_list.add(ngram);
			it_order++;
		}
		///////
		//Now we add the ngrams that matches the  order length
		for (int i = 0; i < getSequenceSize(sentence)-(order-1) ; i++) {
			ngram = "";
			//starting prom our iterator index, we look up until as many word as the order
			for (it_order = i; it_order < i + order; it_order++) {
				ngram+= splitted[it_order]+" ";
			}
			ngram = ngram.trim();
			returned_list.add(ngram);//cutting extra space at the end
		}
		return returned_list;
	}
	
	
	/**
	 * Method parsing the given sentence and generate all the combinations of ngrams,
	 * by varying the order n between the given minOrder and maxOrder.
	 * 
	 * This method will be used in the NgramCount class for counting the ngrams 
	 * occurring in a corpus.
	 * 
	 * Algorithm (one possible algo...)
	 * initialize list of ngrams
	 * for n = minOrder to maxOrder (for each order)
	 * 	 for i = 0 to sentence.length-n (parse the whole sentence)
	 *     initialize ngram string parsedSentence
	 *     for j = i to i+n-1 (create a ngram made of the following sequence of words starting from i to i + the order size)
	 *       ngram = ngram + " " + sentence[j]
	 *     add ngramm to list ngrams 
	 * return list ngrams
	 * 
	 * Example
	 * given the sentence "a b c d e f g", with minOrder=1 and maxOrder=3, it will result in the following list:
	 * [a, b, c, d, e, f, g, a b, b c, c d, d e, e f, f g, a b c, b c d, c d e, d e f, e f g]
	 * 
	 * @param sentence the sentence from which to generate n-grams.
	 * @param minOrder the minimal order of the n-grams to create.
	 * @param maxOrder the maximal order of the n-grams to create.
	 * @return a list of generated n-grams from the sentence.
	 */
	public static List<String> generateNgrams (String sentence, int minOrder, int maxOrder) {
		List<String> returned_list = new ArrayList<String>();
		String ngram;
		String[] splitted  = sentence.split("\\s+");
		int it_order = 0;
		for(int order = minOrder; order <= maxOrder; order++)
		{
			for (int i = 0; i < getSequenceSize(sentence)-(order-1) ; i++) {
				ngram = "";
				//starting from our iterator index, we look up until as many word as the order
				for (it_order = i; it_order < i + order; it_order++) {
					ngram+= splitted[it_order]+" ";
				}
				ngram = ngram.trim();
				returned_list.add(ngram);//we cut the last car because it is an extra space
			}
		}
		return returned_list;
	}

}
