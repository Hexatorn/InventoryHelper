package hexatorn.inventorysupport;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class Controller {

    @FXML
    private Button btnLoadFile01;
    @FXML
    private TextField tfPatchToFile01;

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
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open Resource File");
//        fileChooser.showOpenDialog(primaryStage);
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
