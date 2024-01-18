package view.commands;

import view.ConsoleUI;

public class AddRecord extends Command{
    public AddRecord(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить запись";
    }
    @Override
    public void execute() {consoleUI.addRecord();}
}
