package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class property extends Application {
    public void start(Stage stage) throws Exception{
        Button b = new Button("_Click me");
        b.setTextFill(Color.RED);
        b.setMnemonicParsing(true);

        Tooltip tp = new Tooltip("Click this button to save data");
        b.setTooltip(tp);
       Alert a = new Alert(Alert.AlertType.INFORMATION, "Button is clicked");
       b.setOnAction(e-> a.show());

        FlowPane fp = new FlowPane(b);
        Scene sc = new Scene(fp, 400, 400);
        stage.setScene(sc);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
