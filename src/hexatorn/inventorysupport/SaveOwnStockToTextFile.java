package hexatorn.inventorysupport;

import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Hexatorn on 2017-04-27.
 */
class SaveOwnStockToTextFile {
    static void WriteToTextFile(MyFile file, ObservableList<Row> obsList) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(file.getAbsolutePath());
        for (Row row : obsList) {
            if (row.getCurentOwnStock() != 0)
                zapis.println(row.getKodSKU() + "\t" + row.getCurentOwnStock());
        }
        zapis.close();
    }
}
