package model;

import java.io.*;

public class FileHandler {
    public String save(String info) {
        try {
            Parser parser = new Parser();
            String parsInfo = parser.parsInfo(info);
            String fileName = getFileName(parsInfo);
            try(FileWriter writer = new FileWriter("src/files/" + fileName + ".txt", true)) {
                writer.write(parsInfo + "\n");
                return "Информация успешно записана в файл.";
            }
            catch(IOException e){
                return "Произошла ошибка при записи в файл.";
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }


    }
    public String load() {
        String fullInfo = "";
        File folder = new File("src/files");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = reader.readLine();
                    while (line != null) {
                        fullInfo += line + "\n";
                        line = reader.readLine();
                    }
                    reader.close();
                } catch (IOException e) {
                    return "Произошла ошибка при чтении файла.";
                }
            }
        }
        return fullInfo;
    }

    private String getFileName(String info) {
        String[] splitInfo = info.split(" ");
        return splitInfo[0];
    }
}
