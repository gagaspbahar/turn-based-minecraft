package com.aetherwars;

import javafx.fxml.FXML;
import java.io.*;
import java.nio.file.Files;
import com.aetherwars.model.Player;
import java.net.URISyntaxException;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.*;
import com.aetherwars.util.config.CSVReader;
import java.io.File;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import com.aetherwars.model.type.*;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import java.util.*;
import javafx.fxml.FXMLLoader;

public class Controller5 {
    
    @FXML
    private Text errorText;

    @FXML
    private TextField player1box;

    @FXML
    private TextField player2box;

    @FXML
    private Text goBack;

    @FXML
    private Rectangle gobackBox;

    @FXML
    private Text submitLoad;

    @FXML
    private Rectangle submitLoadBox;

    @FXML
    void goBackClicked(MouseEvent event) throws Exception {
        Stage popupwindow = (Stage) gobackBox.getScene().getWindow();
        Pane throwPane = FXMLLoader.load(AetherWars.class.getClassLoader().getResource("./Opening.fxml"));
        popupwindow.setScene(new Scene(throwPane));
        popupwindow.centerOnScreen();
    }

    @FXML
    void loadClicked(MouseEvent event) throws Exception {

        if (player1box.getText().equals("") || player2box.getText().equals("")) {
            errorText.setText("Please enter a name for both players");
            return;
        } 
        int panjang1 = player1box.getText().length();
        int panjang2 = player2box.getText().length();
        if (panjang1 < 5 || panjang2 < 5) {
            errorText.setText("Filename is not valid");
            return;
        } 
        if ((!player1box.getText().substring(panjang1-4, panjang1).equals(".csv") && !player1box.getText().substring(panjang1-4, panjang1).equals(".txt")) 
                || (!player2box.getText().substring(panjang2-4, panjang2).equals(".csv") && !player2box.getText().substring(panjang2-4, panjang2).equals(".txt"))) {
            errorText.setText("Filename is not valid");
            return;
        }

        String filename1 = "./com/aetherwars/deck/" + player1box.getText();
        String filename2 = "./com/aetherwars/deck/" + player2box.getText();

        boolean file1ada;
        boolean file2ada;

        if (AetherWars.class.getClassLoader().getResource(filename1) != null) {
            file1ada = true;
        } else {
            file1ada = false;
        }
        
        if (AetherWars.class.getClassLoader().getResource(filename2) != null) {
            file2ada = true;
        } else {
            file2ada = false;
        }

        if (!file1ada && !file2ada){
            errorText.setText("Filename 1 and 2 not found!");
            return;
        }
        if (!file1ada) {
            errorText.setText("Filename 1 not found!");
            return;
        }
        if (!file2ada){
            errorText.setText("Filename 2 not found!");
            return;
        }

        try {
            List<String[]> tempdeck1 = loadCSV(filename1);
            List<String[]> tempdeck2 = loadCSV(filename2);
            for (String[] baris : tempdeck1){
                AetherWars.p1.addDeckFromID( Integer.parseInt(baris[0]));
            }
            for (String[] baris : tempdeck2){
                AetherWars.p2.addDeckFromID( Integer.parseInt(baris[0]));
            }
            Stage popupwindow = (Stage) gobackBox.getScene().getWindow();
            Pane throwPane = FXMLLoader.load(AetherWars.class.getClassLoader().getResource("./Sample.fxml"));
            popupwindow.setScene(new Scene(throwPane));
            popupwindow.centerOnScreen();
        }
        catch (URISyntaxException e) {
            errorText.setText("FILE NOT FOUND");
        }
        catch (IOException e) {
            errorText.setText("FILE NOT FOUND");
        }
        
    }

    public List<String[]> loadTXT(String filename) {
        List<String[]> list = new ArrayList<String[]>();
        try {
            Scanner scanner = new Scanner(new File(AetherWars.class.getClassLoader().getResource(filename).toURI()));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                list.add(values);
            }
        } catch (Exception e) {
            errorText.setText("File not found.");
        }
        return list;
    }

    public List<String[]> loadCSV(String filename) throws URISyntaxException, IOException {
        File characterCSVFile = new File(AetherWars.class.getClassLoader().getResource(filename).toURI());
        CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
        characterReader.setSkipHeader(true);
        return characterReader.read();

      }

}

