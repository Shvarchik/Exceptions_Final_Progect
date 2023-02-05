package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Model implements Saveable {

    private Person person;
      
    public Model() {
        person = new Person();
    }

    public void setPerson(List<String> data){

        person.setSurname(data.get(0));
        person.setFirstName(data.get(1));
        person.setPatronymic(data.get(2));
        person.setBirthday(data.get(3));
        person.setTelephoneNumber(data.get(4));
        person.setGender(data.get(5));
    }

    private String setPath(){
        return String.format("%s.txt",person.getSurname());
    }

    @Override
    public void saveToFile() throws IOException {
        
        File file = new File (setPath());
        try (FileWriter writer = new FileWriter(file,true)){
            writer.write (String.format("%s\n",person.toString()));
            writer.flush();
        }
    }
}


