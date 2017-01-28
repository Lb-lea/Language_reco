import langReco.reco.MyLanguageRecognizer1;


public class test1 {

	public static void main(String[] args) {
		MyLanguageRecognizer1 mlr = new MyLanguageRecognizer1("lm/fichConfig_bigram-100.txt");
		String testSentenceFilePath = "data/gold/gold-sent-10.txt";
		String hypLangFilePath = "data/gold/gold-test-10.txt";
		mlr.recognizeFileLanguage(testSentenceFilePath, hypLangFilePath);
	}

}
