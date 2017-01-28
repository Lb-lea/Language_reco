package langReco.reco;


import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import langReco.eval.Performance;
import langModel.LanguageModel;
import langModel.MyLaplaceLanguageModel;
import langModel.MyNgramCounts;
import langModel.NgramCounts;


/**
 * Class BaselineLanguageRecognizerTest: JUnit Test class to evaluate the baseline recognition system.
 * 
 * @author N. Hernandez and S. Quiniou (2015)
 *
 */
public class MyLanguageRecognizer1Test {

	@Test
	public void testMyLanguageRecognizer1() {
		String cc = "-2";
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
