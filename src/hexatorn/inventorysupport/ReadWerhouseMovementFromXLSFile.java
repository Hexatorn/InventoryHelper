package hexatorn.inventorysupport;

import javafx.collections.ObservableList;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

/**
 * Created by Hexatorn on 2017-04-26.
 */
class ReadWerhouseMovementFromXLSFile {


    static void odczyt(MyFile file, ObservableList<Row> obsList) throws IOException, BiffException {
        System.out.println("Wczytywanie Rócghów Magazynowych");
        System.out.println(file.getAbsolutePath());

        Workbook skoroszyt = Workbook.getWorkbook(file.getFile());
        Sheet arkusz = skoroszyt.getSheet(0);

        for(int i = 2;!arkusz.getCell(0, i).getContents().equals("PODSUMOWANIE");i++){
            String skuToCheck = arkusz.getCell(0,i).getContents();
            int wartoscQtyPlus = Integer.parseInt(arkusz.getCell(6,i).getContents());
            System.out.println(wartoscQtyPlus);
            int wartoscQtyMinus = Integer.parseInt(arkusz.getCell(8,i).getContents())*-1;
            Boolean kodIstniejeWTabeli = false;
            if(wartoscQtyMinus+wartoscQtyPlus==0)
                continue;
            for (Row r :obsList) {
                if(r.getKodSKU().equals(skuToCheck)) {
                    kodIstniejeWTabeli = true;
                    r.setQtyWerhouseMovement(r.getQtyWerhouseMovement()+wartoscQtyPlus+wartoscQtyMinus);
                    break;
                }
            }
            if(!kodIstniejeWTabeli) {
                Row row = new Row(skuToCheck);
                row.setQtyWerhouseMovement(wartoscQtyPlus+wartoscQtyMinus);
                obsList.add(row);
                System.out.println("new "+skuToCheck );
            }
        }
        skoroszyt.close();
        System.out.println("Odczyt zakończony sukcesem.");
    }

}
