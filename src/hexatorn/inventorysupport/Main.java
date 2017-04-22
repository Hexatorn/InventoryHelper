package hexatorn.inventorysupport;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Wsparcie Inwentaryzacji");
        primaryStage.setScene(new Scene(root, 500, 275));
        primaryStage.show();

//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open Resource File");
//        fileChooser.showOpenDialog(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);

    }
}
