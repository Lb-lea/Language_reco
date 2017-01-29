package langReco.reco;


import langModel.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MyLanguageRecognizer1 extends LanguageRecognizer {
/**This language recogniser can handle one language model( be it bigram, trigram ..)**/
	private HashMap<String, LanguageModel> models;
	
	public MyLanguageRecognizer1(String fileParam){
		models = new HashMap();
		loadNgramCountPath4Lang (fileParam);
		try {
			FileInputStream fis = new FileInputStream(new File(fileParam));
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			String line;
			while ((line=br.readLine())!=null){
				String[] split = line.split("\\s");
				NgramCounts frNgramCounts = new MyNgramCounts();
				frNgramCounts.readNgramCountsFile(split[2]);
				LanguageModel frllm = new MyLaplaceLanguageModel();
				frllm.setNgramCounts(frNgramCounts);
				
				models.put(split[0], frllm);
				
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String recognizeSentenceLanguage(String sentence) {
		double size = sentence.split(" ").length;
		double max = 0;
		String lan = "ukn";
		for (String s : models.keySet()){
			double proba = models.get(s).getSentenceProb(sentence);
			//System.out.println("langue : "+s+" proba : " + proba +" taille : "+ size);
			if(proba>max){
				max = proba;
				lan = s;
			}
		
		}System.out.println("\n");
		return lan;
	}

}
