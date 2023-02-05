package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    
    private String surname;
    private String firstName;
    private String patronymic;
    private LocalDate birthday;
    private long telephoneNumber;
    private String gender;

    public Person() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthday(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        this.birthday = LocalDate.parse(date.replace(".","/"), formatter);
    }

    public void setTelephoneNumber(String telephonNumber) {
        long number = Long.parseLong(telephonNumber);
        setTelephoneNumber (number);

    }
    private void setTelephoneNumber(long telephonNumber) {
        this.telephoneNumber = telephonNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        String formatBirthday = formatter.format (birthday);
        return String.format("<%s> <%s> <%s> <%s> <%d> <%s>", surname, firstName, patronymic,
         formatBirthday, telephoneNumber, gender);
    }

}
