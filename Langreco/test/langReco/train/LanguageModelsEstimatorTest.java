package langReco.train;


import static org.junit.Assert.*;

import java.io.FileWriter;

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
 * @author hernandez-n
 *
 */
public class LanguageModelsEstimatorTest {
	
	public static String trainEnFilePath ="data/train/train-en.txt";
	public static String trainFrFilePath ="data/train/train-fr.txt";
	public static String trainDaFilePath ="data/train/train-da.txt";
	public static String trainDeFilePath ="data/train/train-de.txt";
	public static String trainEsFilePath ="data/train/train-es.txt";
	public static String trainEtFilePath ="data/train/train-et.txt";
	public static String trainLvFilePath ="data/train/train-lv.txt";
	public static String trainNlFilePath ="data/train/train-nl.txt";
	public static String trainPlFilePath ="data/train/train-pl.txt";
	public static String trainSvFilePath ="data/train/train-sv.txt";
	public static String lmEnFilePath = "-100-train-en.lm";
	public static String lmFrFilePath = "-100-train-fr.lm";
	public static String lmDaFilePath = "-100-train-da.lm";
	public static String lmDeFilePath = "-100-train-de.lm";
	public static String lmEsFilePath = "-100-train-es.lm";
	public static String lmEtFilePath = "-100-train-et.lm";
	public static String lmLvFilePath = "-100-train-lv.lm";
	public static String lmNlFilePath = "-100-train-nl.lm";
	public static String lmPlFilePath = "-100-train-pl.lm";
	public static String lmSvFilePath = "-100-train-sv.lm";

	/**
	 * Duplicate this method as many times as you want to create a language model.
	 * Give it an explicit name with respect to the created language model e.g. testCreateLmWordLangEnOrder3
	 * to create a language model with words from texts in English and order 3.
	 */
	@Test
	public void testCreateLmWordLangEnOrder3() {
		NgramCounts enNgramCounts3 = new MyNgramCounts();
		enNgramCounts3.scanTextFile(trainEnFilePath, 3);
		String lmEnFilePath3 = "lm/trigram"+lmEnFilePath;
		enNgramCounts3.writeNgramCountFile(lmEnFilePath3);		
	}
	
	/**
	 * Duplicate this method as many times as you want to create a language model.
	 * Give it an explicit name with respect to the created language model e.g. testCreateLmWordLangEnOrder3
	 * to create a language model with words from texts in English and order 3.
	 */
	@Test
	public void testCreateLmWordLangFrOrder3() {
		NgramCounts frNgramCounts3 = new MyNgramCounts();
		frNgramCounts3.scanTextFile(trainFrFilePath, 3);
		String lmFrFilePath3 = "lm/trigram"+lmFrFilePath;
		frNgramCounts3.writeNgramCountFile(lmFrFilePath3);		
	}

	/**
	 * Duplicate this method as many times as you want to create a language model.
	 * Give it an explicit name with respect to the created language model e.g. testCreateLmWordLangEnOrder3
	 * to create a language model with words from texts in English and order 3.
	 */
	@Test
	public void testCreateLmWordLangDaOrder3() {
		NgramCounts daNgramCounts3 = new MyNgramCounts();
		daNgramCounts3.scanTextFile(trainDaFilePath, 3);
		String lmDaFilePath3 = "lm/trigram"+lmDaFilePath;
		daNgramCounts3.writeNgramCountFile(lmDaFilePath3);	
	}
	
	/**
	 * Duplicate this method as many times as you want to create a language model.
	 * Give it an explicit name with respect to the created language model e.g. testCreateLmWordLangEnOrder3
	 * to create a language model with words from texts in English and order 3.
	 */
	@Test
	public void testCreateLmWordLangDeOrder3() {
		NgramCounts deNgramCounts3 = new MyNgramCounts();
		String trainDeFilePath = "data/train/train-de.txt";
		deNgramCounts3.scanTextFile(trainDeFilePath, 3);
		String lmDeFilePath = "lm/trigram-100-train-de.lm";
		deNgramCounts3.writeNgramCountFile(lmDeFilePath);		
	}
	
	/**
	 * Duplicate this method as many times as you want to create a language model.
	 * Give it an explicit name with respect to the created language model e.g. testCreateLmWordLangEnOrder3
	 * to create a language model with words from texts in English and order 3.
	 */
	@Test
	public void testCreateLmWordLangEsOrder3() {
		NgramCounts esNgramCounts3 = new MyNgramCounts();
		String trainEsFilePath = "data/train/train-es.txt";
		esNgramCounts3.scanTextFile(trainEsFilePath, 3);
		String lmEsFilePath = "lm/trigram-100-train-es.lm";
		esNgramCounts3.writeNgramCountFile(lmEsFilePath);		
	}
	
