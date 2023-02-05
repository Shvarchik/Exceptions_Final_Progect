package Exceptions;

public class UncorrectGenderException extends UncorrectDataException {
    
    public UncorrectGenderException () {
        super("некорректно указан пол");
    }
}
