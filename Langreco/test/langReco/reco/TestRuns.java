package langReco.reco;

import langReco.eval.Performance;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * Created by Lea on 28/01/2017.
 */
public class TestRuns {
    @Test
    public void TestRuns() {
        String goldSentPath = "data/gold/test-sent.txt";
        //test with
        LanguageRecognizer my1 = new MyLanguageRecognizer1("lm/fichConfig_trigram-100.txt");
        LanguageRecognizer my2 = new MyLanguageRecognizer2("lm/ULTIME_CONFIG.txt");
        LanguageRecognizer my3 = new MyLanguageRecognizer3("lm/ULTIME_CONFIG.txt");

        String hypLangFilePath = "data/gold/test-sent-hyp.txt";
        //my1.recognizeFileLanguage(goldSentPath, hypLangFilePath+"1");
        //my2.recognizeFileLanguage(goldSentPath, hypLangFilePath+"2");
        //my3.recognizeFileLanguage(goldSentPath, hypLangFilePath+"3");

    }


    @Rule
    public TestName name = new TestName();


    @Before
    public void printSeparator()
    {
        System.out.println("\n=== " + name.getMethodName() + " =====================");
    }

}
