package nl.novi.backend.techiteasy.exceptions;

public class RecordNotFoundException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public RecordNotFoundException(){
        super();
    }

    public RecordNotFoundException(String message){
        super(message);
    }
}

