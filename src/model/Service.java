package model;

public class Service {
    private final FileHandler fileHandler;

    public Service() {
        fileHandler = new FileHandler();
    }

    public String addRecord(String info) {
        return fileHandler.save(info);
    }

    public String getAllRecords() {
        return fileHandler.load();
    }
}
