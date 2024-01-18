package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {
    private String name;
    private String birthData;
    private String phoneNumber;
    private String gender;
    private String exceptionMessage;

    public Parser() {
        name = null;
        birthData = null;
        phoneNumber = null;
        gender = null;
        exceptionMessage = null;
    }
    public String parsInfo(String info) throws IllegalArgumentException {
        String[] arrayInfo = info.split(", ");
        if (arrayInfo.length != 4) throw new IllegalArgumentException("Введено неверное количество данных. " +
                "Возможно не верно расставлены запятые.");
        else {
            for(String val : arrayInfo) {
                if (isName(val)) name = val;
                if (isBirthData(val) && isValidBirthData(val)) birthData = val;
                if (isPhoneNumber(val)) phoneNumber = val;
                if (isGender(val)) gender = val;
            }
        }
        if (checkedByNull()) return name + ", " + birthData + ", " + phoneNumber
                + ", " + gender;
        else {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private boolean isName(String val) {
        return val.matches("[А-Яа-я_ ]+") && val.length() > 1 && val.contains(" ");
    }
    private boolean isBirthData(String val) {
        return val.matches("(\\d{1,2}.\\d{1,2}.\\d{4})");
    }
    private boolean isPhoneNumber(String val) {
        return val.matches("[0-9_+]+") && val.length() > 10 && val.length() < 13;
    }
    private boolean isGender(String val) {
        return val.length() == 1 && val.matches( "(м|ж)");
    }
    private boolean checkedByNull() {
        exceptionMessage = "Не найдено данных";
        boolean res = true;
        if (name == null) {
            res = false;
            exceptionMessage += " об ФИО";
        }
        if (birthData == null) {
            res = false;
            exceptionMessage += ", о дате рождения";
        }
        if (phoneNumber == null) {
            res = false;
            exceptionMessage += ", о номере телефона";
        }
        if (gender== null) {
            res = false;
            exceptionMessage += ", о поле человека";
        }
        exceptionMessage += ".";
        return res;
    }
    private boolean isValidBirthData(String val) {
        try {
            LocalDate birthData = LocalDate.parse(val, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return LocalDate.now().isAfter(birthData);
        }
        catch (DateTimeParseException e) {
            System.out.println("Введена неправильная дата.");
            return false;
        }
    }
}
