package dom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Sheet {
    private static Sheet instance;
    OutputData outputData;
    ArrayList<Field> fields;
    ArrayList<Row> rows;
    ArrayList<Column> columns;
    MayBeUsedValueForCells valueCellList;

    private Sheet() {
    }

    public static Sheet getInstance() {
        if (instance == null) {
            instance = new Sheet();
        }
        return instance;
    }

    void inIt() {
        outputData = OutputData.getInstance();
        fields = new ArrayList<>();
        rows = new ArrayList<>();
        columns = new ArrayList<>();
        int index_F = 0;
        int numberFieldForCell = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fields.add(new Field(index_F, numberFieldForCell));
                index_F += 3;
                numberFieldForCell++;
            }
            index_F += 18;
        }

        int index_R = 0;
        int numberRowForCell = 0;
        for (int i = 0; i < 9; i++) {
            rows.add(new Row(index_R, numberRowForCell));
            index_R += 9;
            numberRowForCell++;
        }

        int index_C;
        int numberColumnForCell = 0;
        for (int i = 0; i < 9; i++) {
            index_C = i;
            columns.add(new Column(index_C, numberColumnForCell));
            numberColumnForCell++;
        }
    }

    void findAllValueForCellMayBeUsed() {
        for (int cellNumber = 0; cellNumber < 81; cellNumber++) {
            Cell cell = outputData.outputCellsList.get(cellNumber);
            if (cell.value == 0) {
                int fieldNumber = cell.F;
                int rowNumber = cell.R;
                int columnNumber = cell.C;

                valueCellList = new MayBeUsedValueForCells(fields.get(fieldNumber).cellsMayBe, rows.get(rowNumber).cellsMayBe, columns.get(columnNumber).cellsMayBe);
                cell.maybeUsedValueList = valueCellList.mayBeCellValuesSet();

//                 System.out.println("MayBeUsedValue for Cell #" + cellNumber + " " + cell.maybeUsedValueList);
            } else {
                cell.maybeUsedValueList.add(cell.value);
            }
        }
    }

    void definitionSet() {
        HashSet<Integer> finalCellValueForRow;
        HashSet<Integer> finalCellValueForColumn;
        HashSet<Integer> finalCellValue;
        HashSet<Integer> row;
        HashSet<Integer> column;
        for (int cellNumber = 0; cellNumber < 81; cellNumber++) {
            Cell cell = outputData.outputCellsList.get(cellNumber);
            if (cell.value == 0) {
                int rowNumber = cell.R;
                int columnNumber = cell.C;
                row = rows.get(rowNumber).cellsRowInIt.get(columnNumber).maybeUsedValueList;
                column = columns.get(columnNumber).cellsColumnInIt.get(rowNumber).maybeUsedValueList;
                finalCellValueForRow = new HashSet<>();
                finalCellValueForColumn = new HashSet<>();
                finalCellValue = new HashSet<>();
                for (int i = 0; i < 9; i++) {
                    int I = i + 1;
                    if (row.contains(I)) {
                        int count = 0;
                        for (int j = 0; j < 9; j++) {
                            HashSet<Integer> rowCheck = rows.get(rowNumber).cellsRowInIt.get(j).maybeUsedValueList;
                            if (!rowCheck.contains(I)) {
                                finalCellValueForRow.add(I);
                            } else {
                                count++;
                                if (count > 1) {
                                    finalCellValueForRow.remove(I);
                                    break;
                                }
                            }
                        }
                    }
                    if (column.contains(I)) {
                        int count = 0;
                        for (int j = 0; j < 9; j++) {
                            HashSet<Integer> columnCheck = columns.get(columnNumber).cellsColumnInIt.get(j).maybeUsedValueList;
                            if (!columnCheck.contains(I)) {
                                finalCellValueForColumn.add(I);
                            } else {
                                count++;
                                if (count > 1) {
                                    finalCellValueForColumn.remove(I);
                                    break;
                                }
                            }
                        }
                    }
                }
                for (int i = 1; i < 10; i++) {
                    if (finalCellValueForRow.contains(i) || finalCellValueForColumn.contains(i)) {
                        finalCellValue.add(i);
                    }
                }
                cell.defVelue = finalCellValue;
//                System.out.println("!MayBeValue for Cell #" + cellNumber + " " + cell.defVelue);
//                System.out.println("finalCellValueForRow #" + cellNumber + " " + finalCellValueForRow);
//                System.out.println("finalCellValueForColumn #" + cellNumber + " " + finalCellValueForColumn);
//                System.out.println("finalCellValue #" + cellNumber + " " + finalCellValue);
            }
        }
    }

    void definitionCell() {
        int count = 0;
        for (int cellNumber = 0; cellNumber < 81; cellNumber++) {
            Cell cell = outputData.outputCellsList.get(cellNumber);
            if (cell.defVelue.size() == 1) {
                count++;
                Iterator<Integer> i = cell.defVelue.iterator();
                while (i.hasNext()) {
                    int v = i.next();
                    cell.value = v;
                    cell.maybeUsedValueList.clear();
                    cell.maybeUsedValueList.add(v);
                    cell.defVelue.clear();
                }
            }
        }
        if (count == 0) {
            perebor();
        }
    }

    void perebor() {
        int count = 0;
        for (int cellNumber = 0; cellNumber < 81; cellNumber++) {
            Cell cell = outputData.outputCellsList.get(cellNumber);
            if (cell.maybeUsedValueList.size() > 1) {
                count++;
                int v = 0;
                Iterator<Integer> i = cell.maybeUsedValueList.iterator();
                while (i.hasNext()) {
                    v = i.next();
                    cell.value = v;
                }
                cell.defVelue.clear();
                cell.maybeUsedValueList.clear();
                cell.maybeUsedValueList.add(v);
                break;
            }
        }
        if (count == 0) {
            System.out.println("ERROR PEREBOR!!!!!!!!!!!");
        }
    }
}
