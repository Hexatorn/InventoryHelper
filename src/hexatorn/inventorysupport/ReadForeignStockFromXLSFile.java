package hexatorn.inventorysupport;

import javafx.collections.ObservableList;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.IOException;

/**
 * Created by Hexatorn on 2017-04-27.
 */
class ReadForeignStockFromXLSFile {
    static void odczyt(MyFile file, ObservableList<Row> obsList) throws IOException, BiffException {
        System.out.println("odczyt Stanu Obcego");
        System.out.println(file.getAbsolutePath());

        Workbook skoroszyt = Workbook.getWorkbook(file.getFile());
        Sheet arkusz = skoroszyt.getSheet(0);

        for(int i = 2;!arkusz.getCell(0, i).getContents().equals("PODSUMOWANIE");i++){
            String skuToCheck = arkusz.getCell(0,i).getContents();
            int qty = Integer.parseInt(arkusz.getCell(6,i).getContents());
            Boolean kodIstniejeWTabeli = false;
            if(qty==0)
                continue;
            for (Row r :obsList) {
                if(r.getKodSKU().equals(skuToCheck)) {
                    kodIstniejeWTabeli = true;
                    r.setQtyForeignStock(r.getQtyForeignStock()+qty);
                    System.out.println("edit "+skuToCheck);
                    break;
                }
            }
            if(!kodIstniejeWTabeli) {
                Row row = new Row(skuToCheck);
                row.setQtyForeignStock(qty);
                obsList.add(row);
                System.out.println("new "+skuToCheck );
            }
        }
        skoroszyt.close();
        System.out.println("Odczyt zakończony sukcesem.");
    }
}
