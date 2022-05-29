package dom;

import java.util.ArrayList;
import java.util.HashSet;

public class MayBeValueForSet {
    Cell cell;
    HashSet<Cell> cellsMayBe = new HashSet<>();
    ArrayList<Cell> cellsList;

    MayBeValueForSet(ArrayList<Cell> list) {
        this.cellsList = list;
    }

    public HashSet<Cell> mayBeValue() {
        for (int i = 1; i <= 9; i++) {
            cell = new Cell();
            cell.value = i;
            if (!cellsList.contains(cell)) {
                cellsMayBe.add(cell);
            }
        }
        return cellsMayBe;
    }
}
