package hexatorn.inventorysupport;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Wsparcie Inwentaryzacji");
        primaryStage.setScene(new Scene(root, 800, 275));
        primaryStage.setMinWidth(870);
        primaryStage.setMaxWidth(870);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}
