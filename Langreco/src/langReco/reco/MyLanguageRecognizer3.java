package langReco.reco;

import langModel.LanguageModel;
import langModel.MyLaplaceLanguageModel;
import langModel.MyNgramCounts;
import langModel.NgramCounts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * This LG is able to compute 2 or more level of language models.*/

public class MyLanguageRecognizer3 extends LanguageRecognizer {



    private HashMap<String, ArrayList<LanguageModel>> models;

    //fileParam = bigAssConfig
    public MyLanguageRecognizer3(String fileParam){
        models = new HashMap();

        try {
            BufferedReader brGros=new BufferedReader(new FileReader(fileParam));
            String line;
            while ((line=brGros.readLine())!=null){
                BufferedReader brPetit=new BufferedReader(new FileReader(line));
                String smallLine;
                while((smallLine=brPetit.readLine())!=null){
                    String[] split = smallLine.split("\\s");
                    NgramCounts NgramCounts = new MyNgramCounts();
                    NgramCounts.readNgramCountsFile(split[2]);
                    LanguageModel llm = new MyLaplaceLanguageModel();
                    llm.setNgramCounts(NgramCounts);
                    ArrayList<LanguageModel> tmpArr = models.get(split[0]);
                    if (tmpArr == null)
                        tmpArr = new ArrayList();
                    tmpArr.add(llm);
                    models.put(split[0], tmpArr);
                }
                brPetit.close();
            }
            brGros.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String recognizeSentenceLanguage(String sentence) {
        double max = 0.0;
        String lan = "unk";
        for (String lang : models.keySet()){
            ArrayList<LanguageModel> tmpArr = models.get(lang);
            double proba1 = tmpArr.get(0).getSentenceProb(sentence);
            double proba2 = tmpArr.get(1).getSentenceProb(sentence);
            double res = proba2/proba1;
            if(res>max){
                max = res;
                lan = lang;
            }
        }
        return lan;
    }

}

