package hexatorn.inventorysupport;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.*;
import jxl.read.biff.BiffException;
import java.io.FileNotFoundException;
import java.io.IOException;

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


//    private MyFile fileListOfNature = new MyFile("C:\\Users\\Hexatorn\\Desktop\\INWENTARYZACJA SKL 20417\\FOCUS ZIEONA GÓRA 20417\\test.txt");
    private MyFile fileListOfNature = new MyFile("");
    private MyFile fileListWarehouseMoves = new MyFile("");
    private MyFile fileListForegionStock = new MyFile("");
    private MyFile fileListOwnStock = new MyFile("");


    private ObservableList<Row> rows = FXCollections.observableArrayList();

    @FXML
    public void onActionLoad() throws IOException, BiffException {
        ReadListOfNatureFromTextFile.odczyt(fileListOfNature,rows);
        ReadWerhouseMovementFromXLSFile.odczyt(fileListWarehouseMoves ,rows);
        ReadForeignStockFromXLSFile.odczyt(fileListForegionStock,rows);
        ReadOwnStockFromXLSFile.odczyt(fileListOwnStock,rows);
    }

    private void loadTable(){

        TableColumn tbColumnId = new TableColumn("ID");
        tbColumnId.setMinWidth(40);
        tbColumnId.setPrefWidth(40);
        tbColumnId.setMaxWidth(70);
        tbColumnId.setCellValueFactory(new PropertyValueFactory<Row, Integer>("id"));


        TableColumn tbColumnKodSKU = new TableColumn("SKU");
        tbColumnKodSKU.setPrefWidth(150);
        tbColumnKodSKU.setMinWidth(150);
        tbColumnKodSKU.setMaxWidth(200);
        tbColumnKodSKU.setCellValueFactory(
                new PropertyValueFactory<Row, String>("kodSKU"));

        TableColumn tbColumnLoN = new TableColumn("    Spis\nz Natury");
        tbColumnLoN.setMinWidth(70);
        tbColumnLoN.setCellValueFactory(
                new PropertyValueFactory<Row, Integer>("qtyListOfNature"));

        TableColumn tbColumnWM = new TableColumn("       Ruchy\nMagazynowe");
        tbColumnWM.setMinWidth(70);
        tbColumnWM.setCellValueFactory(
                new PropertyValueFactory<Row, Integer>("qtyWerhouseMovement"));

        TableColumn tbColumnCurrentStock = new TableColumn("    Stock\nAktualny");
        tbColumnCurrentStock.setMinWidth(70);
        tbColumnCurrentStock.setCellValueFactory(
                new PropertyValueFactory<Row, Integer>("qtyCurrentStock"));

        TableColumn tbColumnForeignStock = new TableColumn("    Stock\nMg. Komis");
        tbColumnForeignStock.setMinWidth(70);
        tbColumnForeignStock.setCellValueFactory(
                new PropertyValueFactory<Row, Integer>("qtyForeignStock"));

        TableColumn tbColumnForeignRW = new TableColumn("    RW\nMg. Komis");
        tbColumnForeignRW.setMinWidth(70);
        tbColumnForeignRW.setCellValueFactory(
                new PropertyValueFactory<Row, Integer>("foreignRW"));

        TableColumn tbColumnOwnStock = new TableColumn("    Stock\nMg. Własny");
        tbColumnOwnStock.setMinWidth(70);
        tbColumnOwnStock.setCellValueFactory(
                new PropertyValueFactory<Row, Integer>("qtyOwnStock"));

        TableColumn tbColumnOwnRW = new TableColumn("    RW\nMg. Własny");
        tbColumnOwnRW.setMinWidth(70);
        tbColumnOwnRW.setCellValueFactory(
                new PropertyValueFactory<Row, Integer>("ownRW"));

        TableColumn tbColumnOwnPW = new TableColumn("    PW\nMg. Własny");
        tbColumnOwnPW.setMinWidth(70);
        tbColumnOwnPW.setCellValueFactory(
                new PropertyValueFactory<Row, Integer>("ownPW"));

        tabelView.setEditable(true);
        tabelView.setItems(rows);
        tabelView.getColumns().clear();
        tabelView.getColumns().addAll(
                tbColumnId,
                tbColumnKodSKU,
                tbColumnLoN,
                tbColumnWM,
                tbColumnCurrentStock,
                tbColumnForeignStock,
                tbColumnForeignRW,
                tbColumnOwnStock,
                tbColumnOwnRW,
                tbColumnOwnPW);
    }

    @FXML
    public void onActionExportCurentForegionStock() throws FileNotFoundException {
        MyFile file = choseFileToSave();
        if(file!=null){
            SaveForegionStockToTextFile.WriteToTextFile(file,rows);
        }

    }
    @FXML
    public void onActionExportCurentOwnStock() throws FileNotFoundException {
        MyFile file = choseFileToSave();
        if(file!=null){
            SaveOwnStockToTextFile.WriteToTextFile(file,rows);
        }
    }

    private MyFile choseFileToSave(){
        JFileChooser jFileChooser = new JFileChooser();
        if(jFileChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
            MyFile file = new MyFile(jFileChooser.getSelectedFile().getAbsolutePath());
            if(!file.getAbsolutePath().contains(".txt")){
                file.setPatchfile(file.getAbsolutePath()+".txt");
            }
            return file;
        }
        return null;
    }


    @FXML
    public void onActionLoadListOfNature() throws FileNotFoundException {
        choseFile(tfPatchToFile01,firstClickToTfPatchToFile01,fileListOfNature);
        if(fileListOfNature.getAbsolutePath()=="")
            ReadListOfNatureFromTextFile.odczyt(fileListOfNature,rows);
    }
    @FXML
    public void onActionLoadWarehouseMovment() throws IOException, BiffException {
        choseFile(tfPatchToFile02,firstClickToTfPatchToFile02,fileListWarehouseMoves);
        if(fileListWarehouseMoves.getAbsolutePath()=="")
            ReadWerhouseMovementFromXLSFile.odczyt(fileListWarehouseMoves ,rows);
    }
    @FXML
    public void onActionLoadForegionStock() throws IOException, BiffException {
        choseFile(tfPatchToFile03,firstClickToTfPatchToFile03,fileListForegionStock);
        if(fileListForegionStock.getAbsolutePath()=="")
            ReadForeignStockFromXLSFile.odczyt(fileListForegionStock,rows);
    }
    @FXML
    public void onActionLoadOwnStock() throws IOException, BiffException {
        choseFile(tfPatchToFile04,firstClickToTfPatchToFile04,fileListOwnStock);
        if(fileListOwnStock.getAbsolutePath()=="")
            ReadOwnStockFromXLSFile.odczyt(fileListOwnStock,rows);
    }

    private void choseFile(TextField tf, MyBoolean mb,MyFile f){
        JFileChooser jFileChooser = new JFileChooser();
        if(jFileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            f.setFile(jFileChooser.getSelectedFile());
            mb.setB(true);
            changeTextAtFirstClick(tf,mb,f.getAbsolutePath());
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

    public void initialize(){
        loadTable();
    }

}
