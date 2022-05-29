package dom;

import java.util.ArrayList;
import java.util.HashSet;

public class Definition {
    ArrayList<Cell> list = new ArrayList<>();
    Cell cell = new Cell();

    void def() {
        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 10; j++) {
                if (list.get(i).maybeUsedValueList.contains(j) && !list.get(i + 1).maybeUsedValueList.contains(j)) {

                }
            }
        }
    }

}
