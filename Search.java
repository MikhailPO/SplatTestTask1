package searchinfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Создание списока файлов для посика
 * Поиск текста в файлах
 *
 *
 * */
public class Search {
    String Path = new String();
    String Extension = new String();
    String Text = new String();
    String MyLabel = new String("This text is found in the following files");
    ArrayList<String> Result = new ArrayList<String>();

    private static StringBuilder readFile(String path) {
        // Assumes that a file article.rss is available on the SD card
        File file = new File(path);
        StringBuilder builder = new StringBuilder();
        if (!file.exists()) {
            throw new RuntimeException("File not found");
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return builder;
    }

    private List<File> listf(String directoryName) {
        List<File> resultList = new ArrayList<File>();
        File directory = new File(directoryName);
        try {



            File[] fList = directory.listFiles();
            resultList.addAll(Arrays.asList(fList));
            for (File file : fList) {
                if (file.isFile()) {

                } else if (file.isDirectory()) {
                    resultList.addAll(listf(file.getAbsolutePath()));
                }
            }
            return resultList;
        } catch (Exception e) {
            MyLabel=Path+" - Incorect Path!";
        }
        return resultList;

    }


    private ArrayList<String> fileList(String Path, String Extension) {
        ArrayList<String> FileList = new ArrayList<String>();
        List<File> result = listf(Path);
        for (File file : result) {
            String extension = "";
            String fileName = file.getAbsolutePath();
            int i = fileName.lastIndexOf('.');
            if (i > 0) {
                extension = fileName.substring(i + 1);
            }
            if (extension.equals(Extension))
                FileList.add(fileName);

        }
        return FileList;
    }

    public boolean SearchText() {
        if (Path.isEmpty()) {
            return false;
        }
        ArrayList<String> fList = fileList(Path, Extension);
        for (String path : fList) {
            int index = readFile(path).indexOf(Text);
            if (index > -1)
                Result.add(path);


        }
        return true;
    }
}

