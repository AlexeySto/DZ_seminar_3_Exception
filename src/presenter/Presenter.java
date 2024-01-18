package presenter;

import model.Service;
import view.View;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addRecord(String info) {
        view.printAnswer(service.addRecord(info));
    }
    public void getAllRecords() {
        view.printAnswer(service.getAllRecords());
    }
}
