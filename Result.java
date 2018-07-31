package searchinfiles;
/**
 * Класс для вывода результатов поиска
 *
 * */
import javafx.beans.property.SimpleStringProperty;

public class Result {
    SimpleStringProperty PFile = new SimpleStringProperty();

    public String getPFile() {
        return PFile.get();
    }

    public void setPFile(String PFile) {
        this.PFile.set(PFile);
    }

    public SimpleStringProperty PFileProperty() {
        return PFile;
    }
}
