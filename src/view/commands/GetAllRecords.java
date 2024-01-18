package view.commands;

import view.ConsoleUI;

public class GetAllRecords extends Command{
    public GetAllRecords(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывесть все записи";
    }
    @Override
    public void execute() {consoleUI.getAllRecords();}
}
