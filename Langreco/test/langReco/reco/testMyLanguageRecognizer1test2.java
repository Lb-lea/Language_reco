package langReco.reco;

import langReco.eval.Performance;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * Created by Lea on 29/01/2017.
 */
public class testMyLanguageRecognizer1test2{


    @Test
    public void testMyLanguageRecognizer1test2() {
        String cc = "-20";
        String goldSentPath = "data/gold/gold-sent"+cc+".txt";
        String goldLangPath = "data/gold/gold-lang"+cc+".txt";


        LanguageRecognizer my1 = new MyLanguageRecognizer1("lm/fichConfig_trigram-100.txt");
        // or use the following if you want to consider all the languages
        // LanguageRecognizer baseline = new BaselineLanguageRecognizer();

        String hypLangFilePath = "data/gold/gold-test-tri"+cc+".txt";
        my1.recognizeFileLanguage(goldSentPath, hypLangFilePath);
        System.out.printf("System performance = %f\n", Performance.evaluate(goldLangPath, hypLangFilePath));
    }


    @Rule
    public TestName name = new TestName();


    @Before
    public void printSeparator()
    {
        System.out.println("\n=== " + name.getMethodName() + " =====================");
    }

}