	/**
	 * Duplicate this method as many times as you want to create a language model.
	 * Give it an explicit name with respect to the created language model e.g. testCreateLmWordLangEnOrder3
	 * to create a language model with words from texts in English and order 3.
	 */
	@Test
	public void testCreateLmWordLangEtOrder3() {
		NgramCounts etNgramCounts3 = new MyNgramCounts();
		etNgramCounts3.scanTextFile(trainEtFilePath, 3);
		String lmEtFilePath3 = "lm/trigram"+lmEtFilePath;
		etNgramCounts3.writeNgramCountFile(lmEtFilePath3);	
	}
	
	/**
	 * Duplicate this method as many times as you want to create a language model.
	 * Give it an explicit name with respect to the created language model e.g. testCreateLmWordLangEnOrder3
	 * to create a language model with words from texts in English and order 3.
	 */
	@Test
	public void testCreateLmWordLangLvOrder3() {
		NgramCounts lvNgramCounts3 = new MyNgramCounts();
		lvNgramCounts3.scanTextFile(trainLvFilePath, 3);
		String lmLvFilePath3 = "lm/trigram"+lmLvFilePath;
		lvNgramCounts3.writeNgramCountFile(lmLvFilePath3);	
	}
	
	/**
	 * Duplicate this method as many times as you want to create a language model.
	 * Give it an explicit name with respect to the created language model e.g. testCreateLmWordLangEnOrder3
	 * to create a language model with words from texts in English and order 3.
	 */
	@Test
	public void testCreateLmWordLangNlOrder3() {
		NgramCounts nlNgramCounts3 = new MyNgramCounts();
		nlNgramCounts3.scanTextFile(trainNlFilePath, 3);
		String lmNlFilePath3 = "lm/trigram"+lmNlFilePath;
		nlNgramCounts3.writeNgramCountFile(lmNlFilePath3);		
	}
	
	/**
	 * Duplicate this method as many times as you want to create a language model.
	 * Give it an explicit name with respect to the created language model e.g. testCreateLmWordLangEnOrder3
	 * to create a language model with words from texts in English and order 3.
	 */
	@Test
	public void testCreateLmWordLangPlOrder3() {
		NgramCounts plNgramCounts3 = new MyNgramCounts();
		plNgramCounts3.scanTextFile(trainPlFilePath, 3);
		String lmPlFilePath3 = "lm/trigram"+lmPlFilePath;
		plNgramCounts3.writeNgramCountFile(lmPlFilePath3);	
	}


	/**
	 * Duplicate this method as many times as you want to create a language model.
	 * Give it an explicit name with respect to the created language model e.g. testCreateLmWordLangEnOrder3
	 * to create a language model with words from texts in English and order 3.
	 */
	@Test
	public void testCreateLmWordLangSvOrder3() {
		NgramCounts svNgramCounts3 = new MyNgramCounts();
		svNgramCounts3.scanTextFile(trainSvFilePath, 3);
		String lmSvFilePath3 = "lm/trigram"+lmSvFilePath;
		svNgramCounts3.writeNgramCountFile(lmSvFilePath3);	
	}
	
	@Test
	public void testConfigTrigram(){
		try{
			FileWriter fw = new FileWriter("lm/fichConfig_trigram-100.txt");
				fw.append("en\ten_tri\tlm/trigram"+lmEnFilePath+"\n");
				fw.append("fr\tfr_tri\tlm/trigram"+lmFrFilePath+"\n");
				fw.append("da\tda_tri\tlm/trigram"+lmDaFilePath+"\n");
				fw.append("de\tde_tri\tlm/trigram"+lmDeFilePath+"\n");
				fw.append("es\tes_tri\tlm/trigram"+lmEsFilePath+"\n");
				fw.append("et\tet_tri\tlm/trigram"+lmEtFilePath+"\n");
				fw.append("lv\tlv_tri\tlm/trigram"+lmLvFilePath+"\n");
				fw.append("nl\tnl_tri\tlm/trigram"+lmNlFilePath+"\n");
				fw.append("pl\tpl_tri\tlm/trigram"+lmPlFilePath+"\n");
				fw.append("sv\tsv_tri\tlm/trigram"+lmSvFilePath+"\n");
				fw.close();
			}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConfigAll(){
		try{
			FileWriter fw = new FileWriter("lm/ULTIME_CONFIG.txt");
				fw.append("fichConfig_bigram-100.txt\n");
				fw.append("fichConfig_trigram-100.txt\n");
				fw.close();
			}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	@Rule
	public TestName name = new TestName();

	
	@Before
	public void printSeparator()
	{
		System.out.println("\n=== " + name.getMethodName() + " =====================");
	}

}
