package Presenter;

import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.format.DateTimeParseException;
import Exceptions.*;

public class Validator implements Validable{

    @Override
    public boolean validate (List<String> list){

        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        for (int i=0; i< list.size(); i++){
            try{
                if (i==0) 
                    isValidName(list.get(i), "Фамилия");
                if (i==1)
                    isValidName(list.get(i), "Имя"); 
                if (i == 2)
                    isValidName(list.get(2), "Отчество"); 
                if (i==3)
                    isValidDate (list.get(i));
                if (i == 4)
                    isValidTelephone(list.get(i)); 
                if (i == 5)
                    isValidGender(list.get(i));
            } catch (UncorrectDataException e){
                sb.append ("\n");
                sb.append(e.getMessage());
                flag = false;
            }
        }
        if (flag == false){
            throw new UncorrectDataException(sb.toString());
        } 
        return flag;
    }

    private boolean isValidName (String name, String field){
        for (int i = 0; i < name.length(); i++) {
            if (! Character.UnicodeBlock.of(name.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC)) {
                throw new UncorrectDataException(String.format("некорректно задано поле %s, допустимы только буквы кириллицы",field));
            }
        }
        return true;
    }
    
    private boolean isValidGender (String gender){
        if (!(gender.equals("f") || gender.equals("m")))
            throw new UncorrectGenderException();
        return true;
    }
    
    private boolean isValidDate (String birthday)  {

        LocalDate date;
        Integer [] month_30 = {4, 6, 9, 11};
        int day;
        
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            date = LocalDate.parse(birthday, formatter);
            day = date.getDayOfMonth();

        } catch (DateTimeParseException e) {
            throw new UncorrectBirthdayException("некорректный формат даты");
        }
        
        if ((Arrays.asList(month_30).contains(date.getMonthValue()) && day > 30) ||
                (date.isLeapYear() && date.getMonthValue() == 2 && day > 29) ||
                (!date.isLeapYear() && date.getMonthValue() == 2 && day > 28)) {
            
            throw new UncorrectBirthdayException("введена некорректная дата рождения");
            
        } else 
            return true;
    }

    private boolean isValidTelephone (String telephone) {
        long telNumber;
        try{
            telNumber = Long.parseLong(telephone);
        } catch (NumberFormatException e){
            throw new UncorrectPhoneException("некорректный формат номера телефона");
        }
        if (telNumber <=0  || telephone.length() < 3){
            throw new UncorrectPhoneException("некорректный номер телефона");
        } 
        return true;
    }
}
