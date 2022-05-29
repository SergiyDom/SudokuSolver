package dom;

import java.util.ArrayList;

public class OutputData {
    private static OutputData instance;
    ArrayList<Cell> outputCellsList = new ArrayList<>();

    private OutputData() {
        inIt();
    }

    public static OutputData getInstance() {
        if (instance == null) {
            instance = new OutputData();
        }
        return instance;
    }
    public void inIt(){
        for (int i = 0; i < 81; i++) {
            outputCellsList.add(new Cell());
        }
        outputCellsList.get(7).value = 1;
        outputCellsList.get(8).value = 4;
        outputCellsList.get(14).value = 3;
        outputCellsList.get(16).value = 8;
        outputCellsList.get(17).value = 5;
        outputCellsList.get(18).value = 8;
        outputCellsList.get(20).value = 1;
        outputCellsList.get(22).value = 2;
        outputCellsList.get(26).value = 7;

        outputCellsList.get(30).value = 5;
        outputCellsList.get(32).value = 7;
        outputCellsList.get(38).value = 4;
        outputCellsList.get(42).value = 1;
        outputCellsList.get(46).value = 9;

        outputCellsList.get(54).value = 5;
        outputCellsList.get(61).value = 7;
        outputCellsList.get(62).value = 2;
        outputCellsList.get(65).value = 2;
        outputCellsList.get(67).value = 1;
        outputCellsList.get(76).value = 4;
        outputCellsList.get(80).value = 1;
    }
}
