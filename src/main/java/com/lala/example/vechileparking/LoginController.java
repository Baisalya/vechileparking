package com.lala.example.vechileparking;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import javafx.scene.control.Alert.AlertType;
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
    @FXML
    private Hyperlink gotoregbtn;
    @FXML
    Alert alert=new Alert(AlertType.INFORMATION);
    @FXML
    private Button loginbtn;
    public  void  loginButtonOnAction(ActionEvent event){
    if (txtmobileno.getText().isBlank()==false && txtpassword.getText().isBlank()==false){
        ValidateLogin();
    }else {
        loginmsg.setText("Invalid credintial");
        alert.setHeaderText("Look, an Information Dialog");
    }
    }
     public  void  cancelButtonOnAction(ActionEvent event){
         Stage stage=(Stage) cancelbtn.getScene().getWindow();
         stage.close();
     }
//going to login page to regpage
public void gotoregbtnOnAction(ActionEvent event){
    createAccountForm();
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
        String Loginveryfy="SELECT count(1) FROM user WHERE phone_no='"+txtmobileno.getText()+"' AND password='"+txtpassword.getText()+"'";
        try {
            Statement statement=connectDB.createStatement();
            ResultSet resultSet=statement.executeQuery(Loginveryfy);
            while (resultSet.next()){
                if (resultSet.getInt(1)==1){
              loginmsg.setText("Login Successfully");
              alert.setHeaderText("Look, an Information Dialog");

                }else{
                    loginmsg.setText("Invalid Login!! Try Again ");
                 //   alert.setHeaderText("Look, an Information Dialog");

                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    //open to regpage function

    public void createAccountForm() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
            Stage regstage = new Stage();
            regstage.setScene(new Scene(root, 560, 400));
            regstage.setTitle("SignUP");
            // regstage.setScene(scene);
            regstage.resizableProperty().setValue(false);//resizable of
            regstage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
