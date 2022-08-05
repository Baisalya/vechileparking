package com.lala.example.vechileparking;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    @FXML
    private ImageView img;
    @FXML
    private TextField txtfirstname;
    @FXML
    private  TextField txtlastname;
    @FXML
    private TextField txtvechilno;
    @FXML
    private TextField txtmobileno;
    @FXML
    private TextField txtpassword;
    @FXML
    private Button loginbtn;
    @FXML
    private Label btntologin;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File backgrounndimg = new File("Assets/signup.jpg");
        Image bgimage = new Image(backgrounndimg.toURI().toString());
        img.setImage(bgimage);
    }
}
