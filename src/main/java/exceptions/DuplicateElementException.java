package exceptions;

public class DuplicateElementException extends IllegalArgumentException{
    public DuplicateElementException(String message){
        super(message);
    }
}
