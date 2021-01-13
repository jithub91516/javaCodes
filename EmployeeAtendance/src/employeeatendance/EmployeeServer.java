/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeatendance;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class EmployeeServer extends Application {
    GridPane pane;
    Button attend;
    Label id,password;
    TextField idNum;
    PasswordField pass;
    Scene scene;
    @Override
    public void start(Stage primaryStage) {
       pane=new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(10);
        pane.setHgap(10);
        attend = new Button("attend");
        id=new Label("Id number");
        GridPane.setConstraints(id, 0, 0);
        idNum=new TextField();
        GridPane.setConstraints(idNum, 1, 0);
        password=new Label("Password");
        GridPane.setConstraints(password, 0, 1);
        pass=new PasswordField();
        GridPane.setConstraints(pass, 1, 1);
        GridPane.setConstraints(attend, 1, 2);
        

        pane.getChildren().addAll(id,idNum,password,pass,attend);    
        scene = new Scene(pane, 300, 200);
        
        primaryStage.setTitle("Employee Atendance!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
