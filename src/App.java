import Presenter.Presenter;
import View.*;
import java.util.Scanner;
import Exceptions.*;

public class App {
    public static void main(String[] args) throws Exception {
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view);
        boolean flag = true;
        try (Scanner sc = new Scanner(System.in, "ibm866")) {

            while (flag) {
                System.out.println(" 1 - добавить запись  2 - выход");
                String key = sc.next();
                switch (key) {
                    case "1":
                        if (presenter.getData() == 0) {
                            presenter.reply("Данных недостаточно");
                        } else {
                            try {
                                presenter.saveToFile();
                            } catch (UncorrectDataException e) {
                                presenter.reply(e.getMessage());
                            }
                        }
                        break;
                    case "2":
                        flag = false;
                        break;
                    default:
                        System.out.println ("введите 1 или 2");
                        break;    
                }
            }
        }
    }
}
