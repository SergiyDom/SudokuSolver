package dom;

public class Print {
    Sheet sheet;
    OutputData outputData;

    Print(Sheet sheet) {
        this.sheet = sheet;
    }

    Print(OutputData data) {
        this.outputData = data;
    }


    public void print_Sheet() {
        int cellCounter = 0;
        int fieldCounter = 0;
        for (int k = 0; k < 3; k++) {
            while (cellCounter < 9) {
                for (int i = fieldCounter; i <= fieldCounter + 2; i++) {
                    for (int j = cellCounter; j <= cellCounter + 2; j++) {
                        System.out.print(sheet.fields.get(i).cellsFieldInIt.get(j).value + " ");
                    }
                    System.out.print(" ");
                }
                System.out.println();
                cellCounter += 3;
            }
            cellCounter = 0;
            fieldCounter += 3;
            System.out.println();
        }
    }

    public void print_OutputData() {
        int A = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(outputData.outputCellsList.get(A).value + " ");
                A += 1;
                if (j == 2 || j == 5) System.out.print(" ");
            }
            System.out.println();
            if (i == 2 || i == 5) System.out.println();
        }
    }
}
