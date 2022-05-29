package dom;

import java.util.ArrayList;
import java.util.HashSet;

public class Column {
    OutputData outputData = OutputData.getInstance();
    HashSet<Cell> cellsMayBe = new HashSet<>();
    ArrayList<Cell> cellsColumnInIt = new ArrayList<>();
    MayBeValueForSet values;
    int A, C;

    Column(int index, int C) {
        this.A = index;
        this.C = C;
        InIt();
        findValues();
    }

    void InIt() {
        for (int j = 0; j < 9; j++) {
            outputData.outputCellsList.get(A).C = C;
            cellsColumnInIt.add(outputData.outputCellsList.get(A));
            A += 9;
        }
    }

    void findValues() {
        values = new MayBeValueForSet(cellsColumnInIt);
        cellsMayBe = values.mayBeValue();
    }
}
