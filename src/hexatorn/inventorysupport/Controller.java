package hexatorn.inventorysupport;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import java.io.File;

public class Controller {

    @FXML
    private Button btnLoadFile01;
    @FXML
    private TextField tfPatchToFile01;
    @FXML
    private StackPane stackPane;

    public Controller(){
        System.out.println("Witaj Java FX");
    }

    @FXML
    void initialize(){
        System.out.println("initialize");
    }

    @FXML
    public void onActionLoadListOfNature(){
        System.out.println("click");

        JFileChooser jFileChooser = new JFileChooser();
        if(jFileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            File file = jFileChooser.getSelectedFile();
            firstClickToTfPatchToFile01 = false;
            tfPatchToFile01.setText(file.getName());
        }
    }


    private static boolean firstClickToTfPatchToFile01 = true;
    @FXML
    public void onActionClearTextAtFirstClick(){
        if (firstClickToTfPatchToFile01){
            tfPatchToFile01.setText("");
            firstClickToTfPatchToFile01 = false;
        }
    }
}
