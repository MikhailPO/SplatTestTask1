package searchinfiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
/**
 * Обработка действий в программе
 *
 * */
public class Controller {
    public TextField InputPath;
    public TextField InputWord;
    public ComboBox ComBox;
    public TableView<Result> rTable;
    @FXML
    private javafx.scene.control.Label MyLabel;

    public void initialize() {
        MyLabel.setText(" ");
    }


    public void go(ActionEvent actionEvent) {
        Search search = new Search();
        search.Path = InputPath.getText();
        search.Text = InputWord.getText();
        search.Extension = ComBox.getValue().toString();
        if (!search.SearchText()) {
            MyLabel.setText("Path is Empty!");
        }
        MyLabel.setText(search.MyLabel);

        for (String res : search.Result) {
            Result result = new Result();
            result.setPFile(res);
            rTable.getItems().add(result);
        }


    }
}
