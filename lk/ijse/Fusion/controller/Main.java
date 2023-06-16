package lk.ijse.Fusion.lk.ijse.Fusion.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import lk.ijse.Fusion.lk.ijse.Fusion.Util.Navigation;
import lk.ijse.Fusion.lk.ijse.Fusion.Util.Routes;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {
    public TextField usernameTXT;
    public PasswordField passwordTXT;
    public MediaView mediaView;
    public AnchorPane MainPane;
    public MediaView bannerView;
    public MediaView mediafram2;


    public void LogInOnAction(ActionEvent actionEvent) throws IOException {
        System.out.println(usernameTXT.getText());
        String tempUsername = usernameTXT.getText();
        String tempPassword = passwordTXT.getText();
        System.out.println(passwordTXT.getText());
        if (tempUsername.equals("sandaru") && tempPassword.equals("2001")) {

            System.out.println(passwordTXT.getText());
            Navigation.navigate(Routes.DASHBOARD, MainPane);
        }
        if (tempUsername.equals("stock") && tempPassword.equals("2001")) {
            Navigation.navigate(Routes.STOCKDASH, MainPane);
        }
        if (tempUsername.equals("it") && tempPassword.equals("2001")) {
            Navigation.navigate(Routes.IT_MANAGERDASH, MainPane);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        File file = new File("oop.mp4");
//        Media media = new Media(file.toURI().toString());
//        MediaPlayer mp = new MediaPlayer(media);
//        mp.setAutoPlay(true);
//        mediaView.setMediaPlayer(mp);
//        mp.play();
//
//        file = new File("Suppliers.mp4");
//        media = new Media(file.toURI().toString());
//        MediaPlayer mp2 = new MediaPlayer(media);
//        mp2.setAutoPlay(true);
//        mediafram2.setMediaPlayer(mp2);
//        mp2.play();


    }

    public void logEnterPress(KeyEvent keyEvent) {

    }
}