package hexatorn.inventorysupport;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.*;

import java.io.File;

public class Controller {


    @FXML
    private TextField tfPatchToFile01;
    @FXML
    private TextField tfPatchToFile02;
    @FXML
    private TextField tfPatchToFile03;
    @FXML
    private TextField tfPatchToFile04;

    @FXML
    private TableView<Row> tabelView;

    private static MyBoolean firstClickToTfPatchToFile01 = new MyBoolean();
    private static MyBoolean firstClickToTfPatchToFile02 = new MyBoolean();
    private static MyBoolean firstClickToTfPatchToFile03 = new MyBoolean();
    private static MyBoolean firstClickToTfPatchToFile04 = new MyBoolean();


    private ObservableList<Row> rows = FXCollections.observableArrayList(
        new Row("ML2005",20,2),
        new Row("ML2006",10,-1),
        new Row("ML2007",49,-5),
        new Row("ML2008",25,7)
    );

    @FXML
    public void onActionLoad(){
        LoadTable();
    }

    private void LoadTable(){

        TableColumn tbColumnId = new TableColumn("ID");
        tbColumnId.setMinWidth(40);
        tbColumnId.setCellValueFactory(new PropertyValueFactory<Row, Integer>("id"));


        TableColumn tbColumnKodSKU = new TableColumn("SKU");
        tbColumnKodSKU.setMinWidth(150);
        tbColumnKodSKU.setCellValueFactory(
                new PropertyValueFactory<Row, String>("kodSKU"));

        TableColumn tbColumnLoN = new TableColumn("Spis z Natury");
        tbColumnLoN.setMinWidth(90);
        tbColumnLoN.setCellValueFactory(
                new PropertyValueFactory<Row, Integer>("qtyListOfNature"));

        TableColumn tbColumnWM = new TableColumn("Ruchy Magazynowe");
        tbColumnWM.setMinWidth(90);
        tbColumnWM.setCellValueFactory(
                new PropertyValueFactory<Row, Integer>("qtyWerhouseMovement"));

        TableColumn tbColumnCurrentStock = new TableColumn("Stock Aktualny");
        tbColumnCurrentStock.setMinWidth(90);
        tbColumnCurrentStock.setCellValueFactory(
                new PropertyValueFactory<Row, Integer>("qtyCurrentStock"));

        tabelView.setEditable(true);
        tabelView.setItems(rows);
        tabelView.getColumns().clear();
        tabelView.getColumns().addAll(tbColumnId,tbColumnKodSKU,tbColumnLoN,tbColumnWM,tbColumnCurrentStock);
    }

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
