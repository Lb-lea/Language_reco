import java.util.ArrayList;
import java.util.List;

/**
 * Created by E154981H on 18/01/17.
 */
public class testing_bin {
    public static void main(String[] args) {
        String sentence = "a b c d e f";
        int minOrder = 1;
        int maxOrder = 3;
        List<String> returned_list = new ArrayList<String>();
        String ngram;
        String[] splitted = sentence.split("\\s+");
        int it_order = 0;
        for (int order = minOrder; order <= maxOrder; order++) {
            for (int i = 0; i < getSequenceSize(sentence) - (order - 1); i++) {
                ngram = "";
                //starting prom our iterator index, we look up until as many word as the order
                for (it_order = i; it_order < i + order; it_order++) {
                    ngram += splitted[it_order] + " ";
                }
                returned_list.add(ngram);
            }
        }
        System.out.println(returned_list.toString());

    }
    public static int getSequenceSize (String sequence) {
        return sequence.split("\\s+").length;
    }
}
