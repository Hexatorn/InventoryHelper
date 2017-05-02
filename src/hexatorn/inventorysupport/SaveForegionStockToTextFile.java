package hexatorn.inventorysupport;

import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Hexatorn on 2017-04-27.
 */
class SaveForegionStockToTextFile {

    static void WriteToTextFile(MyFile file, ObservableList<Row> obsList) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(file.getAbsolutePath());
        for (Row row: obsList) {
            zapis.println(row.getKodSKU()+"\t"+row.getCurentForeignStock());
        }
        zapis.close();
    }

}
