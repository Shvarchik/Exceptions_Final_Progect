package View;

import java.util.Scanner;

public class ConsoleView implements View {

    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in, "ibm866");
    }

    @Override
    public String getData() {
        System.out.print("\033[H\033[J");
        System.out.println("Введите данные <Фамилия Имя Отчество датарождения номертелефона пол>: ");
        return in.nextLine();
    }
    
    @Override
    public void setReply(String reply) {
        System.out.println(reply);
    }
}
