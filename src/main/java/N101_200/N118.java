package N101_200;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> first = new LinkedList<>();
        if (numRows >= 1) {
            first.add(1);
            List<Integer> previous = first;
            result.add(first);
            for (int i = 1; i < numRows; i++) {
                List<Integer> current = new LinkedList<>();
                current.add(1);
                for (int j = 0; j < previous.size() - 1; j++) {
                    current.add(previous.get(j) + previous.get(j + 1));
                }
                current.add(1);
                previous = current;
                result.add(current);
            }
        }
        return result;
    }
}
