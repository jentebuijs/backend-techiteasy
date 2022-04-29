package nl.novi.backend.techiteasy.exceptions;

public class TelevisionNotFoundException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public TelevisionNotFoundException(){
        super();
    }

    public TelevisionNotFoundException(String message){
        super(message);
    }
}

