package dom;

import java.util.HashSet;

public class MayBeUsedValueForCells {
    Cell cell;
    HashSet<Integer> cellsMayBe = new HashSet<>();
    HashSet<Cell> cells_F_List;
    HashSet<Cell> cells_R_List;
    HashSet<Cell> cells_C_List;

    public MayBeUsedValueForCells(HashSet<Cell> list_F, HashSet<Cell> list_R, HashSet<Cell> list_C) {
        this.cells_F_List = list_F;
        this.cells_R_List = list_R;
        this.cells_C_List = list_C;
    }

    public HashSet<Integer> mayBeCellValuesSet() {
        for (int i = 1; i <= 9; i++) {
            cell = new Cell();
            cell.value = i;
            if (cells_F_List.contains(cell) && cells_R_List.contains(cell) && cells_C_List.contains(cell)) {
                cellsMayBe.add(i);
            }
        }
        return cellsMayBe;
    }
}