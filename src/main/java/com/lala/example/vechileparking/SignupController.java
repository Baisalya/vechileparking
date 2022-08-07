package com.lala.example.vechileparking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    @FXML
    private Label txtid;
    @FXML
    private ImageView img;
    @FXML
    private TextField txtfirstname;
    @FXML
    private  TextField txtlastname;
    @FXML
    private TextField txtvehicleno;
    @FXML
    private TextField txtmobileno;
    @FXML
    private TextField txtpassword;
    @FXML
    private Button loginbtn;
    @FXML
    private Hyperlink btntologin;
    Alert a = new Alert(Alert.AlertType.NONE);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File backgrounndimg = new File("Assets/signup.jpg");
        Image bgimage = new Image(backgrounndimg.toURI().toString());
        img.setImage(bgimage);
    }

    public void gotoLoginOnAction(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Stage regstage = new Stage();
            regstage.setScene(new Scene(root, 560, 400));
            regstage.setTitle("Login");
            // regstage.setScene(scene);
            regstage.resizableProperty().setValue(false);//resizable of
            regstage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
    public  void AutoUniqueID(){
        dbconnection connow=new dbconnection();
        Connection connectDB=connow.getCon();
        String uniqueIdquery="select max(unque_id) from user";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet=statement.executeQuery(uniqueIdquery);
            resultSet.next();
            resultSet.getString("MAX(unque_id)");
            if (resultSet.getString("MAX(unque_id)")== null)
            {
                txtid.setText("Pid001");
            }else{
                long id=Long.parseLong(resultSet.getString("MAX(unque_id)").substring(2,resultSet.getString("MAX(unque_id)").length()));
                id++;
                txtid.setText("pid"+String.format("%03d",id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }

    }
    public void SignupbuttonOnAction(ActionEvent event){
        if(txtfirstname.getText().isBlank()==true && txtlastname.getText().isBlank()==true){
            a.setAlertType(Alert.AlertType.WARNING);
            a.setContentText("Please enter firstname & lastname");
            a.show();
            return;
        }if (txtmobileno.getText().isBlank()==true){
            a.setAlertType(Alert.AlertType.WARNING);
            a.setContentText("Please enter your mobile no");
            a.show();
            return;

        }if (txtvehicleno.getText().isBlank()==true && txtpassword.getText().isBlank()==true){
            a.setAlertType(Alert.AlertType.WARNING);
            a.setContentText("Please enter vehicle no and password");
            a.show();
            return;
        }else{
            Usercreation();
        }

        }

    public void Usercreation(){
        dbconnection connow=new dbconnection();
        Connection connectDB=connow.getCon();
        String userid= txtid.getText();
        String firstname=txtfirstname.getText();
        String lastname=txtlastname.getText();
        String vehicle_no=txtvehicleno.getText();
        String mobile_no=txtmobileno.getText();
        String password=txtpassword.getText();
        String regquery="insert into user (unque_id,fname,lname,vehicle_id,phone_no,password)values('";
        String insertfield=userid+"','"+firstname +"','"+ lastname +"','"+ vehicle_no +"','"+mobile_no+"','"+password+"')";
        String Inserttoreg=regquery+insertfield;
        try {
            Statement statement=connectDB.createStatement();
            statement.executeUpdate(Inserttoreg);
            System.out.println("sucessfull");
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
