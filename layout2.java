package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.FileInputStream;

public class layout2 extends Application {
    public void start(Stage stage) throws Exception{
        ImageView i1 = new ImageView(new Image(new FileInputStream("C:\\Users\\HP\\Downloads\\add_employee.png")));
        ImageView i2 = new ImageView(new Image(new FileInputStream("C:\\Users\\HP\\Downloads\\emplyee.png")));
        ImageView i3 = new ImageView(new Image(new FileInputStream("C:\\Users\\HP\\Downloads\\edit_employee.png")));

        ScrollPane sp1 = new ScrollPane(i1);
        ScrollPane sp2 = new ScrollPane(i2);
        ScrollPane sp3 = new ScrollPane(i3);
//        SplitPane root= new SplitPane(sp1, sp2, sp3);
//        root.setDividerPositions(0.33,0.66);

//        Tab t1 = new Tab("add_employee", sp1);
//        Tab t2 = new Tab("employee", sp2);
//        Tab t3 = new Tab("edit_employee", sp3);
//        TabPane root = new TabPane();
//        root.getTabs().addAll(t1, t2, t3);

        TitledPane t1 = new TitledPane("add_employee", sp1);
        TitledPane t2 = new TitledPane("employee", sp2);
        TitledPane t3 = new TitledPane("edit_employee", sp3);
        Accordion root = new Accordion();
        root.getPanes().addAll(t1, t2, t3);


        Scene sc = new Scene(root, 400, 400);
        stage.setScene(sc);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
