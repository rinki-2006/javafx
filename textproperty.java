package javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;



public class textproperty extends Application implements EventHandler<ActionEvent> {
    Text t;
    RadioButton r1, r2, r3;
    CheckBox c1, c2, c3;
    ChoiceBox<Integer> cb;
    public void start(Stage stage) throws Exception{
        t = new Text("Hello world");
        HBox h1 = new HBox();
        h1.getChildren().add(t);

       r1 = new RadioButton("Red");
       r2 = new RadioButton("Green");
       r3 = new RadioButton("Blue");
       ToggleGroup tg = new ToggleGroup();
       r1.setToggleGroup(tg);
       r2.setToggleGroup(tg);
       r3.setToggleGroup(tg);
       //layout
       HBox h = new HBox();
       h.getChildren().addAll(r1, r2, r3);
       // give spacing
       h.setSpacing(15);
       // set padding
       h.setPadding(new Insets(10,10,10,10));

       c1= new CheckBox("Normal");
       c2= new CheckBox("Bold");
       c3= new CheckBox("Italic");

       HBox h2 = new HBox();
       h2.getChildren().addAll(c1, c2, c3);
       h2.setSpacing(15);
       h2.setPadding(new Insets(10,10,10,10));

       cb = new ChoiceBox<>();
       cb.getItems().addAll(10,20,30,50);

        VBox v = new VBox();
        v.setSpacing(15);
        v.setPadding(new Insets(10,10,10,10));
        v.getChildren().addAll(h1, h,h2, cb);

        r1.setOnAction(this);
        r2.setOnAction(this);
        r3.setOnAction(this);
        c1.setOnAction(this);
        c2.setOnAction(this);
        c3.setOnAction(this);
        cb.setOnAction(this);

        Scene sc = new Scene(v, 400,400);
        stage.setScene(sc);
        stage.show();

    }
    public void handle(ActionEvent e){
        FontWeight fw = FontWeight.NORMAL;
        FontPosture fp = FontPosture.REGULAR;

        if(r1.isSelected()){
            t.setFill(Paint.valueOf("RED"));
        }
        // for r2
        if(r2.isSelected()){
            t.setFill(Paint.valueOf("Green"));
        }
        // for r3
        if(r3.isSelected()){
            t.setFill(Paint.valueOf("Blue"));
        }
        // for c1 by default normal
        // for c2
        if(c2.isSelected()){
            fw = FontWeight.BOLD;
        }
        // for c3
        if(c2.isSelected()){
            fp = FontPosture.ITALIC;
        }
        t.setFont(Font.font("Times New Roman", fw, fp, cb.getValue()));
    }
    public static void main(String[] args) {
        launch(args);
    }
}
