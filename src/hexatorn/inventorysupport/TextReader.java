package hexatorn.inventorysupport;

import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Hexatorn on 2017-04-25.
 */
public class TextReader {

    static String linia = "";
    static String kod = "";
    static double liczba = 0.00 ;


    static void odczyt (MyFile file, ObservableList<Row> obsList) throws FileNotFoundException {
       System.out.println(file.getAbsolutePath());
        Scanner in = new Scanner(file.getFile());
        Scanner skaner = new Scanner("");
        String s = "";
        String[] line;
        
        while (in.hasNext()){
            s = in.nextLine();
            line = s.split("\t");
            obsList.add(new Row(line[0]));
        }
    }
}
