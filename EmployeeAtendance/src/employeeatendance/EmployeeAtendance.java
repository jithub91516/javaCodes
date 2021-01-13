/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeatendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class EmployeeAtendance extends Application {

    Button addEmployee, updateEmployee, removeEmployee, payEmployee, adminLogin, createAdmin, registerbtn, back;
    Label adminName, password, userexist, invalidpass, created, createname, createpassword;
    TextField adminInput, namefield;
    PasswordField adminPass, passwordfield;
    GridPane pane, pane2;
    Scene scene, register,serverScene;
    PreparedStatement pstmt;
    Connection conn;
    ResultSet rs;
    Password checkPassword = new Password();

    @Override
    public void start(Stage primaryStage) {
        pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(10);
        pane.setHgap(10);
        adminLogin = new Button("Login");
        createAdmin = new Button("create admin");
        adminName = new Label("Admin Name");
        GridPane.setConstraints(adminName, 0, 0);
        adminInput = new TextField();
        GridPane.setConstraints(adminInput, 1, 0);
        password = new Label("Password");
        GridPane.setConstraints(password, 0, 1);
        adminPass = new PasswordField();
        GridPane.setConstraints(adminPass, 1, 1);
        GridPane.setConstraints(adminLogin, 1, 2);
        GridPane.setConstraints(createAdmin, 1, 3);

        pane.getChildren().addAll(adminName, adminInput, password, adminPass, adminLogin, createAdmin);
        scene = new Scene(pane, 300, 200);
        adminLogin.setOnAction(e -> {
            adminLogin(adminInput.getText(), adminPass.getText());
        });

        userexist = new Label("Username already exist, try another one");
        userexist.setTextFill(Color.RED);
        userexist.setVisible(false);
        invalidpass = new Label("Invalid password\n" + "must be 8 to 10 chracters contains at least\n" + "(one upper,one lower,one number,and one special chracters)");
        invalidpass.setTextFill(Color.RED);
        invalidpass.setVisible(false);
        created = new Label("Ssuccefully created\n" + "go back and log in");
        created.setTextFill(Color.GREEN);
        created.setVisible(false);
        registerbtn = new Button("Register");
        back = new Button("Back");
        pane2 = new GridPane();
        pane2.setPadding(new Insets(10, 10, 10, 10));
        pane2.setHgap(10);
        pane2.setVgap(10);
        createname = new Label("Username");
        GridPane.setConstraints(createname, 0, 0);
        namefield = new TextField();
        GridPane.setConstraints(namefield, 1, 0);
        createpassword = new Label("Password");
        GridPane.setConstraints(createpassword, 0, 1);
        passwordfield = new PasswordField();
        GridPane.setConstraints(passwordfield, 1, 1);
        GridPane.setConstraints(registerbtn, 1, 2);
        GridPane.setConstraints(back, 1, 3);
        GridPane.setConstraints(userexist, 1, 4);
        GridPane.setConstraints(invalidpass, 1, 4);
        GridPane.setConstraints(created, 1, 4);
        pane2.getChildren().addAll(createname, namefield, createpassword, passwordfield, registerbtn, back, userexist, invalidpass, created);
        register = new Scene(pane2, 410, 250);
        createAdmin.setOnAction(e -> {
            primaryStage.setScene(register);
        });
        registerbtn.setOnAction(e -> {
            createAdmin(namefield.getText(), passwordfield.getText());
        });
        back.setOnAction(e -> {
            primaryStage.setScene(scene);
        });
        primaryStage.setTitle("Employee Atendance!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void createAdmin(String username, String password) {
        initializeJdbc();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM admins WHERE username='" + username + "'");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("already found");
            } else {
                System.out.println("fffffffffffff");
                checkPassword.setPassword(password);
                pstmt = conn.prepareStatement("insert into admins (username,password) values ('" + username + "', '" + password + "')");
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            // Logger.getLogger(EmployeeAtendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {           // exception of invalid password
            System.out.println("invalid pass");
            userexist.setVisible(false);
            invalidpass.setVisible(true);
            created.setVisible(false);
        }
    }

    public void initializeJdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/employeeattendanceproject", "scott", "tiger");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmployeeAtendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void adminLogin(String n, String p) {
        initializeJdbc();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM admins WHERE username='" + n + "' AND password='" + p + "'");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("already found");
            } else {
                System.out.println("Wrong user");
            }
        } catch (SQLException ex) {
            // Logger.getLogger(EmployeeAtendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {           // exception of invalid password
            System.out.println("invalid pass");
            userexist.setVisible(false);
            invalidpass.setVisible(true);
            created.setVisible(false);
        }
    }
    public void serverScene(){   
    }
    public void addEmployee(){
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
