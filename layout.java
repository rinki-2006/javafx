package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import javafx.scene.control.Button;

public class layout extends Application {
    public void start(Stage stage) throws Exception{
        Button b1 = new Button("One");
        Button b2 = new Button("Two");
        Button b3 = new Button("Three");
        Button b4 = new Button("Four");
        Button b5 = new Button("Five");
//        FlowPane root = new FlowPane();
//        root.setHgap(10);
//        root.setVgap(10);

//        TilePane root = new TilePane();
//        root.getChildren().addAll(b1, b2, b3, b4, b5);

//        BorderPane root = new BorderPane();
//        root.setTop(b1);
//        root.setLeft(b2);
//        root.setRight(b3);
//        root.setBottom(b4);
//        root.setCenter(b5);

        GridPane root = new GridPane();
        root.add(b1, 0,0);
        root.add(b2, 1,1);
        root.add(b3, 2,2);
        root.add(b4, 3,3);
        root.add(b5, 4,4);


        Scene sc = new Scene(root, 400, 400);
        stage.setScene(sc);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
