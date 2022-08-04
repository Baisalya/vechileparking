package com.lala.example.vechileparking;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.net.URL;
public class LoginController implements Initializable {
    @FXML
    private Button cancelbtn;
    @FXML
    private Label loginmsg;
    @FXML
    private ImageView bgimgview;
    @FXML
    private ImageView bgimgView2;
    @FXML
    private TextField txtmobileno;
    @FXML
    private PasswordField txtpassword;
    public  void  loginButtonOnAction(ActionEvent event){

    if (txtmobileno.getText().isBlank()==false && txtpassword.getText().isBlank()){
        loginmsg.setText("Take user name and password");
        ValidateLogin();
    }else {
        loginmsg.setText("Invalid Credintial");
    }
    }
     public  void  cancelButtonOnAction(ActionEvent event){
         Stage stage=(Stage) cancelbtn.getScene().getWindow();
         stage.close();
     }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File backgrounndimg=new File("Assets/loginbg.jpg");
        Image bgimage=new Image(backgrounndimg.toURI().toString());
        bgimgview.setImage(bgimage);
        //
        File backgrounndimg2=new File("Assets/login2.jpg");
        Image bgimage2=new Image(backgrounndimg2.toURI().toString());
        bgimgView2.setImage(bgimage2);
    }
    public void ValidateLogin(){
        dbconnection connow=new dbconnection();
        Connection connectDB=connow.getCon();
        String Loginveryfy="SELECT * FROM `user` WHERE phone_no='"+txtmobileno.getText()+"' and password='"+txtpassword.getText()+"'";
        try {
            Statement statement=connectDB.createStatement();
            ResultSet resultSet=statement.executeQuery(Loginveryfy);
            while (resultSet.next()){
                if (resultSet.getInt(1)==1){
              loginmsg.setText("Login Successfully");
                }else{
                    loginmsg.setText("Invalid Login!! Try Again ");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
