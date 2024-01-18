package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Введено не корректное значение команды!";
    private final Scanner scanner;
    private final Presenter presentor;
    private final MainMenu menu;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presentor = new Presenter(this);
        menu = new MainMenu(this);
        work = true;
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            executeRequest();
        }

    }

    private void hello() { System.out.println("Здравствуйте!");}
    private void printMenu() {
        System.out.println(menu.getMenu());
    }
    private void executeRequest() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private boolean checkCommand(int numCommand){
        if (numCommand < menu.getSize() + 1){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
    @Override
    public void printAnswer(String text) { System.out.println(text);}

    public void finish() {
        System.out.println("Досвидания!");
        work = false;
    }

    public void addRecord() {
        System.out.println("Введите ФИО, дату рождения, телефон и пол человека через запятую. \n " +
                "Дату рождения в формате: дд.мм.гггг \n" +
                "Пол: м или ж");
        String info = scanner.nextLine();
        presentor.addRecord(info);
    }

    public void getAllRecords() {
        presentor.getAllRecords();
    }
}
