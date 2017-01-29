package langReco.reco;


import langModel.*;

import java.util.HashMap;
import java.util.Map;

public class MyLanguageRecognizer1Log extends LanguageRecognizer {
/**This language recogniser can handle one language model( be it bigram, trigram ..)**/
	private HashMap<String, LanguageModel> models;

	public MyLanguageRecognizer1Log(String fileParam){
		models = new HashMap();

		loadNgramCountPath4Lang (fileParam);
		for (String lang: langNgramCountMap.keySet()){
			Map<String, String> hashTmp = langNgramCountMap.get(lang);
			for(String gram: hashTmp.keySet()){
				NgramCounts newNgram = new MyNgramCounts();
				newNgram.readNgramCountsFile(hashTmp.get(gram));
				LanguageModel newModel = new MyLaplaceLanguageModelLog();
				newModel.setNgramCounts(newNgram);

				models.put(lang,newModel);
			}
		}
	}
	
	@Override
	public String recognizeSentenceLanguage(String sentence) {
		double max = 0;
		String lan = "unk";
		for (String s : models.keySet()){

			double proba = models.get(s).getSentenceProb(sentence);
			if(proba>max){
				max = proba;
				lan = s;
			}
		
		}
		return lan;
	}

}
