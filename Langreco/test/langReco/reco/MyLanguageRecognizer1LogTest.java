package langReco.reco;


import langReco.eval.Performance;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;


/**
 * Class BaselineLanguageRecognizerTest: JUnit Test class to evaluate the baseline recognition system.
 * 
 * @author N. Hernandez and S. Quiniou (2015)
 *
 */
public class MyLanguageRecognizer1LogTest {

	@Test
	public void testMyLanguageRecognizer1Bigram() {
		//cc = -2 | -10 | -20 | "" = all
		String cc = "";
		String goldSentPath = "data/gold/gold-sent"+cc+".txt";
		String goldLangPath = "data/gold/gold-lang"+cc+".txt";

		
		LanguageRecognizer my1 = new MyLanguageRecognizer1Log("lm/fichConfig_bigram-100.txt");
		// or use the following if you want to consider all the languages
		// LanguageRecognizer baseline = new BaselineLanguageRecognizer();

		String hypLangFilePath = "data/test/gold-test-reco1-log-bi"+cc+".txt";
		my1.recognizeFileLanguage(goldSentPath, hypLangFilePath);
		System.out.printf("System performance = %f\n", Performance.evaluate(goldLangPath, hypLangFilePath));
	}

	@Test
	public void testMyLanguageRecognizer1Trigram() {
		String cc = "";
		String goldSentPath = "data/gold/gold-sent"+cc+".txt";
		String goldLangPath = "data/gold/gold-lang"+cc+".txt";


		LanguageRecognizer my1 = new MyLanguageRecognizer1Log("lm/fichConfig_trigram-100.txt");
		// or use the following if you want to consider all the languages
		// LanguageRecognizer baseline = new BaselineLanguageRecognizer();

		String hypLangFilePath = "data/test/gold-test-reco1-log-tri"+cc+".txt";
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
