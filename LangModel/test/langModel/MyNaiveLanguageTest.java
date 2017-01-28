package langModel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by E154981H on 20/01/17.
 */
public class MyNaiveLanguageTest {
    public MyNaiveLanguageModel set(){
        MyNgramCounts ngramC = new MyNgramCounts();
        String texte = "<s> bonjour </s>\n<s> Ce cours est enlisant </s>\n<s> La carottes est cuite </s>\n" +
                "<s> le lapin est la </s>";
        ngramC.scanTextString(texte, 2);
        MyNaiveLanguageModel nlm = new MyNaiveLanguageModel();
        nlm.setNgramCounts(ngramC);
        return  nlm;
    }



    @Test
    public void testGetNgramProb() {
        MyNaiveLanguageModel nlm = this.set();
        System.out.println(nlm.getNgramProb("Ce cours"));
        assertEquals(1, (double) nlm.getNgramProb("Ce cours"), 0.001);//dela =precision
        System.out.println(nlm.getNgramProb("poule"));
        assertEquals(0, (double) nlm.getNgramProb("poule"), 0.001);//dela =precision
        System.out.println(nlm.getNgramProb("Ce enlisant"));
        assertEquals(0, (double) nlm.getNgramProb("Ce enlisant"), 0.001);//dela =precision
    }

    @Test
    public void testSentenceProb() {
        MyNaiveLanguageModel nlm = this.set();
        System.out.println(nlm.getSentenceProb("<s> Ce cours est la </s>"));
        assertEquals(0.008,(double)nlm.getSentenceProb("<s> Ce cours est la </s>"),0.001);//dela =precision
    }

}
