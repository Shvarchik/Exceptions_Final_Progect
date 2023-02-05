package Presenter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import Model.*;
import View.View;

public class Presenter {

    Saveable model;
    View view;
    List<String> data;
    Validable validator;

    public Presenter(View view) {
        this.view = view;
        this.model = new Model();
        this.validator = new Validator(); 
    }
    
    public void saveToFile ()  {
        if (validator.validate(data)) {

            ((Model)model).setPerson(data);
        }
        try {
            model.saveToFile();
            reply("данные сохранены в файл");
        } catch (IOException e) {
            view.setReply("ошибка при записи файла:\n");
            e.printStackTrace();
        }
    }

    public int getData (){
        String dataString = view.getData();
        List<String> strings = splitString(dataString);
        int code;
        if (strings.size() == 6){
            code = 1;
            data = strings;
        }     
        else 
            code = 0;              // view.reply("данных недостаточно"); 
        return code;
    }
   
    private List <String> splitString (String data){
        List <String> strings = Arrays.asList(data.split(" "));
        return (strings);
    }

    public void reply (String string){
        view.setReply(string);
    }
}


