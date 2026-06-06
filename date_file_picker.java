package javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;


public class date_file_picker extends Application {
    TextArea ta;
    Slider sl;
    public void start(Stage stage)throws Exception{
        ta = new TextArea();
        ta.setPrefColumnCount(100);
        ta.setPrefRowCount(20);

        sl = new Slider(10,50,10);
        sl.setMajorTickUnit(5);
        sl.setShowTickMarks(true);

        // use date picker
        DatePicker dp = new DatePicker();
        // set week
        dp.setShowWeekNumbers(true);
        dp.setOnAction(e->ta.setText("Date : " + dp.getValue() + "\n" + ta.getText()));

        // color picker
        ColorPicker cp = new ColorPicker();
        cp.setOnAction(e->
        {
            ta.setStyle("-fx-text-fill: #" + cp.getValue().toString().substring(2,8));
            ta.setText(cp.getValue() + "\n" + ta.getText());
        });

        Button b = new Button("Open File");
        //handle event on button
        b.setOnAction(e->{
                FileChooser fc = new FileChooser();
               java.io.File file =  fc.showOpenDialog(stage);
               // for reading and opening
            try(Scanner sc = new Scanner(new FileInputStream(file))){
                // for reading initially it is empty
                String str = "";
                while(sc.hasNext())
                    str = str + sc.nextLine() + "\n";
                ta.setText(str);

            } catch (Exception ex) {
                System.out.println(e);
            }
        });

        VBox v = new VBox();
        v.getChildren().addAll(ta,sl, dp, cp, b);
        v.setAlignment(Pos.TOP_CENTER);

        sl.valueProperty().addListener(e->ta.setFont(Font.font(sl.getValue())));
        Scene sc = new Scene(v, 500,500);
        stage.setScene(sc);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
