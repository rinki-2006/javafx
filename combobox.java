package javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.scene.control.*;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

class customer {
    private int cust_id;
    private String name;
    private String address;

    public customer(int c, String n, String a) {
        cust_id = c;
        name = n;
        address = a;
    }
    public int getId(){
        return cust_id;
    }
    public String getname(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String add){
        address = add;
    }
}
public class combobox extends Application {
    int count = 0;
    Label l1, l2, l3;
    ComboBox<Integer> c1;
    TextField t1, t2;
    Button b1, b2;
    public void start(Stage stage) throws Exception{
        HashMap<Integer, customer> hm = new HashMap<>();

        Font f = new Font("Times New Roman", 20);
        l1 = new Label("Customer ID");
        l1.setFont(f);
        c1 = new ComboBox<>();
        c1.setStyle("-fx-font-size:20");
        HBox h = new HBox();
        h.getChildren().addAll(l1, c1);
        h.setAlignment(Pos.CENTER);


        l2 = new Label("Name");
        l2.setFont(f);
        t1 = new TextField();
        t1.setPrefColumnCount(15);
        HBox h1 = new HBox();
        h1.getChildren().addAll(l2, t1);
        h1.setAlignment(Pos.CENTER);

        l3 = new Label("Address");
        l3.setFont(f);
        t2 = new TextField();
        t2.setPrefColumnCount(20);
        HBox h2 = new HBox();
        h2.getChildren().addAll(l3, t2);
        h2.setAlignment(Pos.CENTER);

        b1 = new Button("Create");
        b1.setFont(f);

        b1.setOnAction(e->{++count;
        c1.getItems().add(count);
        c1.setValue(count);
        t1.setText("");
        t2.setText("");
        });

        b2 = new Button("Save");
        b2.setFont(f);
        //whatever the data is entered in text field we should create an object of customer and
        //stored in hash map as well as store in file
        b2.setOnAction(e->{
            customer c = new customer(c1.getValue(), t1.getText(), t2.getText());
            hm.put(count, c);
            // try with resources
            try(PrintStream ps = new PrintStream(new FileOutputStream("C:/Users/HP/Desktop/use txt file in java/customer.txt"))){
                for(customer ct: hm.values()){
                    ps.println(ct.getId());
                    ps.println(ct.getname());
                    ps.println(ct.getAddress());
                }
            } catch (Exception ex) {}
        });

        HBox h3 = new HBox();
        h3.getChildren().addAll(b1, b2);
        h3.setAlignment(Pos.CENTER);

        VBox v = new VBox();
        v.getChildren().addAll(h, h1, h2, h3);
        v.setAlignment(Pos.CENTER);

        // pull the data from file and put in hash map
        try(Scanner sc = new Scanner(new FileInputStream("C:/Users/HP/Desktop/use txt file in java/customer.txt"))){
            int c;
            String n;
            String a;
            while(sc.hasNext()){
                c = sc.nextInt();
                n = sc.next();
                a = sc.next();
                hm.put(c, new customer(c, n, a));
                if(c>count)count = c;
                c1.getItems().add(c);
            }
        } catch (Exception ex) {}

        c1.valueProperty().addListener(e->{
            int c = c1.getValue();
            customer ct = hm.get(c);
            t1.setText(ct.getname());
            t2.setText(ct.getAddress());
        });
        Scene sc = new Scene(v, 500,500);
        stage.setScene(sc);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
