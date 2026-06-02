package javafx;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.*;

import javafx.scene.control.Button;

public class first extends Application {
    public void start(Stage stage) throws Exception{
        Button b = new Button("Click");
        FlowPane fp = new FlowPane();
        fp.getChildren().add(b);
        Scene sc = new Scene(fp);

        stage.setScene(sc);
        stage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
}
