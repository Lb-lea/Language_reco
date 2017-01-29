package langReco.reco;

import langReco.eval.Performance;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * Created by E154981H on 20/01/17.
 */
public class MyLanguageRecognizer2LogTest {
    @Test
    public void testMyLanguageRecognizer2() {
        //cc = -2 | -10 | -20 | "" = all
        String cc = "";
        String goldSentPath = "data/gold/gold-sent"+cc+".txt";
        String goldLangPath = "data/gold/gold-lang"+cc+".txt";

        //test with
        LanguageRecognizer my1 = new MyLanguageRecognizer2Log("lm/ULTIME_CONFIG.txt");


        String hypLangFilePath = "data/test/gold-test-reco2-log"+cc+".txt";
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
