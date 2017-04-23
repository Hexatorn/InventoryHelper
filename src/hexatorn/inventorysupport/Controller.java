package hexatorn.inventorysupport;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import javax.swing.*;

import java.io.File;

public class Controller {

    @FXML
    private Button btnLoadFile01;
    @FXML
    private Button btnLoadFile02;
    @FXML
    private Button btnLoadFile03;
    @FXML
    private Button btnLoadFile04;
    @FXML
    private TextField tfPatchToFile01;
    @FXML
    private TextField tfPatchToFile02;
    @FXML
    private TextField tfPatchToFile03;
    @FXML
    private TextField tfPatchToFile04;
    @FXML
    private StackPane stackPane;

    private static MyBoolean firstClickToTfPatchToFile01 = new MyBoolean();
    private static MyBoolean firstClickToTfPatchToFile02 = new MyBoolean();
    private static MyBoolean firstClickToTfPatchToFile03 = new MyBoolean();
    private static MyBoolean firstClickToTfPatchToFile04 = new MyBoolean();


    @FXML
    public void onActionLoadListOfNature(){
        choseFile(tfPatchToFile01,firstClickToTfPatchToFile01);
    }
    @FXML
    public void onActionLoadWarehouseMovment(){
        choseFile(tfPatchToFile02,firstClickToTfPatchToFile02);
    }
    public void onActionLoadForegionStock(){
        choseFile(tfPatchToFile03,firstClickToTfPatchToFile03);
    }
    public void onActionLoadOwnStock(){
        choseFile(tfPatchToFile04,firstClickToTfPatchToFile04);
    }

    private void choseFile(TextField tf, MyBoolean mb){
        JFileChooser jFileChooser = new JFileChooser();
        if(jFileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            File file = jFileChooser.getSelectedFile();
            mb.setB(true);
            changeTextAtFirstClick(tf,mb,file.getAbsolutePath());
        }
    }


    @FXML
    public void onActionClearTextAtFirstClick01(){
        changeTextAtFirstClick(tfPatchToFile01,firstClickToTfPatchToFile01,"");
    }
    @FXML
    public void onActionClearTextAtFirstClick02(){
        changeTextAtFirstClick(tfPatchToFile02,firstClickToTfPatchToFile02,"");
    }
    @FXML
    public void onActionClearTextAtFirstClick03(){
        changeTextAtFirstClick(tfPatchToFile03,firstClickToTfPatchToFile03,"");
    }
    @FXML
    public void onActionClearTextAtFirstClick04(){
        changeTextAtFirstClick(tfPatchToFile04,firstClickToTfPatchToFile04,"");
    }

    private void changeTextAtFirstClick(TextField tf, MyBoolean mb, String s){
        if(mb.getB()){
            tf.setText(s);
            mb.setB(false);
        }
    }

}
