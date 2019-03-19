package N101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--)
                row.set(j, row.get(j - 1) + row.get(j));
            row.add(1);
        }
        return row;
    }
}
