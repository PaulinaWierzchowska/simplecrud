package pl.sda.simplecrud;

public class CarExistsException extends RuntimeException{
    public CarExistsException(String message) {
        super(message);
    }
}
