package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Date;

public class Controller {
    @FXML
    public TextArea textPane;

    private FileChooser fileChooser = new FileChooser();
    private File file;

    @FXML
    public void newFile(ActionEvent actionEvent) {
        textPane.clear();
        Stage stage = (Stage) textPane.getScene().getWindow();
        stage.setTitle("Untitled - Notepad");
        file = null;
    }

    @FXML
    public void openFile(ActionEvent actionEvent) {
        file = fileChooser.showOpenDialog(null);
        if (file != null){
            Stage stage = (Stage) textPane.getScene().getWindow();
            stage.setTitle(file.getName() + "- Notepad");
            BufferedReader br = null;
            String CurrentLine;
            try {
                br = new BufferedReader(new FileReader(file));
                while ((CurrentLine = br.readLine()) != null){
                    textPane.appendText(CurrentLine + "\n");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void saveFile(ActionEvent actionEvent) {
        String cont = textPane.getText();
        if (file != null){
            try {
                if (!file.exists()){
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(cont);
                bw.close();
                }catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            file = fileChooser.showSaveDialog(null);
            if (file != null){
                Stage stage = (Stage) textPane.getScene().getWindow();
                stage.setTitle(file.getName() + "- Notepad");
                try {
                    if (!file.exists()){
                        file.createNewFile();
                    }

                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(cont);
                    bw.close();
                    }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    public void saveAsFile(ActionEvent actionEvent) {
        file = fileChooser.showSaveDialog(null);
        String cont = textPane.getText();
        if (file != null){
            Stage stage = (Stage) textPane.getScene().getWindow();
            stage.setTitle(file.getName() + "- Notepad");
            try {
                if (!file.exists()){
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(cont);
                bw.close();
                }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void exitApp(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void UndoText(ActionEvent actionEvent) {
        textPane.undo();
    }

    @FXML
    public void CutText(ActionEvent actionEvent) {
        textPane.cut();
    }

    @FXML
    public void CopyText(ActionEvent actionEvent) {
        textPane.copy();
    }

    @FXML
    public void PasteText(ActionEvent actionEvent) {
        textPane.paste();
    }

    @FXML
    public void DeleteText(ActionEvent actionEvent) {
        String delete = textPane.getSelectedText();
        int i = textPane.getText().indexOf(delete);
        textPane.deleteText(i,i+delete.length());
    }

    @FXML
    public void SelectAll(ActionEvent actionEvent) {
        textPane.selectAll();
    }

    @FXML
    public void DateTime(ActionEvent actionEvent) {
        Date date = new Date();
        textPane.setText(date.toString());
    }

    @FXML
    public void WordWrap(ActionEvent actionEvent) {
        CheckMenuItem temp =(CheckMenuItem) actionEvent.getSource();
        textPane.setWrapText(temp.isSelected());
    }
}