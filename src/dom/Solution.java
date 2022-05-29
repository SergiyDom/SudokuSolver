package dom;

import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        Sheet sheet = Sheet.getInstance();
        Print print_1 = new Print(sheet);
        Cell cell = new Cell();

        sheet.inIt();
        System.out.println("##OutPutData##");
        print_1.print_Sheet();

        System.out.println("--------");

        cell.value = 0;
        int c = 0;
        boolean stop = true;

        Date statr = new Date();

        while (stop) {
            sheet.inIt();
            sheet.findAllValueForCellMayBeUsed();
            sheet.definitionSet();
            sheet.definitionCell();
            c++;
            stop = sheet.outputData.outputCellsList.contains(cell);
        }
        Date finish = new Date();
        long time = finish.getTime() - statr.getTime();
//
        System.out.println("##FINAL## " + c + " iteration");
        System.out.println("time left: " + time + "ms");
        print_1.print_Sheet();


//        OutputData outputData = OutputData.getInstance();
//        System.out.println("outPutData - start");
//        print_2.print_2();
//        Print print_2 = new Print(outputData);
//        System.out.println("cellsFieldMayBe " + sheet.fields.get(0).cellsMayBe);
//        System.out.println("cellsRowMayBe " + sheet.rows.get(0).cellsMayBe);
//        System.out.println("cellsColumnMayBe " + sheet.columns.get(0).cellsMayBe);
    }
}

