package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.text.Font;


public class textarea_slider extends Application {
    TextArea ta;
    Slider s;
    public void start(Stage stage) throws Exception{
        ta = new TextArea();
        ta.setPrefColumnCount(100);
        ta.setPrefRowCount(20);

        s = new Slider(10,50,10);
        VBox v = new VBox();
        v.getChildren().addAll(ta, s);

        s.valueProperty().addListener(e-> ta.setFont(Font.font(s.getValue())));
        Scene sc = new Scene(v, 400,400);
        stage.setScene(sc);
        stage.show();;
    }
    public static void main(String[] args) {

        launch(args);
    }
}
