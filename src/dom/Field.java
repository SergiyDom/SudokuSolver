package dom;

import java.util.ArrayList;
import java.util.HashSet;

public class Field {
    OutputData outputData = OutputData.getInstance();
    HashSet<Cell> cellsMayBe = new HashSet<>();
    ArrayList<Cell> cellsFieldInIt = new ArrayList<>();
    MayBeValueForSet values;
    int A, F;

    Field(int index, int F) {
        this.A = index;
        this.F = F;
        InIt();
        findValues();
    }

    void InIt() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                outputData.outputCellsList.get(A).F = F;
                cellsFieldInIt.add(outputData.outputCellsList.get(A));
                A += 1;
            }
            A += 6;
        }
    }

    void findValues() {
        values = new MayBeValueForSet(cellsFieldInIt);
        cellsMayBe = values.mayBeValue();
    }
}
