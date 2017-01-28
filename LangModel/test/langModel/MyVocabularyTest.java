package langModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import static org.junit.Assert.*;
import java.util.TreeSet;

public class MyVocabularyTest {

	@Test
	public void testVocabulaire() {
		MyVocabulary voc1 = new MyVocabulary();
		voc1.addWord("lel");
		TreeSet<String> sset = new TreeSet<String>();
		sset.add("bonjour");
		sset.add("adieu");
		sset.add("cheval");
		sset.add("Martine mange des lasagnes");
		voc1.scanNgramSet(sset);
		
		voc1.writeVocabularyFile("test/langModel/voc.txt");
		assertEquals(8,voc1.getSize());

		MyVocabulary voc2 = new MyVocabulary();
		voc2.readVocabularyFile("test/langModel/voc.txt");
		assertEquals(8,voc1.getSize());
		assertTrue(voc2.contains("bonjour"));
		voc2.removeWord("bonjour");
		assertFalse(voc2.contains("bonjour"));
	}



	/**
	 * The following code displays a separator
	 * between each method output
	 *
	 * (manually added)
	 **/
	@Rule
	public TestName name = new TestName();

	@Before
	public void printSeparator()
	{
		System.out.println("\n=== " + name.getMethodName() + " =====================");
	}


}
