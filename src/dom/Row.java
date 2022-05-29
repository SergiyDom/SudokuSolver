package dom;

import java.util.ArrayList;
import java.util.HashSet;

public class Row {
    OutputData outputData = OutputData.getInstance();
    HashSet<Cell> cellsMayBe = new HashSet<>();
    ArrayList<Cell> cellsRowInIt = new ArrayList<>();
    MayBeValueForSet values;
    int A, R;

    Row(int index, int R) {
        this.A = index;
        this.R = R;
        InIt();
        findValues();
    }

    void InIt() {
        for (int j = 0; j < 9; j++) {
            outputData.outputCellsList.get(A).R = R;
            cellsRowInIt.add(outputData.outputCellsList.get(A));
            A += 1;
        }
    }

    void findValues() {
        values = new MayBeValueForSet(cellsRowInIt);
        cellsMayBe = values.mayBeValue();
    }
}